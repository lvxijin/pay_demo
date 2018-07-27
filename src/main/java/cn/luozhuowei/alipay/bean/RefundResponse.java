package cn.luozhuowei.alipay.bean;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.response.AlipayTradeRefundResponse;

/**
 * 退款响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class RefundResponse extends AlipayTradeRefundResponse {

	private static final long serialVersionUID = 1L;

	/** 
	 * 用户的登录id
	 */
	@Override
	public String getBuyerLogonId() {
		return super.getBuyerLogonId();
	}

	/** 
	 * 买家在支付宝的用户id
	 */
	@Override
	public String getBuyerUserId() {
		return super.getBuyerUserId();
	}

	/** 
	 * 本次退款是否发生了资金变化
	 */
	@Override
	public String getFundChange() {
		return super.getFundChange();
	}
	
	/** 
	 * 退款支付时间
	 */
	@Override
	public Date getGmtRefundPay() {
		return super.getGmtRefundPay();
	}
	
	/** 
	 * 商户订单号
	 */
	@Override
	public String getOutTradeNo() {
		return super.getOutTradeNo();
	}

	/** 
	 * 本次退款金额中买家退款金额
	 */
	@Override
	public String getPresentRefundBuyerAmount() {
		return super.getPresentRefundBuyerAmount();
	}

	/** 
	 * 本次退款金额中平台优惠退款金额
	 */
	@Override
	public String getPresentRefundDiscountAmount() {
		return super.getPresentRefundDiscountAmount();
	}

	/** 
	 * 本次退款金额中商家优惠退款金额
	 */
	@Override
	public String getPresentRefundMdiscountAmount() {
		return super.getPresentRefundMdiscountAmount();
	}
	
	/** 
	 * 退款币种信息
	 */
	@Override
	public String getRefundCurrency() {
		return super.getRefundCurrency();
	}

	/** 
	 * 退款使用的资金渠道
	 */
	@Override
	public List<TradeFundBill> getRefundDetailItemList() {
		return super.getRefundDetailItemList();
	}

	/** 
	 * 退款总金额
	 */
	@Override
	public String getRefundFee() {
		return super.getRefundFee();
	}

	/** 
	 * 本次商户实际退回金额<br> 
	 * 注：在签约收单产品时需勾选“返回资金明细”才会返回
	 */
	@Override
	public String getSendBackFee() {
		return super.getSendBackFee();
	}

	/** 
	 * 交易在支付时候的门店名称
	 */
	@Override
	public String getStoreName() {
		return super.getStoreName();
	}

	/**
	 * 支付宝交易号
	 */
	@Override
	public String getTradeNo() {
		return super.getTradeNo();
	}
	
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
	@Override
	public String toString() {
		return toJson();
	}

}
