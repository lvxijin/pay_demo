package cn.luozhuowei.weixinpay.bean;

/**
 * 微信签名异常
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public class WeixinpaySignException extends WeixinpayException {

	private static final long serialVersionUID = 1L;

	public WeixinpaySignException(String message) {
		super(message);
	}

	public WeixinpaySignException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeixinpaySignException(Throwable cause) {
		super(cause);
	}

}
