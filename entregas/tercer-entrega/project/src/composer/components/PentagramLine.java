package composer.components;

import javax.swing.JPanel;

public class PentagramLine extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5280123554104195943L;
	private String note;
	
	public PentagramLine(String note) {
		super();
		setNote(note);
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
}