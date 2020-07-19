package ndtvUI;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NDTVWeatherPage extends TestBase{
	public static int TempInNDTV;
	@BeforeMethod
	public void setUp(){
		initialization();
	}
	@Test
	 public static void cityWeather() throws InterruptedException  {
		//Clicking on sub menu
		 driver.findElement(By.id("h_sub_menu")).click();
		 //Clicking on weather button
		 driver.findElement(By.linkText("WEATHER")).click();
		 Thread.sleep(2000);
		 //input Allahabad in pin box
		 driver.findElement(By.id("searchBox")).sendKeys("Allahabad");
		 Thread.sleep(2000);
		 //Clicking on checkbox
		 driver.findElement(By.id("Allahabad")).click();
		 Thread.sleep(2000);
   
		 String cityName=driver.findElement(By.xpath("//div[contains(text(),'Allahabad')]")).getText();
		 System.out.println(cityName);
		 Assert.assertEquals(cityName, "Allahabad");

		 driver.findElement(By.xpath("//div[contains(text(),'Allahabad')]")).click();
		 Thread.sleep(2000);
		 String TempText=driver.findElement(By.xpath("(//span[@class='heading']//b)[4]")).getText();
		 
		 //Extracting only integer value from string
		 String str=TempText;
		 TempInNDTV = Integer.parseInt(str.replaceAll("[^0-9]", ""));
		
		 System.out.println("Temp in NDTV Degrees: "+TempInNDTV);  
     }
			@AfterMethod
			public void tearDown(){
			driver.quit();
}
}