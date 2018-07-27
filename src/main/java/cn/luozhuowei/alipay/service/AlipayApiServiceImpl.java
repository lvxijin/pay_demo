package cn.luozhuowei.alipay.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.luozhuowei.alipay.bean.*;
import cn.luozhuowei.alipay.util.*;
import cn.luozhuowei.common.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeOrderSettleRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeOrderSettleResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;

/**
 * 阿里支付服务
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public class AlipayApiServiceImpl implements AlipayApiService {

	private static final Logger logger = LoggerFactory.getLogger(AlipayApiServiceImpl.class);
	private AlipayClient client = AlipayClientUtil.getDefaultAlipayClient();
	
	@Override
	public AlipayTradePrecreateResponse precreate(PrecreateRequest request, String notifyUrl) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradePrecreateRequest req = new AlipayTradePrecreateRequest();
			req.setNotifyUrl(notifyUrl);
			req.setBizContent(json);
			AlipayTradePrecreateResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.precreate，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.precreate，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.precreate，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradeCreateResponse create(CreateRequest request, String notifyUrl) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeCreateRequest req = new AlipayTradeCreateRequest();
			req.setNotifyUrl(notifyUrl);
			req.setBizContent(json);
			AlipayTradeCreateResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.create，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.create，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.create，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradePayResponse pay(PayRequest request, String notifyUrl) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradePayRequest req = new AlipayTradePayRequest();
			req.setNotifyUrl(notifyUrl);
			req.setBizContent(json);
			AlipayTradePayResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.pay，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.pay，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.pay，请求异常！req={}", json, e);
			throw e;
		}
	}
	
	@Override
	public String appClientPay(AppClientPayRequest request, String notifyUrl) throws AlipayApiException {
		String json = null;
		try {
			if (request != null) {
				json = request.toJson();
			}
			AlipayTradeAppPayRequest req = new AlipayTradeAppPayRequest();
			req.setNotifyUrl(notifyUrl);
			req.setBizContent(json);
			AlipayTradeAppPayResponse resp = client.pageExecute(req, "GET");
			String url = resp.getBody();
			return url.substring(url.indexOf("?") + 1);
		} catch (AlipayApiException e) {
			logger.error("alipay.appClientPay，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradeAppPayResponse appPay(AppPayRequest request, String notifyUrl) throws AlipayApiException {
		String json = null;
		try {
			if (request != null) {
				json = request.toJson();
			}
			AlipayTradeAppPayRequest req = new AlipayTradeAppPayRequest();
			req.setNotifyUrl(notifyUrl);
			req.setBizContent(json);
			AlipayTradeAppPayResponse resp = client.pageExecute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.appPay，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.appPay，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.appPay，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradeWapPayResponse wapPay(WapPayRequest request, String notifyUrl) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeWapPayRequest req = new AlipayTradeWapPayRequest();
			req.setNotifyUrl(notifyUrl);
			req.setBizContent(json);
			AlipayTradeWapPayResponse resp = client.pageExecute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.wapPay，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.wapPay，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.wapPay，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradeCloseResponse close(CloseRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeCloseRequest req = new AlipayTradeCloseRequest();
			req.setBizContent(json);
			AlipayTradeCloseResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.close，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.close，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.close，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradeCancelResponse cancel(CancelRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeCancelRequest req = new AlipayTradeCancelRequest();
			req.setBizContent(json);
			AlipayTradeCancelResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.cancel，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.cancel，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.cancel，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public RefundResponse refund(RefundRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeRefundRequest req = new AlipayTradeRefundRequest();
			req.setBizContent(json);
			AlipayTradeRefundResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.refund，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.refund，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			RefundResponse response = new RefundResponse();
			BeanUtils.copyProperties(resp, response);
			return response;
		} catch (AlipayApiException e) {
			logger.error("alipay.refund，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public AlipayTradeOrderSettleResponse settle(SettleRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeOrderSettleRequest req = new AlipayTradeOrderSettleRequest();
			req.setBizContent(json);
			AlipayTradeOrderSettleResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.settle，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.settle，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.settle，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public QueryResponse query(QueryRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeQueryRequest req = new AlipayTradeQueryRequest();
			req.setBizContent(json);
			AlipayTradeQueryResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.query，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.query，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			QueryResponse response = new QueryResponse();
			BeanUtils.copyProperties(resp, response);
			return response;
		} catch (AlipayApiException e) {
			logger.error("alipay.query，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public RefundQueryResponse refundQuery(RefundQueryRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipayTradeFastpayRefundQueryRequest req = new AlipayTradeFastpayRefundQueryRequest();
			req.setBizContent(json);
			AlipayTradeFastpayRefundQueryResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.refundQuery，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.refundQuery，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			RefundQueryResponse response = new RefundQueryResponse();
			BeanUtils.copyProperties(resp, response);
			return response;
		} catch (AlipayApiException e) {
			logger.error("alipay.refundQuery，请求异常！req={}", json, e);
			throw e;
		}
	}

	@Override
	public String getOauthUrl(String redirectUri, OauthScopeEnum scope) throws UnsupportedEncodingException {
		try {
			if (scope == null) {
				scope = OauthScopeEnum.AUTH_BASE;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(AlipayConfigUtil.oauthUrl);
			sb.append("?app_id=").append(AlipayConfigUtil.appId);
			sb.append("&scope=").append(scope.getScope());
			sb.append("&redirect_uri=").append(URLEncoder.encode(redirectUri, AlipayConfigUtil.charset));
			logger.info("alipay.getOauthUrl，redirectUri={}，url={} ", redirectUri, sb.toString());
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			logger.error("alipay.getOauthUrl，redirectUri={}", redirectUri, e);
			throw e;
		}
	}
	
	@Override
	public AlipaySystemOauthTokenResponse oauthToken(OauthTokenRequest request) throws AlipayApiException {
		String json = null;
		try {
			json = request.toJson();
			AlipaySystemOauthTokenRequest req = new AlipaySystemOauthTokenRequest();
			req.setGrantType(request.getGrantType());
			req.setCode(request.getCode());
			req.setRefreshToken(request.getRefreshToken());
			AlipaySystemOauthTokenResponse resp = client.execute(req);
			if (resp != null && resp.isSuccess()) {
				logger.info("alipay.precreate，执行请求！req={}, resp={}", json, JSONObject.toJSONString(resp));
			} else {
				logger.error("alipay.precreate，请求失败！req={}, resp={}", json, JSONObject.toJSONString(resp));
			}
			return resp;
		} catch (AlipayApiException e) {
			logger.error("alipay.precreate，请求异常！req={}", json, e);
			throw e;
		}
	}
}
