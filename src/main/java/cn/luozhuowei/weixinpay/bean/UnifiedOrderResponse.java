package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 统一下单响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class UnifiedOrderResponse extends WeixinpayBaseResponse {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "device_info")
	private String deviceInfo; // 设备号,调用接口提交的终端设备号

	@JSONField(name = "result_code")
	private String resultCode; // 业务结果，SUCCESS/FAIL

	@JSONField(name = "trade_type")
	private String tradeType; // 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP

	@JSONField(name = "prepay_id")
	private String prepayId; // 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时

	public UnifiedOrderResponse() {
		super(true);
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	@Override
	public boolean isSuccess() {
		return "SUCCESS".equalsIgnoreCase(resultCode);
	}

}
