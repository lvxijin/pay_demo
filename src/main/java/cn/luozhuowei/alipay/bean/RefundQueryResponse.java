package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;

/**
 * 退款查询响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class RefundQueryResponse extends AlipayTradeFastpayRefundQueryResponse {

	private static final long serialVersionUID = 1L;

	/** 
	 * 退款失败错误码。只在使用异步退款接口情况下才会返回该字段
	 */
	@Override
	public String getErrorCode() {
		return super.getErrorCode();
	}

	/** 
	 * 行业特殊信息（例如在医保卡支付退款中，医保局向商户返回医疗信息）。
	 */
	@Override
	public String getIndustrySepcDetail() {
		return super.getIndustrySepcDetail();
	}

	/** 
	 * 本笔退款对应的退款请求号
	 */
	@Override
	public String getOutRequestNo() {
		return super.getOutRequestNo();
	}

	/** 
	 * 创建交易传入的商户订单号
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
	 * 本次退款请求，对应的退款金额
	 */
	@Override
	public String getRefundAmount() {
		return super.getRefundAmount();
	}

	/** 
	 * 发起退款时，传入的退款原因
	 */
	@Override
	public String getRefundReason() {
		return super.getRefundReason();
	}

	/** 
	 * 该笔退款所对应的交易的订单金额
	 */
	@Override
	public String getTotalAmount() {
		return super.getTotalAmount();
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
