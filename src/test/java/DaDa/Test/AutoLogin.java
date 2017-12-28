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
	public static void main(String[] args) throws InterruptedException, IOException {
		AutoLogin login = new AutoLogin();
		login.inputInfo();
		login.shotScreen();
		
	}
	
}
