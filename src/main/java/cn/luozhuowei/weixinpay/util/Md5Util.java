package cn.luozhuowei.weixinpay.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5工具类
 * 
 * @author zhuowei.luo
 * @date 2018/7/11
 */
public class Md5Util {

	/**
	 * md5
	 */
	public static String md5(String param) {
		StringBuilder sb = new StringBuilder();
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(param.getBytes());
			byte[] digest = messageDigest.digest();
			for (int i = 0; i < digest.length; ++i) {
				int b = digest[i] & 255;
				if (b < 16) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}