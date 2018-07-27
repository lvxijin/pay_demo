package cn.luozhuowei.alipay.bean;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.SettleInfo;

/**
 * 交易创建请求
 * 
 * @desc 
 * <p>可以通过这个接口制作固定收款码，具体步骤：<br>
 * 1、拼接阿里静默授权URL，重定向redirect_url设置成h5支付页面地址，然后生成固定二维码<br>
 * 2、用户通过支护宝扫码后会跳到重定向地址，也就是支付页面，提交带上返回的auth_code授权码<br>
 * 3、后台根据auth_code授权码调用oauth.token接口获取alipay_user_id也就是buyerId<br>
 * 4、通过buyerId调用交易创建接口返回的trade_no，唤醒支付宝进行支付<br>
 * </p>
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class CreateRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复

	@JSONField(name = "seller_id")
	private String sellerId; // 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID

	@JSONField(name = "total_amount")
	private String totalAmount; // 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]，如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】

	@JSONField(name = "discountable_amount")
	private String discountableAmount; // 可打折金额.参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]，如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】

	@JSONField(name = "subject")
	private String subject; // 订单标题（必填）

	@JSONField(name = "body")
	private String body; // 对交易或商品的描述

	@JSONField(name = "buyer_id")
	private String buyerId; // 买家的支付宝唯一用户号（2088开头的16位纯数字的用户id），（必填）

	@JSONField(name = "goods_detail")
	private List<GoodsDetail> goodsDetails; // 订单包含的商品列表信息，

	@JSONField(name = "operator_id")
	private String operatorId; // 商户操作员编号

	@JSONField(name = "store_id")
	private String storeId; // 商户门店编号

	@JSONField(name = "terminal_id")
	private String terminalId; // 商户机具终端编号

	@JSONField(name = "extend_params")
	private ExtendParams extend_params; // 业务扩展参数

	@JSONField(name = "timeout_express")
	private String timeoutExpress; // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
									// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。

	@JSONField(name = "settle_info")
	private SettleInfo settleInfo; // 描述结算信息，json格式，详见结算参数说明

	@JSONField(name = "business_params")
	private String businessParams; // 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式

	/**
	 * 交易创建请求，必填参数
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param buyerId 买家的支付宝唯一用户号（2088开头的16位纯数字的用户id），需要通过授权接口获取alipay_user_id
	 * @param totalAmount 订单总金额（必填），单位为元
	 * @param subject 订单标题
	 */
	public CreateRequest(String outTradeNo, String buyerId, Integer totalAmount, String subject) {
		this(outTradeNo, buyerId, totalAmount.toString(), subject);
	}
	
	/**
	 * 交易创建请求，必填参数
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param buyerId 买家的支付宝唯一用户号（2088开头的16位纯数字的用户id），需要通过授权接口获取alipay_user_id
	 * @param totalAmount 订单总金额（必填），单位为元，只精确到二位小数
	 * @param subject 订单标题
	 */
	public CreateRequest(String outTradeNo, String buyerId, Double totalAmount, String subject) {
		this(outTradeNo, buyerId, toMoneyStr(totalAmount), subject);
	}
	
	/**
	 * 交易创建请求，必填参数
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param buyerId 买家的支付宝唯一用户号（2088开头的16位纯数字的用户id），需要通过授权接口获取alipay_user_id
	 * @param totalAmount 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param subject 订单标题
	 */
	public CreateRequest(String outTradeNo, String buyerId, String totalAmount, String subject) {
		this();
		this.outTradeNo = outTradeNo;
		this.buyerId = buyerId;
		this.totalAmount = totalAmount;
		this.subject = subject;
	}

	public CreateRequest() {
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public List<GoodsDetail> getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
		this.goodsDetails = goodsDetails;
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

	public ExtendParams getExtend_params() {
		return extend_params;
	}

	public void setExtend_params(ExtendParams extend_params) {
		this.extend_params = extend_params;
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

}
