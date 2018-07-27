package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;

import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 关闭订单请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class CloseOrderRequest extends WeixinpayBaseRequest<CloseOrderResponse> {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "appid")
	private String appId; // 微信开放平台审核通过的应用APPID

	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号

	@JSONField(name = "nonce_str")
	private String nonceStr; // 随机字符串

	/**
	 * 关闭订单请求
	 * 
	 * @param outTradeNo 商户订单号
	 */
	public CloseOrderRequest(String outTradeNo) {
		super("pay/closeorder");
		this.outTradeNo = outTradeNo;
		this.appId = WeixinpayConfigUtil.appId;
		this.mchId = WeixinpayConfigUtil.mchId;
		this.nonceStr = WeixinpayUtil.getRandomString(15);
	}

	@Override
	public Class<CloseOrderResponse> getResponseClass() {
		return CloseOrderResponse.class;
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

}
