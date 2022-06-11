import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Frise
 * fonctionne correctement
 */
public class TestFrise {

	/**
	 * methode de lancement des tests
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestFrise(), args);
	}

	/**
	 * Test de la méthode ajouterCarteTrie
	 */
	public void test_01_ajouterCarteTrie(){
		/**
		 * Initialisation
		 */
		Carte[] cartesNonTrie = new Carte[9];//création du tableau de cartes non triées
		cartesNonTrie[7] = new Carte("L'invention de la vis:-250");
		cartesNonTrie[5] = new Carte("L'invention du sablier:900");
		cartesNonTrie[4] = new Carte("L'invention de la boussole:1090");
		cartesNonTrie[3] = new Carte("L'invention des lunettes:1299");
		cartesNonTrie[8] = new Carte("L'invention de l'imprimerie:1437");
		cartesNonTrie[1] = new Carte("L'invention de la lunette astronomique:1609");
		cartesNonTrie[0] = new Carte("L'invention du diapason:1711");
		cartesNonTrie[6] = new Carte("L'invention de la locomotive:1804");
		cartesNonTrie[2] = new Carte("L'invention du jeu de roles:1974");
		
		Carte[] cartesTrie = new Carte[9];//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention de la vis:-250");
		cartesTrie[1] = new Carte("L'invention du sablier:900");
		cartesTrie[2] = new Carte("L'invention de la boussole:1090");
		cartesTrie[3] = new Carte("L'invention des lunettes:1299");
		cartesTrie[4] = new Carte("L'invention de l'imprimerie:1437");
		cartesTrie[5] = new Carte("L'invention de la lunette astronomique:1609");
		cartesTrie[6] = new Carte("L'invention du diapason:1711");
		cartesTrie[7] = new Carte("L'invention de la locomotive:1804");
		cartesTrie[8] = new Carte("L'invention du jeu de roles:1974");
		
		Frise f = new Frise(); //création de la frise
		for(Carte carte:cartesNonTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesNonTrie
		}

		Carte[] cartesDeFrise = f.getCartes();//récupére les cartes de la frise


		/**
		 * Différents tests
		 */
		assertEquals("Vérification de la taille du tableau, doit être égale à 9",9,cartesDeFrise.length);//vérification de la taille du tableau

		for(int i=0;i<9;i++){
			//vérifie date de la carte courante
			assertEquals("La date doit être égale à "+cartesTrie[i].getDate(),cartesTrie[i].getDate(),cartesDeFrise[i].getDate());

			//vérifie l'évènement de la carte courante
			assertEquals("L'évènement doit être égale à "+cartesTrie[i].getEvenement(),cartesTrie[i].getEvenement(),cartesDeFrise[i].getEvenement());

			//vérifie si la carte courante a sa date visible
			assertEquals("La date doit être visible",true,cartesDeFrise[i].getDateVisible());

		}
	}

	/**
	 * Test de la méthode verifierCarteApres si on veut placer la carte avant l'emplacement 0
	 */
	public void test_02_verifierCarteApres_PremiereCarte(){
		
		Carte[] cartesTrie = new Carte[3];//création du tableau de cartes déjà triées

		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("L'invention des lunettes:1299");
		
		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		//si la carte peut s'insérer
		//l'indice est -1 car on veut vérifier si elle peut s'insérer avant la première carte
		assertEquals("Si la carte peut s'insérer cela renvoie True",true,f.verifierCarteApres(new Carte("L'invention de la vis:-250"),-1));

		//si la carte ne peut pas s'insérer
		assertEquals("La carte ne peut s'insérer donc false",false,f.verifierCarteApres(new Carte("Découverte du francium:1939"),-1));





	}

	/**
	 * Test de la méthode verifierCarteApres si on veut placer la carte après un emplacement 
	 */
	public void test_03_verifierCarteApres_DansLaFrise(){
		
		Carte[] cartesTrie = new Carte[3];//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("L'invention des lunettes:1299");
		
		Frise f = new Frise(); //création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		//si la carte peu s'insérer
		assertEquals("Si la carte peut s'insérer cela renvoie True",true,f.verifierCarteApres(new Carte("L'invention de la boussole:1090"),1));

		//si la carte ne peut pas s'insérer 
		assertEquals("La carte ne peut s'insérer donc false",false,f.verifierCarteApres(new Carte("L'invention de la vis:-250"),1));
	}

	/**
	 * Test de la méthode verifierCarteApres si on veut placer en dehors de la frise
	 */
	public void test_04_verifierCarteApres_enDehorsDeLaFrise(){
		
		Carte[] cartesTrie = new Carte[3];//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("L'invention des lunettes:1299");


		
		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		//appelle de la méthode verifierCarteApres si la carte qu'on veut placé est en dehors du tableau
		boolean ajout = f.verifierCarteApres(new Carte("L'invention de la boussole:1090"),10);

		//test
		assertEquals("La carte ne peut s'insérer donc false",false,ajout);


	}

	/**
	 * Test de la méthode ajouterCarteApres lorsque la place n'est pas dans la frise
	 */
	public void test_05_ajouterCarteApres_enDehorsDeLaFrise(){

		Carte[] cartesTrie = new Carte[3];//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("L'invention des lunettes:1299");
		
		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTriees
		}

		Carte c = new Carte("Découverte du francium:1939");//carte qu'on essaye d'ajouter

		boolean ajout = f.ajouterCarteApres(c,10);//résulat de l'opération d'ajout et opération

		//verification de la taille du tableau
		assertEquals("La carte ne s'ajoute pas, donc la taille du tableau doit être de 3",3,f.getCartes().length);

		//verification que l'opération n'a pas eu lieu
		assertEquals("La fonction ajouterCarteApres() retourne false",false,ajout);
	}

	/**
	 * Test de la méthode ajouterCarteApres lorsque la place est dans la frise à la bonne place
	 */
	public void test_06_ajouterCarteApres_dansLaFrise_bonnePlace(){
		Carte[] cartesTrie = new Carte[3];

		//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("Découverte du francium:1939");

		
		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		Carte c = new Carte("L'invention des lunettes:1299"); //création de la carte qu'on veut ajouter

		boolean ajout = f.ajouterCarteApres(c,1);//ajout de la carte à son emplacement dans la frise

		Paquet p = new Paquet(cartesTrie);
		p.ajouterCarte(c,1);  //ajout de la carte c dans cartes en utilisant les fonctions de paquet
		cartesTrie = p.getCartes();


		/**
		 * Différents tests pour vérifier si la carte a bien été ajoutée
		 */
		//verification que l'opération a bien eu lieu
		assertEquals("La fonction ajouterCarteApres() retourne true",true,ajout);

		//vérification de la taille du tableau
		assertEquals("La carte s'ajoute, donc la taille du tableau doit être de 4",4,f.getCartes().length);

		Carte[] cartesDeFrise = f.getCartes();
		
		for(int i=0;i<4;i++){
			//vérifie date de la carte courante
			assertEquals("La date doit être égale à "+cartesTrie[i].getDate(),cartesTrie[i].getDate(),cartesDeFrise[i].getDate());

			//vérifie l'évènement de la carte courante
			assertEquals("L'évènement doit être égale à "+cartesTrie[i].getEvenement(),cartesTrie[i].getEvenement(),cartesDeFrise[i].getEvenement());

			//vérifie si la cârte courante a sa date visible
			assertEquals("La date doit être visible",true,cartesDeFrise[i].getDateVisible());

		}

	}

	/**
	 * Test de la méthode ajouterCarteApres lorsque la place est dans la frise à la mauvaise place
	 */
	public void test_07_ajouterCarteApres_dansLaFrise_mauvaisePlace(){
		Carte[] cartesTrie = new Carte[3];

		//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("Découverte du francium:1939");

		
		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		Carte c = new Carte("L'invention des lunettes:1299"); //création de la carte qu'on veut ajouter

		boolean ajout = f.ajouterCarteApres(c,2);//essaye d'ajouter la carte au mauvais emplacement dans la frise

		/**
		 * Différents tests pour vérifier si la carte n'a pas été ajoutée
		 */
		//verification que l'opération a bien eu lieu
		assertEquals("La fonction ajouterCarteApres() retourne false",false,ajout);

		//vérification de la taille du tableau
		assertEquals("La carte ne s'ajoute pas, donc la taille du tableau doit être de 3",3,f.getCartes().length);

		Carte[] cartesDeFrise = f.getCartes();

		//vérification de chaque cartes en comparant les cartes de cartes et cartesFrise
		for(int i=0;i<3;i++){
			//vérifie date de la carte courante
			assertEquals("La date doit être égale à "+cartesTrie[i].getDate(),cartesTrie[i].getDate(),cartesDeFrise[i].getDate());

			//vérifie l'évènement de la carte courante
			assertEquals("L'évènement doit être égale à "+cartesTrie[i].getEvenement(),cartesTrie[i].getEvenement(),cartesDeFrise[i].getEvenement());

			//vérifie si la cârte courante a sa date visible
			assertEquals("La date doit être visible",true,cartesDeFrise[i].getDateVisible());

		}
	}

	/**
	 * Test de la méthode ajouterCarteApres quand la frise est vide
	 */
	public void test_08_ajouterCarteApres_friseVide(){
		Frise f = new Frise();

		Carte c = new Carte("L'invention des lunettes:1299");

		boolean ajout = f.ajouterCarteApres(c,-1);

		assertEquals("La carte doit s'insérer",true,ajout);
		

	}

	/**
	 * Test de la méthode ajouterCarteApres quand la place est la première place soit l'indice -1
	 */
	public void test_09_ajouterCarteApres_premierePlace_bonnePlace(){

		Carte[] cartesTrie = new Carte[3];

		//création du tableau de cartes déjà triées
		cartesTrie[0] = new Carte("L'invention du sablier:900");
		cartesTrie[1] = new Carte("L'invention de la boussole:1090");
		cartesTrie[2] = new Carte("Découverte du francium:1939");


		Carte c = new Carte("L'invention de la vis:-250");//création de la carte qu'on veut ajouter

		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		boolean ajout = f.ajouterCarteApres(c,-1);//ajout de la carte à son emplacement dans la frise

		Paquet p = new Paquet(cartesTrie);
		p.ajouterCarte(c,-1);  //ajout de la carte c dans cartes en utilisant les fonctions de paquet
		cartesTrie = p.getCartes();


		

		Carte[] cartesDeFrise = f.getCartes();//récupére les cartes de la frise

		/**
		 * Différents tests
		 */
		assertEquals("Doit l'avoir insérer donc égale a true",true,ajout);
		assertEquals("Vérification de la taille du tableau, doit être égale à 4",4,cartesDeFrise.length);//vérification de la taille du tableau

		for(int i=0;i<4;i++){
			//vérifie date de la carte courante
			assertEquals("La date doit être égale à "+cartesTrie[i].getDate(),cartesTrie[i].getDate(),cartesDeFrise[i].getDate());

			//vérifie l'évènement de la carte courante
			assertEquals("L'évènement doit être égale à "+cartesTrie[i].getEvenement(),cartesTrie[i].getEvenement(),cartesDeFrise[i].getEvenement());

			//vérifie si la cârte courante a sa date visible
			assertEquals("La date doit être visible",true,cartesDeFrise[i].getDateVisible());

		}
	}
	/**
	 * Test de la méthode ajouterCarteApres quand la place est la première place soit l'indice -1
	 */
	public void test_10_ajouterCarteApres_premierePlace_mauvaisePlace(){

		Carte[] cartesTrie = new Carte[3];

		//création du tableau de cartes déjà triées

		cartesTrie[0] = new Carte("L'invention de la vis:-250");
		cartesTrie[1] = new Carte("L'invention du sablier:900");
		cartesTrie[2] = new Carte("L'invention de la boussole:1090");


		Carte c = new Carte("Découverte du francium:1939");//création de la carte qu'on veut ajouter

		Frise f = new Frise();//création de la frise
		for(Carte carte:cartesTrie){
			f.ajouterCarteTrie(carte); //ajoute chaque carte une à une de cartesTrie
		}

		boolean ajout = f.ajouterCarteApres(c,-1);//essaye d'ajouter la carte à l'emplaement 0 dans la frise

		Carte[] cartesDeFrise = f.getCartes();//récupére les cartes de la frise

		/**
		 * Différents tests
		 */
		assertEquals("Ne doit pas l'avoir insérer donc égale a false",false,ajout);
		assertEquals("Vérification de la taille du tableau, doit être égale à 3",3,cartesDeFrise.length);//vérification de la taille du tableau

		for(int i=0;i<3;i++){
			//vérifie date de la carte courante
			assertEquals("La date doit être égale à "+cartesTrie[i].getDate(),cartesTrie[i].getDate(),cartesDeFrise[i].getDate());

			//vérifie l'évènement de la carte courante
			assertEquals("L'évènement doit être égale à "+cartesTrie[i].getEvenement(),cartesTrie[i].getEvenement(),cartesDeFrise[i].getEvenement());

			//vérifie si la cârte courante a sa date visible
			assertEquals("La date doit être visible",true,cartesDeFrise[i].getDateVisible());

		}


	}
}
