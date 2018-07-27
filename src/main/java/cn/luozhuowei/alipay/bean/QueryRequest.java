package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 交易查询
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class QueryRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 订单支付时传入的商户订单号,和支付宝交易号不能同时为空
	
	@JSONField(name = "trade_no")
	private String tradeNo; // 支付宝交易号，和商户订单号不能同时为空

	/**
	 * 交易查询（参数二选一）
	 * 
	 * @param outTradeNo 商户订单号
	 * @param tradeNo 支付宝交易号
	 */
	public QueryRequest(String outTradeNo, String tradeNo) {
		this();
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
	}
	
	public QueryRequest() {
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
