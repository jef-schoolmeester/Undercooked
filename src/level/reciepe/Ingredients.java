package level.reciepe;

/*
 * Classe d�crivant un ingr�dient. 
 * Un ingr�dient est constitu� d'un �tat et d'un nom.
 * 
 * @author Pierre Abeille
 */

public class Ingredients {

	private String name;
	private State state;
	
	public Ingredients(String name, State state) {
		this.name = name;
		this.state = state;
	}
	
}
