package AssertionPACK;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class assertionclass 
{
	WebDriver driver;
	@Test()
	public void testScripts() throws InterruptedException
	{						
		WebDriverManager.firefoxdriver().setup();

		driver=new FirefoxDriver();
		Thread.sleep(1500);
		driver.manage().window().maximize();
		Thread.sleep(1500);
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='dynamictable']/../../details")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]\r\n"
				+ "");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@id='refreshtable']")).click();
		Thread.sleep(3000);
		
		
		//LOCATE THE WEBTABLE
		WebElement table = driver.findElement(By.xpath("//table[@id='dynamictable']"));
		
		
		//find all rows in table
		List<WebElement> rows = (List<WebElement>)table.findElements(By.tagName("tr"));
		
		System.out.println(rows.size());
		
		
		Assert.assertEquals(rows.size(),6);
		
		boolean status=false;

		for (WebElement row : rows) 
		{
			String ExpectRow = row.getText();
			System.out.println(ExpectRow);
			
			//if we pass the data that is present in actual data we will not get any assertion error
			if(ExpectRow.contains("Jennifer"))
			{
				status=true;
				break;
			}
		}
		
		Assert.assertTrue(status);
		driver.quit();
	}
	
	
}
