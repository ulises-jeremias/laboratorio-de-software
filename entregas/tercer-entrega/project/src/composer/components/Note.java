package composer.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import composer.utils.MusicalNote;

public class Note extends JLabel {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6468559182176223083L;
	private MusicalNote musicalNote;
	private boolean isSelected = false;
	
	public Note(String note, char duration) {
		super("");
		setMusicalNote(new MusicalNote(note, duration));
		setSelected(false);
	}

	public Note(char duration) {
		super("");
		setMusicalNote(new MusicalNote("", duration));
		setSelected(false);
	}

	public void setImage(String relativePath) {
		setIcon(new ImageIcon(getClass().getResource(relativePath)));
	}

	public MusicalNote getMusicalNote() {
		return musicalNote;
	}

	public void setMusicalNote(MusicalNote musicalNote) {
		this.musicalNote = musicalNote;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public void toggleSelected() {
		setBorder(!isSelected() ? new LineBorder(Color.BLUE) : null);
		setSelected(!isSelected());
	}
}
