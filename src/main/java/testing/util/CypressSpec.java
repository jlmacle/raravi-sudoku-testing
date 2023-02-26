package   testing.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CypressSpec   
    { 
        static Logger logger = LogManager.getLogger(CypressSpec.class);
      
        /**
         * Checks if the Cypress spec contained in the batch file passes or fails.
         * @param batchFileName the name of the batch file that runs the Cypress spec.
         * @return a boolean indicating if the Cypress spec passed or failed.
         */
        public static boolean passed(String batchFileName)
        {
            
            boolean specPassed = false;
            ProcessBuilder pb = new ProcessBuilder();  
            Process p = null; 
            pb.command(System.getenv(Ext.ENV_E2E_CYPRESS_BATCH_FOLDER)+batchFileName);  
            
            try 
            {
                p = pb.start();
                String results = new String(p.getInputStream().readAllBytes());                
                if (logger.isDebugEnabled()) logger.debug(String.format("Results from : %s", batchFileName));
                if (logger.isDebugEnabled()) logger.debug(results);
                if (results.contains(Ext.CYPRESS_SPEC_SUCCESS_PATTERN))
                    { specPassed = true; }
            } 
            catch (IOException e) 
            {
                if (logger.isErrorEnabled()) logger.error(String.format("IOException running the command: %s", e.getMessage()));
                e.printStackTrace();
            }       

            return specPassed;
        }

    /**
     * Gets the content of the Cypress spec.
     * @param batchFileName the name of the batch file that runs the Cypress spec.
     * @return A String containing the content of the Cypress spec.
     */
    public static String getCypressSpecContent(String batchFileName)
    {
        
        String batchContent = null;
        String specContent = null;
        
        try 
        {   
            // Getting the batch file content.
            batchContent = new String(Files.readAllBytes(Paths.get(System.getenv(Ext.ENV_E2E_CYPRESS_BATCH_FOLDER)+batchFileName)));
        
            // Getting the spec file path.
            String specRelativeFilePath = batchContent.substring(batchContent.indexOf('"')+3, batchContent.lastIndexOf('"'));
            Path path = Paths.get(Paths.get("").toAbsolutePath().toString(), specRelativeFilePath);        
            specContent = new String(Files.readAllBytes(path));
            if (logger.isDebugEnabled()) logger.debug(specContent);
        } 
        catch (IOException e) {
           if (logger.isErrorEnabled()) logger.error(String.format("Error reading file: %s", e.getMessage()));           
        } 
        return specContent;
    
    }
    
    public static void main(String[] args) 
    {        
        if (logger.isDebugEnabled()) logger.debug(String.format("test passed : %s", passed(Ext.US2_1.get("Chrome"))));       
    }
}

// Credit to https://www.vogella.com/tutorials/Logging/article.html
// for the help with the Java logging API.