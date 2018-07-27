package cn.luozhuowei.alipay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.api.domain.OpenApiRoyaltyDetailInfoPojo;

/**
 * 交易结算 （分账）请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class SettleRequest extends AlipayBaseBean{

	private static final long serialVersionUID = 1L;

	@JSONField(name = "out_request_no")
	private String outRequestNo; // 结算请求流水号 开发者自行生成并保证唯一性（必填）
	
	@JSONField(name = "trade_no")
	private String tradeNo; // 支付宝订单号（必填）
	
	@JSONField(name = "royalty_parameters")
	private OpenApiRoyaltyDetailInfoPojo royaltyParameters; // 分账明细信息（必填）
	
	@JSONField(name = "operator_id")
	private String operatorId; // 操作员id
	
	/**
	 * 交易结算 （分账）请求
	 * 
	 * @param outRequestNo 结算请求流水号 开发者自行生成并保证唯一性（必填）
	 * @param tradeNo 支付宝订单号（必填）
	 * @param royaltyParameters 分账明细信息（必填）
	 * @param operatorId 操作员id
	 */
	public SettleRequest(String outRequestNo, String tradeNo, OpenApiRoyaltyDetailInfoPojo royaltyParameters,
			String operatorId) {
		this();
		this.outRequestNo = outRequestNo;
		this.tradeNo = tradeNo;
		this.royaltyParameters = royaltyParameters;
		this.operatorId = operatorId;
	}
	
	public SettleRequest() {
	}

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public OpenApiRoyaltyDetailInfoPojo getRoyaltyParameters() {
		return royaltyParameters;
	}

	public void setRoyaltyParameters(OpenApiRoyaltyDetailInfoPojo royaltyParameters) {
		this.royaltyParameters = royaltyParameters;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
}
