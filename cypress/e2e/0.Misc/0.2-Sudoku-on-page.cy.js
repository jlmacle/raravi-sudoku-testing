describe('Sudoku on page', () => {
    it('Sudoku on page', () => {
        cy.visit('');
        cy.contains('Sudoku');
    });
})