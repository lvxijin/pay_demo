package cn.luozhuowei.weixinpay.util;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import cn.luozhuowei.weixinpay.bean.WeixinpayBaseRequest;
import cn.luozhuowei.weixinpay.bean.WeixinpayBaseResponse;
import cn.luozhuowei.weixinpay.bean.WeixinpaySignException;

/**
 * 微信支付请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/11
 */
public class WeixinpayRequest {
	
	private static final Logger logger = LoggerFactory.getLogger(WeixinpayRequest.class);
	
	/**
	 * 微信支付请求（post）
	 * 
	 * @desc 支付请求，包含参数签名
	 */
	@SuppressWarnings("unchecked")
	public static <T extends WeixinpayBaseResponse> T request(WeixinpayBaseRequest<T> request) throws Exception {
		if (request != null) {
			String xml = signRequest(request.getUrl(), request.toSortedMap(), request.isSSL());
			JSONObject json = WeixinpayUtil.xmlToJson(xml, false, false);
			String jsonStr = json.toJSONString();
			logger.info("weixinpay.resp=" + jsonStr);
			String sign = signAndJsonGroup(request, json);
			logger.info("weixinpay.resp.group=" + json.toJSONString());
			WeixinpayBaseResponse resp = null;
			try {
				resp = json.toJavaObject(request.getResponseClass());
			} catch (Exception e) {
				resp = JSONObject.parseObject(jsonStr).toJavaObject(request.getResponseClass());
				e.printStackTrace();
			}
			if (resp.isRequestSuccess() && sign != null) {
				if (resp.getSign() == null || !resp.getSign().equals(sign)) {
					logger.error("weixinpay，验证签名异常！返回数据可能遭篡改，mySign={}，respSign={}，resp=" + jsonStr, sign,
							resp.getSign());
					throw new WeixinpaySignException("验证签名异常！");
				}
			}
			return (T) resp;
		} else {
			throw new NullPointerException("request is null !");
		}
	}

	/**
	 * 请求结果签名、解析下标$数据
	 */
	private static <T extends WeixinpayBaseResponse> String signAndJsonGroup(WeixinpayBaseRequest<T> request, JSONObject json)
			throws InstantiationException, IllegalAccessException {
		WeixinpayBaseResponse obj = request.getResponseClass().newInstance();
		Set<String> groupByArrStartKeys = obj.getGroupByArrStartKeys();
		Integer groupMax$Count = obj.getGroupMax$Count();
		String sign = null;
		if (obj.isCheckSign()) {
			sign = WeixinpayUtil.sign(new TreeMap<>(json));
		}
		if (groupByArrStartKeys != null && !groupByArrStartKeys.isEmpty() && groupMax$Count != null
				&& groupMax$Count > 0) {
			try {
				WeixinpayXmlUtil.group(json, groupByArrStartKeys, groupMax$Count);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sign;
	}
	
	/**
	 * 微信支付请求签名
	 */
	private static String signRequest(String url, SortedMap<String, Object> param, boolean isSSL) throws Exception {
		String sign = WeixinpayUtil.sign(param);
		param.put("sign", sign);
		String xml = WeixinpayUtil.paramToXML(param);
		logger.info("weixinpay.req=" + xml);
		String result = null;
		if (isSSL) {
			result = WeixinHttpUtil.sendSSLPost(url, xml);
		} else {
			result = WeixinHttpUtil.sendPost(url, xml);
		}
		logger.info("weixinpay.resp=" + result);
		return result;
	}

}
