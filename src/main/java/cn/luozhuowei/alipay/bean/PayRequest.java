package cn.luozhuowei.alipay.bean;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;

/**
 * 交易支付请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 * @desc 商家扫用户支付宝二维码收款、声波收款
 */
public class PayRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	public static final String SCENE_BAR_CODE = "bar_code"; // 条码支付
	public static final String SCENE_WAVE_CODE = "wave_code"; // 声波支付

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号（必填）,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复

	@JSONField(name = "scene")
	private String scene; // 支付场景（必填），条码支付，取值：bar_code，声波支付，取值：wave_code

	@JSONField(name = "auth_code")
	private String authCode; // 支付授权码，就是用户付款展示的二维码的数据（必填），25~30开头的长度为16~24位的数字，实际字符串长度以开发者获取的付款码长度为准

	@JSONField(name = "product_code")
	private String productCode; // 销售产品码

	@JSONField(name = "subject")
	private String subject; // 订单标题（必填）

	@JSONField(name = "buyer_id")
	private String buyerId; // 买家的支付宝用户id，如果为空，会从传入了码值信息中获取买家ID

	@JSONField(name = "seller_id")
	private String sellerId; // 卖方商家id，如果该值为空，则默认为商户签约账号对应的支付宝用户ID

	@JSONField(name = "total_amount")
	private String totalAmount; // 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]，如果同时传入【可打折金额】和【不可打折金额】，该参数可以不用传入；如果同时传入了【可打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【可打折金额】+【不可打折金额】

	@JSONField(name = "trans_currency")
	private String transCurrency; // 标价币种, total_amount
									// 对应的币种单位。支持英镑：GBP、港币：HKD、美元：USD、新加坡元：SGD、日元：JPY、加拿大元：CAD、澳元：AUD、欧元：EUR、新西兰元：NZD、韩元：KRW、泰铢：THB、瑞士法郎：CHF、瑞典克朗：SEK、丹麦克朗：DKK、挪威克朗：NOK、马来西亚林吉特：MYR、印尼卢比：IDR、菲律宾比索：PHP、毛里求斯卢比：MUR、以色列新谢克尔：ILS、斯里兰卡卢比：LKR、俄罗斯卢布：RUB、阿联酋迪拉姆：AED、捷克克朗：CZK、南非兰特：ZAR、人民币：CNY

	@JSONField(name = "settle_currency")
	private String settleCurrency; // 商户指定的结算币种，支持英镑：GBP、港币：HKD、美元：USD、新加坡元：SGD、日元：JPY、加拿大元：CAD、澳元：AUD、欧元：EUR、新西兰元：NZD、韩元：KRW、泰铢：THB、瑞士法郎：CHF、瑞典克朗：SEK、丹麦克朗：DKK、挪威克朗：NOK、马来西亚林吉特：MYR、印尼卢比：IDR、菲律宾比索：PHP、毛里求斯卢比：MUR、以色列新谢克尔：ILS、斯里兰卡卢比：LKR、俄罗斯卢布：RUB、阿联酋迪拉姆：AED、捷克克朗：CZK、南非兰特：ZAR、人民币：CNY

	@JSONField(name = "discountable_amount")
	private String discountableAmount; // 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。
										// 如果该值未传入，但传入了【订单总金额】和【不可打折金额】，则该值默认为【订单总金额】-【不可打折金额】

	@JSONField(name = "body")
	private String body; // 订单描述

	@JSONField(name = "goods_detail")
	private List<GoodsDetail> goodsDetails; // 订单包含的商品列表信息

	@JSONField(name = "operator_id")
	private String operatorId; // 商户操作员编号

	@JSONField(name = "store_id")
	private String storeId; // 商户门店编号

	@JSONField(name = "terminal_id")
	private String terminalId; // 商户机具终端编号

	@JSONField(name = "extend_params")
	private ExtendParams extendParams; // 业务扩展参数

	@JSONField(name = "timeout_express")
	private String timeoutExpress; // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
									// 该参数数值不接受小数点， 如 1.5h，可转换为 90m

	@JSONField(name = "auth_confirm_mode")
	private String authConfirmMode; // 预授权确认模式，授权转交易请求中传入，适用于预授权转交易业务使用，目前只支持PRE_AUTH(预授权产品码);COMPLETE：转交易支付完成结束预授权，解冻剩余金额;
									// NOT_COMPLETE：转交易支付完成不结束预授权，不解冻剩余金额

	@JSONField(name = "terminal_params")
	private String terminalParams; // 商户传入终端设备相关信息，具体值要和支付宝约定

	/**
	 * 交易支付请求（条码支付），必填字段
	 * 
	 * @param outTradeNo 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
	 * @param authCode 支付授权码，就是用户付款展示的二维码的数据
	 * @param subject 订单标题
	 * @desc 商家扫用户支付宝二维码收款
	 */
	public PayRequest(String outTradeNo, String authCode, String subject) {
		this(outTradeNo, SCENE_BAR_CODE, authCode, subject);
	}

	/**
	 * 交易支付请求（条码支付、声波支付），必填字段
	 * 
	 * @param outTradeNo 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
	 * @param scene 支付场景（必填），条码支付，取值：bar_code，声波支付，取值：wave_code
	 * @param authCode 支付授权码，就是用户付款展示的二维码的数据
	 * @param subject 订单标题
	 * @desc 商家扫用户支付宝二维码收款或声波收款
	 */
	public PayRequest(String outTradeNo, String scene, String authCode, String subject) {
		this();
		this.outTradeNo = outTradeNo;
		this.scene = scene;
		this.authCode = authCode;
		this.subject = subject;
	}

	public PayRequest() {
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}

	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getDiscountableAmount() {
		return discountableAmount;
	}

	public void setDiscountableAmount(String discountableAmount) {
		this.discountableAmount = discountableAmount;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public String getAuthConfirmMode() {
		return authConfirmMode;
	}

	public void setAuthConfirmMode(String authConfirmMode) {
		this.authConfirmMode = authConfirmMode;
	}

	public String getTerminalParams() {
		return terminalParams;
	}

	public void setTerminalParams(String terminalParams) {
		this.terminalParams = terminalParams;
	}

}
