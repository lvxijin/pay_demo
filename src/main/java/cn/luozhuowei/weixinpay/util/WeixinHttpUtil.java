package cn.luozhuowei.weixinpay.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 微信SSL证书请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/13
 */
@SuppressWarnings("all")
public class WeixinHttpUtil {

	/**
	 * Post 请求 
	 */
	public static String sendPost(String url, String param) throws Exception {
		byte[] data = sendPostToByte(url, param);
		if (data != null) {
			return new String(data, "UTF-8");
		}
		return null;
	}
	
	/**
	 * Post 请求 
	 */
	public static byte[] sendPostToByte(String url, String param) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			
			byte[] buffer = new byte[1024];
			int len = 0;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			InputStream is = conn.getInputStream();
			while ((len = is.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.close();
	        return bos.toByteArray();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * SSL 请求（post） 
	 */
	public static String sendSSLPost(String url, String param) throws Exception {
		byte[] data = sendSSLPostToByte(url, param);
		if (data != null) {
			return new String(data, "UTF-8");
		}
		return null;
	}
	
	/**
	 * SSL 请求（post） 
	 */
	public static byte[] sendSSLPostToByte(String url, String param) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		// 获取证书
		FileInputStream instream = new FileInputStream(new File(WeixinpayConfigUtil.certPath));
		try {
			// 证书密码
			keyStore.load(instream, WeixinpayConfigUtil.certPasswd.toCharArray());
		} finally {
			instream.close();
		}
		SSLContext sslcontext = SSLContexts.custom()
				.loadKeyMaterial(keyStore, WeixinpayConfigUtil.certPasswd.toCharArray())// 这里也是写密码的
				.build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		try {
			HttpPost httpost = new HttpPost(url); // 设置响应头信息
			httpost.addHeader("Connection", "keep-alive");
			httpost.addHeader("Accept", "*/*");
			httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpost.addHeader("Host", "api.mch.weixin.qq.com");
			httpost.addHeader("X-Requested-With", "XMLHttpRequest");
			httpost.addHeader("Cache-Control", "max-age=0");
			httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
			httpost.setEntity(new StringEntity(param, "UTF-8"));
			CloseableHttpResponse response = httpclient.execute(httpost);
			try {
				HttpEntity entity = response.getEntity();
				byte[] data = EntityUtils.toByteArray(response.getEntity());
				// String data = EntityUtils.toString(response.getEntity(), "UTF-8");
				EntityUtils.consume(entity);
				return data;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

}