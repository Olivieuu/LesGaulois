package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	private String texte;

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
	
//	public void recevoirCoup(int forceCoup) {
//		assert isInvariantVerified(forceCoup) : "la force du coup reçu est positive";
//	
//		int forceAvant = force;
//		force -= forceCoup;
//		int forceApres = force;
//	
//		if (force > 0) {
//			parler("Aie !");
//		}
//		else {
//			parler("J'abandonne !");
//		}
//		assert isPostConditionVerified(forceAvant,forceApres) : "la force d’un Romain a diminué";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force-= forceCoup;
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipements == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipements;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				}
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			} texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup-= resistanceEquipement;
		return forceCoup;
	
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] == null) {
				continue;
			}
			else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
			}
			nbEquipementEjecte++;
			equipements[i] = null;
		}
		return equipementEjecte;
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