describe('US 2.2 - Access to level Hard can be found', () => {
  it('passes', () => {
    cy.visit('/')
    // When clicking on Easy, "Medium" should be visible, selectable and "Medium" should be visible instead of Easy
    cy.get('.status__difficulty-select').select('Hard')
    cy.contains('Hard')
      .should('not.have.value', 'Easy')
  })
})