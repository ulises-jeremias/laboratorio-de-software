package composer.utils;

public class MusicalNote {
	private String note;
	private char duration = 'q';

	public MusicalNote(String noteWithDuration) {
		Integer length = noteWithDuration.length();
		
		setNote(noteWithDuration.substring(0, length - 1));
		setDuration(noteWithDuration.charAt(length - 1));
	}
	
	public MusicalNote(String note, char duration) {
		this.note = note;
		this.duration = duration;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public char getDuration() {
		return duration;
	}

	public void setDuration(char duration) {
		this.duration = duration;
	}
	
	public String toString() {
		return note + duration;
	}
	
	public boolean isValidDuration() {
		return "whqistxn".contains(String.valueOf(duration));
	}
	
	public boolean isValid() {
		return !note.isEmpty() && isValidDuration();
	}
}
