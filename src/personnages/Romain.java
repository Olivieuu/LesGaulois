package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;

	private boolean isInvariantVerified(int force) {
	    return force > 0;
	}
	
	private boolean isPostConditionVerified(int forceAvant, int forceApres) {
	    return forceAvant - forceApres > 0;
	}
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
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
	
	private void sEquiper(Equipement equipement) {
		if (nbEquipements >= 2) {
			parler("est déjà bien protégé !");
			return;
		}
		for(int i=0;i<nbEquipements;i++) {
			if(equipements[i] == equipement) {
				parler("possède déjà un " + equipement + " !");
				return;
			}
		}
		equipements[nbEquipements] = equipement;
		nbEquipements ++;
		parler("s'équipe avec " + equipement + ".");
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
		
		garde.sEquiper(Equipement.CASQUE);
		garde.sEquiper(Equipement.CASQUE);
		garde.sEquiper(Equipement.BOUCLIER);
		garde.sEquiper(Equipement.CASQUE);
	}
}