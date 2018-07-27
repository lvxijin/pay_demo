package cn.luozhuowei.alipay.bean;

import java.io.Serializable;
import java.text.DecimalFormat;

import com.alibaba.fastjson.JSONObject;

/**
 * Alipay Base Bean.
 * 
 * @author zhuowei.luo
 * @date 2018/7/9
 */
public class AlipayBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return toJson();
	}
	
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
	/**
	 * 保留两位小数 
	 */
	public static String toMoneyStr(Double money) {
		if (money != null) {
			DecimalFormat df = new DecimalFormat("#.##");
			return df.format(money);
		} else {
			return null;
		}
	}
	
}
