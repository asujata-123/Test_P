package Pardot.Pardot_ToolBox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AutomationSettings {
	
   private static final Properties props;
   
   
   // - hash to retrieve tester name from config file, indexed by test name
   static {
		    	           	
	        props = new Properties();
	        String configFile="";
	        if (PardotTestCase.platform.toLowerCase().indexOf("windows")>=0) configFile = PardotTestCase.workingDir+"\\configuration\\config.properties";
			else configFile = PardotTestCase.workingDir+"";
	 	  	InputStream input = IOutils.getInputStream(configFile);
	 	  	
	 	   	// load a properties file
	 	   	try {
	 	     
	 	   		props.load(input);
	 	     
	 	   	} catch (IOException ex) {
	 	   		ex.printStackTrace();
	 	   	} finally {
	 	   		if (input != null) {
	 	   			try {
	 	   				input.close();
	 	   			} catch (IOException e) {
	 	   				e.printStackTrace();
	 	   			}
	 	   		}
	 	   	}
		   		   
	}   
	    
	     	    
   //getters	    
	
	public static int getTimeout() {		
	   int timeout = Integer.parseInt(props.getProperty("timeout","10"));				
	   return timeout;		
     }
	
	public static int getLoginTimeout() {		
		   int timeout = Integer.parseInt(props.getProperty("loginTimeout","10"));				
		   return timeout;		
	     }

	public static String getBaseURL() {		
	   return props.getProperty("baseurl","");					   		
     }
	
	public static String getUserName() {		
		   return props.getProperty("email_address","");					   		
	     }

	public static String getPassword() {		
		   return props.getProperty("password","");					   		
	     }
	
	public static String getOptions() {		
		   return props.getProperty("options","");					   		
	     }
	/*public static int getUniqueListSequence() {		
		   int seq= Integer.parseInt(props.getProperty("UniqueListSequence","0"));	
		   return seq;
	     }*/

	// Delays
	public static int getEventDelay() {		
		   int delay = Integer.parseInt(props.getProperty("eventdelay","10"));				
		   return delay;		
	     }
	
	public static int getClickDelay() {		
		   int delay = Integer.parseInt(props.getProperty("clickdelay","10"));				
		   return delay;		
	     }
	public static int getDelay(String type){
		   int delay = Integer.parseInt(props.getProperty("delay"+type,"10"));		
		   return delay;
	}
	////
	
	public static int getLocalStressLoopIterations() {		
		   int iterations = Integer.parseInt(props.getProperty("localstressloop","10"));				
		   return iterations;		
	     }
	
	public static String getWIP() {		
		   return props.getProperty("WIP","10");					   		
	     }
	
	public static String getKnownIssue() {		
		   return props.getProperty("knownIssue","10");					   		
	     }
	
	public static String getTempWA() {		
		   return props.getProperty("tempWorkaround","10");					   		
	     }
	
	public static String getCompliance1() {		
		   return props.getProperty("compliance1","10");					   		
	     }
	
	public static String getArtifact() {		
		   return props.getProperty("artifact","10");					   		
	     }
	
	public static String getRunParametersFilename() {		
		   return props.getProperty("parametersFile","10");					   		
	     }
	
		
	public static String getBuild(String build) {		
		   return props.getProperty("build"+build,"10");					   		
	     }
	
	public static String getTestDataItem(String buildIndex) {
		return props.getProperty(buildIndex,"10");
	}

	public static int getCatastrophicTimeout() {
		return Integer.parseInt(props.getProperty("catastrophicTimeout", "10"));
	}
	
   	
}
