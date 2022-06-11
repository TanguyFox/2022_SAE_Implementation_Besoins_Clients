import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;
/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquet {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	/**
	 * Test du constructeur sans paramètre
	 */
	public void test_01_constructeur_sans_param(){
		Paquet p = new Paquet();//création du paquet
		assertEquals("La longueur du tableau doit = 0",0,p.getNbCartes());
	}

	/**
	 * Test du constructeur avec paramètre
	 */
	public void test_02_constructeur_avec_param(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		assertEquals("La longueur du tableau doit = 3",3,p.getNbCartes());//test de la taille du tableau

	}

	/**
	 * Test de l'accesseur getCarte à une place donnée à l'intérieur du tableau
	 */
	public void test_03_getCarte_interieur_paquet(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		Carte c = p.getCarte(2);
		assertEquals("La taille du tableau doit = 3",3,p.getNbCartes());//test de la taille du tableau
		/**
		 * Test les attributs de la carte en question
		 */
		assertEquals("L'évènement doit = L'invention de Deep Blue","L'invention de Deep Blue",c.getEvenement());
		assertEquals("La date doit = 1997",1997,c.getDate());
		assertEquals("La dateVisible doit = false",false,c.getDateVisible());
	}

	/**
	 * Test de l'accesseur getCarte à une place donnée à l'extérieur du tableau
	 */
	public void test_04_getCarte_exterieur_paquet(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		Carte c = p.getCarte(10);//carte à l'extérieur du paquet
		assertEquals("La taille du tableau doit = 3",3,p.getNbCartes());//test de la taille du tableau
		assertEquals("La carte retourner doit = null",null,c);
	}

	/**
	 * Test de l'ajout d'une carte à la fin du paquet
	 */
	public void test_06_ajouterCarteFin(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		Carte c = new Carte("L'invention de la roue:-2000");
		p.ajouterCarteFin(c);
		assertEquals("La taille du tableau doit = 4",4,p.getNbCartes());//test de la taille du tableau
		Carte c2 = p.getCarte(3); //récupère la dernière carte du paquet
		/**
		 * Test les attributs de la carte en question
		 */
		assertEquals("L'évènement doit = L'invention de la roue","L'invention de la roue",c2.getEvenement());
		assertEquals("La date doit = -2000",-2000,c2.getDate());
		assertEquals("La dateVisible doit = false",false,c2.getDateVisible());
	}
	
	/**
	 * Test de la supression d'une carte à une place p à l'intérieur du tableau
	 */
	public void test_07_retirerCarte_interieur(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		p.retirerCarte(0);//suppression de la carte à l'emplacement 0
		assertEquals("La taille du tableau doit = 2",2,p.getNbCartes());
		/**
		 * Carte 1 doit aller en 0 et la carte 2 est en position 1
		 */
		Carte c0 = p.getCarte(0);
		assertEquals("L'évènement doit = L'invention du langage de programmation java","L'invention du langage de programmation java",c0.getEvenement());
		assertEquals("La date doit = 1997",1995,c0.getDate());
		assertEquals("La dateVisible doit = false",false,c0.getDateVisible());

		Carte c1 = p.getCarte(1);
		assertEquals("L'évènement doit = L'invention de Deep Blue","L'invention de Deep Blue",c1.getEvenement());
		assertEquals("La date doit = 1997",1997,c1.getDate());
		assertEquals("La dateVisible doit = false",false,c1.getDateVisible());
	}

	/**
	 * Test de la supression d'une carte à une place p à l'exterieur du tableau
	 */
	public void test_08_retirerCarte_exterieur(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet

		p.retirerCarte(11);//suppression de la carte à l'emplacement 11 ne supprime rien
		assertEquals("La taille du tableau doit = 3",3,p.getNbCartes());
	}

	/**
	 * Test de l'ajout d'une carte au début du paquet
	 */
	public void test_09_ajouterCarteDebut(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		Carte c = new Carte("L'invention de la roue:-2000");
		p.ajouterCarteDebut(c);
		assertEquals("La taille du tableau doit = 4",4,p.getNbCartes());//test de la taille du tableau
		Carte c2 = p.getCarte(0); //récupère la dernière carte du paquet
		/**
		 * Test les attributs de la carte en question
		 */
		assertEquals("L'évènement doit = L'invention de la roue","L'invention de la roue",c2.getEvenement());
		assertEquals("La date doit = -2000",-2000,c2.getDate());
		assertEquals("La dateVisible doit = false",false,c2.getDateVisible());
	}

	/**
	 * Test de l'ajout d'une carte à une place p à l'intérieur du tableau
	 */
	public void test_10_ajouterCarte_interieur(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		p.ajouterCarte(new Carte("L'invention de la roue:-2000"),1);//ajout de la carte à l'emplacement 1+1 soit 2
		assertEquals("La taille du tableau doit = 4",4,p.getNbCartes());
		/**
		 * La nouvelle carte doit aller à l'emplacement 2 et l'ancienne carte à l'emplacement 2 doit aller à l'emplacement 3
		 */
		Carte c2 = p.getCarte(2);
		assertEquals("L'évènement doit = L'invention de la roue","L'invention de la roue",c2.getEvenement());
		assertEquals("La date doit = -2000",-2000,c2.getDate());
		assertEquals("La dateVisible doit = false",false,c2.getDateVisible());
		Carte c3 = p.getCarte(3);
		assertEquals("L'évènement doit = L'invention de Deep Blue","L'invention de Deep Blue",c3.getEvenement());
		assertEquals("La date doit = 1997",1997,c3.getDate());
		assertEquals("La dateVisible doit = false",false,c3.getDateVisible());
	}

	/**
	 * Test d'ajout d'une carte à une place p à l'exterieur du tableau
	 */
	public void test_11_ajouterCarte_exterieur(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet
		p.ajouterCarte(new Carte("L'invention de la roue:-2000"),-5);//ajout de la carte à l'emplacement -5 n'ajoute rien
		assertEquals("La taille du tableau doit = 3",3,p.getNbCartes());
	}

	/**
	 * Test de la méthode toString la date non visible
	 */
	public void test_12_toString(){
		Carte[] cartes = new Carte[2];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		
		Paquet p = new Paquet(cartes);//création du paquet
		String f = p.toString();
		

		String s ="--------------------------\n0. carte(??? -> Découverte du francium)\n1. carte(??? -> L'invention du langage de programmation java)\n--------------------------";
		
		assertEquals("la chaine f et s doivent être égale",s,f);
	}

	/**
	 * Test de la méthode toString avec la date visible
	 */
	public void test_13_toString(){
		Carte[] cartes = new Carte[2];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[0].retournerCarte();
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[1].retournerCarte();
		
		Paquet p = new Paquet(cartes);//création du paquet
		String f = p.toString();
		

		String s ="--------------------------\n0. carte(1939 -> Découverte du francium)\n1. carte(1995 -> L'invention du langage de programmation java)\n--------------------------";
		
		assertEquals("la chaine f et s doivent être égale",s,f);
	}

	/**
	 * Test du constructeur qui prend un nom de fichier en paramètre
	 */
	public void test_14_constructeur_nomFichier(){
		/**
		 * Création du paquet via le nouveau constructeur
		 */
		Paquet p = new Paquet("timeline.txt"); //création du paquet via le fichier timeline.txt
		Carte[] cartesDuPaquet = p.getCartes();


		/**
		 * Récupération des cartes manuellement
		 */
		LectureFichier fichierTimeLine = new LectureFichier("timeline.txt");//lecture du fichier
		String[] cartesString = fichierTimeLine.lireFichier();			 //extraction des chaines de caractères
		Carte[] cartesDuFichier = new Carte[cartesString.length];				 //définition de la taille du tableau

		for(int i =0;i<cartesString.length;i++){
			cartesDuFichier[i] = new Carte(cartesString[i]);				 //convertion de la chaine de caractère en Carte
		}

		//verification de la taille du tableau
		assertEquals("Vérification de la taille du tableau qui doit = "+cartesDuFichier.length,cartesDuFichier.length,p.getNbCartes());

		//verification des cartes une à une
		for(int j=0;j<cartesDuFichier.length;j++){
			assertEquals("Evenement doit = "+cartesDuFichier[j].getEvenement(),cartesDuFichier[j].getEvenement(),cartesDuPaquet[j].getEvenement());
			assertEquals("Date doit = "+cartesDuFichier[j].getDate(),cartesDuFichier[j].getDate(),cartesDuPaquet[j].getDate());
		}
	}

	/**
	 * Test de la méthode pioche au hasard lorsque le paquet est remplie
	 */
	public void test_15_piocheHasard_paquetRemplie(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet

		Carte c = p.piocherHasard();

		cartes = p.getCartes();
		
		//la carte tirée ne doit plus appartenir au paquet de carte
		boolean estDansPaquet = false;
		int i =0;
		while(i<cartes.length && !estDansPaquet){
			if(cartes[i] == c)
				estDansPaquet = true;
			i++;
		}

		assertEquals("La longueur du tableau doit être maintenant de 2",2,cartes.length);
		assertEquals("La carte tirée ne doit plus appartenir au paquet de cartes",false,estDansPaquet);



		
	}

	/**
	 * Test de la méthode pioche au hasard lorsque le paquet est vide
	 */
	public void test_16_piocheHasard_paquetVide(){
		
		
		Paquet p = new Paquet();//création du paquet

		Carte c = p.piocherHasard();

		assertEquals("La carte piochée doit être null",null,c);
		
	}


	/**
	 * Test de l'ajout d'une carte à la fin du paquet si le paquet est vide
	 */
	public void test_17_ajouterCarteFin_PaquetVide(){
		Paquet p = new Paquet();//création du paquet vide
		Carte c = new Carte("L'invention de la roue:-2000");
		p.ajouterCarteFin(c);
		assertEquals("La taille du tableau doit = 1",1,p.getNbCartes());//test de la taille du tableau
		Carte c2 = p.getCarte(0); //récupère la dernière carte du paquet
		
		assertEquals("La carte doit être égale à la carte en question",c,c2);//test si l'objet est le même
	}

	/**
	 * Test de l'ajout d'une carte au début du paquet si le paquet est vide
	 */
	public void test_18_ajouterCarteDebut_PaquetVide(){
		Paquet p = new Paquet();//création du paquet vide
		Carte c = new Carte("L'invention de la roue:-2000");
		p.ajouterCarteDebut(c);
		assertEquals("La taille du tableau doit = 1",1,p.getNbCartes());//test de la taille du tableau
		Carte c2 = p.getCarte(0); //récupère la dernière carte du paquet
		
		assertEquals("La carte doit être égale à la carte en question",c,c2);//test si l'objet est le même
	}
	
	/**
	 * Test de l'ajout d'une carte au paquet si le paquet est vide
	 */
	public void test_19_ajouterCarte_PaquetVide(){
		Paquet p = new Paquet();//création du paquet vide
		Carte c = new Carte("L'invention de la roue:-2000");
		p.ajouterCarte(c,0);
		assertEquals("La taille du tableau doit = 1",1,p.getNbCartes());//test de la taille du tableau
		Carte c2 = p.getCarte(0); //récupère la dernière carte du paquet
		
		assertEquals("La carte doit être égale à la carte en question",c,c2);//test si l'objet est le même
	}

	/**
	 * Test de la méthode retirerCarte si le paquet est vide 
	 */
	public void test_20_retirerCarte_PaquetVide(){
		Paquet p = new Paquet();
		p.retirerCarte(0); //essaye de retirer carte si le paquet est vide
		assertEquals("La taille du tableau doit être de 0",0,p.getNbCartes());//vérifie la taille du tableau

	}

	/**
	 * Test de la méthode ajouterCarteApres quand on veut l'insérer en première position
	 */
	public void test_21_ajouterCarteApres_premierePosition(){
		Carte[] cartes = new Carte[3];//création du tableau de cartes
		cartes[0] = new Carte("Découverte du francium:1939");
		cartes[1] = new Carte("L'invention du langage de programmation java:1995");
		cartes[2] = new Carte("L'invention de Deep Blue:1997");
		Paquet p = new Paquet(cartes);//création du paquet

		Carte c = new Carte("L'invention de la roue:-2000");
		p.ajouterCarte(c,-1);

		Carte[] tempo = cartes;
		cartes = new Carte[4];
		for(int i = 0;i<3;i++){
			cartes[i+1] = tempo[i];
		}
		cartes[0] = c;

		Carte[] cartesDuPaquet = p.getCartes();
		assertEquals("La taille du paquet doit être de 4",4,cartesDuPaquet.length);
		
		for(int i = 0;i<4;i++){
			//vérifie date de la carte courante
			assertEquals("La date doit être égale à "+cartes[i].getDate(),cartes[i].getDate(),cartesDuPaquet[i].getDate());

			//vérifie l'évènement de la carte courante
			assertEquals("L'évènement doit être égale à "+cartes[i].getEvenement(),cartes[i].getEvenement(),cartesDuPaquet[i].getEvenement());
		}





	}
}
