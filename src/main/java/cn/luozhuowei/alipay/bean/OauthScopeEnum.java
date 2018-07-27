package cn.luozhuowei.alipay.bean;

/**
 * 授权范围枚举
 * 
 * @author zhuowei.luo
 * @date 2018/7/10
 */
public enum OauthScopeEnum {

	/**
	 * 用户信息授权（静默）
	 */
	AUTH_BASE("auth_base"),

	/**
	 * 获取用户信息（非静默）
	 */
	AUTH_USER("auth_user");

	private String scope;

	private OauthScopeEnum(String scope) {
		this.scope = scope;
	}

	public String getScope() {
		return scope;
	}
}
