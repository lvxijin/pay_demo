package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 订单查询请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class OrderQueryRequest extends WeixinpayBaseRequest<OrderQueryResponse> {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "appid")
	private String appId; // 微信开放平台审核通过的应用APPID

	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号

	@JSONField(name = "transaction_id")
	private String transactionId; // 微信订单号,优先使用

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号

	@JSONField(name = "nonce_str")
	private String nonceStr; // 随机字符串
	
	/**
	 * 订单查询请求（参数二选一）
	 * 
	 * @param outTradeNo 商户订单号，不能与transactionId同时为空
	 * @param transactionId 微信订单号，不能与outTradeNo同时为空，优先使用
	 */
	public OrderQueryRequest(String outTradeNo, String transactionId) {
		this();
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
	}

	public OrderQueryRequest() {
		super("pay/orderquery");
		this.appId = WeixinpayConfigUtil.appId;
		this.mchId = WeixinpayConfigUtil.mchId;
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

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	@Override
	public Class<OrderQueryResponse> getResponseClass() {
		return OrderQueryResponse.class;
	}

}
