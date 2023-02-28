describe('New game on page', () => {
    it('New game on page', () => {
        cy.visit('');
        cy.contains('New game');
    });
})