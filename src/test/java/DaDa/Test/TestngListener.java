package DaDa.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
//https://www.ibm.com/developerworks/cn/opensource/os-cn-testinglistener/index.html  test讲解
public class TestngListener extends TestListenerAdapter {  //继承testng的一个监听事件类
	//重写父类的一个失败监听方法
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		System.out.println("success");
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  super.onTestFailure(tr);
		  System.out.println("O(∩_∩)O哈哈~O(∩_∩)O哈哈~");

		  //调用自己写的截图方法
		  try {
			this.shotScreen(tr);
			  System.out.println("O(∩_∩)O哈哈~O(∩_∩)O哈哈~");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public void shotScreen(ITestResult tr) throws IOException {
		  TestDriver dr = (TestDriver)tr.getInstance();
		  dr.shotScreen();	  
	  }
	  @Override
	  public void onTestStart(ITestResult result) {
		  super.onTestStart(result);
		  System.out.println("onTestStart");
	  }
	  
	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  super.onTestSkipped(tr);
		  System.out.println("onTestSkipped");

	  }
	  
	  
	  @Override
	  public void onStart(ITestContext testContext) {
		  super.onStart(testContext);
		  System.out.println("onStart");

	  }

	  @Override
	  public void onFinish(ITestContext testContext) {
		  super.onFinish(testContext);
		  System.out.println("onFinish");

	  }
	  
	  
	
}
