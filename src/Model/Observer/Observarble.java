package Model.Observer;

public abstract class Observarble {
	
	private Observer o;
	
	public void setObserver(Observer o) {
		this.o = o;
	}
	
	public void Notify() {
		o.update();
	}
}
