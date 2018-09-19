package composer.state;

public class Store {
	public static final String SET_NOTES = "set-notes";
	public static final String UPDATE_NOTES_STR = "update-notes-str";
	public static final String UPDATE_NOTES = "update-notes";
	
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
			case Store.UPDATE_NOTES:
			case Store.UPDATE_NOTES_STR:
				state.update(nextState);
				break;
			case Store.SET_NOTES:
				state.setNotesFromState(nextState);
				break;
		}
	}
}
