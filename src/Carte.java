/**
 * Description de la class Carte :
 * 
 * Une carte est composée d'un évènement auquel est associé une date.
 * Si une carte est sur le verso la date est cachée/masquée
 * Aux contraires si elle est sur recto elle est visible et on peut visualiser la date
 */ 
class Carte{

	/**
	 * Attributs:
	 */
	/**
	 * Nom de l'évènement
	 */
	private String evenement;

	/**
	 * Date de l'événement
	 */
	private int date;

	/**
	 * Face de la carte en question
	 */
	private boolean dateVisible;


	/**
	 * Constructeur
	 */
	/**
	 * Constructeur avec paramètre
	 * @param carte sous la forme "EVENEMENT:DATE" et affecte la chaine EVENEMENT à evenement, DATE à date et
	 * initialement la carte n'est pas visible
	 */
	public Carte(String carte){
		/**
		 * début
		 * 	    i <-- 0
		 * 	    evenement <-- ""
		 * 	    d <-- ""
		 * 	    TANT QUE ième_caractère(carte,i) != ':' FAIRE :
		 * 	    		evenement <-- evenement + ième_caractère(carte,i)
		 * 	    		i <-- i + 1
		 * 	    FIN TQ
		 * 
		 * 	    i <-- i + 1 //ignore le caractère ':'
		 * 
		 * 	    TANT QUE i < longueur(carte) FAIRE :
		 * 	    		d <-- d + ième_caractère(carte,i)
		 * 	    		i <-- i + 1
		 * 	    FIN TQ
		 * 
		 * 	    date <-- convertirEntier(d)
		 * 	    dateVisible <-- faux
		 * fin
		 * 
		 * Lexique : 
		 * i 		 : entier 			   : indice d'incrémentation
		 * evenement : chaine de caractère : evenement à une date donnée
		 * d 		 : chaine de caractère : date de l'évènement à convertir
		 * date      : entier 			   : date de l'évenement convertit
		 * 
		 */
		int i = 0;
		evenement="";
		String d="";
		while(carte.charAt(i) != ':'){
			evenement += carte.charAt(i); //ajouter chaque caractère un à un
			i++;
		}
		i++; //pour ignorer le caractère ':'
		while(i< carte.length()){
			d += carte.charAt(i); //ajouter chaque caractère un à un à 
			i++;
		}
		date = Integer.parseInt(d);
		dateVisible = false;

	}



	/**
	 * Accesseurs :
	 */
	public String getEvenement(){
		return evenement;
	}

	public int getDate(){
		return date;
	}

	public boolean getDateVisible(){
		return dateVisible;
	}

	
	/**
	 * Méthodes :
	 */
	
	/**
	 * Permet de changer de côté la carte
	 */
	public void retournerCarte(){
		if(dateVisible)
			dateVisible = false;
		else
			dateVisible = true;
	}

	/**
	 * 
	 * @return une chaine de caractère sous la forme :
	 * 		- ??? -> EVENEMENT si la date n'est pas visible
	 * 		- DATE -> EVENEMENT si la date est visible
	 */
	public String toString(){
		String s="";
		if(dateVisible)
			s+= date + " -> " + evenement;
		else
			s+= "??? -> " + evenement;
		return s;
	}

	public boolean setDateVisible(boolean d){
		this.dateVisible=d;
		return this.dateVisible;

	}
}