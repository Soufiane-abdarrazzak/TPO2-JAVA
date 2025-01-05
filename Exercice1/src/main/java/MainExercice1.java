public class MainExercice1 {
    public static void main(String[] args) {
        try {
            EntierNaturel entier = new EntierNaturel(5);
            System.out.println("Valeur initiale : " + entier.getVal());

            entier.setVal(10);
            System.out.println("Valeur après modification : " + entier.getVal());

            entier.decrementer();
            System.out.println("Valeur après décrémentation : " + entier.getVal());

            entier.setVal(-5); // Provoque une exception
        } catch (NombreNegatifException e) {
            System.err.println("Exception capturée : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }
    }
}
