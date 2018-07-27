package cn.luozhuowei.weixinpay.bean;

/**
 * 微信异常
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class WeixinpayException extends Exception {

	private static final long serialVersionUID = 1L;

	public WeixinpayException(String message) {
		super(message);
	}

	public WeixinpayException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeixinpayException(Throwable cause) {
		super(cause);
	}
	
}
