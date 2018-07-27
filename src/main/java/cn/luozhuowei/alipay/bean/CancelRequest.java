package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 交易撤销请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class CancelRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;
	
	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 订单支付时传入的商户订单号,和支付宝交易号不能同时为空

	@JSONField(name = "trade_no")
	private String tradeNo; // 支付宝交易号，和商户订单号不能同时为空
	
	/**
	 * 交易撤销请求
	 * 
	 * @param outTradeNo 商户订单号，不能同时与tradeNo为空（参数二选一）
	 * @param tradeNo 支付宝交易号，不能同时与outTradeNo为空（参数二选一）
	 * @param operatorId 卖家端自定义的的操作员 ID
	 */
	public CancelRequest(String outTradeNo, String tradeNo) {
		this();
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
	}

	public CancelRequest() {
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
}
