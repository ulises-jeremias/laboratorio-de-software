package composer.state;

import java.util.ArrayList;
import composer.utils.MusicalNote;

public class State {	
	private ArrayList<MusicalNote> notes;
	
	public State() {
		setNotes(new ArrayList<MusicalNote>());
	}

	public ArrayList<MusicalNote> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<MusicalNote> notes) {
		this.notes = notes;
	}
}
