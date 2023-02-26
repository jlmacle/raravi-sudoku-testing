package testing.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;

public class CypressSpecTest 
{
	@Disabled("Passes in Eclipse, or in main, but not in VSCode")
    @Test
    void isPassedTest()
    {
        String batchFileName = Ext.US2_1.get("Chrome");
        assertTrue(CypressSpec.passed(batchFileName));
    }
    
    //@Disabled("Disabled for quicker test runs")
    @Test
    void getContentTest()
    {
    	String expectedContent = "describe('US 2.1 - Level easy at startup', () => {\r\n"
    			+ "  it('passes', () => {\r\n"
    			+ "    cy.visit('/')\r\n"
    			+ "    cy.get('.status__difficulty-select').should('have.value', 'Easy')\r\n"
    			+ "  })\r\n"
    			+ "})";
    	
    	assertEquals(expectedContent, CypressSpec.getCypressSpecContent(Ext.US2_1.get("Chrome")));
    }
    
}
