package Pardot1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsPage;

import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.GenerateData;
import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsListAdd;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CreateProspect extends PardotTestCase {
	public static GenerateData genData;
	public static String _previprospectFName;	
	public static String _previprospectLName;	
	public static String _previEmail;
	public static String uniEmail1;
	public static String listName;
	public static String _previousListName;
	public static String _listName;
	
	@Test(priority=1)
	
	public static void CreateProspect1() throws Exception {
		PardotTestCase.testName = "CreateProspect";	
		PardotTestCase.tester = "Sujata Sudhakar";
		
		WebDriver driver = GeneralMethods.startDriver();
			
		//BufferedWriter artifact = Artifact.OpenArtifact(GeneralMethods.getArtifactName(), testName+"  ",timeStamp);
		
		// Objects used
		
		LoginPage lp = new LoginPage(driver, "loginpage");
		ListModulePage lmp = new ListModulePage(driver, "listmodulepage");
		ProspectsPage pp = new ProspectsPage(driver, "prospectspage");
		ProspectsListAdd pl = new ProspectsListAdd(driver, "prospectslist");
		genData=new GenerateData();
		
		// Test case infrastructure
					String currStepResult = null;
					String prevStepResult = null;
					String iterationStamp = "";
					String preReq = null;
					
					// Log in to main page
			     lp.launchApplication("Pardot");			       
			     lp.login();
			     	
			 	        try{
			 	        	
			 	        	
			 	    	        	 
			 	        	 FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			 	 					.withTimeout(160, TimeUnit.SECONDS)
			 	 					.pollingEvery(1500, TimeUnit.MILLISECONDS)
			 	 					.ignoring(NoSuchElementException.class);
			 	    	
			 	     
			 	    ProspectsPage.hoverElement(driver, driver.findElement(By.linkText("Prospects")));				 	        	
				 	driver.findElement(By.linkText("Prospect List")).click();
				 	
				 	fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pr_link_create")));		 
			 		ProspectsPage.hoverElement(driver, driver.findElement(By.id("pr_link_create")));
		 			driver.findElement(By.id("pr_link_create")).click();
		 			
		 			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("default_field_3361")));
		 			pp.FName.clear();
		 			pp.FName.sendKeys("FirstName"+genData.generateRandomNumber(9));
		 			
		 			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("default_field_3371")));
		 			pp.LName.clear();
		 			pp.LName.sendKeys("LastName"+genData.generateRandomNumber(9));	 				 
		 		
		 			fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		 			driver.findElement(By.id("email")).sendKeys("Test"+genData.generateRandomNumber(9)+"@Test.com");
		 				
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.id("default_field_3401")).sendKeys("Pardot");
		 				
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.id("default_field_3411")).sendKeys("https://pi.pardot.com/");
		 				
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.campaignSelectorCSS)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.optionSelectorCSS)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.profileSelectorCSS)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.optionSelectorCSS1)).click();
		 				
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.assignToSelectorCSS)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.optionSelectorCSS2)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.user_SelectorCSS)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.cssSelector(pp.optionSelectorCSS3)).click();
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 			driver.findElement(By.id("score")).sendKeys(genData.generateRandomNumber(9));
		 			
		 			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		 				
		 			driver.findElement(By.name("commit")).click();
		 				 		 				
		 				 System.out.println("Wait 3s after login");
		 		          GeneralMethods.delay(3000);
		 		          // Calculate the test step elapsed time
		 		  		 // long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
		 		  		         return;
		 		        } catch (Exception e){
		 		        	System.out.println("List: Exception thrown " + e.getMessage());
		 		        	return;
		 		        }
		 		      
		 	   }

//Prospect list add
	
	@Test(dependsOnMethods={"CreateProspect1"})
	public void CreateProspectList() throws IOException, InterruptedException{
	    try {
	    	
	    	driver.findElement(By.linkText("Edit")).click();
	    	driver.findElement(By.linkText("LISTS")).click();
	    	
	    	driver.findElement(By.cssSelector("b")).click();
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("b")).isDisplayed();
			driver.findElement(By.cssSelector("div.chzn-search > input[type=\"text\"]")).clear();
			    
			driver.findElement(By.cssSelector("div.chzn-search > input[type=\"text\"]")).sendKeys(CreateList.listName);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			   
			driver.findElement(By.className("active-result")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.name("commit")).click();   	 
	    	
	      return;
	    } catch (NoAlertPresentException e) {
	      return;
	    }
	  }

	@Test(dependsOnMethods={"CreateProspectList"})
	//Prospect attached to the list
	public void EnsureProspect() throws IOException, InterruptedException{
	    try{
	    	ListModulePage lmp = new ListModulePage(driver, "listmodulepage");
		 lmp.Marketing.click();
		 lmp.Segmentation.click();
	    	    	
		    driver.findElement(By.cssSelector("#listx_row_a0 > td:nth-child(2) > a")).click();
		 
			 System.out.println("Wait 3s after login");
	          GeneralMethods.delay(3000);
	          // Calculate the test step elapsed time
	  		 // long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
	  		         return;
	        } catch (Exception e){
	        	System.out.println("List: Exception thrown " + e.getMessage());
	        	return;
	        }
	      
   }
	
	//Logout
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
	  driver.quit();
	 }
	

}
	

			     	
