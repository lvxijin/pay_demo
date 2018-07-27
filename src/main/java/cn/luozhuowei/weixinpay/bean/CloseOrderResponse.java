package cn.luozhuowei.weixinpay.bean;

/**
 * 关闭订单响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class CloseOrderResponse extends WeixinpayBaseResponse {

	private static final long serialVersionUID = 1L;

	public CloseOrderResponse() {
		super(true);
	}

	@Override
	public boolean isSuccess() {
		return isRequestSuccess();
	}

}
