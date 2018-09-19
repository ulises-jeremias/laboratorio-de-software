package composer.actions;

import java.util.ArrayList;

import composer.state.State;
import composer.state.Store;
import composer.utils.MusicalInstrument;
import composer.utils.MusicalNote;
import composer.utils.MusicalPattern;

public class MusicActions {
	private static Store store = Store.getSingletone();
	
	private static void dispatch(String type, State nextState) {
		store.dispatch(type, nextState);
	}
	
	public static ArrayList<MusicalPattern> getNotes() {
		return store.getState().getPatterns();
	}
	
	public static String getPatternsAsString() {
		StringBuilder sbStr = new StringBuilder();
		ArrayList<MusicalPattern> patterns = store.getState().getPatterns();
		
		for (MusicalPattern pattern: patterns) {
			sbStr.append(pattern.toString());
			sbStr.append(" ");
		}
		
		return sbStr.toString();
	}
	
	public static String getPatternsString() {
		return store.getState().getPatternsStr();
	}
	
	public static boolean addInstrument(String instrument) {
		State nextState = new State();
		ArrayList<MusicalPattern> patterns = new ArrayList<MusicalPattern>();
		
		patterns.add(new MusicalInstrument(instrument));
		nextState.setPatterns(patterns);
		
		try {
			dispatch(Store.UPDATE_PATTERNS, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean addNote(String noteWithDuration) {
		State nextState = new State();
		ArrayList<MusicalPattern> patterns = new ArrayList<MusicalPattern>();
		
		patterns.add(new MusicalNote(noteWithDuration));
		nextState.setPatterns(patterns);
		
		try {
			dispatch(Store.UPDATE_PATTERNS, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}

	public static boolean addNote(String note, char duration) {
		State nextState = new State();
		ArrayList<MusicalPattern> patterns = new ArrayList<MusicalPattern>();
		
		patterns.add(new MusicalNote(note, duration));
		nextState.setPatterns(patterns);
		
		try {
			dispatch(Store.UPDATE_PATTERNS, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}

	public static boolean removePatterns(int n) {
		State nextState = new State();
		ArrayList<MusicalPattern> previewPatterns = store.getState().getPatterns();

		if (previewPatterns.size() == 0) {
			return true;
		}

		ArrayList<MusicalPattern> notes = new ArrayList<MusicalPattern>(previewPatterns.subList(0, previewPatterns.size() - n));
		
		nextState.setPatterns(notes);
		
		try {
			dispatch(Store.SET_PATTERNS, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean removePatterns() {
		State nextState = new State();
		
		nextState.setPatterns(new ArrayList<MusicalPattern>());
		
		try {
			dispatch(Store.SET_PATTERNS, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}

	public static boolean onTextFieldChange(String field) {
		State nextState = new State();
		
		nextState.setPatternsStr(field);
		
		try {
			dispatch(Store.UPDATE_PATTERNS_STR, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
}
