package cn.luozhuowei.weixinpay.bean;

import java.util.List;
import java.util.TreeSet;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 退款响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class RefundResponse extends WeixinpayBaseResponse {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "result_code")
	private String resultCode; // 业务结果, SUCCESS/FAIL

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号

	@JSONField(name = "transaction_id")
	private String transactionId; // 微信订单号

	@JSONField(name = "out_refund_no")
	private String outRefundNo; // 商户退款单号

	@JSONField(name = "refund_id")
	private String refundId; // 微信退款单号

	@JSONField(name = "refund_fee")
	private Integer refundFee; // 退款总金额,单位为分,可以做部分退款

	@JSONField(name = "settlement_refund_fee")
	private Integer settlementRefundFee; // 应结退款金额,去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额,单位为分

	@JSONField(name = "total_fee")
	private Integer totalFee; // 订单总金额，单位为分，只能为整数

	@JSONField(name = "settlement_total_fee")
	private Integer settlementTotalFee; // 应结订单金额，单位为分，去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。

	@JSONField(name = "fee_type")
	private String feeType; // 订单金额货币类型，默认人民币：CNY

	@JSONField(name = "cash_fee")
	private Integer cashFee; // 现金支付金额，单位为分，只能为整数

	@JSONField(name = "cash_fee_type")
	private String cashFeeType; // 现金支付币种，默认人民币：CNY

	@JSONField(name = "cash_refund_fee")
	private Integer cashRefundFee; // 现金退款金额，单位为分，只能为整数
	
	@JSONField(name = "coupon_type")
	private List<String> couponTypes; // 代金券类型，CASH--充值代金券 ；NO_CASH---非充值代金券；订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0

	@JSONField(name = "coupon_refund_fee")
	private Integer couponRefundFee; // 代金券退款总金额，单位为分，代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金

	@JSONField(name = "coupon_refund_fees")
	private List<Integer> couponRefundFees; // 单个代金券退款金额,代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
	
	@JSONField(name = "coupon_refund_count")
	private Integer couponRefundCount; // 退款代金券使用数量
	
	@JSONField(name = "coupon_refund_id")
	private List<String> couponRefundIds; // 退款代金券ID, $n为下标，从0开始编号

	public RefundResponse() {
		super(true);
		super.groupMax$Count = 1;
		super.groupByArrStartKeys = new TreeSet<>();
		super.groupByArrStartKeys.add("coupon_type");
		super.groupByArrStartKeys.add("coupon_refund_fee");
		super.groupByArrStartKeys.add("coupon_refund_id");
	}

	@Override
	public boolean isSuccess() {
		return "SUCCESS".equalsIgnoreCase(resultCode);
	}

	/**
	 * 业务结果, SUCCESS/FAIL
	 */
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
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
	 * 微信订单号
	 */
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * 商户退款单号
	 */
	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	/**
	 * 微信退款单号
	 */
	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	/**
	 * 退款总金额,单位为分,可以做部分退款
	 */
	public Integer getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	/**
	 * 应结退款金额,去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额,单位为分
	 */
	public Integer getSettlementRefundFee() {
		return settlementRefundFee;
	}

	public void setSettlementRefundFee(Integer settlementRefundFee) {
		this.settlementRefundFee = settlementRefundFee;
	}

	/**
	 * 订单总金额，单位为分，只能为整数
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * 应结订单金额，单位为分，去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	 */
	public Integer getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	/**
	 * 订单金额货币类型，默认人民币：CNY
	 */
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	/**
	 * 现金支付金额，单位为分，只能为整数
	 */
	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	/**
	 * 现金支付币种，默认人民币：CNY
	 */
	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	/**
	 * 现金退款金额，单位为分，只能为整数
	 */
	public Integer getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(Integer cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}

	/**
	 * 代金券退款总金额，单位为分，代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
	 */
	public Integer getCouponRefundFee() {
		return couponRefundFee;
	}

	public void setCouponRefundFee(Integer couponRefundFee) {
		this.couponRefundFee = couponRefundFee;
	}

	/**
	 * 退款代金券使用数量
	 */
	public Integer getCouponRefundCount() {
		return couponRefundCount;
	}

	public void setCouponRefundCount(Integer couponRefundCount) {
		this.couponRefundCount = couponRefundCount;
	}

	/**
	 * 代金券类型，CASH--充值代金券 ；NO_CASH---非充值代金券；订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
	 */
	public List<String> getCouponTypes() {
		return couponTypes;
	}

	public void setCouponTypes(List<String> couponTypes) {
		this.couponTypes = couponTypes;
	}

	/**
	 * 单个代金券退款金额,代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金 
	 */
	public List<Integer> getCouponRefundFees() {
		return couponRefundFees;
	}

	public void setCouponRefundFees(List<Integer> couponRefundFees) {
		this.couponRefundFees = couponRefundFees;
	}

	/**
	 * 退款代金券ID, $n为下标，从0开始编号 
	 */
	public List<String> getCouponRefundIds() {
		return couponRefundIds;
	}

	public void setCouponRefundIds(List<String> couponRefundIds) {
		this.couponRefundIds = couponRefundIds;
	}
	
}
