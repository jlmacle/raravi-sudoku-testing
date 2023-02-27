describe('US 2.2-1 - Access to level Medium can be found', () => {
  it('passes', () => {
    cy.visit('/')
    // When clicking on "Easy", "Medium" should be visible, selectable and "Easy" should not be visible anymore
    cy.get('.status__difficulty-select').select('Medium')
    cy.contains('Medium')
      .should('not.have.value', 'Easy')
  })
})