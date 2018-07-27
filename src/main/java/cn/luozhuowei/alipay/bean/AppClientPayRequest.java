package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;

/**
 * App客户端支付请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 * @desc 外部商户APP唤起快捷SDK创建订单并支付
 */
public class AppClientPayRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "total_amount")
	private String totalAmount; // 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]

	@JSONField(name = "body")
	private String body; // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。

	@JSONField(name = "subject")
	private String subject; // 商品的标题/交易标题/订单标题/订单关键字等。

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复

	@JSONField(name = "timeout_express")
	private String timeoutExpress; // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
									// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。

	@JSONField(name = "product_code")
	private String productCode; // 销售产品码，商家和支付宝签约的产品码

	@JSONField(name = "goods_type")
	private String goodsType; // 商品主类型 :0-虚拟类商品,1-实物类商品

	@JSONField(name = "promo_params")
	private String promoParams; // 优惠参数,注：仅与支付宝协商后可用

	@JSONField(name = "passback_params")
	private String passbackParams; // 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝。

	@JSONField(name = "extend_params")
	private ExtendParams extendParams; // 业务扩展参数

	@JSONField(name = "enable_pay_channels")
	private String enablePayChannels; // 可用渠道，用户只能在指定渠道范围内支付,当有多个渠道时用“,”分隔
										// ,注，与disable_pay_channels互斥

	@JSONField(name = "store_id")
	private String storeId; // 商户门店编号

	@JSONField(name = "disable_pay_channels")
	private String disablePayChannels; // 禁用渠道，用户不可用指定渠道支付,当有多个渠道时用“,”分隔,注，与enable_pay_channels互斥

	@JSONField(name = "ext_user_info")
	private ExtUserInfo extUserInfo; // 外部指定买家

	/**
	 * App客户端支付请求
	 * 
	 * @param outTradeNo 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额，单位为元
	 * @param subject 订单标题
	 * @desc 外部商户APP唤起快捷SDK创建订单并支付
	 */
	public AppClientPayRequest(String outTradeNo, Integer totalAmount, String subject) {
		this(outTradeNo, totalAmount.toString(), subject);
	}

	/**
	 * App客户端支付请求
	 * 
	 * @param outTradeNo 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额，单位为元，只精确到二位小数
	 * @param subject 订单标题
	 * @desc 外部商户APP唤起快捷SDK创建订单并支付
	 */
	public AppClientPayRequest(String outTradeNo, Double totalAmount, String subject) {
		this(outTradeNo, toMoneyStr(totalAmount), subject);
	}

	/**
	 * App客户端支付请求
	 * 
	 * @param outTradeNo 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param totalAmount 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param subject 订单标题
	 * @desc 外部商户APP唤起快捷SDK创建订单并支付
	 */
	public AppClientPayRequest(String outTradeNo, String totalAmount, String subject) {
		this();
		this.totalAmount = totalAmount;
		this.subject = subject;
		this.outTradeNo = outTradeNo;
	}

	/**
	 * App客户端支付请求
	 */
	public AppClientPayRequest() {
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getPromoParams() {
		return promoParams;
	}

	public void setPromoParams(String promoParams) {
		this.promoParams = promoParams;
	}

	public String getPassbackParams() {
		return passbackParams;
	}

	public void setPassbackParams(String passbackParams) {
		this.passbackParams = passbackParams;
	}

	public ExtendParams getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(ExtendParams extendParams) {
		this.extendParams = extendParams;
	}

	public String getEnablePayChannels() {
		return enablePayChannels;
	}

	public void setEnablePayChannels(String enablePayChannels) {
		this.enablePayChannels = enablePayChannels;
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

	public ExtUserInfo getExtUserInfo() {
		return extUserInfo;
	}

	public void setExtUserInfo(ExtUserInfo extUserInfo) {
		this.extUserInfo = extUserInfo;
	}

}
