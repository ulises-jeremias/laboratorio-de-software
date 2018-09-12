package composer.actions;

import java.util.ArrayList;

import composer.state.State;
import composer.state.Store;
import composer.utils.MusicalNote;

public class MusicalNotes {
	private static Store store = Store.getSingletone();
	
	private static void dispatch(State nextState) {
		store.dispatch(nextState);
	}
	
	public static ArrayList<MusicalNote> getNotes() {
		return store.getState().getNotes();
	}
	
	public static boolean addNote(String noteWithDuration) {
		State nextState = new State();
		ArrayList<MusicalNote> notes = new ArrayList<MusicalNote>();
		
		notes.add(new MusicalNote(noteWithDuration));
		nextState.setNotes(notes);
		
		try {
			dispatch(nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
}
