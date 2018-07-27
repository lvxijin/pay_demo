package cn.luozhuowei.weixinpay.bean;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Weixinpay Base Response.
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public abstract class WeixinpayBaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String DATE_FORMAT = "yyyyMMddHHmmss";

	@JSONField(serialize = false)
	private boolean checkSign;
	
	@JSONField(serialize = false)
	protected Set<String> groupByArrStartKeys;
	
	@JSONField(serialize = false)
	protected Integer groupMax$Count;
	
	@JSONField(name = "return_code")
	private String returnCode; // 返回状态码， SUCCESS/FAIL，此字段是通信标识，非交易标识

	@JSONField(name = "return_msg")
	private String returnMsg; // 返回信息，如非空，为错误原因

	@JSONField(name = "appid")
	private String appId; // 微信开放平台审核通过的应用APPID

	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号

	@JSONField(name = "nonce_str")
	private String nonceStr; // 随机字符串

	@JSONField(name = "sign")
	private String sign; // 签名

	@JSONField(name = "err_code")
	private String errCode; // 错误码

	@JSONField(name = "err_code_des")
	private String errCodeDes; // 结果信息描述

	/**
	 * 是否校验签名 
	 */
	public WeixinpayBaseResponse(boolean checkSign){
		this.checkSign = checkSign;
	}
	
	/**
	 * 是否校验签名 （base）
	 */
	@JSONField(serialize = false)
	public boolean isCheckSign() {
		return checkSign;
	}
	
	/**
	 * 请求是否成功，通信标识，非交易状态  （base）
	 */
	@JSONField(serialize = false)
	public boolean isRequestSuccess() {
		return "SUCCESS".equalsIgnoreCase(returnCode);
	}
	
	/**
	 * 交易是否成功  （abstract）
	 */
	@JSONField(serialize = false)
	public abstract boolean isSuccess();
	
	/**
	 * 转成json（base）
	 */
	@JSONField(serialize = false)
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
	@Override
	@JSONField(serialize = false)
	public String toString() {
		return toJson();
	}
	
	/**
	 * 转成有序map（base）
	 */
	@JSONField(serialize = false)
	public SortedMap<String, Object> toSortedMap() {
		return new TreeMap<>(JSONObject.parseObject(toJson()));
	}
	
	/**
	 * 解析xml元素按下标$组成数组的参数的开始字符（base）
	 */
	public Set<String> getGroupByArrStartKeys() {
		return groupByArrStartKeys;
	}
	
	/**
	 * 解析xml元素按下标$最多有多少个（base）
	 */
	public Integer getGroupMax$Count() {
		return groupMax$Count;
	}

	/**
	 * 返回状态码（base），SUCCESS/FAIL，此字段是通信标识，非交易标识 
	 */
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * 返回信息，如非空，为错误原因 （base）
	 */
	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	/**
	 * 微信开放平台审核通过的应用APPID（base）
	 */
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 微信支付分配的商户号 （base）
	 */
	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	/**
	 * 随机字符串 （base）
	 */
	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	/**
	 * 签名 （base）
	 */
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 错误码 （base）
	 */
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * 结果信息描述 （base）
	 */
	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}
	
}
