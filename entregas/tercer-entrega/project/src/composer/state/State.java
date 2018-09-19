package composer.state;

import java.util.ArrayList;

import composer.utils.MusicalNote;

public class State {	
	private ArrayList<MusicalNote> notes;
	private String notesStr;

	public State() {
		setNotes(new ArrayList<MusicalNote>());
		setNotesStr("");
	}

	/**
	 * @return the notesStr
	 */
	public String getNotesStr() {
		return notesStr;
	}

	/**
	 * @param notesStr the noteStr to set
	 */
	public void setNotesStr(String notesStr) {
		this.notesStr = notesStr;
	}

	public ArrayList<MusicalNote> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<MusicalNote> notes) {
		this.notes = notes;
	}
	
	public void update(State nextState) {
		notes.addAll(nextState.getNotes());
		setNotesStr(nextState.getNotesStr());
	}

	public void setNotesFromState(State nextState) {
		setNotes(nextState.getNotes());
	}
	
	public void reset() {
		setNotes(new ArrayList<MusicalNote>());
		setNotesStr("");
	}
}
