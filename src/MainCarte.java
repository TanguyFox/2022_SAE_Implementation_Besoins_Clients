/**
 *Descriptif de la classe MainCarte :
 * Créer une carte pour chaque carte présente dans le fichier timeline.txt
 * Puis on l'affiche
 * Puis on la retourne 
 * Puis on l'affiche une seconde fois
 */
class MainCarte{

	public static void main(String[] args){
		
		LectureFichier timeLine = new LectureFichier("timeline.txt");
		String[] paquet = timeLine.lireFichier();//lecture du fichier en question pour extraire les cartes sous formes de chaine de caractère
		
		for(int i =0;i<paquet.length;i++){	//répète le nb de fois l'opération autant de fois qu'il y a de carte
			Carte c = new Carte(paquet[i]); //Pour chaque carte carte on créer une instance de celle cigrace à la class carte
			System.out.println(c);			//on l'affiche
			c.retournerCarte();				//la retourne
			System.out.println(c);			//puis on l'affiche
		}

	}
}