package cn.luozhuowei.alipay.bean;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.domain.VoucherDetail;
import com.alipay.api.response.AlipayTradeQueryResponse;

/**
 * 交易查询响应
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public class QueryResponse extends AlipayTradeQueryResponse {

	private static final long serialVersionUID = 1L;

	/**
	 * 支付宝店铺编号
	 */
	@Override
	public String getAlipayStoreId() {
		return super.getAlipayStoreId();
	}

	/**
	 * 预授权支付模式，该参数仅在信用预授权支付场景下返回。信用预授权支付：CREDIT_PREAUTH_PAY
	 */
	@Override
	public String getAuthTradePayMode() {
		return super.getAuthTradePayMode();
	}

	/**
	 * 买家支付宝账号
	 */
	@Override
	public String getBuyerLogonId() {
		return super.getBuyerLogonId();
	}

	/**
	 * 买家实付金额，单位为元，两位小数。该金额代表该笔交易买家实际支付的金额，不包含商户折扣等金额
	 */
	@Override
	public String getBuyerPayAmount() {
		return super.getBuyerPayAmount();
	}

	/**
	 * 买家在支付宝的用户id
	 */
	@Override
	public String getBuyerUserId() {
		return super.getBuyerUserId();
	}

	/**
	 * 买家用户类型。CORPORATE:企业用户；PRIVATE:个人用户。
	 */
	@Override
	public String getBuyerUserType() {
		return super.getBuyerUserType();
	}

	/**
	 * 平台优惠金额
	 */
	@Override
	public String getDiscountAmount() {
		return super.getDiscountAmount();
	}

	/**
	 * 本次交易支付所使用的单品券优惠的商品优惠信息
	 */
	@Override
	public String getDiscountGoodsDetail() {
		return super.getDiscountGoodsDetail();
	}

	/**
	 * 交易支付使用的资金渠道
	 */
	@Override
	public List<TradeFundBill> getFundBillList() {
		return super.getFundBillList();
	}

	/**
	 * 行业特殊信息（例如在医保卡支付业务中，向用户返回医疗信息）。
	 */
	@Override
	public String getIndustrySepcDetail() {
		return super.getIndustrySepcDetail();
	}

	/**
	 * 交易中用户支付的可开具发票的金额，单位为元，两位小数。该金额代表该笔交易中可以给用户开具发票的金额
	 */
	@Override
	public String getInvoiceAmount() {
		return super.getInvoiceAmount();
	}

	/**
	 * 商家优惠金额
	 */
	@Override
	public String getMdiscountAmount() {
		return super.getMdiscountAmount();
	}

	/**
	 * 买家支付宝用户号，该字段将废弃，不要使用
	 */
	@Override
	public String getOpenId() {
		return super.getOpenId();
	}

	/**
	 * 商家订单号
	 */
	@Override
	public String getOutTradeNo() {
		return super.getOutTradeNo();
	}

	/**
	 * 支付币种订单金额
	 */
	@Override
	public String getPayAmount() {
		return super.getPayAmount();
	}

	/**
	 * 订单支付币种
	 */
	@Override
	public String getPayCurrency() {
		return super.getPayCurrency();
	}

	/**
	 * 积分支付的金额，单位为元，两位小数。该金额代表该笔交易中用户使用积分支付的金额，比如集分宝或者支付宝实时优惠等
	 */
	@Override
	public String getPointAmount() {
		return super.getPointAmount();
	}

	/**
	 * 实收金额，单位为元，两位小数。该金额为本笔交易，商户账户能够实际收到的金额
	 */
	@Override
	public String getReceiptAmount() {
		return super.getReceiptAmount();
	}

	/**
	 * 本次交易打款给卖家的时间
	 */
	@Override
	public Date getSendPayDate() {
		return super.getSendPayDate();
	}

	/**
	 * 结算币种订单金额
	 */
	@Override
	public String getSettleAmount() {
		return super.getSettleAmount();
	}

	/**
	 * 订单结算币种，对应支付接口传入的settle_currency，支持英镑：GBP、港币：HKD、美元：USD、新加坡元：SGD、日元：JPY、
	 * 加拿大元：CAD、澳元：AUD、欧元：EUR、新西兰元：NZD、韩元：KRW、泰铢：THB、瑞士法郎：CHF、瑞典克朗：SEK、丹麦克朗：DKK、
	 * 挪威克朗：NOK、马来西亚林吉特：MYR、印尼卢比：IDR、菲律宾比索：PHP、毛里求斯卢比：MUR、以色列新谢克尔：ILS、斯里兰卡卢比：LKR
	 * 、俄罗斯卢布：RUB、阿联酋迪拉姆：AED、捷克克朗：CZK、南非兰特：ZAR
	 */
	@Override
	public String getSettleCurrency() {
		return super.getSettleCurrency();
	}

	/**
	 * 结算币种兑换标价币种汇率
	 */
	@Override
	public String getSettleTransRate() {
		return super.getSettleTransRate();
	}

	/**
	 * 商户门店编号
	 */
	@Override
	public String getStoreId() {
		return super.getStoreId();
	}

	/**
	 * 请求交易支付中的商户店铺的名称
	 */
	@Override
	public String getStoreName() {
		return super.getStoreName();
	}

	/**
	 * 商户机具终端编号
	 */
	@Override
	public String getTerminalId() {
		return super.getTerminalId();
	}

	/**
	 * 交易的订单金额，单位为元，两位小数。该参数的值为支付时传入的total_amount
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

	/**
	 * 交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、
	 * TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）
	 */
	@Override
	public String getTradeStatus() {
		return super.getTradeStatus();
	}

	/**
	 * 标价币种，该参数的值为支付时传入的trans_currency，支持英镑：GBP、港币：HKD、美元：USD、新加坡元：SGD、日元：JPY、
	 * 加拿大元：CAD、澳元：AUD、欧元：EUR、新西兰元：NZD、韩元：KRW、泰铢：THB、瑞士法郎：CHF、瑞典克朗：SEK、丹麦克朗：DKK、
	 * 挪威克朗：NOK、马来西亚林吉特：MYR、印尼卢比：IDR、菲律宾比索：PHP、毛里求斯卢比：MUR、以色列新谢克尔：ILS、斯里兰卡卢比：LKR
	 * 、俄罗斯卢布：RUB、阿联酋迪拉姆：AED、捷克克朗：CZK、南非兰特：ZAR、人民币：CNY、新台币：TWD。当trans_currency 和
	 * settle_currency 不一致时，trans_currency支持人民币：CNY、新台币：TWD
	 */
	@Override
	public String getTransCurrency() {
		return super.getTransCurrency();
	}

	/**
	 * 标价币种兑换支付币种汇率
	 */
	@Override
	public String getTransPayRate() {
		return super.getTransPayRate();
	}

	/**
	 * 本交易支付时使用的所有优惠券信息
	 */
	@Override
	public List<VoucherDetail> getVoucherDetailList() {
		return super.getVoucherDetailList();
	}
	
	/**
	 * 获取当前订单状态 
	 */
	public OrderPayStatusEnum getOrderPayStatus() {
		return OrderPayStatusEnum.of(getTradeStatus());
	}

	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
}
