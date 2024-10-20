package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;


	public Gaulois(String nom, int force) {
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
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la figure de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée !");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Romain garde = new Romain("Garde",3);
		Gaulois asterix = new Gaulois("Asterix",8);
		Druide panoramix = new Druide("Panoramix",5,10);

		panoramix.preparerPotion();
		asterix.boirePotion(panoramix.forcePotion);
		asterix.frapper(garde);
	}
	
}