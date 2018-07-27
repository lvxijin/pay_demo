package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 退款查询请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class RefundQueryRequest extends WeixinpayBaseRequest<RefundQueryResponse> {

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

	@JSONField(name = "refund_id")
	private String refundId; // 微信生成的退款单号，在申请退款接口有返回

	@JSONField(name = "offset")
	private String offset; // 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录

	/**
	 * 退款查询请求
	 * 
	 * @param outTradeNo 商户订单号
	 */
	public RefundQueryRequest(String outTradeNo) {
		this(outTradeNo, null, null, null);
	}
	
	/**
	 * 退款查询请求（四选一）
	 * 
	 * @param outTradeNo 商户订单号
	 * @param transactionId 微信生成的订单号，在支付通知中有返回
	 * @param outRefundNo 商户退款单号，商户系统内部的退款单号，商户系统内部唯一
	 * @param refundId 微信生成的退款单号，在申请退款接口有返回
	 */
	public RefundQueryRequest(String outTradeNo, String transactionId, String outRefundNo,
			String refundId) {
		this();
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.outRefundNo = outRefundNo;
		this.refundId = refundId;
	}

	public RefundQueryRequest() {
		super("pay/refundquery");
		this.appId = WeixinpayConfigUtil.appId;
		this.mchId = WeixinpayConfigUtil.mchId;
		this.nonceStr = WeixinpayUtil.getRandomString(15);
	}

	@Override
	public Class<RefundQueryResponse> getResponseClass() {
		return RefundQueryResponse.class;
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

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	/**
	 * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录 
	 */
	public String getOffset() {
		return offset;
	}

	/**
	 * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录 
	 */
	public void setOffset(String offset) {
		this.offset = offset;
	}

}
