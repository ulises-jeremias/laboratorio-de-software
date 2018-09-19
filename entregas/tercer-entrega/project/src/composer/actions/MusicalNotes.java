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
	
	public static String getNotesString() {
		return store.getState().getNotesStr();
	}
	
	public static boolean addNote(String noteWithDuration) {
		State nextState = new State();
		ArrayList<MusicalNote> notes = new ArrayList<MusicalNote>();
		
		notes.add(new MusicalNote(noteWithDuration));
		nextState.setNotes(notes);
		
		try {
			dispatch(Store.UPDATE_NOTES, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}

	public static boolean addNote(String note, char duration) {
		State nextState = new State();
		ArrayList<MusicalNote> notes = new ArrayList<MusicalNote>();
		
		notes.add(new MusicalNote(note, duration));
		nextState.setNotes(notes);
		
		try {
			dispatch(Store.UPDATE_NOTES, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}

	public static boolean removeNotes(int n) {
		State nextState = new State();
		ArrayList<MusicalNote> previewNotes = store.getState().getNotes();

		if (previewNotes.size() == 0) {
			return true;
		}

		ArrayList<MusicalNote> notes = new ArrayList<MusicalNote>(previewNotes.subList(0, previewNotes.size() - n));
		
		nextState.setNotes(notes);
		
		try {
			dispatch(Store.SET_NOTES, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean removeNotes() {
		State nextState = new State();
		
		nextState.setNotes(new ArrayList<MusicalNote>());
		
		try {
			dispatch(Store.SET_NOTES, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}

	public static boolean onTextFieldChange(String field) {
		State nextState = new State();
		
		nextState.setNotesStr(field);
		
		try {
			dispatch(Store.UPDATE_NOTES_STR, nextState);
		}
		catch(Error e) {
			return false;
		}
		
		return true;
	}
}
