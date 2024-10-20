package prjt;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver;
		 
		 driver = new ChromeDriver();
	       driver.get("https://onecognizant.cognizant.com/Home?GlobalAppId=3990");
	       driver.manage().window().maximize();  
	      
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
			driver.findElement(By.xpath("//*[@id='oneC_searchAutoComplete']")).sendKeys("Associate 360");
			driver.findElement(By.xpath("//div[contains(text(),'Associate 360')]")).click();
	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame("appFrame");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			Actions act = new Actions(driver);
				WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
				System.out.println(dropdown.getText());
				System.out.println();
			     act.moveToElement(dropdown).build().perform();
		
			     	List<WebElement> list1 = driver.findElements(By.xpath("//li[contains(@class,'openSubMenu')]"));
			     	for(WebElement l : list1) {
			     		System.out.println(l.getText());
			     	}	     	
			     	WebElement Personal = driver.findElement(By.xpath("//li[contains(text(),'Personal')]"));
			     	System.out.println(Personal.getText());
			     	System.out.println();
			     	act.moveToElement(Personal).build().perform();
	                List<WebElement> list2 = driver.findElements(By.xpath("//li[contains(text(),'Personal')]/ul/li"));
			     	
	                if(list2.size()>0) {
			     	for(WebElement l : list2) {
			     		System.out.println(l.getText());
			     	}
	                }
	                System.out.println();
	                WebElement Education = driver.findElement(By.xpath("//li[contains(text(),'Education')]"));
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			     	System.out.println(Education.getText());
			     	System.out.println();
			     	act.moveToElement(Education).build().perform();
			     	
	                List<WebElement> list3 = driver.findElements(By.xpath("//li[contains(text(),'Education')]//li"));
			     	
	                if(list3.size()>0) {
			     	for(WebElement l : list3) {
			     		System.out.println(l.getText());
			     	}
	                }
	                System.out.println();
	                WebElement Experience = driver.findElement(By.xpath("//li[contains(text(),'Experience')]"));
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			     	System.out.println(Experience.getText());
			     	act.moveToElement(Experience).build().perform();
			     	
	                List<WebElement> list4 = driver.findElements(By.xpath("//li[contains(text(),'Experience')]//li"));
			     	
	                if(list4.size()>0) {
			     	for(WebElement l : list4) {
			     		System.out.println(l.getText());
			     	}
	                }
	                System.out.println();
	                WebElement Travel = driver.findElement(By.xpath("//li[contains(text(),'Travel')]"));
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			     	System.out.println(Travel.getText());
			     	act.moveToElement(Travel).build().perform();
			     	
	                List<WebElement> list5 = driver.findElements(By.xpath("//li[contains(text(),'Travel')]//li"));
			     	
	                if(list5.size()>0) {
			     	for(WebElement l : list5) {
			     		System.out.println(l.getText());
			     	}
	                }
	 
	 
			     	
	}

			     	
}
