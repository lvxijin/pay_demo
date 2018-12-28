package cn.luozhuowei.weixinpay.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信支付工具类
 * 
 * @author zhuowei.luo
 * @date 2018/7/11
 */
public class WeixinpayUtil {
	
	private final static String CHAR_CACHE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * 根据参数转换成请求XML
	 */
	public static String paramToXML(SortedMap<String, Object> param) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		param.forEach((key, value) -> {
			sb.append("<").append(key).append(">");
			sb.append("<![CDATA[").append(value).append("]]>");
			sb.append("</").append(key).append(">");
		});
		sb.append("</xml>");
		return sb.toString();
	}
	
	/**
	 * 参数签名
	 * 
	 * @param param 排序map -&gt; TreeMap
	 */
	public static String sign(SortedMap<String, Object> param) {
		// param.put("sign_type", "MD5");
		StringBuilder sb = new StringBuilder();
		param.forEach((key, value) -> {
			if (value != null && !"".equals(value) && !"sign".equals(key) && !"key".equals(key)) {
				sb.append(key).append("=").append(value).append("&");
			}
		});
		sb.append("key=").append(WeixinpayConfigUtil.apiKey);
		return Md5Util.md5(sb.toString()).toUpperCase();
	}
	
	/**
	 * 随机字符串 
	 */
	public static String getRandomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(CHAR_CACHE.charAt(random.nextInt(CHAR_CACHE.length())));
		}
		return sb.toString();
	}
	
	/**
	 * 获取用户ip地址 
	 */
	/*public static String getIpAddress() {
		String ip = IpUtil.getIpAddress(null);
		if (ip != null && ("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip))) {
			return IpUtil.localIp();
		}
		return ip;
	}*/
	
	/**
	 * 元 -&gt; 分 
	 * 
	 * @param money 金钱（元），只精确两位小数
	 * @return money * 100，元转换成分
	 */
	public static Integer yuanToCent(double money) {
		return (int) new BigDecimal(money).multiply(new BigDecimal(100)).doubleValue();
	}
	
	/**
	 * 保留两位小数 
	 */
	public static String toMoneyStr(Double money) {
		if (money != null) {
			DecimalFormat df = new DecimalFormat("#.##");
			return df.format(money);
		} else {
			return null;
		}
	}
	
	/**
	 * xml转换成json
	 * 
	 * @param xml xml字符串
	 * @param retainRootNode 是否保留根节点
	 * @param valueToArray true 键值对中值保存为数组类型，false 键值对形式，相同会替换
	 */
	public static JSONObject xmlToJson(String xml, boolean retainRootNode, boolean valueToArray) {
		return WeixinpayXmlUtil.xmlToJson(xml, retainRootNode, valueToArray);
	}

	/**
	 * xml转换成json
	 * 
	 * @param xml xml字符串
	 * @param retainRootNode 是否保留根节点
	 * @param valueToArray true 键值对中值保存为数组类型，false 键值对形式，相同会替换
	 * @param groupByArrStartKeys 解析xml元素按下标$组成数组的参数的开始字符
	 * @param groupMax$Count 解析xml元素按下标$最多有多少个
	 */
	public static JSONObject xmlToJson(String xml, boolean retainRootNode, boolean valueToArray,
			Set<String> groupByArrStartKeys, Integer groupMax$Count) {
		return WeixinpayXmlUtil.xmlToJson(xml, retainRootNode, valueToArray, groupByArrStartKeys, groupMax$Count);
	}
	
}
