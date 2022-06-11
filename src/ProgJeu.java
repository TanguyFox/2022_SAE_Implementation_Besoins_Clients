import java.util.Scanner;
/**
 * Descriptif de la classe ProgJeu:
 * Permet de jouer au jeu timeline tout seul 
 */

class 	ProgJeu{


	/**
	 * Méthode principale de lancement du jeu
	 * @param args arguments
	 */
	public static void main(String[] args){
		if(args.length != 2){ // vérification du bon nombre d'argument
			System.out.println("Mauvais nombre d'argument, attendu 2, taille de la main et nom du fichier");
		}
		else{
			int tailleMain = Integer.parseInt(args[0]);//récupère la taille de la main du joueur
			String nomFichier = args[1];//et le nom du fichier

			
			HighScore hs = new HighScore(tailleMain);//highscore

			Scanner input = new Scanner(System.in);

			boolean joueurVeutJouer = true; //variable qui permet de savoir si un joueur veut rejouer une partie

			/**
			 * Boucle principale qui permet de ralancer une partie
			 */
			while(joueurVeutJouer){

				Jeu timeLine = new Jeu(tailleMain,nomFichier);//on initialise le jeu avec la classe jeu et ces 2 arguments
				
				/**
				 * Tant que le joueur a des cartes dans la main le jeu continue
				 * Et tant que la pioche n'est pas vide le jeu continue aussi
				 */
				while(timeLine.getMainJoueur().getNbCartes() != 0 && timeLine.getPioche().getNbCartes() != 0){

					System.out.println(timeLine);//affiche la frise et la main du joeur

					int indiceCarte = timeLine.choisirCarte();//le joueur choisie une carte dans sa main
					int indiceFrise = timeLine.choisirApresCarte();//il choisie emplacement probable dans la frise

					timeLine.jouerCarte(indiceCarte,indiceFrise);//il joue la carte choisie à l'emplacement choisie
				}

				if(timeLine.getMainJoueur().getNbCartes() == 0){
					
					System.out.println("Gagne !\n Score : "+timeLine.getScore());//si la main du joueur est vide c'est qu'il a gagné

					hs.ajouterScore(timeLine.getScore());

					System.out.println("\n High Scores : "+hs.toString());//affiche le highscore

				}
				else{
					System.out.println("Perdu !\n Score : "+timeLine.getScore()+"\n High Scores : "+hs.toString());//sinon c'est qu'il a perdu et que la pioche est vide 

				}




				System.out.println("Voulez vous faire une nouvelle partie : O pour Oui et N pour Non : [O\\N] ?");

				String saisie = input.nextLine();//saisie utilisateur

				/**
				 * Boucle qui permet de vérifier la saisie utilisateur
				 */
				while(!(saisie.charAt(0) == 'N' || saisie.charAt(0) == 'n' || saisie.charAt(0) == 'O' || saisie.charAt(0) == 'o')){
					System.out.println("Saisie incorrecte veuillez écrire [O\\N]");
					saisie = input.nextLine();
				}

				if(saisie.charAt(0) == 'N' || saisie.charAt(0) == 'n'){
					joueurVeutJouer = false;//permet d'arreter la partie
				}


			}
				
		}
	}
}