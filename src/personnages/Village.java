package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private int nbMaxVillageois;
	
	public Village(String nom, int nbMaxVillageois) {
		this.nom = nom;
		this.nbMaxVillageois = nbMaxVillageois;
		villageois = new Gaulois[nbMaxVillageois];
	}
	
	public Village(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public Gaulois ajouterHabitant(Gaulois gaulois) {
		if(nbVillageois < nbMaxVillageois) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			return gaulois;
		}
		return null;
	}
	
	public Gaulois trouverHabitant(int i) {
		return villageois[i];
	}
	
	public void afficherVillageois(Chef chef, int nbVillageois) {
		System.out.println("Dans le village de " + chef.getNom() + " vivent les gaulois : ");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println(" - " + trouverHabitant(i));
		}
	}
	
	public static void main(String[] args) {
		Village irr = new Village("Village des Irréductibles", 30);
		Chef chef = new Chef("Abraracourcix",6,irr);
		Gaulois asterix = new Gaulois("Astérix",8);
		Gaulois obelix = new Gaulois("Obélix",25);
		
		irr.ajouterHabitant(asterix);
		irr.ajouterHabitant(obelix);
		irr.afficherVillageois(chef,2);
	}
}