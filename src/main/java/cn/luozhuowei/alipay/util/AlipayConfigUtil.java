package cn.luozhuowei.alipay.util;

import java.io.File;

import cn.luozhuowei.common.ConfigUtil;
import cn.luozhuowei.common.TxtFileUtil;

/**
 * 阿里支付配置
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public class AlipayConfigUtil {

	public static final String serverUrlDev = "https://openapi.alipaydev.com/gateway.do"; // 开发调试
	public static final String oauthUrlDev ="https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm";
	
	public static final String serverUrlRun = "https://openapi.alipay.com/gateway.do"; // 正式上线
	public static final String oauthUrlRun ="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";
	
	public static final String serverUrl = serverUrlRun; // 阿里调用网关地址 
	public static final String oauthUrl = oauthUrlRun; // 阿里授权地址
	public static final String appId; // appId
	public static final String privateKeyForPkcs8; // rsa私有key，注意：这里是pkcs8编码的私有key！！！
	public static final String publicKeyForAlipay; // rsa公共key，注意：不是应用公共key，是阿里的公共key！！！这里是个坑
	public static final String format = "json"; // 格式：json
	public static final String charset = "UTF-8"; // 编码：UTF-8
	public static final String signType = "RSA2"; // 非对称加密类型：RSA2

	static {
		appId = ConfigUtil.getProperty("alipayAppId");
		privateKeyForPkcs8 = readPemFile(ConfigUtil.getProperty("alipayPrivateKeyPath"));
		publicKeyForAlipay = readPemFile(ConfigUtil.getProperty("alipayPublicKeyPath"));
	}

	private static String readPemFile(String path) {
		String txt = TxtFileUtil.readTxtFile(new File(path));
		// 替换注释
		txt = txt.replaceAll("----.*\r\n", "");
		// 替换换行符
		txt = txt.replace("\r\n", "");
		return txt;
	}
	
}
