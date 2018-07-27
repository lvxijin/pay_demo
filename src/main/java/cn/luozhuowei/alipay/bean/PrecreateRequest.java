package cn.luozhuowei.alipay.bean;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.SettleInfo;

/**
 * 预下单请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public class PrecreateRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复

	@JSONField(name = "seller_id")
	private String sellerId; // 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID

	@JSONField(name = "total_amount")
	private String totalAmount; // 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]
									// 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】

	@JSONField(name = "discountable_amount")
	private String discountableAmount; // 可打折金额.
											// 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
											// 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】

	@JSONField(name = "subject")
	private String subject; // 订单标题（必填）

	@JSONField(name = "goods_detail")
	private List<GoodsDetail> goodsDetails; // 订单包含的商品列表信息.json格式.
											// 其它说明详见：“商品明细说明”

	@JSONField(name = "body")
	private String body; // 对交易或商品的描述

	@JSONField(name = "operator_id")
	private String operatorId; // 商户操作员编号

	@JSONField(name = "store_id")
	private String storeId; // 商户门店编号

	@JSONField(name = "disable_pay_channels")
	private String disablePayChannels; // 禁用渠道，用户不可用指定渠道支付，当有多个渠道时用“,”分隔
										// ，注，与enable_pay_channels互斥
										// ，渠道列表：https://docs.open.alipay.com/common/wifww7

	@JSONField(name = "enable_pay_channels")
	private String enablePayChannels; // 可用渠道，用户只能在指定渠道范围内支付 ，当有多个渠道时用“,”分隔
										// ，注，与disable_pay_channels互斥

	@JSONField(name = "terminal_id")
	private String terminalId; // 商户机具终端编号

	@JSONField(name = "extend_params")
	private ExtendParams extendParams; // 业务扩展参数

	@JSONField(name = "timeout_express")
	private String timeoutExpress; // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
									// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。

	@JSONField(name = "settle_info")
	private SettleInfo settleInfo; // 描述结算信息

	@JSONField(name = "business_params")
	private String businessParams; // 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式

	@JSONField(name = "qr_code_timeout_express")
	private String qrCodeTimeoutExpress; // 该笔订单允许的最晚付款时间，逾期将关闭交易，从生成二维码开始计时。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
											// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	
	/**
	 * 预下单请求，必填参数
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额（必填），单位为元
	 * @param subject 订单标题
	 */
	public PrecreateRequest(String outTradeNo, Integer totalAmount, String subject) {
		this(outTradeNo, totalAmount.toString(), subject);
	}
	
	/**
	 * 预下单请求，必填参数
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param subject 订单标题
	 */
	public PrecreateRequest(String outTradeNo, Double totalAmount, String subject) {
		this(outTradeNo, toMoneyStr(totalAmount), subject);
	}
	
	/**
	 * 预下单请求，必填参数
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param subject 订单标题
	 */
	public PrecreateRequest(String outTradeNo, String totalAmount, String subject) {
		this();
		this.outTradeNo = outTradeNo;
		this.totalAmount = totalAmount;
		this.subject = subject;
	}

	private PrecreateRequest() {
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDiscountableAmount() {
		return discountableAmount;
	}

	public void setDiscountableAmount(String discountableAmount) {
		this.discountableAmount = discountableAmount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<GoodsDetail> getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public String getDisablePayChannels() {
		return disablePayChannels;
	}

	public void setDisablePayChannels(String disablePayChannels) {
		this.disablePayChannels = disablePayChannels;
	}

	public String getEnablePayChannels() {
		return enablePayChannels;
	}

	public void setEnablePayChannels(String enablePayChannels) {
		this.enablePayChannels = enablePayChannels;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public ExtendParams getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(ExtendParams extendParams) {
		this.extendParams = extendParams;
	}

	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	public SettleInfo getSettleInfo() {
		return settleInfo;
	}

	public void setSettleInfo(SettleInfo settleInfo) {
		this.settleInfo = settleInfo;
	}

	public String getBusinessParams() {
		return businessParams;
	}

	public void setBusinessParams(String businessParams) {
		this.businessParams = businessParams;
	}

	public String getQrCodeTimeoutExpress() {
		return qrCodeTimeoutExpress;
	}

	public void setQrCodeTimeoutExpress(String qrCodeTimeoutExpress) {
		this.qrCodeTimeoutExpress = qrCodeTimeoutExpress;
	}

}
