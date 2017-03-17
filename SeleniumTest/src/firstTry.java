import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstTry {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set up drivers
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//statements to see if test passed and
		Boolean statement1=true,statement2=true,statement3 = true,statement4= true;
		//Website to test
		driver.get("http://book.theautomatedtester.co.uk/chapter2");
		
		//test1
		try{
			driver.findElement(By.name("but56"));
		}
		catch(Exception e){
			System.out.println(e);
			statement1 = false;
		}

		//test2
		try{
			driver.findElement(By.id("random"));
		}
		catch(Exception e){
			System.out.println(e);
			statement2 = false;
		}
		
		//test3
		try{
			driver.findElement(By.linkText("Index"));
		}
		catch(Exception e){
			System.out.println(e);
			statement3 = false;
		}
		
		//test4
		try{
			WebElement firstClick = driver.findElement(By.linkText("Index"));
			firstClick.click();
			
		}
		catch(Exception e){
			System.out.println(e);
			statement4 = false;
		}
		finally{
			driver.close();
		}
			
		//loop to check if statements passed
//		ArrayList statementHolder = new ArrayList();
//
//		
//		String statement="statement";
//		for (int i=1; i <=4 ; i++)
//		{
//			statementHolder.add(java.lang.Boolean.parseBoolean(statement+i));
//		}
//		int i =1;
//		
//		for(Object o : statementHolder){
//		if (o =="true")
//		{
//			System.out.println("Statement "+i +" Passed");
//		}
//		else 
//		System.out.println(o+ " " + "Statement " +i+" Failed");
//		i++; 
//		}

//		ArrayList<Boolean> statementHolder = new ArrayList();
//		int i =1;
//		String statement;
//		statementHolder.add(statement1);
//		statementHolder.add(statement2);
//		statementHolder.add(statement3);
//		statementHolder.add(statement4);
//		for(boolean o : statementHolder){
//		if (o ==true)
//		{
//			System.out.println("Statement "+i +" Passed");
//		}
//		else 
//		System.out.println("Statement " +i+" Failed");
//		i++; 
//		}
}
}