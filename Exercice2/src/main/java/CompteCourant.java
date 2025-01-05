public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double solde, String titulaire, double decouvertAutorise) {
        super(numeroCompte, solde, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > getSolde() + decouvertAutorise) {
            throw new FondsInsuffisantsException("Fonds insuffisants même avec découvert.");
        }
        super.deposer(-montant);
    }
}
