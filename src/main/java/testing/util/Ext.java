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

    /************************************************************/
    /* About Cypress */
    /************************************************************/

    // E2e Cypress batch folder path
    public static final String ENV_E2E_CYPRESS_BATCH_FOLDER = "CT_SUDOKU_APP_TESTING-E2E_CYPRESS_BATCH_FILES";

    // Homepage visit pattern
    public static final String HOME_PAGE_VISIT_PATTERN = "cy.visit('/')";
    
    public static final String HOME_PAGE_SELECTED_LEVEL_PATTERN = "cy.get('.status__difficulty-select').select(";
    // Cypress spec success pattern
    public static final String CYPRESS_SPEC_SUCCESS_PATTERN = "All specs passed!";

    /************************************************************/
    /* About Selenium */
    /************************************************************/
    public static final String WEBDRIVER_FOLDER = "./z_webdrivers/";
    public static final String WEBDRIVER_CHROME_KEY = "webdriver.chrome.driver";
    public static final String WEBDRIVER_EDGE_KEY = "webdriver.edge.driver";

    //US 2.1:
    public static final Map<String,String> US2_1 = new HashMap<>();
    public static final Map<String,String> US2_2_1 = new HashMap<>();
    public static final Map<String,String> US2_2_2 = new HashMap<>();
    public static final Map<String,String> US0 = new HashMap<>();
    public static final Map<String,Map> LEVELS = new HashMap<>();
    public static final String LEVELS_SCRIPT_FOLDER = "2.Levels/";
    public static final String US2_1_A_CHROME = LEVELS_SCRIPT_FOLDER+"US2.1.a-Chrome-Level-easy-at-startup.bat";
    public static final String US2_1_B_EDGE = LEVELS_SCRIPT_FOLDER+"US2.1.b-Edge-Level-easy-at-startup.bat";
    public static final String US2_2_1_A_EDGE = LEVELS_SCRIPT_FOLDER+"US2.2-1.a-Edge-Visibility-of-level-medium.bat";
    public static final String US2_2_1_B_CHROME = LEVELS_SCRIPT_FOLDER+"US2.2-1.b-Chrome-Visibility-of-level-medium.bat";
    public static final String US2_2_2_A_EDGE = LEVELS_SCRIPT_FOLDER+"US2.2-2.a-Edge-Visibility-of-level-hard.bat";
    public static final String US2_2_2_B_FIREFOX = LEVELS_SCRIPT_FOLDER+"US2.2-2.b-Firefox-Visibility-of-level-hard.bat";
    public static final String THE_BROWSER_IS_ON_THE_HOME_PAGE = "The browser is on the home page";
    public static final String THE_DEFAULT_LEVEL_IS_EASY = "The default level is \"Easy\"";
    public static final String MISC_SCRIPT_FOLDER = "0.Misc/";
    public static final String US0_CHROME = MISC_SCRIPT_FOLDER+"0.1-Chrome-Port-number.bat";

    
}
