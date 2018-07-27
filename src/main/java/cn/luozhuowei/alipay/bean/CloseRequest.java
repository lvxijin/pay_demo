package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 交易关闭请求
 */
public class CloseRequest extends AlipayBaseBean {

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 订单支付时传入的商户订单号,和支付宝交易号不能同时为空

	@JSONField(name = "trade_no")
	private String tradeNo; // 支付宝交易号，和商户订单号不能同时为空
	
	@JSONField(name = "operator_id")
	private String operatorId; // 卖家端自定义的的操作员 ID
	
	/**
	 * 交易关闭请求
	 * 
	 * @param outTradeNo 商户订单号，不能同时与tradeNo为空（参数二选一）
	 * @param tradeNo 支付宝交易号，不能同时与outTradeNo为空（参数二选一）
	 * @param operatorId 卖家端自定义的的操作员 ID
	 */
	public CloseRequest(String outTradeNo, String tradeNo, String operatorId) {
		this();
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.operatorId = operatorId;
	}
	
	public CloseRequest() {
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

}
