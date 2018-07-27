package cn.luozhuowei.weixinpay.service;

import cn.luozhuowei.weixinpay.bean.*;

/**
 * 微信支付服务
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 */
public interface WeixinpayApiService {

	/**
	 * 统一下单请求（服务器下单，App端调用微信支付）
	 * 
	 * @desc 商户系统先调用该接口在微信支付服务后台生成预支付交易单<br>返回正确的预支付交易会话标识后再在APP里面调起支付。
	 */
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request) throws WeixinpayException;
	
	/**
	 * app客户端支付（调用微信sdk）
	 * 
	 * @param parentId 通过统一下单接口返回的预支付回话标识
	 * @desc APP唤起快捷SDK支付的请求json
	 */
	public String appClientPay(String parentId);
	
	/**
	 * 订单查询
	 * 
	 * @desc 商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑
	 */
	public OrderQueryResponse orderQuery(OrderQueryRequest request) throws WeixinpayException;
	
	/**
	 * 关闭订单 
	 * 
	 * @desc 用于交易创建后，用户在一定时间内未进行支付，可调用该接口直接将未付款的交易进行关闭；<br>
	 * 	               商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；<br>
	 * 	               系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
	 */
	public CloseOrderResponse closeOrder(CloseOrderRequest request) throws WeixinpayException;
	
	/**
	 * 退款 
	 * 
	 * @desc 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号。
	 */
	public RefundResponse refund(RefundRequest request) throws WeixinpayException;
	
	/**
	 * 退款查询 
	 * 
	 * @desc 提交退款申请后，通过调用该接口查询退款状态。<br>
	 *       退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
	 */
	public RefundQueryResponse refundQuery(RefundQueryRequest request) throws WeixinpayException;
	
	/**
	 * 下载对账单
	 * 
	 * @desc 商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。
	 * @api https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_6&index=8
	 * @return 返回响应字节数据，具体解析参考@api
	 */
	public byte[] downloadBill(DownloadBillRequest request) throws WeixinpayException;
	
	/**
	 * 下载历史交易清单
	 * 
	 * @desc 商户可以通过该接口下载自2017年6月1日起 的历史资金流水账单。
	 * @api https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_18&index=9
	 * @return 返回响应字节数据，具体解析参考@api
	 */
	public byte[] downloadFundFlow(DownloadBillRequest request) throws WeixinpayException;
	
}
