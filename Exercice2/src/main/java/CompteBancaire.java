public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String titulaire;

    public CompteBancaire(String numeroCompte, double solde, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.titulaire = titulaire;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void deposer(double montant) {
        solde += montant;
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour retirer " + montant);
        }
        solde -= montant;
    }

    public void afficherSolde() {
        System.out.println("Compte " + numeroCompte + " - Solde : " + solde);
    }
}
