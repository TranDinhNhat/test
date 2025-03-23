package fpt.servlet;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DangKiServletTest {
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
	
	@Test
	public void testcase1reg() {
			driver.get("http://localhost:8080/asmpd10670/dangki");
			WebElement userid = driver.findElement(By.name("id"));
			WebElement email = driver.findElement(By.name("email"));
			WebElement pass = driver.findElement(By.name("password"));
			WebElement fullname = driver.findElement(By.name("fullname"));
			WebElement regButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
			
			userid.sendKeys("use1");
			email.sendKeys("user1@gmail.com");
			pass.sendKeys("123");
			fullname.sendKeys("boy");
			regButtom.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement passreg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'Đăng Nhập Tài Khoản']")));
			Assert.assertTrue(passreg.isDisplayed());
	}
	
	//test nhập trùng email
	@Test
	public void testcase4reg() {
		driver.get("http://localhost:8080/asmpd10670/dangki");
		WebElement userid = driver.findElement(By.name("id"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		WebElement regButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user7");
		email.sendKeys("nhattdpd108553@gmail.com");
		pass.sendKeys("123");
		fullname.sendKeys("Dinh");
		regButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passreg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Email đã tồn tại, vui lòng chọn email khác!']")));
		Assert.assertTrue(passreg.isDisplayed());
	}
	//test nhập khong đúng định dạng email
	@Test
	public void testcase2reg() {
		driver.get("http://localhost:8080/asmpd10670/dangki");
		WebElement userid = driver.findElement(By.name("id"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		WebElement regButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user3");
		email.sendKeys("nhattdpd108553");
		pass.sendKeys("123");
		fullname.sendKeys("Tran Nhat");
		regButtom.click();
		
		WebElement passreg = driver.findElement(By.xpath("//h3[text() = 'Nhập không đúng dạng email']"));
		Assert.assertTrue(passreg.isDisplayed());
		
	}
	 
	//test để pass null
	@Test
	public void testcase5reg() {
		driver.get("http://localhost:8080/asmpd10670/dangki");
		WebElement userid = driver.findElement(By.name("id"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		WebElement regButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user3");
		email.sendKeys("nhattdpd108553@gmail.com");
		pass.sendKeys("");
		fullname.sendKeys("Tran Nhat");
		regButtom.click();
		
		WebElement passreg= driver.findElement(By.xpath("//h3[text() = 'Tạo Tài Khoản Mới']"));
		Assert.assertTrue(passreg.isDisplayed());
	}
	//test trùng user
	@Test
	public void testcase6reg() {
		driver.get("http://localhost:8080/asmpd10670/dangki");
		WebElement userid = driver.findElement(By.name("id"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement fullname = driver.findElement(By.name("fullname"));
		WebElement regButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user2");
		email.sendKeys("nhattdpd1085537777@gmail.com");
		pass.sendKeys("123");
		fullname.sendKeys("nhatver2");
		regButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement passreg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text () = 'User đã tồn tại, vui lòng chọn tên user khác!']")));
		Assert.assertTrue(passreg.isDisplayed());
 
	}
	
	
 
	
	 
	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

 

}
