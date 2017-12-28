package DaDa.Test;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	WebDriver driver;
	public TestDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.dadaabc.com/");
		driver.manage().window().maximize();
	}
	

	public void shotScreen() throws IOException {
		long tStamp = System.currentTimeMillis();
		String picName = DateConvert.stampToDate(String.valueOf(tStamp));
		String currentPath = System.getProperty("user.dir");
		String picLoaction = currentPath + "\\src\\dada\\" + picName + ".png";
		System.out.println(picLoaction);
		File shotScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(shotScreen, new File(picLoaction));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
