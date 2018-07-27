package cn.luozhuowei.alipay.service;

import java.io.UnsupportedEncodingException;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradeOrderSettleResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import cn.luozhuowei.alipay.bean.*;

/**
 * 阿里支付服务
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public interface AlipayApiService {
	
	/**
	 * 线下交易预创建 
	 * 
	 * @param request 请求参数
	 * @param notifyUrl 支付成功通知url
	 * @desc 交易预创建，根据接口返回生成二维码后，展示给用户，由用户扫描二维码完成订单支付
	 * @return outTradeNo 商户的订单号，qrCode 当前预下单请求生成的二维码码串
	 */
	public AlipayTradePrecreateResponse precreate(PrecreateRequest request, String notifyUrl) throws AlipayApiException;
	
	/**
	 * 交易创建 
	 * 
	 * @param request 请求参数
	 * @param notifyUrl 支付成功通知url
	 * @desc 交易的创建下单
	 * @return outTradeNo 商户的订单号，tradeNo 支付宝交易号
	 */
	public AlipayTradeCreateResponse create(CreateRequest request, String notifyUrl) throws AlipayApiException;
	
	/**
	 * 交易支付，商家扫用户支付宝二维码收款
	 * 
	 * @param request 请求参数
	 * @param notifyUrl 支付成功通知url
	 * @desc 商家扫码收款
	 */
	public AlipayTradePayResponse pay(PayRequest request, String notifyUrl) throws AlipayApiException;
	
	/**
	 * app客户端支付 （app sdk调用本地支付宝）
	 * 
	 * @param request 请求参数，可以为 null
	 * @param notifyUrl 支付成功通知url
	 * @return 给客户端请求的json字符串
	 * @desc 外部商户APP唤起快捷SDK创建订单并支付
	 */
	public String appClientPay(AppClientPayRequest request, String notifyUrl) throws AlipayApiException;
	
	/**
	 * app支付
	 * 
	 * @param request 请求参数，可以为 null
	 * @param notifyUrl 支付成功通知url
	 * @return outTradeNo 商户的订单号，tradeNo 支付宝交易号，totalAmount 该笔订单的资金总额(元)，sellerId 收款方用户id
	 * @desc 外部商户APP唤起快捷SDK创建订单并支付
	 */
	public AlipayTradeAppPayResponse appPay(AppPayRequest request, String notifyUrl) throws AlipayApiException;
	
	/**
	 * 支付（手机网站）
	 * 
	 * @return outTradeNo 商户的订单号，tradeNo 支付宝交易号，totalAmount 该笔订单的资金总额(元)，sellerId 收款方用户id
	 * @desc 手机网站支付，外部商户创建订单并支付
	 */
	public AlipayTradeWapPayResponse wapPay(WapPayRequest request, String notifyUrl) throws AlipayApiException;
	
	/**
	 * 交易关闭 
	 * 
	 * @desc 用于交易创建后，用户在一定时间内未进行支付，可调用该接口直接将未付款的交易进行关闭；<br>
	 * 	               商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；<br>
	 * 	               系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
	 */
	public AlipayTradeCloseResponse close(CloseRequest request) throws AlipayApiException;
	
	/**
	 * 交易撤销 
	 * 
	 * @desc 支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户
	 */
	public AlipayTradeCancelResponse cancel(CancelRequest request) throws AlipayApiException;
	
	/**
	 * 退款 
	 * 
	 * @desc 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，支付宝将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上<br>交易超过约定时间（签约时设置的可退款时间）的订单无法进行退款
	 */
	public RefundResponse refund(RefundRequest request) throws AlipayApiException;
	
	/**
	 * 交易结算 （分账）
	 * 
	 * @desc 交易支付后，进行结算（分账）
	 */
	public AlipayTradeOrderSettleResponse settle(SettleRequest request) throws AlipayApiException;
	
	/**
	 * 交易查询
	 * 
	 * @desc 该接口提供所有支付宝支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑
	 */
	public QueryResponse query(QueryRequest request) throws AlipayApiException;
	
	/**
	 * 退款查询
	 * 
	 * @desc 商户可使用该接口查询自已通过alipay.trade.refund提交的退款请求是否执行成功
	 */
	public RefundQueryResponse refundQuery(RefundQueryRequest request) throws AlipayApiException;
	
	/**
	 * 获取授权URL
	 * 
	 * @param redirectUri 重定向url
	 * @param scope 授权范围，默认auth_base
	 */
	public String getOauthUrl(String redirectUri, OauthScopeEnum scope) throws UnsupportedEncodingException;
	
	/**
	 * 根据授权码获取访问令牌、用户id
	 * 
	 * @return alipayUserId 用户id（交易创建请求中的buyerId），accessToken 访问令牌，refreshToken 刷新令牌
	 */
	public AlipaySystemOauthTokenResponse oauthToken(OauthTokenRequest request) throws AlipayApiException;
	
}
