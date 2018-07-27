package cn.luozhuowei.test;

import java.io.UnsupportedEncodingException;

import com.alipay.api.AlipayApiException;

import cn.luozhuowei.alipay.bean.QueryRequest;
import cn.luozhuowei.alipay.bean.QueryResponse;
import cn.luozhuowei.alipay.service.AlipayApiService;
import cn.luozhuowei.alipay.service.AlipayApiServiceImpl;

/**
 * 支付宝支付测试
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public class AlipayTest {

	public static void main(String[] args) throws AlipayApiException, UnsupportedEncodingException {
		AlipayApiService service = new AlipayApiServiceImpl();
		QueryResponse resp = service.query(new QueryRequest("1531474671720", null));
		System.out.println(resp);
		System.out.println(resp.getTradeStatus());
		System.out.println(resp.isSuccess());
	}
	
}
