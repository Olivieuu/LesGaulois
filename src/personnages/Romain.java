package personnages;

public class Romain {

	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
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
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public static void main(String[] args) {
		Romain jules = new Romain("Jules",10);
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(jules.getNom());
		System.out.println(jules);
		jules.parler("Bonjour !");
		jules.recevoirCoup(asterix.getForce());
	}
}