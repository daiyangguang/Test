package DaDa.Test;



import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileUtil {
	private Properties prop;
	private String filePath;
	public ReadFileUtil(String filePath) throws IOException {
		this.filePath = filePath;
		this.prop = readProperties();
	}
	private Properties readProperties() throws IOException {
		Properties prop = new Properties();
		try {
			InputStream inputStream = new FileInputStream(filePath);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			prop.load(bufferedInputStream);	
		} catch (Exception e) {
			System.out.println(e);
		}		
		return prop;
	}
	
	public String getPro(String key) {
		String result = "";
		if (prop.containsKey(key)) {
			String userName = prop.getProperty(key);
			result = userName;
		}
		else {
			System.out.println("����ȡ��key����");
			result = "";
		}
		return result;
	}
}
