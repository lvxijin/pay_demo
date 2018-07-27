package cn.luozhuowei.weixinpay.bean;

import cn.luozhuowei.common.OrderEntityEnum;

/**
 * 微信订单状态枚举
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public enum OrderTradeStateEnum {
	
	/**
	 * 支付成功，付款成功
	 */
	SUCCESS("SUCCESS", OrderEntityEnum.ORDERSTATUS_SUC, "支付成功"),

	/**
	 * 转入退款，已经退款
	 */
	REFUND("REFUND", OrderEntityEnum.ORDERSTATUS_FIAL_REFUNDED, "转入退款"),

	/**
	 * 未支付，已统一下单，客户未支付
	 */
	NOTPAY("NOTPAY", OrderEntityEnum.ORDERSTATUS, "未支付"),

	/**
	 * 已关闭
	 */
	CLOSED("CLOSED", OrderEntityEnum.ORDERSTATUS_CLOSE, "已关闭"),

	/**
	 * 已撤销（刷卡支付）
	 */
	REVOKED("REVOKED", OrderEntityEnum.ORDERSTATUS_REVOKED, "已撤销（刷卡支付）"),

	/**
	 * 用户支付中
	 */
	USERPAYING("USERPAYING", OrderEntityEnum.ORDERSTATUS_PAY, "用户支付中"),

	/**
	 * 支付失败(其他原因，如银行返回失败)
	 */
	PAYERROR("PAYERROR", OrderEntityEnum.ORDERSTATUS_FIAL, "支付失败(其他原因，如银行返回失败)"),

	/**
	 * 未知
	 */
	UNKNOWN("", null, "未知");

	private String tradeState;
	private Integer payStatus;
	private String desc;

	private OrderTradeStateEnum(String tradeState, OrderEntityEnum status, String desc) {
		this.tradeState = tradeState;
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
		return tradeState;
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

	private OrderTradeStateEnum setTradeStatus(String tradeState) {
		this.tradeState = tradeState;
		return this;
	}

	public static OrderTradeStateEnum of(String tradeState) {
		if (tradeState == null) {
			return UNKNOWN.setTradeStatus(tradeState);
		}
		OrderTradeStateEnum[] values = OrderTradeStateEnum.values();
		if (values != null) {
			for (OrderTradeStateEnum status : values) {
				if (tradeState.equalsIgnoreCase(status.tradeState)) {
					return status;
				}
			}
		}
		return UNKNOWN.setTradeStatus(tradeState);
	}
	
	@Override
	public String toString() {
		return "OrderTradeStateEnum{\"tradeState\": " + tradeState + ", \"desc\": " + desc + "}";
	}
	
}
