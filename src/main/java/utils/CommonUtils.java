package utils;

import java.io.IOException;
import java.util.Properties;

public class CommonUtils {

	// 根据Key读取配置文件的Value
	public static String readProperties(String fileName, String key) {
		Properties props = new Properties();
		try {
			props.load(CommonUtils.class.getClassLoader().getResourceAsStream(fileName));
			String value = props.getProperty(key);
			return value;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
