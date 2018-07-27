package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 下载历史交易清单请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/13
 */
public class DownloadBillRequest extends WeixinpayBaseRequest<WeixinpayBaseResponse> {

	private static final long serialVersionUID = 1L;
	public static final String DATE_FORMAT = "yyyyMMdd";

	@JSONField(name = "appid")
	private String appId; // 微信开放平台审核通过的应用APPID

	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号

	@JSONField(name = "nonce_str")
	private String nonceStr; // 随机字符串

	@JSONField(name = "bill_date")
	private String billDate; // 对账单日期，下载对账单的日期，格式：yyyyMMdd
	
	@JSONField(name = "bill_type")
	private String billType; // 账单类型，ALL，返回当日所有订单信息; 默认值 SUCCESS，返回当日成功支付的订单;REFUND，返回当日退款订单;RECHARGE_REFUND，返回当日充值退款订单
	
	@JSONField(name = "tar_type")
	private String tarType; // 压缩账单，压缩类型，非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	
	/**
	 * 下载历史交易清单请求
	 * 
	 * @param billDate 对账单日期，下载对账单的日期，格式：yyyyMMdd
	 * @param billType 账单类型，ALL，返回当日所有订单信息，默认值; SUCCESS，返回当日成功支付的订单;REFUND，返回当日退款订单;RECHARGE_REFUND，返回当日充值退款订单
	 * @param tarType 压缩账单，压缩类型，非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	 */
	public DownloadBillRequest(String billDate, String billType, String tarType) {
		this();
		this.billDate = billDate;
		this.billType = billType;
		this.tarType = tarType;
	}

	public DownloadBillRequest() {
		super("pay/downloadbill");
		this.appId = WeixinpayConfigUtil.appId;
		this.mchId = WeixinpayConfigUtil.mchId;
		this.nonceStr = WeixinpayUtil.getRandomString(15);
	}

	@Override
	public Class<WeixinpayBaseResponse> getResponseClass() {
		return WeixinpayBaseResponse.class;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	
	public String getBillType() {
		return billType;
	}
	
	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getTarType() {
		return tarType;
	}

	public void setTarType(String tarType) {
		this.tarType = tarType;
	}

}
