import java.util.ArrayList;

public class MainExercice2 {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        try {
            // Création de comptes
            CompteCourant compte1 = new CompteCourant("123", 5000, "Soufiane", 1000);
            CompteEpargne compte2 = new CompteEpargne("456", 10000, "Ali", 0.05);

            // Ajout des comptes à la liste
            comptes.add(compte1);
            comptes.add(compte2);

            // Affichage des soldes
            compte1.afficherSolde();
            compte2.afficherSolde();

            // Retrait avec découvert
            compte1.retirer(5500); // Utilisation du découvert
            compte1.afficherSolde();

            // Générer des intérêts sur le compte d'épargne
            compte2.genererInterets();
            compte2.afficherSolde();

            // Effectuer un transfert entre comptes
            effectuerTransfert(comptes, "123", "456", 3000);

        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.err.println(e.getMessage());
        }
    }

    // Méthode pour effectuer un transfert entre deux comptes
    public static void effectuerTransfert(ArrayList<CompteBancaire> comptes, String source, String destination, double montant)
            throws CompteInexistantException, FondsInsuffisantsException {
        CompteBancaire compteSource = trouverCompte(comptes, source);
        CompteBancaire compteDestination = trouverCompte(comptes, destination);

        compteSource.retirer(montant);
        compteDestination.deposer(montant);
    }

    // Méthode pour trouver un compte dans la liste
    public static CompteBancaire trouverCompte(ArrayList<CompteBancaire> comptes, String numero)
            throws CompteInexistantException {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumeroCompte().equals(numero)) {
                return compte;
            }
        }
        throw new CompteInexistantException("Compte avec numéro " + numero + " inexistant.");
    }
}
