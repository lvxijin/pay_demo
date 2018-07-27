package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 退款查询
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class RefundQueryRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 商户订单号,和支付宝交易号不能同时为空
	
	@JSONField(name = "trade_no")
	private String tradeNo; // 支付宝交易号，和商户订单号不能同时为空
	
	@JSONField(name = "out_request_no")
	private String outRequestNo; // 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号（必填）
	
	/**
	 * 退款查询
	 * 
	 * @param outTradeNo 商户订单号，不能同时与tradeNo为空（参数二选一）
	 * @param tradeNo 支付宝交易号，不能同时与outTradeNo为空（参数二选一）
	 * @param outRequestNo 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号（必填）
	 */
	public RefundQueryRequest(String outTradeNo, String tradeNo, String outRequestNo) {
		this();
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.outRequestNo = outRequestNo;
	}
	
	/**
	 * 退款查询
	 * 
	 * @param tradeNo 支付宝交易号
	 */
	public RefundQueryRequest(String tradeNo) {
		this();
		this.tradeNo = tradeNo;
		this.outRequestNo = tradeNo;
	}
	
	public RefundQueryRequest(){
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

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}
	
}
