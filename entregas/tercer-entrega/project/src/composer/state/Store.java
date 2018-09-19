package composer.state;

public class Store {
	public static final String SET_PATTERNS = "set-patterns";
	public static final String UPDATE_PATTERNS_STR = "update-patterns-str";
	public static final String UPDATE_PATTERNS = "update-patterns";
	
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
			case Store.UPDATE_PATTERNS:
			case Store.UPDATE_PATTERNS_STR:
				state.update(nextState);
				break;
			case Store.SET_PATTERNS:
				state.setPatternsFromState(nextState);
				break;
		}
	}
}
