package part03;

/**
 *	Objects from which an id or name can be obtained. They can also call toString() and getDetails() method.
 *	Implemented by Recipe and Ingredient
 */
public interface IdedAndNamed {
	public int getId();
	public String getName();
	public String toString();
	public String getDetails();
}
