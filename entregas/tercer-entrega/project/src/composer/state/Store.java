package composer.state;

public class Store {
	private static Store instance = null;
	
	private State state;
	
	public static Store getSingletone() {
		if (instance == null) {
			instance = new Store();
		}
		
		return instance;
	}
	
	private Store() {
		setState(new State());
	}

	public State getState() {
		return state;
	}

	private void setState(State state) {
		this.state = state;
	}
	
	public void dispatch(State nextState) {
		
	}
}
