package cn.luozhuowei.weixinpay.bean;

import java.util.List;
import java.util.TreeSet;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 退款查询响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class RefundQueryResponse extends WeixinpayBaseResponse {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "result_code")
	private String resultCode; // 业务结果, SUCCESS/FAIL

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号

	@JSONField(name = "transaction_id")
	private String transactionId; // 微信订单号

	@JSONField(name = "total_refund_count")
	private Integer totalRefundCount; // 订单总退款次数,订单总共已发生的部分退款次数，当请求参数传入offset后有返回

	@JSONField(name = "total_fee")
	private Integer totalFee; // 订单总金额，单位为分，只能为整数

	@JSONField(name = "fee_type")
	private String feeType; // 订单金额货币类型，默认人民币：CNY

	@JSONField(name = "cash_fee")
	private Integer cashFee; // 现金支付金额，单位为分，只能为整数

	@JSONField(name = "cash_fee_type")
	private String cashFeeType; // 现金支付币种，默认人民币：CNY

	@JSONField(name = "settlement_total_fee")
	private Integer settlementTotalFee; // 应结订单金额，单位为分，去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。

	@JSONField(name = "refund_count")
	private String refundCount; // 退款笔数,当前返回退款笔数

	@JSONField(name = "out_refund_no")
	private List<String> outRefundNos; // 商户退款单号

	@JSONField(name = "refund_id")
	private List<String> refundIds; // 微信退款单号

	@JSONField(name = "refund_channel")
	private List<String> refundChannels; // 退款渠道,ORIGINAL—原路退款；BALANCE—退回到余额；OTHER_BALANCE—原账户异常退到其他余额账户；OTHER_BANKCARD—原银行卡异常退到其他银行卡

	@JSONField(name = "refund_fee")
	private Integer refundFee; // 退款总金额,单位为分,可以做部分退款
	
	@JSONField(name = "refund_fees")
	private List<Integer> refundFees; // 退款总金额,单位为分,可以做部分退款

	@JSONField(name = "coupon_refund_fee")
	private List<Integer> couponRefundFees; // 代金券退款金额,代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金

	@JSONField(name = "coupon_refund_count")
	private List<Integer> couponRefundCounts; // 代金券或立减优惠使用数量

	@JSONField(name = "coupon_refund_id")
	private List<List<String>> couponRefundIds; // 代金券或立减优惠ID

	@JSONField(name = "coupon_type")
	private List<List<String>> couponTypes; // 代金券类型,CASH--充值代金券
											// ，NO_CASH---非充值优惠券，开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,$m为下标,从0开始编号，举例：coupon_type_$0_$1

	@JSONField(name = "coupon_refund")
	private List<List<Integer>> couponRefunds; // 单个代金券或立减优惠退款金额,$n为下标，$m为下标，从0开始编号

	@JSONField(name = "refund_status")
	private List<String> refundStatuss; // 退款状态：SUCCESS—退款成功；REFUNDCLOSE—退款关闭；PROCESSING—退款处理中；CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。$n为下标，从0开始编号。

	@JSONField(name = "refund_account")
	private List<String> refundAccounts; // 退款资金来源,REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户；REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款；$n为下标，从0开始编号。

	@JSONField(name = "refund_recv_accout")
	private List<String> refundRecvAccouts; // 退款入账账户，取当前退款单的退款入账方。1）退回银行卡：{银行名称}{卡类型}{卡尾号}；2）退回支付用户零钱:支付用户零钱；3）退还商户:商户基本账户，商户结算银行账户；4）退回支付用户零钱通:支付用户零钱通

	@JSONField(name = "refund_success_time")
	private List<String> refundSuccessTimes; // 退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号。

	public RefundQueryResponse() {
		super(true);
		super.groupMax$Count = 2;
		super.groupByArrStartKeys = new TreeSet<>();
		super.groupByArrStartKeys.add("out_refund_no");
		super.groupByArrStartKeys.add("refund_id");
		super.groupByArrStartKeys.add("refund_channel");
		super.groupByArrStartKeys.add("refund_fee");
		super.groupByArrStartKeys.add("coupon_refund_fee");
		super.groupByArrStartKeys.add("coupon_refund_count");
		super.groupByArrStartKeys.add("coupon_refund_id");
		super.groupByArrStartKeys.add("coupon_type");
		super.groupByArrStartKeys.add("coupon_refund");
		super.groupByArrStartKeys.add("refund_status");
		super.groupByArrStartKeys.add("refund_accoun");
		super.groupByArrStartKeys.add("refund_recv_accout");
		super.groupByArrStartKeys.add("refund_success_time");
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
	 * 订单总退款次数, 订单总共已发生的部分退款次数，当请求参数传入offset后有返回
	 */
	public Integer getTotalRefundCount() {
		return totalRefundCount;
	}

	public void setTotalRefundCount(Integer totalRefundCount) {
		this.totalRefundCount = totalRefundCount;
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
	 * 应结订单金额，单位为分，去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	 */
	public Integer getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	/**
	 * 退款笔数,当前返回退款笔数
	 */
	public String getRefundCount() {
		return refundCount;
	}

	public void setRefundCount(String refundCount) {
		this.refundCount = refundCount;
	}

	/**
	 * 商户退款单号
	 */
	public List<String> getOutRefundNos() {
		return outRefundNos;
	}

	public void setOutRefundNos(List<String> outRefundNos) {
		this.outRefundNos = outRefundNos;
	}

	/**
	 * 微信退款单号
	 */
	public List<String> getRefundIds() {
		return refundIds;
	}

	public void setRefundIds(List<String> refundIds) {
		this.refundIds = refundIds;
	}

	/**
	 * 退款渠道,ORIGINAL—原路退款；BALANCE—退回到余额；OTHER_BALANCE—原账户异常退到其他余额账户；
	 * OTHER_BANKCARD—原银行卡异常退到其他银行卡
	 */
	public List<String> getRefundChannels() {
		return refundChannels;
	}

	public void setRefundChannels(List<String> refundChannels) {
		this.refundChannels = refundChannels;
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
	 * 退款总金额,单位为分,可以做部分退款
	 */
	public List<Integer> getRefundFees() {
		return refundFees;
	}

	public void setRefundFees(List<Integer> refundFees) {
		this.refundFees = refundFees;
	}

	/**
	 * 代金券退款金额, 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
	 */
	public List<Integer> getCouponRefundFees() {
		return couponRefundFees;
	}

	public void setCouponRefundFees(List<Integer> couponRefundFees) {
		this.couponRefundFees = couponRefundFees;
	}

	/**
	 * 代金券或立减优惠使用数量
	 */
	public List<Integer> getCouponRefundCounts() {
		return couponRefundCounts;
	}

	public void setCouponRefundCounts(List<Integer> couponRefundCounts) {
		this.couponRefundCounts = couponRefundCounts;
	}

	/**
	 * 代金券或立减优惠ID
	 */
	public List<List<String>> getCouponRefundIds() {
		return couponRefundIds;
	}

	public void setCouponRefundIds(List<List<String>> couponRefundIds) {
		this.couponRefundIds = couponRefundIds;
	}

	/**
	 * 代金券类型,CASH--充值代金券
	 * ，NO_CASH---非充值优惠券，开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,$m为下标,
	 * 从0开始编号，举例：coupon_type_$0_$1
	 */
	public List<List<String>> getCouponTypes() {
		return couponTypes;
	}

	public void setCouponTypes(List<List<String>> couponTypes) {
		this.couponTypes = couponTypes;
	}

	/**
	 * 单个代金券或立减优惠退款金额, $n为下标，$m为下标，从0开始编号
	 */
	public List<List<Integer>> getCouponRefunds() {
		return couponRefunds;
	}

	public void setCouponRefunds(List<List<Integer>> couponRefunds) {
		this.couponRefunds = couponRefunds;
	}

	/**
	 * 退款状态：SUCCESS—退款成功；REFUNDCLOSE—退款关闭；PROCESSING—退款处理中；CHANGE—退款异常，
	 * 退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
	 * $n为下标，从0开始编号。
	 */
	public List<String> getRefundStatuss() {
		return refundStatuss;
	}

	public void setRefundStatuss(List<String> refundStatuss) {
		this.refundStatuss = refundStatuss;
	}

	/**
	 * 退款资金来源,REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户；
	 * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款；$n为下标，从0开始编号。
	 */
	public List<String> getRefundAccounts() {
		return refundAccounts;
	}

	public void setRefundAccounts(List<String> refundAccounts) {
		this.refundAccounts = refundAccounts;
	}

	/**
	 * 退款入账账户，取当前退款单的退款入账方。1）退回银行卡：{银行名称}{卡类型}{卡尾号}；2）退回支付用户零钱:支付用户零钱；3）退还商户:
	 * 商户基本账户，商户结算银行账户；4）退回支付用户零钱通:支付用户零钱通
	 */
	public List<String> getRefundRecvAccouts() {
		return refundRecvAccouts;
	}

	public void setRefundRecvAccouts(List<String> refundRecvAccouts) {
		this.refundRecvAccouts = refundRecvAccouts;
	}

	/**
	 * 退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号。
	 */
	public List<String> getRefundSuccessTimes() {
		return refundSuccessTimes;
	}

	public void setRefundSuccessTimes(List<String> refundSuccessTimes) {
		this.refundSuccessTimes = refundSuccessTimes;
	}

}
