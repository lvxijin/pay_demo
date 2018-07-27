package cn.luozhuowei.weixinpay.bean;

import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * Weixinpay Base Request.
 * 
 * @author zhuowei.luo
 * @date 2018/7/11
 */
public abstract class WeixinpayBaseRequest<T extends WeixinpayBaseResponse> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String DATE_FORMAT = "yyyyMMddHHmmss";
	
	@JSONField(serialize = false)
	private String url;
	@JSONField(serialize = false)
	protected boolean ssl = false;
	
	/**
	 * Weixinpay Base Bean.
	 * 
	 * @param uri 域名后面一部分url，如统一下单接口pay/unifiedorder
	 */
	public WeixinpayBaseRequest(String uri) {
		this.url = WeixinpayConfigUtil.serverUrl + uri;
	}
	
	@JSONField(serialize = false)
	public String getUrl() {
		return url;
	}

	@JSONField(serialize = false)
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
	@JSONField(serialize = false)
	public SortedMap<String, Object> toSortedMap() {
		return new TreeMap<>(JSONObject.parseObject(toJson()));
	}
	
	@JSONField(serialize = false)
	public abstract Class<T> getResponseClass();
	
	@Override
	@JSONField(serialize = false)
	public String toString() {
		return toJson();
	}
	
	/**
	 * 保留两位小数 
	 */
	@JSONField(serialize = false)
	public static String toMoneyStr(Double money) {
		return WeixinpayUtil.toMoneyStr(money);
	}
	
	/**
	 * 是否为SSL证书请求
	 */
	@JSONField(serialize = false)
	public boolean isSSL() {
		return ssl;
	}
	
}
