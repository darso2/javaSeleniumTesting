import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Downloads/HTML/HTML/DragAndDrop.html");
		boolean result = true;
		try{
		WebElement e = driver.findElement(By.id("draggable"));
		WebElement target1 = driver.findElement((By.id("droppable")));
		WebElement target2 = driver.findElement((By.id("droppable2")));
		// get co-ordinates of the the leement
		Point coord = target2.getLocation();
		System.out.println(coord.getX());
		Actions builder = new Actions(driver);
		builder.dragAndDrop(e, target1).perform();
		builder.dragAndDrop(e, target2).perform();
		//get x/y co-ordinate and assign it to the drag and drop 
		builder.dragAndDropBy(e, coord.getX(),coord.getY());
		}
		
		catch(Exception e){
			result = false;
		}
		finally{
			driver.close();
		if (result)
			System.out.println("Yeah");
		else
			System.out.println("nah");}
		}
	}


