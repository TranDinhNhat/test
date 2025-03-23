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

public class LoginServletTest {
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
	public void testcae1Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("admin");
		pass.sendKeys("123");
		loginButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement succesMess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()= 'Welcome, Admin']")));
		
		Assert.assertTrue(succesMess.isDisplayed());
		
	 
	}
	//login tài khoản khong đúng mật khẩu
	@Test
	public void testcae2Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("admin");
		pass.sendKeys("1234");
		loginButtom.click();
		
		 
		
		WebElement passlogin = driver.findElement(By.xpath("//h3[text()= 'Đăng Nhập Tài Khoản']"));
		Assert.assertTrue(passlogin.isDisplayed());
	 
	}
	 
	//login tài khoản null pass
	@Test
	public void testcae4Login() {
driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("admin");
		pass.sendKeys("");
		loginButtom.click();
		
		 
		
		WebElement passlogin = driver.findElement(By.xpath("//h3[text()= 'Đăng Nhập Tài Khoản']"));
		Assert.assertTrue(passlogin.isDisplayed());
		
	}
	
	//testlogin null username 
	@Test
	public void testcae5Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("");
		pass.sendKeys("123");
		loginButtom.click();
		
		WebElement passlogin = driver.findElement(By.xpath("//h3[text()= 'Yêu cầu đăng nhập lại và thông báo username trống']"));
		Assert.assertTrue(passlogin.isDisplayed());
		
	 
	}
 
	//test đúng user của người dùng vào giao diện của người dùng
	@Test
	public void testcae9Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user");
		pass.sendKeys("123");
		loginButtom.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement succesMess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()= 'Welcome, User']")));
		
		Assert.assertTrue(succesMess.isDisplayed());
		
	 
	}
	 
	//test user của người dùng nhập sai pass
	@Test
	public void testcae11Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user");
		pass.sendKeys("1234");
		loginButtom.click();
		
		WebElement passlogin = driver.findElement(By.xpath("//h3[text()= 'Sai Mật Khẩu']"));
		Assert.assertTrue(passlogin.isDisplayed());
		
	 
	}
	
	//test login khi để null pass
	@Test
	public void testcae12Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("user");
		pass.sendKeys("");
		loginButtom.click();
		
		WebElement passlogin = driver.findElement(By.xpath("//h3[text()= 'Yêu cầu đăng nhập lại và thông báo pass trống ']"));
		Assert.assertTrue(passlogin.isDisplayed());
		
	 
	}
	//test khi để null user name
	@Test
	public void testcae14Login() {
		driver.get("http://localhost:8080/asmpd10670/login");
		
		WebElement userid = driver.findElement(By.name("id"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButtom = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		userid.sendKeys("");
		pass.sendKeys("123");
		loginButtom.click();
		
		WebElement passlogin = driver.findElement(By.xpath("//h3[text()= 'Yêu cầu đăng nhập lại và thông báo tài khoản trống ']"));
		Assert.assertTrue(passlogin.isDisplayed());
		
	 
	}
	 

	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

 
}

