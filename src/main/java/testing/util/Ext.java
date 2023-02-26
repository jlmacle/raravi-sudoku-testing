package testing.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to externalize the strings used.
 */
public class Ext 
{
    // Website URL:
    public static final String URL = "http://localhost:3000/";

    // E2e Cypress batch folder path
    public static final String ENV_E2E_CYPRESS_BATCH_FOLDER = "CT_SUDOKU_APP_TESTING-E2E_CYPRESS_BATCH_FILES";

    // Homepage visit pattern
    public static final String HOME_PAGE_VISIT_PATTERN = "cy.visit('/')";
    
    // Cypress spec success pattern
    public static final String CYPRESS_SPEC_SUCCESS_PATTERN = "All specs passed!";

    //US 2.1:
    public static final Map<String,String> US2_1 = new HashMap<>();
    public static final String US2_1_A_CHROME = "US2.1.a-Chrome-Level-easy-at-startup.bat";
    public static final String US2_1_B_CHROMIUM = "US2.1.b-Chromium-Level-easy-at-startup.bat";
    public static final String THE_BROWSER_IS_ON_THE_HOME_PAGE = "The browser is on the home page";
    public static final String THE_DEFAULT_LEVEL_IS_EASY = "The default level is \"Easy\"";
    

    
}
