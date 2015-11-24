import java.util.ArrayList;
import java.util.Observable;


public class Item extends Observable {

	private String quantita;
	private boolean state;

	/**
	 * @return the Address
	 */
	
	public String getQuantita() {
		return quantita;
	}

	private ArrayList<Totale> observers;
	
	public Item (String quantita) {
		super();
		this.quantita = quantita;
		observers =new ArrayList<Totale>();
		System.out.println("sono in nuovo item");
	}
	
	public void newQuantita(){
		setChanged();
		NotifyObservers();
	}
	
	public void AddObserver(Totale o) {
		observers.add(o);
	}

	public void RemoveObserver(Totale o) {
		observers.remove(o);
		
	}

	public void NotifyObservers() {
		setChanged();

		for(int i=0;i<observers.size();i++){
			((Totale)observers.get(i)).update();
		}	
	}
	
	public void setState(boolean s){
		this.state=s;
		setChanged();
        notifyObservers();

	}
	
	public boolean getState(){
		return this.state;
	}
	

}
