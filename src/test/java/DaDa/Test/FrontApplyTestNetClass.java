package DaDa.Test;

import org.openqa.selenium.By;

public class FrontApplyTestNetClass extends TestDriver {
	public void showStudentSchedule() {
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/aside/div[2]/ul/li[2]/a")).click();;
		System.out.println("打开课表");
	}
	public void choseClassTime() {
		
	}
}
