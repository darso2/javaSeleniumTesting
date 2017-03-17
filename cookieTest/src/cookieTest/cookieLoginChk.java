package cookieTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class cookieLoginChk {

	public static void main(String[] args) {
		// Change path if on another system
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		//signin button
		WebElement signInBttn = driver.findElement(By.id("gb_70"));
		signInBttn.click();
		WebElement loginBox = driver.findElement(By.id("Email"));
		loginBox.sendKeys("facebooktestfriday1");
		loginBox.submit();
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
		WebElement passBox = driver.findElement(By.id("Passwd"));
		passBox.sendKeys("facebooktestfriday");
		signInBttn = driver.findElement(By.id("signIn"));
		signInBttn.submit();
		
		//checks logged in or not		
		driver.get("http://www.google.co.uk");
		Boolean loginResult = true;
		Boolean logoutResult= true;
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gbwa")));
		}
		catch (Exception e)
		{
			System.out.println(e);
			loginResult = false;
		}
				
		//add cookie to Cookie.data
			try{
			File file = new File("C:\\Users\\Administrator\\Desktop\\Cookie.data");
			file.delete();
			file.createNewFile();
			BufferedWriter bW = new BufferedWriter(new FileWriter(file));
			for(Cookie ck : driver.manage().getCookies()){
				 bW.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
				 bW.newLine();
			}
            bW.close();	
            }
			
			catch (Exception ex){
				ex.getStackTrace();
			}
		
		//logout 
		driver.get("https://accounts.google.com/Logout");
		//asserts logout
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("yDmH0d")));
		}
		catch (Exception f){
			logoutResult = false;
		}
		driver.get("http://www.google.co.uk");

		//loading cookie
		try{
		File file = new File("C:\\Users\\Administrator\\Desktop\\Cookie.data");
		BufferedReader bR = new BufferedReader(new FileReader(file));
		String linereader;
		while((linereader=bR.readLine()) != null){
			StringTokenizer str = new StringTokenizer(linereader,";");
			while(str.hasMoreTokens()){
				String name = str.nextToken();
				String value = str.nextToken();
				String domain = str.nextToken();
				String path= str.nextToken();
				Date expiry = null;
				//date is deprecated so use this instead
				DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
				String dt;
				if(!(dt=str.nextToken()).equals("null")){
					//need to parse date
					expiry = df.parse(dt);
					}
				Boolean isSecure = new Boolean(str.nextToken()).booleanValue();	
				   Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);																	
			        driver.manage().addCookie(ck);
			}
		}
		bR.close();
		}
		catch (Exception g)
		{
			System.out.println(g);
			g.printStackTrace();
		}
		
		driver.navigate().refresh();
		//checked logged in 
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gbwa")));
		}
		catch (Exception h){
			h.getStackTrace();
		}


	if (loginResult){
		System.out.println("yeah");
	}
	else 
		System.out.println("nah");
	}
	@Ignore
	public void Logintest(){
		
	}
}
