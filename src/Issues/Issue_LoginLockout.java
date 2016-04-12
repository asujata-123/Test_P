package Issues;
import java.io.BufferedWriter;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.MainPage;


public class Issue_LoginLockout extends PardotTestCase {
	private WebDriver driver;
	private ChromeOptions options;
	private StringBuffer verificationErrors = new StringBuffer();
	public BufferedWriter artifact;
	public MainPage mp;
	public LoginPage lp;
	//public SmartFilesPage sfp;
	
	@Before
	public void etUp() throws Exception {
		PardotTestCase.testName = "Issue_LoginLockout";
		PardotTestCase.tester = "Sujata Sudhakar"; 
		//artifact = Artifact.OpenArtifact("SmokeTestRunTranscript", testName+"  ",timeStamp);
	//	artifact = Artifact.OpenArtifact(GeneralMethods.getArtifactName(), testName+"  ",timeStamp); // MGB 5/5/2014
		
		options = new ChromeOptions();
	    options.addArguments(chromeOptions);
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		
	}
	  
	@Test
	public void test() throws Exception {
		System.out.println("* * * * * Start of " +testName +" test * * * * *");
		int localStressLoop = 1;
		
		// Test case infrastructure
		String currStepResult = null;
		String prevStepResult = null;
		String iterationStamp = "";
		String preReq = null;
		String reqFields = "";
			
		
	    
	    
		// Test data
		String organization = "Shared Cloud;GenHealth Enterprises, Inc. (GHEnt)"; 
			
	    // Run in local stress loop to make sure the test is robust
	 	for (int i = 1; i <= localStressLoop; i++){ // localStressLoop is controlled via the config.properties file	     
	 		
	 		if (localStressLoop > 1) iterationStamp = Integer.toString(i) +" / " +localStressLoop +" ";
			System.out.println("* * * * * *  Local stress loop iteration # " +iterationStamp);
		    			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
			// Pages browsed 
		    mp  = new MainPage(driver, "mainPage.txt");
		    lp = new LoginPage(driver, "login.txt");
		   // sfp = new SmartFilesPage(driver, "smartfilespage.txt");
		    
			// test step
		    lp.launchApplication("Pardot"); // Changed on 3/21/2016
	        lp.login();
	        GeneralMethods.delay(5000);
	        currStepResult = lp.verifyLogin() && mp.checkLoginSucceeded().equals("00") ? "Pass" : "Fail";
			//Artifact.VerifyWriteToArtifactS(artifact, iterationStamp+"Verify successful user login to "+GeneralMethods.getDeployment()+" build version "+mp.getBuildNumber(), currStepResult); // MGB 5/5/2014
			
			if (currStepResult.equals("Fail")) break;
			
		} // stress loop closing bracket
	}
	
	@After
	public void tearDown() throws Exception {	
		
		// Cleanup
		driver.quit();
		driver = null;
	}
}
