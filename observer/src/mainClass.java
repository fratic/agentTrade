
public class mainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Totale t = new Totale();
		Item it = new Item("10");
	
		/*	Item it1 = new Item("3");
		Item it2 = new Item("2");
*/
		//System.out.println(t.toString());
		//it.AddObserver(t);
		
	//	it.AddObserver(t);
		it.addObserver(t);
		it.newQuantita();
		
	/*	
	 	
	 	it1.AddObserver((Observer) t);
		it1.newQuantita();
		
		it2.AddObserver((Observer) t);
		it2.newQuantita();	
	
		
	*/
		
	}

}
