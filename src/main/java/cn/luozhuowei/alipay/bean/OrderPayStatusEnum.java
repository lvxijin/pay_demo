package cn.luozhuowei.alipay.bean;

import cn.luozhuowei.common.OrderEntityEnum;

/**
 * 订单支付状态
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public enum OrderPayStatusEnum {

	/**
	 * 交易创建，等待买家付款 
	 */
	WAIT_BUYER_PAY("WAIT_BUYER_PAY", OrderEntityEnum.ORDERSTATUS_PAY, "交易创建，等待买家付款"),
	
	/**
	 * 未付款交易超时关闭，或支付完成后全额退款 
	 */
	TRADE_CLOSED("TRADE_CLOSED", OrderEntityEnum.ORDERSTATUS_FIAL_REFUNDED, "未付款交易超时关闭，或支付完成后全额退款"),
	
	/**
	 * 交易支付成功 
	 */
	TRADE_SUCCESS("TRADE_SUCCESS", OrderEntityEnum.ORDERSTATUS_SUC, "交易支付成功"),
	
	/**
	 * 交易结束，不可退款 
	 */
	TRADE_FINISHED("TRADE_FINISHED", OrderEntityEnum.ORDERSTATUS_CLOSE, "交易结束，不可退款"),
	
	/**
	 * 未知 
	 */
	UNKNOWN("", null, "未知");
	
	private String tradeStatus;
	private Integer payStatus;
	private String desc;
	
	private OrderPayStatusEnum(String tradeStatus, OrderEntityEnum status, String desc){
		this.tradeStatus = tradeStatus;
		if (status != null) {
			this.payStatus = status.getStatus();
		} else {
			this.payStatus = -1;
		}
		this.desc = desc;
	}
	
	/**
	 * 交易状态code 
	 */
	public String getTradeStatus() {
		return tradeStatus;
	}
	
	/**
	 * 状态描述 
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 业务支付状态 
	 */
	public Integer getPayStatus() {
		return payStatus;
	}
	
	private OrderPayStatusEnum setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
		return this;
	}
	
	public static OrderPayStatusEnum of(String tradeStatus) {
		if (tradeStatus == null) {
			return UNKNOWN.setTradeStatus(tradeStatus);
		}
		OrderPayStatusEnum[] values = OrderPayStatusEnum.values();
		if (values != null) {
			for (OrderPayStatusEnum status : values) {
				if (tradeStatus.equalsIgnoreCase(status.tradeStatus)) {
					return status;
				}
			}
		}
		return UNKNOWN.setTradeStatus(tradeStatus);
	}
	
}
