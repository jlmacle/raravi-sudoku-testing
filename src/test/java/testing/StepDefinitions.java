package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.util.CypressSpec;
import testing.util.Ext;


public class StepDefinitions { 
    WebDriver driver;
    public StepDefinitions() {
        Ext.LEVELS.put("Medium", Ext.US2_2_1);
        Ext.LEVELS.put("Hard", Ext.US2_2_2);
        Ext.US2_1.put("Chrome", Ext.US2_1_A_CHROME);
        Ext.US2_1.put("Edge", Ext.US2_1_B_EDGE);
        Ext.US2_2_1.put("Edge", Ext.US2_2_1_A_EDGE);
        Ext.US2_2_1.put("Chrome", Ext.US2_2_1_B_CHROME);
        Ext.US2_2_2.put("Edge", Ext.US2_2_2_A_EDGE);
        Ext.US2_2_2.put("Firefox", Ext.US2_2_2_B_FIREFOX);
        Ext.US0.put("Chrome",Ext.US0_CHROME);

        // For Selenium
        System.setProperty(Ext.WEBDRIVER_CHROME_KEY, Ext.WEBDRIVER_FOLDER+"chromedriver.exe");
        System.setProperty(Ext.WEBDRIVER_EDGE_KEY, Ext.WEBDRIVER_FOLDER+"msedgedriver.exe");

    }

    static Logger logger = LogManager.getLogger(StepDefinitions.class);


// US 2.1
@When("{string} is on the homepage")
    public void is_on_the_homepage(String browser) {
        String batchFileName = Ext.US2_1.get(browser);
        boolean containsBrowserName = batchFileName.contains(browser);
        String cypressScriptContent = CypressSpec.getCypressSpecContent(batchFileName);
        boolean oneInstanceOfVisitAndOnHomePage = (cypressScriptContent.indexOf(Ext.HOME_PAGE_VISIT_PATTERN)==cypressScriptContent.lastIndexOf(Ext.HOME_PAGE_VISIT_PATTERN));
        assertTrue(containsBrowserName&&oneInstanceOfVisitAndOnHomePage);
    }

// US 0.1
    @Then("The default level is easy [{string}]")
    public void The_default_level_is_easy(String browser) {
        assertTrue(CypressSpec.passed(Ext.US0.get(browser))); 
    }

// 2nd implementation of US 2.1 using Selenium
    // @When("{string} is on the homepage")
    // public void is_on_the_homepage(String browser) {       
    //     DesiredCapabilities capabilities = new DesiredCapabilities();
    //     capabilities.setCapability("browserName", browser);
        
    //     if (driver != null) {
    //         driver.quit();
    //     }

    //     if (browser.equals("Chrome")) {            
    //         driver = new ChromeDriver();
    //     } else if (browser.equals("Edge")) {            
    //         driver = new EdgeDriver();
    //     } else {
    //         throw new RuntimeException("Browser not supported");
    //     }

    //     driver.get(Ext.URL);
    //     assertEquals(driver.getTitle(), "Sudoku");
    // }

    // @Then("The default level is easy [{string}]")
    // public void The_default_level_is_easy(String browser) {
    //     DesiredCapabilities capabilities = new DesiredCapabilities();
    //     capabilities.setCapability("browserName", browser);
        
    //     if (driver != null) {
    //         driver.quit();
    //     }

    //     if (browser.equals("Chrome")) {            
    //         driver = new ChromeDriver();
    //     } else if (browser.equals("Edge")) {            
    //         driver = new EdgeDriver();
    //     } else {
    //         throw new RuntimeException("Browser not supported");
    //     }

    //     driver.get(Ext.URL);

    //     List<WebElement> dropdownElements = driver.findElements(By.className("status__difficulty-select-select"));
    //     String elementText = null;
    //     for (WebElement element : dropdownElements) {
    //          if (dropdownElements.size()==1)
    //          {elementText = element.getText();}
            
    //     }
    //     assertEquals(elementText, "Easy");
        

    // }

    // US 2.2
    @When("{string} is on the homepage, and I select where Easy is [{string}]")
    public void is_on_the_homepage_and_I_select_where_Easy_is(String browserName, String level) {
        Map mapRelatedToLevel = Ext.LEVELS.get(level);
        String batchFileName = ((Map<String,String>)mapRelatedToLevel).get(browserName);  
        System.out.println("batchFileName: "+batchFileName);
        boolean browserisOnHomePageAndLevelIsSelected = false;
        boolean cypressRunOptionContainsBrowserName = batchFileName.contains(browserName);
        String cypressScriptContent = CypressSpec.getCypressSpecContent(batchFileName);
        boolean oneInstanceOfVisitAndOnHomePage = (cypressScriptContent.indexOf(Ext.HOME_PAGE_VISIT_PATTERN)==cypressScriptContent.lastIndexOf(Ext.HOME_PAGE_VISIT_PATTERN));
        boolean selectionWhereEasyIs = 
            ( (cypressScriptContent.indexOf(Ext.HOME_PAGE_SELECTED_LEVEL_PATTERN)
                ==cypressScriptContent.lastIndexOf(Ext.HOME_PAGE_SELECTED_LEVEL_PATTERN))
            );        
        browserisOnHomePageAndLevelIsSelected =
        cypressRunOptionContainsBrowserName && oneInstanceOfVisitAndOnHomePage && 
        selectionWhereEasyIs;
        assertTrue(browserisOnHomePageAndLevelIsSelected);
    }

    
    @Then("{string} should be visible, selectable and Easy should not be visible anymore [{string}]")
    public void should_be_visible_selectable_and_Easy_should_not_be_visible_anymore(String level, String browserName) {
        Map mapRelatedToLevel = Ext.LEVELS.get(level);
        String batchFileName = ((Map<String,String>)mapRelatedToLevel).get(browserName);
        assertTrue(CypressSpec.passed(batchFileName));
    }

    @Then("The port number is {int} [{string}]")
    public void The_port_number_is(int i, String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    

    

    


    

}
