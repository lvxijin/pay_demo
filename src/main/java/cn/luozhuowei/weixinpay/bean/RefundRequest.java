package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 退款请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class RefundRequest extends WeixinpayBaseRequest<RefundResponse> {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "appid")
	private String appId; // 微信开放平台审核通过的应用APPID

	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号

	@JSONField(name = "nonce_str")
	private String nonceStr; // 随机字符串，不长于32位

	@JSONField(name = "transaction_id")
	private String transactionId; // 微信生成的订单号，在支付通知中有返回

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号

	@JSONField(name = "out_refund_no")
	private String outRefundNo; // 商户退款单号，商户系统内部的退款单号，商户系统内部唯一

	@JSONField(name = "total_fee")
	private String totalFee; // 订单金额，单位为分，只能为整数

	@JSONField(name = "refund_fee")
	private String refundFee; // 退款总金额，订单总金额，单位为分，只能为整数

	@JSONField(name = "refund_fee_type")
	private String refundFeeType; // 退款货币类型，需与支付一致，或者不填。符合ISO4217标准的三位字母代码，默认人民币：CNY

	@JSONField(name = "refund_desc")
	private String refundDesc; // 退款原因，若商户传入，会在下发给用户的退款消息中体现退款原因

	@JSONField(name = "refund_account")
	private String refundAccount; // 退款资金来源，仅针对老资金流商户使用。REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）；REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款

	@JSONField(name = "notify_url")
	private String notifyUrl; // 退款结果通知url，异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数，如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。

	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号,与transactionId不能同时为空（二选一）
	 * @param transactionId 微信生订单号,与outTradeNo不能同时为空（二选一）
	 * @param outRefundNo 商户退款单号，商户系统内部的退款单号，商户系统内部唯一（必填）
	 * @param totalFee 订单金额，单位为分（必填）
	 * @param refundFee 退款总金额，订单总金额，单位为分（必填）
	 * @param refundDesc 退款原因，若商户传入，会在下发给用户的退款消息中体现退款原因
	 */
	public RefundRequest(String outTradeNo, String transactionId, String outRefundNo, Integer totalFee,
			Integer refundFee, String refundDesc) {
		this(transactionId, outTradeNo, outRefundNo, totalFee.toString(), refundFee.toString(), refundDesc);
	}

	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号,与transactionId不能同时为空（二选一）
	 * @param transactionId 微信生订单号,与outTradeNo不能同时为空（二选一）
	 * @param outRefundNo 商户退款单号，商户系统内部的退款单号，商户系统内部唯一（必填）
	 * @param totalFee 订单金额，单位为分，只精确到两位小数点（必填）
	 * @param refundFee 退款总金额，订单总金额，单位为分，只精确到两位小数点（必填）
	 * @param refundDesc 退款原因，若商户传入，会在下发给用户的退款消息中体现退款原因
	 */
	public RefundRequest(String outTradeNo, String transactionId, String outRefundNo, Double totalFee, Double refundFee,
			String refundDesc) {
		this(transactionId, outTradeNo, outRefundNo, toMoneyStr(totalFee), toMoneyStr(refundFee), refundDesc);
	}

	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号,与transactionId不能同时为空（二选一）
	 * @param transactionId 微信生订单号,与outTradeNo不能同时为空（二选一）
	 * @param outRefundNo 商户退款单号，商户系统内部的退款单号，商户系统内部唯一（必填）
	 * @param totalFee 订单金额，单位为分，只能为整数（必填）
	 * @param refundFee 退款总金额，订单总金额，单位为分，只能为整数（必填）
	 */
	public RefundRequest(String outTradeNo, String transactionId, String outRefundNo, String totalFee,
			String refundFee) {
		this(transactionId, outTradeNo, outRefundNo, totalFee, refundFee, null);
	}

	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号,与transactionId不能同时为空（二选一）
	 * @param transactionId 微信生订单号,与outTradeNo不能同时为空（二选一）
	 * @param outRefundNo 商户退款单号，商户系统内部的退款单号，商户系统内部唯一（必填）
	 * @param totalFee 订单金额，单位为分，只能为整数（必填）
	 * @param refundFee 退款总金额，订单总金额，单位为分，只能为整数（必填）
	 * @param refundDesc 退款原因，若商户传入，会在下发给用户的退款消息中体现退款原因
	 */
	public RefundRequest(String outTradeNo, String transactionId, String outRefundNo, String totalFee, String refundFee,
			String refundDesc) {
		this(transactionId, outTradeNo, outRefundNo, totalFee, refundFee, refundDesc, null);
	}

	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号,与transactionId不能同时为空（二选一）
	 * @param transactionId 微信生订单号,与outTradeNo不能同时为空（二选一）
	 * @param outRefundNo 商户退款单号，商户系统内部的退款单号，商户系统内部唯一（必填）
	 * @param totalFee 订单金额，单位为分，只能为整数（必填）
	 * @param refundFee 退款总金额，订单总金额，单位为分，只能为整数（必填）
	 * @param refundDesc 退款原因，若商户传入，会在下发给用户的退款消息中体现退款原因
	 * @param notifyUrl 退款结果通知url，异步接收微信支付退款结果通知的回调地址，不能有参数
	 */
	public RefundRequest(String outTradeNo, String transactionId, String outRefundNo, String totalFee, String refundFee,
			String refundDesc, String notifyUrl) {
		this();
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.outRefundNo = outRefundNo;
		this.totalFee = totalFee;
		this.refundFee = refundFee;
		this.refundDesc = refundDesc;
		this.notifyUrl = notifyUrl;
	}

	public RefundRequest() {
		super("secapi/pay/refund");
		super.ssl = true;
		this.appId = WeixinpayConfigUtil.appId;
		this.mchId = WeixinpayConfigUtil.mchId;
		this.nonceStr = WeixinpayUtil.getRandomString(15);
	}

	@Override
	public Class<RefundResponse> getResponseClass() {
		return RefundResponse.class;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}

	public String getRefundFeeType() {
		return refundFeeType;
	}

	public void setRefundFeeType(String refundFeeType) {
		this.refundFeeType = refundFeeType;
	}

	public String getRefundDesc() {
		return refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

}
