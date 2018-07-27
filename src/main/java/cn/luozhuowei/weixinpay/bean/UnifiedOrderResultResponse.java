package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 统一下单结果通知响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class UnifiedOrderResultResponse extends WeixinpayBaseResponse {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "device_info")
	private String deviceInfo; // 设备号,调用接口提交的终端设备号

	@JSONField(name = "result_code")
	private String resultCode; // 业务结果，SUCCESS/FAIL

	@JSONField(name = "openid")
	private String openid; // 用户标识,用户在商户appid下的唯一标识

	@JSONField(name = "is_subscribe")
	private String isSubscribe; // 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效

	@JSONField(name = "trade_type")
	private String tradeType; // 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP

	@JSONField(name = "bank_type")
	private String bankType; // 付款银行类型，采用字符串类型的银行标识

	@JSONField(name = "total_fee")
	private Integer totalFee; // 订单总金额，单位为分

	@JSONField(name = "fee_type")
	private String feeType; // 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY

	@JSONField(name = "cash_fee")
	private Integer cashFee; // 现金支付金额订单现金支付金额，单位分

	@JSONField(name = "cash_fee_type")
	private String cashFeeType; // 现金支付货币类型，默认人民币：CNY

	@JSONField(name = "coupon_fee")
	private Integer couponFee; // 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额，单位分

	@JSONField(name = "coupon_count")
	private Integer couponCount; // 代金券或立减优惠使用数量

	@JSONField(name = "transaction_id")
	private String transactionid; // 微信支付订单号

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号

	@JSONField(name = "attach")
	private String attach; // 自定义数据，商家数据包

	@JSONField(name = "time_end")
	private String timeEnd; // 支付完成时间，格式为yyyyMMddHHmmss

	public UnifiedOrderResultResponse() {
		super(true);
	}

	@Override
	public boolean isSuccess() {
		return "SUCCESS".equalsIgnoreCase(resultCode);
	}

	/**
	 * 设备号,调用接口提交的终端设备号
	 */
	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	/**
	 * 业务结果，SUCCESS/FAIL
	 */
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 用户标识，用户在商户appid下的唯一标识
	 */
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	 */
	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	/**
	 * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP
	 */
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * 付款银行类型，采用字符串类型的银行标识
	 */
	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	/**
	 * 订单总金额，单位为分
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
	 */
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	/**
	 * 现金支付金额订单现金支付金额，单位分
	 */
	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	/**
	 * 现金支付货币类型，默认人民币：CNY
	 */
	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	/**
	 * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额，单位分
	 */
	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	/**
	 * 代金券或立减优惠使用数量
	 */
	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	/**
	 * 微信支付订单号
	 */
	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	/**
	 * 商户订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 自定义数据，商家数据包
	 */
	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * 支付完成时间，格式为yyyyMMddHHmmss
	 */
	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

}
