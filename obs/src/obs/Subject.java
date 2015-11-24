package obs;

import java.util.Observable;

public class Subject extends Observable {

	public void startProcss(){
		
		setChanged();
		notifyObservers("Processo iniziato");
	
		setChanged();
		notifyObservers("Processo concluso");
	}
}
