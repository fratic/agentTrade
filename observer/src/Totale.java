import java.util.Observable;
import java.util.Observer;


public class Totale implements Observer {
	
	String Tot;
	
	//public void Update() {}

/*	public void update(Observable arg0, Object arg1) {
		System.out.println("In totale, sono stato avvisato");
		
	}
	*/
	
    public void update() {
        System.out.println("Sono " + this + ": il Subject e' stato modificato!");
    }

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
        System.out.println("Sono " + this + ": il item e' stato modificato!");

	}

	
}
