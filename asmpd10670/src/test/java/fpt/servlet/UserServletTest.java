package fpt.servlet;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
// 
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
public class UserServletTest {
	private WebDriver driver;
	
	@Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\trann\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions(); 
		options.setBinary("C:\\Users\\trann\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe"); 
		options.addArguments("--disable-blink-features=AutomationControlled"); 
		options.addArguments("--incognito"); 
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize(); 
    }
	//Test Create
	 
	@Test
	public void testcase1acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addButtom = driver.findElement(By.linkText("Thêm người dùng"));
		addButtom.click();
		
		//nhập thông tin
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement addaccButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user1");
		pass.sendKeys("123");
		email.sendKeys("user3@gmail.com");
		fullname.sendKeys("Trần Nhật");
		
		addaccButtom.click();
		
		 
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passcreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'user1']")));
		System.out.println("Kết quả mong muốn là pass");
		Assert.assertTrue(passcreate.isDisplayed());
	
		
	}
	//test để trông email
	@Test
	public void testcase2acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addButtom = driver.findElement(By.linkText("Thêm người dùng"));
		addButtom.click();
		
		//nhập thông tin
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement addaccButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user7");
		pass.sendKeys("123");
		email.sendKeys(" ");
		fullname.sendKeys("Trần Nhật");
		
		addaccButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passcreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Hệ thống báo lỗi Email trống']")));
		System.out.println("Kết quả mong muốn là pass");
		Assert.assertTrue(passcreate.isDisplayed());
	
		
	}
	 //test để trống full name
	@Test
	public void testcase4acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addButtom = driver.findElement(By.linkText("Thêm người dùng"));
		addButtom.click();
		
		//nhập thông tin
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement addaccButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user7");
		pass.sendKeys("123");
		email.sendKeys("user10@gmail.com");
		fullname.sendKeys("");
		
		addaccButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passcreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Hệ thống báo lỗi Full Name trống']")));
		Assert.assertTrue(passcreate.isDisplayed());
	
		
	}
	@Test
	public void testcase5acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addButtom = driver.findElement(By.linkText("Thêm người dùng"));
		addButtom.click();
		
		//nhập thông tin
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement addaccButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user5");
		pass.sendKeys("123");
		email.sendKeys("user3@gmail.com");
		fullname.sendKeys("Trần Nhật");
		
		addaccButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passcreate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = 'user5']")));
		System.out.println("Kết quả mong muốn là pass");
		Assert.assertTrue(passcreate.isDisplayed());
	
		
	}
	//TEST UPDATE
	//test thay đổi thông tin
	@Test
	public void testcase6acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addbutupdate = driver.findElement(By.xpath("//a[normalize-space(text())='Chỉnh Sửa Thông Tin']"));
		addbutupdate.click();

		
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement buttomUpdate = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		pass.clear();
		pass.sendKeys("123");
		email.clear();
		email.sendKeys("nn@gmail.com");
		fullname.clear();
		fullname.sendKeys("Trần Kien");
		buttomUpdate.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passupdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()  = 'Trần Kien']")));
		System.out.println("kết quả mong muốn pass");
		Assert.assertTrue(passupdate.isDisplayed());
		
	}
	//test thay đổi thông tin  để trống pass
	@Test
	public void testcase7acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addbutupdate = driver.findElement(By.xpath("//a[normalize-space(text())='Chỉnh Sửa Thông Tin']"));
		addbutupdate.click();

		
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement buttomUpdate = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		pass.clear();
		pass.sendKeys("");
		email.clear();
		email.sendKeys("nn@gmail.com");
		fullname.clear();
		fullname.sendKeys("Trần Kien");
		buttomUpdate.click();

			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passupdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text() = 'Chỉnh sửa thông tin nguời dùng']")));
 
		Assert.assertTrue(passupdate.isDisplayed());
 
	}
	
	@Test
	public void testcase8acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addbutupdate = driver.findElement(By.xpath("//a[normalize-space(text())='Chỉnh Sửa Thông Tin']"));
		addbutupdate.click();

		
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement buttomUpdate = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		pass.clear();
		pass.sendKeys("123");
		email.clear();
		email.sendKeys("");
		fullname.clear();
		fullname.sendKeys("Trần Kien");
		buttomUpdate.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passupdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()  = 'Chỉnh sửa thông tin nguời dùng']")));
 
		Assert.assertTrue(passupdate.isDisplayed());
 
		
	}
	@Test
	public void testcase9acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addbutupdate = driver.findElement(By.xpath("//a[normalize-space(text())='Chỉnh Sửa Thông Tin']"));
		addbutupdate.click();

		
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement buttomUpdate = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		pass.clear();
		pass.sendKeys("123");
		email.clear();
		email.sendKeys("nn@gmail.com");
		fullname.clear();
		fullname.sendKeys("");
		buttomUpdate.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passupdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()  = 'Chỉnh sửa thông tin nguời dùng']")));
 
		Assert.assertTrue(passupdate.isDisplayed());
 
		
	}
	@Test
	public void testcase10acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		WebElement addbutupdate = driver.findElement(By.xpath("//a[normalize-space(text())='Chỉnh Sửa Thông Tin']"));
		addbutupdate.click();

		
		WebElement pass = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		
		WebElement buttomUpdate = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		pass.clear();
		pass.sendKeys("123");
		email.clear();
		email.sendKeys("nn");
		fullname.clear();
		fullname.sendKeys("Trần Kien");
		buttomUpdate.click();
		
		WebElement newUpdateacc = driver.findElement(By.xpath("//h2[text()  = 'Chỉnh sửa thông tin nguời dùng']"));
		Assert.assertTrue(newUpdateacc.isDisplayed());
		
	}
	//Delete Acc
	@Test
	public void testcase11acc() {
		driver.get("http://localhost:8080/asmpd10670/User");
		
		List<WebElement> rowsBefore = driver.findElements(By.xpath("//table/tbody/tr"));
        int initialSize = rowsBefore.size();
		 
		WebElement deleteacc = driver.findElement(By.xpath("(//form/button[contains(text(), 'Xóa Người Dùng')])"));
		deleteacc.click();
		
		// Xác nhận hộp thoại cảnh báo nếu có
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Bạn có chắc chắn muốn xóa người dùng này");
        }
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//table/tbody/tr"), initialSize));

	}
	
	
	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

 

}
