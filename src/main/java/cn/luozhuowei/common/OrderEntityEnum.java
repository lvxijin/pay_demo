package cn.luozhuowei.common;

/**
 * 订单状态枚举
 * 
 * @author zhuowei.luo
 */
public enum OrderEntityEnum {

	/**
	 * 未支付，刚下单
	 */
	ORDERSTATUS(1, "未支付，刚下单"),

	/**
	 * 刚下单之后，开始预支付
	 */
	ORDERSTATUS_PAY(3, "刚下单之后，开始预支付"),

	/**
	 * 支付成功
	 */
	ORDERSTATUS_SUC(2, "支付成功"),

	/**
	 * 支付失败
	 */
	ORDERSTATUS_FIAL(4, "支付时，支付失败"),

	/**
	 * 长时间未支付
	 */
	ORDERSTATUS_TIME_OUT(5, "长时间未支付"),

	/**
	 * 退款
	 */
	ORDERSTATUS_FIAL_REFUNDED(6, "退款"),

	/**
	 * 订单已关闭
	 */
	ORDERSTATUS_CLOSE(7, "订单已关闭"),

	/**
	 * 订单已撤销
	 */
	ORDERSTATUS_REVOKED(8, "订单已撤销");

	private Integer status;
	private String desc;

	private OrderEntityEnum(Integer status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public static OrderEntityEnum of(Integer status) {
		if (status != null) {
			OrderEntityEnum[] values = values();
			if (values != null) {
				for (OrderEntityEnum t : values) {
					if (t.status.equals(status)) {
						return t;
					}
				}
			}
		}
		return null;
	}
	
	public boolean equals(Integer status) {
		return this.status.equals(status);
	}

	public Integer getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}
	
}
