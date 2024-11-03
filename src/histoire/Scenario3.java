package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Musee;
import personnages.Romain;
import personnages.Musee;

public class Scenario3 {

	public static void main(String[] args) {
		
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		milexcus.parler("UN GAU... UN GAUGAU...");
		
		Musee musee = new Musee();
		
		do {
			System.out.println(milexcus.getForce());
			asterix.frapper(milexcus);
		
		} while (minus.getForce() > 0);

		
		musee.donnerTrophees(asterix,minus.ejecterEquipement()[0]);
	
//		while (minus.getForce() > 0) {
//			asterix.frapper(minus);
//		}
		

		asterix.faireUneDonation(musee);

	}

}