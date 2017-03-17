import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createLoginTest {
public static void main(String[] args){

	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://php.thedemosite.co.uk/addauser.php");
	Boolean testresult = true;
	try{	
	
	WebElement userBox = driver.findElement(By.name("username"));
	WebElement passBox = driver.findElement(By.name("password"));
	WebElement saveBttn = driver.findElement(By.name("FormsButton2"));
	userBox.sendKeys("usernametest");
	passBox.sendKeys("testpass");
	saveBttn.submit();
	
	driver.get("http://php.thedemosite.co.uk/login.php");
	userBox = driver.findElement(By.name("username"));
	passBox = driver.findElement(By.name("password"));
	saveBttn = driver.findElement(By.name("FormsButton2"));
	userBox.sendKeys("usernametest");
//	passBox.sendKeys("testpass");
	passBox.sendKeys("testpss");
	saveBttn.submit();


	WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,67);
	testresult= wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"),"Success"));
	}
	catch(Exception e)
	{
		System.out.println(e);
		testresult = false;
	}
	finally{
		driver.close();
	}
	
	if(testresult)
		System.out.println("yeah");
	else 
		System.out.println("nah");
	}
}

