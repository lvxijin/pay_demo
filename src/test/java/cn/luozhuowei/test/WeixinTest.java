package cn.luozhuowei.test;

import cn.luozhuowei.weixinpay.bean.OrderQueryRequest;
import cn.luozhuowei.weixinpay.bean.OrderQueryResponse;
import cn.luozhuowei.weixinpay.service.WeixinpayApiService;
import cn.luozhuowei.weixinpay.service.WeixinpayApiServiceImpl;

/**
 * 微信支付测试
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public class WeixinTest {

	public static void main(String[] args) throws Exception {
		WeixinpayApiService service = new WeixinpayApiServiceImpl();
		OrderQueryResponse query = service.orderQuery(new OrderQueryRequest("1531466414098", null));
		System.out.println(query);
		System.out.println(query.getOrderTradeStateEnum());
		System.out.println(query.isRequestSuccess() && query.isSuccess());
	}
	
}
