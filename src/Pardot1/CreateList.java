package Pardot1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.GenerateData;
import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;

import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsListAdd;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsPage;

public class CreateList extends PardotTestCase {
	public static GenerateData genData;
	public static String _previprospectFName;	
	public static String _previprospectLName;	
	public static String _previEmail;
	public static String uniEmail1;
	public static String listName;
	public static String _previousListName;
	public static String _listName;
		
	@Test(priority=1)
	public static void ListOriginal() throws IOException, InterruptedException {
		try{
		PardotTestCase.testName = "CreateList_Copy";	
		PardotTestCase.tester = "Sujata Sudhakar";
		
	WebDriver driver = GeneralMethods.startDriver();	
		genData=new GenerateData();	 
		
		
		//Page Objects used
     ListModulePage lmp = new ListModulePage(driver, "listmodulepage");	 
	 LoginPage lp = new LoginPage(driver, "loginpage");
	 ProspectsPage pp = new ProspectsPage(driver, "prospectspage");
	 ProspectsListAdd pla = new ProspectsListAdd(driver, "prospectslist");

			  
		
		//BufferedWriter artifact = Artifact.OpenArtifact(GeneralMethods.getArtifactName(), testName+"  ",timeStamp);
			
		// Test case infrastructure
					String currStepResult = null;
					String prevStepResult = null;
					String iterationStamp = "";
					String preReq = null;
					
					// Log in to main page
					lp.launchApplication("Pardot");
			     	lp.login();
			     
	    				    	
				    	lmp.Marketing.click();
				    	lmp.Segmentation.click();
				    	 
				    	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					    driver.findElement(By.id("listxistx_link_create")).click();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							
						lmp.Name.clear();
						lmp.Name.sendKeys(listName="ListOriginal"+genData.generateRandomNumber(4));
						
								
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.id("save_information")).click(); 
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						
						System.out.println("New list is created with name ListOriginal");
											
				      
				          // Calculate the test step elapsed time
				  		 // long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
				  		         return;
	} catch (Exception e){
    	System.out.println("List: Exception thrown " + e.getMessage());
    	return;
}
				        
	}			      
				        
			    	
@Test(dependsOnMethods={"ListOriginal"})
public static void DupeList() throws IOException, InterruptedException {
	
	 ListModulePage lmp = new ListModulePage(driver, "listmodulepage");	
	 
	 lmp.Marketing.click();
	 lmp.Segmentation.click();
 
	    driver.findElement(By.id("listxistx_link_create")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("name")).sendKeys(listName);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.id("save_information")).click(); 
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String ListCreated = listName;
		WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
		Assert.assertEquals(alert.getText().toLowerCase().trim(),"please correct the errors below and re-submit");
							
				if(ListCreated.equals(listName))
				{
					System.out.println("please correct the errors below and re-submit");
					driver.findElement(By.linkText("Cancel")).click();
				} else
				{
					driver.findElement(By.id("save_information")).click();
				}
				
}    
			     	
//RenameList

@Test(dependsOnMethods={"DupeList"})

public void RenameList() throws IOException, InterruptedException{
    try{
     ListModulePage lmp = new ListModulePage(driver, "listmodulepage");
    	
	 lmp.Marketing.click();
	 lmp.Segmentation.click(); 
    	
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("i.icon-cog.muted")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		driver.findElement(By.linkText("Edit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("name")).clear();
										 
		lmp.Name.clear();
		lmp.Name.sendKeys(_listName="ListRename"+genData.generateRandomNumber(4));
					 				 
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.findElement(By.id("save_information")).click();
		
		System.out.println("Wait 3s after login");
          GeneralMethods.delay(3000);
          // Calculate the test step elapsed time
  		  //long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
  		         return;
        } catch (Exception e){
        	System.out.println("List: Exception thrown " + e.getMessage());
        	return;
    }
}
@Test(dependsOnMethods={"RenameList"})
//OrginalNameListCreation
public void OriginalNameListCreation() throws IOException, InterruptedException{
    try{
    	ListModulePage lmp = new ListModulePage(driver, "listmodulepage");
	 lmp.Marketing.click();
	 lmp.Segmentation.click();
    	    	
	    driver.findElement(By.id("listxistx_link_create")).click();
		driver.findElement(By.id("name")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("name")).clear();
								 
		lmp.Name.sendKeys(listName);
		driver.findElement(By.id("save_information")).click();
			    		
		System.out.println("Wait 3s after login");
          GeneralMethods.delay(3000);
          // Calculate the test step elapsed time
  		  //long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
  		         return;
        } catch (Exception e){
        	System.out.println("List: Exception thrown " + e.getMessage());
        	return;
    }
}	



public static boolean SelectFromList(WebDriver driver, WebElement Prospects, String cssData, int choice, int offsetX, int offsetY){	
	try{
		Actions hoverOver = new Actions(driver);
		hoverOver.clickAndHold(Prospects).build().perform();
		List<WebElement> choices = Prospects.findElements(By.cssSelector(cssData));
		WebElement option = choices.get(choice);
		hoverOver.moveToElement(option).click().build().perform();
		hoverOver.release(Prospects).build().perform();
		return true;
	} catch (Exception e){
		System.out.println("Exception thrown on mouse operation method SelectFromList " + e.getMessage());
		return false;
	}
}


//Logout

@AfterClass(alwaysRun = true)
public void tearDown() throws Exception {
  driver.quit();
 }

		 		      
		 	   }


			     	
	
