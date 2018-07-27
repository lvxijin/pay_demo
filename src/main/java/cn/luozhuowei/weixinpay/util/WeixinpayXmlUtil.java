package cn.luozhuowei.weixinpay.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信支付XML工具类
 * 
 * @author zhuowei.luo
 * @date 2018/7/12
 * @desc 微信返回结果傻的一逼，一个数组就能解决的它用$下标的方式，坑爹！！！
 */
public class WeixinpayXmlUtil {

	/**
	 * xml转换成json
	 * 
	 * @param xml xml字符串
	 * @param retainRootNode 是否保留根节点
	 * @param valueToArray true 键值对中值保存为数组类型，false 键值对形式，相同会替换
	 */
	public static JSONObject xmlToJson(String xml, boolean retainRootNode, boolean valueToArray) {
		return xmlToJson(xml, retainRootNode, valueToArray, null, null);
	}
	
	/**
	 * xml转换成json
	 * 
	 * @param xml xml字符串
	 * @param retainRootNode 是否保留根节点
	 * @param valueToArray true 键值对中值保存为数组类型，false 键值对形式，相同会替换
	 * @param groupByArrStartKeys 解析xml元素按下标$组成数组的参数的开始字符
	 * @param groupMax$Count 解析xml元素按下标$最多有多少个
	 */
	public static JSONObject xmlToJson(String xml, boolean retainRootNode, boolean valueToArray,
			Set<String> groupByArrStartKeys, Integer groupMax$Count) {
		JSONObject obj;
		try {
			InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(is);
			Element root = doc.getRootElement();
			if (retainRootNode) {
				obj = new JSONObject();
				obj.put(root.getName(), iterateElement(root, valueToArray));
			} else {
				obj = new JSONObject(iterateElement(root, valueToArray));
			}
			is.close();
			if (groupByArrStartKeys != null && !groupByArrStartKeys.isEmpty() && groupMax$Count != null
					&& groupMax$Count > 0) {
				try {
					group(obj, groupByArrStartKeys, groupMax$Count);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> iterateElement(Element element, boolean valueArray) {
		List<Element> nodes = element.getChildren();
		Element e = null;
		Map<String, Object> map = new HashMap<>();
		if (valueArray) {
			List<Object> list = null;
			for (int i = 0; i < nodes.size(); i++) {
				list = new LinkedList<>();
				e = nodes.get(i);
				if ("".equals(e.getTextTrim())) {
					if (e.getChildren().size() == 0) {
						continue;
					}
					if (map.containsKey(e.getName())) {
						list = (List<Object>) map.get(e.getName());
					}
					list.add(iterateElement(e, valueArray));
					map.put(e.getName(), list);
				} else {
					if (map.containsKey(e.getName())) {
						list = (List<Object>) map.get(e.getName());
					}
					list.add(elementTextTrim(e));
					map.put(e.getName(), list);
				}
			}
		} else {
			for (int i = 0; i < nodes.size(); i++) {
				e = nodes.get(i);
				if ("".equals(e.getTextTrim())) {
					if (e.getChildren().size() == 0) {
						continue;
					}
					map.put(e.getName(), iterateElement(e, valueArray));
				} else {
					map.put(e.getName(), elementTextTrim(e));
				}
			}
		}
		return map;
	}

	private static Object elementTextTrim(Element e) {
		String text = e.getTextTrim();
		if (text.trim().startsWith("[") && text.trim().endsWith("]")) {
			try {
				return JSONObject.parseArray(text);
			} catch (Exception exc) {
				return text;
			}
		} else {
			return text;
		}
	}
	
	public static void group(JSONObject json, Set<String> startKeys, int max$Count) {
		for (int index = 0; index < max$Count; index++) {
			groupByArray(json, startKeys, index);
		}
	}

	@SuppressWarnings("unchecked")
	private static void groupByArray(JSONObject json, Set<String> startKeys, int max$Index) {
		String regex = "_\\d+$";
		for (int i = 0; i < max$Index; i++) {
			regex = "_\\d+" + regex;
		}
		String filterRegex = ".*" + regex;
		Set<String> filterSet = json.keySet().stream().filter(k -> k.matches(filterRegex)).collect(Collectors.toSet());
		SortedSet<String> keys = new TreeSet<>();
		for (String key : filterSet) {
			for (String startKey : startKeys) {
				if (key.startsWith(startKey)) {
					keys.add(key);
				}
			}
		}
		Pattern p = Pattern.compile(regex);
		List<Object> array;
		String newKey;
		Object val;
		for (String key : keys) {
			Matcher m = p.matcher(key);
			if (m.find()) {
				newKey = key.substring(0, m.start());
				val = json.get(newKey);
				if (val == null) {
					array = new ArrayList<>();
					json.put(newKey, array);
				} else if (val instanceof List) {
					array = (List<Object>) val;
				} else {
					newKey += "s";
					val = json.get(newKey);
					if (val == null) {
						array = new ArrayList<>();
						json.put(newKey, array);
					} else if (val instanceof List) {
						array = (List<Object>) val;
					} else {
						continue;
					}
				}
				if (max$Index > 0) {
					int index = key.indexOf("_", m.start() + 1);
					key = key.substring(0, index);
					val = json.get(key);
					if (val != null && val instanceof List && !array.contains(val)) {
						array.add(val);
					}
				} else {
					array.add(json.get(key));
				}
			}
		}
	}
}
