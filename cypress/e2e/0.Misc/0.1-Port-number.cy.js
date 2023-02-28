describe('Port number', () => {
    it('should be 3000', () => {
        cy.visit('/')
        cy.url().should('include', ':3000')
    })
})