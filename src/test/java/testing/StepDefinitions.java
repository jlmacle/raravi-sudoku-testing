package testing;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import testing.util.CypressSpec;
import testing.util.Ext;


public class StepDefinitions { 
    public StepDefinitions() {
        Ext.LEVELS.put("Medium", Ext.US2_2_1);
        Ext.LEVELS.put("Hard", Ext.US2_2_2);
        Ext.US2_1.put("Chrome", Ext.US2_1_A_CHROME);
        Ext.US2_1.put("Edge", Ext.US2_1_B_EDGE);
        Ext.US2_2_1.put("Edge", Ext.US2_2_1_A_EDGE);
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


    @When("{string} is on the homepage, and I select where Easy is")
    public void is_on_the_homepage_and_I_select_where_Easy_is(String browserName) {
        
        String batchFileName = Ext.US2_2_1.get(browserName);        
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

    


    

}
