package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.InvoiceInfo;
import com.alipay.api.domain.RoyaltyInfo;
import com.alipay.api.domain.SettleInfo;
import com.alipay.api.domain.SubMerchant;

/**
 * 手机网站支付
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 * @desc 外部商户创建订单并支付
 */
public class WapPayRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "body")
	private String body; // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。

	@JSONField(name = "subject")
	private String subject; // 商品的标题/交易标题/订单标题/订单关键字等（必填）。

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复

	@JSONField(name = "timeout_express")
	private String timeoutExpress; // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
									// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。

	@JSONField(name = "time_expire")
	private String timeExpire; // 绝对超时时间，格式为yyyy-MM-dd HH:mm。

	@JSONField(name = "total_amount")
	private String totalAmount; // 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]

	@JSONField(name = "seller_id")
	private String sellerId; // 收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID

	@JSONField(name = "auth_token")
	private String authToken; // 针对用户授权接口，获取用户相关数据时，用于标识用户授权关系

	@JSONField(name = "goods_type")
	private String goodsType; // 商品主类型 :0-虚拟类商品,1-实物类商品

	@JSONField(name = "passback_params")
	private String passbackParams; // 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝。

	@JSONField(name = "quit_url")
	private String quitUrl; // 用户付款中途退出返回商户网站的地址（必选 ？）

	@JSONField(name = "product_code")
	private String productCode; // 销售产品码，商家和支付宝签约的产品码（必选 ？）

	@JSONField(name = "promo_params")
	private String promoParams; // 优惠参数,注：仅与支付宝协商后可用

	@JSONField(name = "royalty_info")
	private RoyaltyInfo royaltyInfo; // 描述分账信息，json格式，详见分账参数说明

	@JSONField(name = "extend_params")
	private ExtendParams extendParams; // 业务扩展参数

	@JSONField(name = "sub_merchant")
	private SubMerchant subMerchant; // 间连受理商户信息体，当前只对特殊银行机构特定场景下使用此字段

	@JSONField(name = "enable_pay_channels")
	private String enablePayChannels; // 可用渠道，用户只能在指定渠道范围内支付,当有多个渠道时用“,”分隔
										// ,注，与disable_pay_channels互斥

	@JSONField(name = "disable_pay_channels")
	private String disablePayChannels; // 禁用渠道，用户不可用指定渠道支付,当有多个渠道时用“,”分隔,注，与enable_pay_channels互斥

	@JSONField(name = "store_id")
	private String storeId; // 商户门店编号

	@JSONField(name = "settle_info")
	private SettleInfo settleInfo; // 描述结算信息

	@JSONField(name = "invoice_info")
	private InvoiceInfo invoiceInfo; // 开票信息

	@JSONField(name = "specified_channel")
	private String specifiedChannel; // 指定渠道，目前仅支持传入pcredit,若由于用户原因渠道不可用，用户可选择是否用其他渠道支付。注：该参数不可与花呗分期参数同时传入

	@JSONField(name = "business_params")
	private String businessParams; // 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式

	@JSONField(name = "ext_user_info")
	private ExtUserInfo extUserInfo; // 外部指定买家

	/**
	 * 手机网站支付
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param subject 订单标题
	 * @desc 外部商户创建订单并支付
	 */
	public WapPayRequest(String outTradeNo, Double totalAmount, String subject) {
		this(outTradeNo, toMoneyStr(totalAmount), subject);
	}

	/**
	 * 手机网站支付
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额（必填），单位为元
	 * @param subject 订单标题
	 * @desc 外部商户创建订单并支付
	 */
	public WapPayRequest(String outTradeNo, Integer totalAmount, String subject) {
		this(outTradeNo, totalAmount.toString(), subject);
	}
	
	/**
	 * 手机网站支付
	 * 
	 * @param outTradeNo 商户订单号（必填）,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额（必填），单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param subject 订单标题
	 * @desc 外部商户创建订单并支付
	 */
	public WapPayRequest(String outTradeNo, String totalAmount, String subject) {
		this();
		this.totalAmount = totalAmount;
		this.subject = subject;
		this.outTradeNo = outTradeNo;
	}

	public WapPayRequest() {
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getPassbackParams() {
		return passbackParams;
	}

	public void setPassbackParams(String passbackParams) {
		this.passbackParams = passbackParams;
	}

	public String getQuitUrl() {
		return quitUrl;
	}

	public void setQuitUrl(String quitUrl) {
		this.quitUrl = quitUrl;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPromoParams() {
		return promoParams;
	}

	public void setPromoParams(String promoParams) {
		this.promoParams = promoParams;
	}

	public RoyaltyInfo getRoyaltyInfo() {
		return royaltyInfo;
	}

	public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
		this.royaltyInfo = royaltyInfo;
	}

	public ExtendParams getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(ExtendParams extendParams) {
		this.extendParams = extendParams;
	}

	public SubMerchant getSubMerchant() {
		return subMerchant;
	}

	public void setSubMerchant(SubMerchant subMerchant) {
		this.subMerchant = subMerchant;
	}

	public String getEnablePayChannels() {
		return enablePayChannels;
	}

	public void setEnablePayChannels(String enablePayChannels) {
		this.enablePayChannels = enablePayChannels;
	}

	public String getDisablePayChannels() {
		return disablePayChannels;
	}

	public void setDisablePayChannels(String disablePayChannels) {
		this.disablePayChannels = disablePayChannels;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public SettleInfo getSettleInfo() {
		return settleInfo;
	}

	public void setSettleInfo(SettleInfo settleInfo) {
		this.settleInfo = settleInfo;
	}

	public InvoiceInfo getInvoiceInfo() {
		return invoiceInfo;
	}

	public void setInvoiceInfo(InvoiceInfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}

	public String getSpecifiedChannel() {
		return specifiedChannel;
	}

	public void setSpecifiedChannel(String specifiedChannel) {
		this.specifiedChannel = specifiedChannel;
	}

	public String getBusinessParams() {
		return businessParams;
	}

	public void setBusinessParams(String businessParams) {
		this.businessParams = businessParams;
	}

	public ExtUserInfo getExtUserInfo() {
		return extUserInfo;
	}

	public void setExtUserInfo(ExtUserInfo extUserInfo) {
		this.extUserInfo = extUserInfo;
	}

}
