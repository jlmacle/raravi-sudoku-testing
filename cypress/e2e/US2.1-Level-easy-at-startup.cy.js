describe('US 2.1 - Level easy at startup', () => {
  it('passes', () => {
    cy.visit('/')
    cy.get('.status__difficulty-select').should('have.value', 'Easy')
  })
})