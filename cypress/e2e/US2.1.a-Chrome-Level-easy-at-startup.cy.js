describe('US 2.1.a - Chrome - Level easy at startup', () => {
  it('passes', () => {
    cy.visit('/')
    cy.get('.status__difficulty-select').should('have.value', 'Easy')
  })
})