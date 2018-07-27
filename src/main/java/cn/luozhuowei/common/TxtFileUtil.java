package cn.luozhuowei.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Txt File Util.
 * 
 * @author zhuowei.luo
 */
public class TxtFileUtil {

	/**
	 * 读取文本文件，以<code>\r\n</code>换行
	 */
	public static String readTxtFile(File file) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString).append("\r\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 写文本文件
	 */
	public static boolean writeTxtFile(File file, String content) {
		FileWriter writer = null;
		boolean isSuccess = false;
		try {
			writer = new FileWriter(file);
			writer.write(content);
			writer.close();
			isSuccess = true;
		} catch (IOException e) {
			e.printStackTrace();
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
	
}
