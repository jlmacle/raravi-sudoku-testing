describe('US 2.2 - Access to the level Medium', () => {
  it('passes', () => {
    cy.visit('/')
    // When clicking on Easy, "Medium" should be visible, selectable and "Medium" should be visible instead of Easy
    cy.get('.status__difficulty-select').select('Medium')
    cy.contains('Medium')
      .should('not.have.value', 'Easy')
  })
})