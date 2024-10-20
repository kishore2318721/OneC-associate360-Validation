package prjt;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class oneC {
	 WebDriver driver;
	
	static List<String>personaldetailslist= new ArrayList<>();
	static List<String>Educationdetailslist= new ArrayList<>();
	static List<String>Experiencedetailslist= new ArrayList<>();
	static List<String>Traveldetails= new ArrayList<>();
	static boolean validation =true;
	
	   @BeforeClass
	   void setUp() {
	       driver = new ChromeDriver();
	       System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	       driver.get("https://onecognizant.cognizant.com/Home?GlobalAppId=3990");
	       driver.manage().window().maximize();  
	      
	   }  
	  
	   @Test(priority=1)
		void Associate360_navigation() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//*[@id='oneC_searchAutoComplete']")).sendKeys("Associate 360");
			driver.findElement(By.xpath("//div[contains(text(),'Associate 360')]")).click();
	   }
	   
	   @Test(priority=2)
		 void DetailsExtraction() {
			
            
			driver.switchTo().frame("appFrame");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions act = new Actions(driver); 
		
				WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
				System.out.println(dropdown.getText());
				System.out.println();
			     act.moveToElement(dropdown).build().perform();
		
			     	List<WebElement> list1 = driver.findElements(By.xpath("//li[contains(@class,'openSubMenu')]"));
			     	for(WebElement l : list1) {
			     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			     		System.out.println(l.getText()); 		
			     	}
	   }
			     	@Test(priority=3)
			        void personal_subheaders() {
			     		Actions act = new Actions(driver); 
			  		     	WebElement Personal = driver.findElement(By.xpath("//li[contains(text(),'Personal')]"));
			  		     	System.out.println(Personal.getText());
			  		     	System.out.println();
			  		     	act.moveToElement(Personal).build().perform();
			                  List<WebElement> list2 = driver.findElements(By.xpath("//li[contains(text(),'Personal')]/ul/li"));
			  		     	
			                  if(list2.size()>0) {
			  		     	for(WebElement l : list2) {
			  		     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  		     		System.out.println(l.getText());
			  		     		personaldetailslist.add(l.getText());
			  		     	}
			                  }
			                  System.out.println();
			  		     	}
			     	 @Test(priority=4)
					  void Education_subheaders() {
			     		Actions act = new Actions(driver); 
			                WebElement Education = driver.findElement(By.xpath("//li[contains(text(),'Education')]"));
			                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					     	System.out.println(Education.getText());
					     	System.out.println();
					     	act.moveToElement(Education).build().perform();
					     	
			                List<WebElement> list3 = driver.findElements(By.xpath("//li[contains(text(),'Education')]//li"));
					     	
			                if(list3.size()>0) {
					     	for(WebElement l : list3) {
					     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					     		System.out.println(l.getText());
					     		Educationdetailslist.add(l.getText());
					     	}
			                }
			                System.out.println();
						}
			     	 @Test(priority=5)     	
			 	    void Experience_subheaders() {
			     		Actions act = new Actions(driver); 
			                 WebElement Experience = driver.findElement(By.xpath("//li[contains(text(),'Experience')]"));
			                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 		     	System.out.println(Experience.getText());
			 		     	act.moveToElement(Experience).build().perform();
			 		     	
			                 List<WebElement> list4 = driver.findElements(By.xpath("//li[contains(text(),'Experience')]//li"));
			 		     	
			                 if(list4.size()>0) {
			 		     	for(WebElement l : list4) {
			 		     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 		     		System.out.println(l.getText());
			 		     		Experiencedetailslist.add(l.getText());
			 		     	}
			                 }
			                 System.out.println();
			 		   	}
			 		     	
			 	    @Test(priority=6)
			 	   void travel_subheaders() {
			 	    	Actions act = new Actions(driver); 
			                 WebElement Travel = driver.findElement(By.xpath("//li[contains(text(),'Travel')]"));
			                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 		     	System.out.println(Travel.getText());
			 		     	act.moveToElement(Travel).build().perform();
			 		     	
			                 List<WebElement> list5 = driver.findElements(By.xpath("//li[contains(text(),'Travel')]//li"));
			 		     	
			                 if(list5.size()>0) {
			 		     	for(WebElement l : list5) {
			 		     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 		     		System.out.println(l.getText());
			 		     		Traveldetails.add(l.getText());
			 		     	}
			                 }
			 	     	}
			 	   @Test(priority=7)
			 		 void details_validation  (){
			 			Actions act = new Actions(driver);
			 			WebElement Personal = driver.findElement(By.xpath("//li[contains(text(),'Personal')]"));
			 	     	
			 	     
			 	     	act.moveToElement(Personal).build().perform();
			 	        List<WebElement> list2 = driver.findElements(By.xpath("//li[contains(text(),'Personal')]/ul/li"));
			 	     	
			 	        if(list2.size()>0) {
			 	     	for(WebElement l : list2) {
			 	     		if(!personaldetailslist.contains(l.getText())) {
			 	     			validation = false;
			 	     		}
			 	     	}
			 		}
			 	        
			 	        
			 	        WebElement Education = driver.findElement(By.xpath("//li[contains(text(),'Education')]"));
			 	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 	    
			 	     	act.moveToElement(Education).build().perform();
			 	     	
			 	        List<WebElement> list3 = driver.findElements(By.xpath("//li[contains(text(),'Education')]//li"));
			 	     	
			 	        if(list3.size()>0) {
			 	     	for(WebElement l : list3) {
			 	     		if(!Educationdetailslist.contains(l.getText())) {
			 	     			validation = false;
			 	     			     		}
			 	     	}
			 	        }
			 			
			 	        
			 	        WebElement Experience = driver.findElement(By.xpath("//li[contains(text(),'Experience')]"));
			 	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 	     	
			 	     	act.moveToElement(Experience).build().perform();
			 	     	
			 	        List<WebElement> list4 = driver.findElements(By.xpath("//li[contains(text(),'Experience')]//li"));
			 	     	
			 	        if(list4.size()>0) {
			 	     	for(WebElement l : list4) {
			 	     		if(!Experiencedetailslist.contains(l.getText())) {
			 	     			validation = false;
			 	     		}
			 	        }
			 		}
			 	        WebElement Travel = driver.findElement(By.xpath("//li[contains(text(),'Travel')]"));
			 	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 	     
			 	     	act.moveToElement(Travel).build().perform();
			 	     	
			 	        List<WebElement> list5 = driver.findElements(By.xpath("//li[contains(text(),'Travel')]//li"));
			 	     	
			 	        if(list5.size()>0) {
			 	     	for(WebElement l : list5) {
			 	     		if(!Traveldetails.contains(l.getText())) {
			 	     			validation = false;
			 	     		}
			 	        }
			 	}
			 	        if(validation=true) {
			 	        	System.out.println("Headers are categorized");
			 	        }
			 	        else {
			 	        	System.out.println("sub-Headers are mismatched");
			 	        }
			 		}
			 	   
			 	    
	  @AfterClass
	 void closedriver() {
		driver.quit();
	}


}

