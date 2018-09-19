package composer.state;

public class Store {
	public static final String REPLACE = "set-notes";
	public static final String UPDATE = "update-notes";
	
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
	
	public void dispatch(String type, State nextState) {
		switch (type) {
			case Store.UPDATE:
				state.update(nextState);
				break;
			case Store.REPLACE:
				state.setNotes(nextState.getNotes());
				break;
		}
	}
}
