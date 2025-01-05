public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double solde, String titulaire, double tauxInteret) {
        super(numeroCompte, solde, titulaire);
        this.tauxInteret = tauxInteret;
    }

    public void genererInterets() {
        double interets = getSolde() * tauxInteret;
        deposer(interets);
    }
}
