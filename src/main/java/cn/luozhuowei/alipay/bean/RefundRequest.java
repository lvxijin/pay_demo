package cn.luozhuowei.alipay.bean;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.OpenApiRoyaltyDetailInfoPojo;

/**
 * 退款请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class RefundRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号,不能和tradeNo同时为空。

	@JSONField(name = "trade_no")
	private String tradeNo; // 支付宝交易号，和商户订单号不能同时为空

	@JSONField(name = "refund_amount")
	private String refundAmount; // 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数

	@JSONField(name = "refund_currency")
	private String refundCurrency; // 订单退款币种信息

	@JSONField(name = "refund_reason")
	private String refundReason; // 退款的原因说明

	@JSONField(name = "out_request_no")
	private String outRequestNo; // 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。

	@JSONField(name = "operator_id")
	private String operatorId; // 商户的操作员编号

	@JSONField(name = "store_id")
	private String storeId; // 商户的门店编号

	@JSONField(name = "terminal_id")
	private String terminalId; // 商户的终端编号

	@JSONField(name = "goods_detail")
	private List<GoodsDetail> goodsDetails; // 退款包含的商品列表信息

	@JSONField(name = "refund_royalty_parameters")
	private List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters; // 退分账明细信息

	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号，tradeNo不能同时为空（二选一）
	 * @param tradeNo 支付宝交易号，outTradeNo不能同时为空（二选一）
	 * @param refundAmount 需要退款的金额，该金额不能大于订单金额（元）
	 * @param refundReason 退款的原因说明，可空
	 */
	public RefundRequest(String outTradeNo, String tradeNo, Double refundAmount, String refundReason) {
		this();
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.refundAmount = toMoneyStr(refundAmount);
		this.refundReason = refundReason;
	}
	
	/**
	 * 退款请求
	 * 
	 * @param outTradeNo 商户订单号，tradeNo不能同时为空（二选一）
	 * @param tradeNo 支付宝交易号，outTradeNo不能同时为空（二选一）
	 * @param refundAmount 需要退款的金额，该金额不能大于订单金额（元）
	 * @param refundReason 退款的原因说明，可空
	 */
	public RefundRequest(String outTradeNo, String tradeNo, String refundAmount, String refundReason) {
		this();
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.refundAmount = refundAmount;
		this.refundReason = refundReason;
	}

	public RefundRequest() {
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundCurrency() {
		return refundCurrency;
	}

	public void setRefundCurrency(String refundCurrency) {
		this.refundCurrency = refundCurrency;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public List<GoodsDetail> getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public List<OpenApiRoyaltyDetailInfoPojo> getRefundRoyaltyParameters() {
		return refundRoyaltyParameters;
	}

	public void setRefundRoyaltyParameters(List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters) {
		this.refundRoyaltyParameters = refundRoyaltyParameters;
	}
	
}
