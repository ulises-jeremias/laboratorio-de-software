package composer.actions;

import java.util.ArrayList;

import composer.state.State;
import composer.state.Store;
import composer.utils.MusicalNote;

public class MusicalNotes {
	private static Store store = Store.getSingletone();
	
	private static void dispatch(String type, State nextState) {
		store.dispatch(type, nextState);
	}
	
	public static ArrayList<MusicalNote> getNotes() {
		return store.getState().getNotes();
	}
	
	public static String getNotesAsString() {
		StringBuilder sbStr = new StringBuilder();
		ArrayList<MusicalNote> notes = store.getState().getNotes();
		
		for (MusicalNote note: notes) {
			sbStr.append(note.toString());
			sbStr.append(" ");
		}
		
		return sbStr.toString();
	}
	
	public static boolean addNote(String noteWithDuration) {
		State nextState = new State();
		ArrayList<MusicalNote> notes = new ArrayList<MusicalNote>();
		
		notes.add(new MusicalNote(noteWithDuration));
		nextState.setNotes(notes);
		
		try {
			dispatch(Store.UPDATE, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean onTextFieldChange(String field) {
		State nextState = new State();
		ArrayList<MusicalNote> notes = new ArrayList<MusicalNote>();
		
		for (String noteWithDuration: field.split(" ")) {
			System.out.println(noteWithDuration);
			notes.add(new MusicalNote(noteWithDuration));
		}
		
		nextState.setNotes(notes);
		
		try {
			dispatch(Store.REPLACE, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
}
