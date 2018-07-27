package cn.luozhuowei.weixinpay.util;

import cn.luozhuowei.common.ConfigUtil;

/**
 * 微信支付配置
 * 
 * @author zhuowei.luo
 * @date 2018/7/11
 */
public class WeixinpayConfigUtil {

	// 请求地址
	public static final String serverUrl = "https://api.mch.weixin.qq.com/"; 
	// 商户号（pay.weixin.qq.com登录id）
	public static final String mchId;
	// Api密钥，用来签名。微信商户平台(pay.weixin.qq.com)-->账户中心-->账户设置-->API安全-->密钥设置
	public static final String apiKey;
	// App ID
	public static final String appId;
	// 退款、撤单请求需证书，证书的地址
	public static final String certPath;
	// 证书密码
	public static final String certPasswd;
	
	static {
		mchId = ConfigUtil.getProperty("wxpayMchId");
		apiKey = ConfigUtil.getProperty("wxpayApiKey");
		appId = ConfigUtil.getProperty("wxpayAppId");
		certPath = ConfigUtil.getProperty("wxpayCertPath");
		certPasswd = ConfigUtil.getProperty("wxpayCertPasswd");
	}
	
}
