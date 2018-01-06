package DaDa.Test;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//@Listeners({TestngListener.class})
//@Listeners({TestngListenerScreenShot.class})

public class AutoLogin extends TestDriver {
	
	public void loginScript(String userName, String password) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("account")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("submitLogin")).click();
		
		Thread.sleep(2000);
		WebElement pop_ups = driver.findElement(By.className("sweet-alert"));
		WebElement cancelBtn = driver.findElement(By.className("cancel"));
		if (pop_ups.isDisplayed()) {
			cancelBtn.click();
		}
		this.checkInfo();
	}
	
	
	public void checkInfo() {
		String  name = driver.findElement(By.className("name")).getText();
		if (name.equals("����-С���� (test-dai)")) {
			System.out.println("��¼�ɹ�");
		}
		else {
			System.out.println("��¼ʧ��");
		}
		
	}
	@Test
	public void inputInfo() throws InterruptedException, IOException {//		this.loginScript("17721010137", "111111");
		ReadFileUtil prop = new ReadFileUtil("account.properties");
		String userName = prop.getPro("username");
		String passWord = prop.getPro("password");
		this.loginScript(userName, passWord);
		
	}
	@Test(dependsOnMethods = "inputInfo")
	public void applyTestNetClass() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/aside/div[2]/ul/li[2]/a")).click();;
		System.out.println("打开课表");
		//判断近期是否有通过的测网报告
//		WebElement pop_ups = driver.findElement(By.className("sweet-alert"));
//		if (pop_ups.isDisplayed()) {
//			driver.findElement(By.className("confirm")).click();
//			this.testNet();
//		}
		//约课操作
		Thread.sleep(2000);
		//1.选择明天
		driver.findElement(By.xpath("//*[@id=\"week-day\"]/div[2]")).click();
		//2.选择时间为晚上9:15的课程
		driver.findElement(By.xpath("//*[@id=\"channel-wrapper\"]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[3]/div[2]/div[7]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"com_option\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"com_option\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("测试人员测试使用~");
		
		Thread.sleep(2000);
		//3.提交约课
		driver.findElement(By.id("submit")).click();
		

		
	}
	public void testNet() throws InterruptedException {
		System.out.println("前台测网操作");
		driver.findElement(By.id("btn-start")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"next_area\"]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"next_area\"]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"next_area\"]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/a[1]")).click();
		
		//再次点击约测网课
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/aside/div[2]/ul/li[2]/a")).click();;

	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		AutoLogin login = new AutoLogin();
		login.inputInfo();
		login.shotScreen();
		login.applyTestNetClass();
		

	}
	
}
