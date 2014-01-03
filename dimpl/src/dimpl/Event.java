package dimpl;

import java.util.Observable;

public class Event extends Observable {

	public void raise() {
		super.setChanged();
		super.notifyObservers();
	}
	
	public void raise(Object arg) {
		super.setChanged();
		super.notifyObservers(arg);
	}
	
}
