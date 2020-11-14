package reciepe;

/*
 * Classe décrivant un ingrédient. 
 * Un ingrédient est constitué d'un état et d'un nom.
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
