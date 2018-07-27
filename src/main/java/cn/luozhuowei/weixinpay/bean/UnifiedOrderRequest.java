package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 统一下单请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/11
 */
public class UnifiedOrderRequest extends WeixinpayBaseRequest<UnifiedOrderResponse> {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "appid")
	private String appId; // 微信开放平台审核通过的应用APPID

	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号

	@JSONField(name = "device_info")
	private String deviceInfo; // 终端设备号(门店号或收银设备ID)，默认请传"WEB"

	@JSONField(name = "nonce_str")
	private String nonceStr; // 随机字符串，不长于32位

	@JSONField(name = "body")
	private String body; // 商品描述交易字段格式根据不同的应用场景按照以下格式：APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。

	@JSONField(name = "detail")
	private String detail; // 商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见

	@JSONField(name = "attach")
	private String attach; // 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一

	@JSONField(name = "fee_type")
	private String feeType; // 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见

	@JSONField(name = "total_fee")
	private Integer totalFee; // 订单总金额，单位为分

	@JSONField(name = "spbill_create_ip")
	private String spbillCreateIp; // 用户端实际ip

	@JSONField(name = "time_start")
	private String timeStart; // 订单生成时间，格式为yyyyMMddHHmmss

	@JSONField(name = "time_expire")
	private String timeExpire; // 订单失效时间，格式为yyyyMMddHHmmss

	@JSONField(name = "goods_tag")
	private String goodsTag; // 订单优惠标记，代金券或立减优惠功能的参数

	@JSONField(name = "notify_url")
	private String notifyUrl; // 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。

	@JSONField(name = "trade_type")
	private String tradeType; // 支付类型

	@JSONField(name = "limit_pay")
	private String limitPay; // no_credit--指定不能使用信用卡支付

	@JSONField(name = "scene_info")
	private String sceneInfo; // 该字段用于统一下单时上报场景信息，目前支持上报实际门店信息。

	/**
	 * 统一下单
	 * 
	 * @param outTradeNo 商户系统内部订单号，要求32个字符内，必须在同一个商户号下唯一
	 * @param totalFee 订单总金额（分），单位别弄错，1元=10角=100分
	 * @param body 商品描述，格式：app名称-商品名称
	 * @param spbillCreateIp 用户端实际ip
	 * @param notifyUrl 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数
	 */
	public UnifiedOrderRequest(String outTradeNo, Integer totalFee, String body, String spbillCreateIp,
			String notifyUrl) {
		this(outTradeNo, totalFee, body, spbillCreateIp, notifyUrl, null);
	}
	
	/**
	 * 统一下单
	 * 
	 * @param outTradeNo 商户系统内部订单号，要求32个字符内，必须在同一个商户号下唯一
	 * @param totalFee 订单总金额（分），单位别弄错，1元=10角=100分
	 * @param body 商品描述，格式：app名称-商品名称
	 * @param spbillCreateIp 用户端实际ip
	 * @param notifyUrl 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数
	 * @param attach 自定义数据（非必填），在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	 */
	public UnifiedOrderRequest(String outTradeNo, Integer totalFee, String body, String spbillCreateIp,
			String notifyUrl, String attach) {
		this();
		this.body = body;
		this.outTradeNo = outTradeNo;
		this.totalFee = totalFee;
		this.spbillCreateIp = spbillCreateIp;
		this.attach = attach;
		this.notifyUrl = notifyUrl;
	}

	public UnifiedOrderRequest() {
		super("pay/unifiedorder");
		this.appId = WeixinpayConfigUtil.appId;
		this.mchId = WeixinpayConfigUtil.mchId;
		this.tradeType = "APP";
		this.nonceStr = WeixinpayUtil.getRandomString(15);
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

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getSceneInfo() {
		return sceneInfo;
	}

	public void setSceneInfo(String sceneInfo) {
		this.sceneInfo = sceneInfo;
	}

	@Override
	public Class<UnifiedOrderResponse> getResponseClass() {
		return UnifiedOrderResponse.class;
	}

}
