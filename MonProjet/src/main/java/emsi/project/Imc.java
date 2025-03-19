package emsi.project;

public class Imc {
	 private double taille;
	    private double poids;

	    public Imc(double taille, double poids) {
	        this.taille = taille;
	        this.poids = poids;
	    }

	    public double calcul() {
	        if (taille <= 0) {
	            throw new IllegalArgumentException("La taille doit être supérieure à zéro.");
	        }
	        return poids / (taille * taille);
	    }

}
