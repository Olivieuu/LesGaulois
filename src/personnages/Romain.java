package personnages;

public class Romain {

	private String nom;
	private int force;

	private boolean isInvariantVerified(int force) {
	    return force > 0;
	}
	
	private boolean isPostConditionVerified(int forceAvant, int forceApres) {
	    return forceAvant - forceApres > 0;
	}
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(this.force);
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
		assert isInvariantVerified(forceCoup) : "la force du coup reçu est positive";
		
		int forceAvant = force;
		force -= forceCoup;
		int forceApres = force;
		
		if (force > 0) {
			parler("Aie !");
		} else {
			parler("J'abandonne !");
		}
		assert isPostConditionVerified(forceAvant,forceApres) : "la force d’un Romain a diminué";
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public static void main(String[] args) {
		Romain garde = new Romain("Garde",6);
		Gaulois asterix = new Gaulois("Asterix",8);
		
		garde.parler("Bonjour !");
		asterix.frapper(garde);
		asterix.frapper(garde);
		asterix.frapper(garde);
		
//		System.out.println("TEST DES ASSERTS :");
//		Romain garde2 = new Romain("Garde2",-6);
//		garde2.recevoirCoup(-1);
		
	}
}