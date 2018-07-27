package cn.luozhuowei.weixinpay.service;

import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import cn.luozhuowei.weixinpay.bean.*;
import cn.luozhuowei.weixinpay.util.*;

/**
 * 微信支付服务
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class WeixinpayApiServiceImpl implements WeixinpayApiService {

	private static final Logger logger = LoggerFactory.getLogger(WeixinpayApiServiceImpl.class);
	
	@Override
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request) throws WeixinpayException {
		UnifiedOrderResponse resp;
		try {
			resp = WeixinpayRequest.request(request);
			logger.info("weixinpay.unifiedOrder，执行请求！req = {}，resp={}", request, resp);
		} catch (Exception e) {
			logger.error("weixinpay.unifiedOrder，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return resp;
	}
	
	@Override
	public String appClientPay(String parentId) {
		JSONObject json = new JSONObject();
		json.put("appId", WeixinpayConfigUtil.appId);
		json.put("partnerId", WeixinpayConfigUtil.mchId);
		json.put("nonceStr", WeixinpayUtil.getRandomString(15));
		json.put("timeStamp", Math.round(System.currentTimeMillis() / 1000));
		json.put("prepayId", parentId);
		json.put("package", "Sign=WXPay");
		SortedMap<String, Object> map = new TreeMap<>();
		json.forEach((k, v) -> {
			map.put(k.toLowerCase(), v);
		});
		String sign = WeixinpayUtil.sign(map);
		json.put("sign", sign);
		return json.toJSONString();
	}

	@Override
	public OrderQueryResponse orderQuery(OrderQueryRequest request) throws WeixinpayException {
		OrderQueryResponse resp;
		try {
			resp = WeixinpayRequest.request(request);
			logger.info("weixinpay.orderQuery，执行请求！req = {}，resp={}", request, resp);
		} catch (Exception e) {
			logger.error("weixinpay.orderQuery，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return resp;
	}

	@Override
	public CloseOrderResponse closeOrder(CloseOrderRequest request) throws WeixinpayException {
		CloseOrderResponse resp;
		try {
			resp = WeixinpayRequest.request(request);
			logger.info("weixinpay.closeOrder，执行请求！req = {}，resp={}", request, resp);
		} catch (Exception e) {
			logger.error("weixinpay.closeOrder，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return resp;
	}
	
	@Override
	public RefundResponse refund(RefundRequest request) throws WeixinpayException {
		RefundResponse resp;
		try {
			resp = WeixinpayRequest.request(request);
			logger.info("weixinpay.refund，执行请求！req = {}，resp={}", request, resp);
		} catch (Exception e) {
			logger.error("weixinpay.refund，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return resp;
	}
	
	@Override
	public RefundQueryResponse refundQuery(RefundQueryRequest request) throws WeixinpayException {
		RefundQueryResponse resp;
		try {
			resp = WeixinpayRequest.request(request);
			logger.info("weixinpay.refundQuery，执行请求！req = {}，resp={}", request, resp);
		} catch (Exception e) {
			logger.error("weixinpay.refundQuery，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return resp;
	}
	
	@Override
	public byte[] downloadBill(DownloadBillRequest request) throws WeixinpayException {
		byte[] data;
		try {
			SortedMap<String, Object> param = request.toSortedMap();
			String sign = WeixinpayUtil.sign(param);
			param.put("sign", sign);
			String xml = WeixinpayUtil.paramToXML(param);
			data = WeixinHttpUtil.sendPostToByte(request.getUrl(), xml);
			logger.info("weixinpay.downloadbill，执行请求！req = {}，data.leng={}", request, data.length);
		} catch (Exception e) {
			logger.error("weixinpay.downloadbill，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return data;
	}

	@Override
	public byte[] downloadFundFlow(DownloadBillRequest request) throws WeixinpayException {
		byte[] data;
		try {
			SortedMap<String, Object> param = request.toSortedMap();
			String sign = WeixinpayUtil.sign(param);
			param.put("sign", sign);
			String xml = WeixinpayUtil.paramToXML(param);
			data = WeixinHttpUtil.sendSSLPostToByte(request.getUrl(), xml);
			logger.info("weixinpay.downloadFundFlow，执行请求！req = {}，data.leng={}", request, data.length);
		} catch (Exception e) {
			logger.error("weixinpay.downloadFundFlow，请求失败！req = {}", request, e);
			throw new WeixinpayException(e);
		}
		return data;
	}

}
