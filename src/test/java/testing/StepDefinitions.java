package testing;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import testing.util.CypressSpec;
import testing.util.Ext;


public class StepDefinitions { 
    public StepDefinitions() {
        Ext.US2_1.put("Chrome", Ext.US2_1_A_CHROME);
        Ext.US2_1.put("Edge", Ext.US2_1_B_EDGE);
        Ext.US2_2.put("Edge", Ext.US2_2_1_A_EDGE);
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

    @Then("The default level is easy [{string}]")
    public void The_default_level_is_easy(String browser) {
        assertTrue(CypressSpec.passed(Ext.US2_1.get(browser))); 
    }

    @When("{string} is on the homepage, and I click on the level {string}")
    public void is_on_the_homepage_and_I_click_on_the_level(String browserName, String selectedLevel) {
        String batchFileName = Ext.US2_2.get(browserName);        
        boolean browserisOnHomePageAndLevelIsSelected = false;
        boolean cypressRunOptionContainsBrowserName = batchFileName.contains(browserName);
        String cypressScriptContent = CypressSpec.getCypressSpecContent(batchFileName);
        boolean oneInstanceOfVisitAndOnHomePage = (cypressScriptContent.indexOf(Ext.HOME_PAGE_VISIT_PATTERN)==cypressScriptContent.lastIndexOf(Ext.HOME_PAGE_VISIT_PATTERN));
        boolean oneInstanceOfSelectedLevelAndSelectedLevelIsCorrect = 
            ( (cypressScriptContent.indexOf(Ext.HOME_PAGE_SELECTED_LEVEL_PATTERN)
                ==cypressScriptContent.lastIndexOf(cypressScriptContent))
            ) &&
            ( cypressScriptContent.contains(Ext.HOME_PAGE_SELECTED_LEVEL_PATTERN+selectedLevel) );
        System.out.println(String.format("oneInstanceOfSelectedLevelAndSelectedLevelIsCorrect=%s", oneInstanceOfSelectedLevelAndSelectedLevelIsCorrect));
        System.out.println(String.format("cypressRunOptionContainsBrowserName=%s", cypressRunOptionContainsBrowserName));
        System.out.println(String.format("oneInstanceOfVisitAndOnHomePage=%s", oneInstanceOfVisitAndOnHomePage));
        browserisOnHomePageAndLevelIsSelected =
        cypressRunOptionContainsBrowserName && oneInstanceOfVisitAndOnHomePage && 
        oneInstanceOfSelectedLevelAndSelectedLevelIsCorrect;
        assertTrue(browserisOnHomePageAndLevelIsSelected);
    }

    @Then("{string} should be visible, selectable and Easy should not be visible anymore")
    public void should_be_visible_selectable_and_Easy_should_not_be_visible_anymore(String s) {
        // Write code here that turns the phrase above into concrete actions
    }


    

}
