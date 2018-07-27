package cn.luozhuowei.weixinpay.bean;

import com.alibaba.fastjson.annotation.JSONField;
import cn.luozhuowei.weixinpay.util.WeixinpayConfigUtil;
import cn.luozhuowei.weixinpay.util.WeixinpayUtil;

/**
 * 下载资金账单请求
 * 
 * @author zhuowei.luo
 * @date 2018/7/13
 */
public class DownloadFundFlowRequest extends WeixinpayBaseRequest<WeixinpayBaseResponse> {

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

	@JSONField(name = "account_type")
	private String accountType; // 资金账户类型，账单的资金来源账户：Basic 基本账户；Operation 运营账户；Fees 手续费账户

	@JSONField(name = "tar_type")
	private String tarType; // 压缩账单，压缩类型，非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。

	/**
	 * 下载资金账单请求
	 * 
	 * @param billDate 对账单日期，下载对账单的日期，格式：yyyyMMdd
	 * @param accountType 资金账户类型，账单的资金来源账户：Basic 基本账户；Operation 运营账户；Fees 手续费账户
	 * @param tarType 压缩账单，压缩类型，非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	 */
	public DownloadFundFlowRequest(String billDate, String accountType, String tarType) {
		this();
		this.billDate = billDate;
		this.accountType = accountType;
		this.tarType = tarType;
	}

	public DownloadFundFlowRequest() {
		super("pay/downloadfundflow");
		super.ssl = true;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getTarType() {
		return tarType;
	}

	public void setTarType(String tarType) {
		this.tarType = tarType;
	}

}
