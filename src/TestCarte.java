import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}

	/**
	 * Test constructeur d'une carte
	 */
	public void test_01_constructeur(){
		Carte c = new Carte("Découverte du francium:1939");//création de la carte
		assertEquals("Évènement doit être = Découverte du francium","Découverte du francium",c.getEvenement());//test de l'attribut evenement
		assertEquals("Date doit être = 1939",1939,c.getDate());//test de l'attribut date
		assertEquals("dateVisible doit être = false",false,c.getDateVisible());//test de l'attribut dateVisible
	}

	/**
	 * Test de la méthode retournerCarte lorsque la date n'est pas visible
	 */
	public void test_02_retournerCarte_date_non_visible(){
		Carte c = new Carte("Découverte du francium:1939");//création de la carte
		//initialement la date n'est pas visible
		c.retournerCarte();//retourne la carte

		/**
		 * Il y a juste l'attribut dateVisible qui doit passer de false à true 
		 */
		assertEquals("Évènement doit être = Découverte du francium","Découverte du francium",c.getEvenement());//test de l'attribut evenement
		assertEquals("Date doit être = 1939",1939,c.getDate());//test de l'attribut date
		assertEquals("dateVisible doit être = false",true,c.getDateVisible());//test de l'attribut dateVisible
	}

	/**
	 * Test de la méthode retournerCarte lorsque la date est visible
	 */
	public void test_03_retournerCarte_date_visible(){
		Carte c = new Carte("Découverte du francium:1939");//création de la carte
		c.setDateVisible(true);//change l'attribut dateVisible à true

		c.retournerCarte();//retourne la carte

		/**
		 * Il y a juste l'attribut dateVisible qui doit passer de true à false 
		 */
		assertEquals("Évènement doit être = Découverte du francium","Découverte du francium",c.getEvenement());//test de l'attribut evenement
		assertEquals("Date doit être = 1939",1939,c.getDate());//test de l'attribut date
		assertEquals("dateVisible doit être = false",false,c.getDateVisible());//test de l'attribut dateVisible
	}
	
	/**
	 * Test de la méthode toString lorsque la date n'est pas visible
	 */
	public void test_04_toString_date_non_visible(){
		Carte c = new Carte("Découverte du francium:1939");//création de la carte

		assertEquals("Doit retourner : ??? -> Découverte du francium","??? -> Découverte du francium",c.toString());
	}
	/**
	 * Test de la méthode toString lorsque la date est visible
	 */
	public void test_05_toString_date_visible(){
		Carte c = new Carte("Découverte du francium:1939");//création de la carte
		c.retournerCarte();							   //la date devient visible
		assertEquals("Doit retourner : 1939 -> Découverte du francium","1939 -> Découverte du francium",c.toString());
	}
		


}
