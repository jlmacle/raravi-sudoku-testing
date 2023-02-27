package testing;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;
import testing.util.CypressSpec;
import testing.util.Ext;


public class StepDefinitions { 
    public StepDefinitions() {
        Ext.US2_1.put("Chrome", Ext.US2_1_A_CHROME);
        Ext.US2_1.put("Edge", Ext.US2_1_B_EDGE);
        Ext.US2_1.put("Edge", Ext.US2_2_1_A_EDGE);
    }

    Logger LOGGER = Logger.getLogger(StepDefinitions.class.getName());

// US 2.1
@When("{string} is on the homepage")
    public void is_on_the_homepage(String browser) {
        System.out.println("browser: "+browser);
        String batchFileName = Ext.US2_1.get(browser);
        System.out.println("batchFileName: "+batchFileName);
        System.out.println(Ext.US2_1);
        boolean containsBrowserName = batchFileName.contains(browser);
        String cypressScriptContent = CypressSpec.getCypressSpecContent(batchFileName);
        boolean oneInstanceOfVisitAndOnHomePage = (cypressScriptContent.indexOf(Ext.HOME_PAGE_VISIT_PATTERN)==cypressScriptContent.lastIndexOf(Ext.HOME_PAGE_VISIT_PATTERN));
        assertTrue(containsBrowserName&&oneInstanceOfVisitAndOnHomePage);
    }

    @Then("The default level is easy [{string}]")
    public void The_default_level_is_easy(String browser) {
        assertTrue(CypressSpec.passed(Ext.US2_1.get(browser))); 
    }

    // @Then("{string} should be visible, selectable and Easy should not be visible anymore")
    // public void should_be_visible_selectable_and_Easy_should_not_be_visible_anymore(String s) {
    //     // Write code here that turns the phrase above into concrete actions
    // }

    // @When("I click on the level {string}")
    // public void I_click_on_the_level(String s) {
    //     // Write code here that turns the phrase above into concrete actions
    // }

    

}
