import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class HighScore{

    //attribut nom du joueur
    private String nom;

    //attribut score;
    private int score;

    //attribut classement des HighScore
    private int[] classement;

    /**
    *  Constructeur vide qui construit 
    * un tableau d'entier "classement" de longueur 5 
    */
    public HighScore(){
        this.classement= new int[5];
        for(int i=0;i<5;i++)
            this.classement[i]=0;
        this.nom=" ";
        this.score=0;
    }

    public HighScore(int taillemain){
        this.classement= new int[taillemain];
        this.nom=" ";
        this.score=0;
    }

    /**
     * Methode qui permet d'ajouter le score du joueur au tableau classement
     * @param sc
     *          score du joueur
     */

   public void ajouterScore(int sc){
       int i=0;
       if(this.classement[i]!=0)
        while(this.classement[i]<sc && i<this.classement.length) //parcourt le tableau tant que la case courante a une valeur differente de 0, que l'on est pas a la fin du tableau et que le score du joueur est superieur a la valeur de la case
            i++;
        else if(this.classement[i]>sc || this.classement[i]==0){ //Si la valeur de la case vaut 0 ou que le score du joueur est infereiur a la valeur de la case, on insere le score du joueur dans cette case
            this.classement[i]=sc;
            Scanner input = new Scanner(System.in);
            System.out.println("NEW HIGHSCORE !!! Quel est ton nom champion ?");
            this.nom= input.next(); //le joueur donne son nom
            
            System.out.println("Bravo "+this.nom+" ! Te voila dans le tableau des HighScores");
        }else{
            System.out.println("Joli score mais pas assez pour etre dans le classement");
        }
   }

   /**
    * Accesseurs
    * 
    */

    /**
     * Permet de recuperer le nom du joueur
     * @return
     *          le nom du joueur
     */

   public String getNom(){
       return this.nom;
   }

   /**
    * Permet de recuperer le score du joueur
    * @return
    *           le score du joueur
    */
   public int getScore(){
       return this.score;
   }
   
   /**
    * Permet de recuperer le tableau des HighScores
    * @return
    *           le tableau des HighScores
    */
   public int[] getClassment(){
       return this.classement;
   }


   /**
    * Permet d'afficher le tableau des HighScore
    */
   public String toString(){
       String S=" ";
       for(int i=0;i<=5;i++){
            S +=Integer.toString((this.classement[i]))+" "; //Transforme la valeur numerique du score en chaine de caracteres
        }
     return S;
   }
}