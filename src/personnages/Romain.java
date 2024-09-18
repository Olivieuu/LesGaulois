package personnages;

public class Romain {

	private String nom;
	private int force;

	public Romain(String nom, int force, int effetPotion) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie !");
		} else {
			parler("J'abandonne !");
		}
	}

}