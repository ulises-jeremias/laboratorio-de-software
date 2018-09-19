package composer.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Instrument extends JLabel {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6468559182176223083L;
    
    private String musicalInstrument;
	private boolean isSelected = false;
	
	public Instrument(String musicalInstrument) {
		super("");
		setMusicalInstrument(musicalInstrument);
		setSelected(false);
	}

	/**
     * @return the musicalInstrument
     */
    public String getMusicalInstrument() {
        return musicalInstrument;
    }

    /**
     * @param musicalInstrument the musicalInstrument to set
     */
    public void setMusicalInstrument(String musicalInstrument) {
        this.musicalInstrument = musicalInstrument;
    }

	public void setImage(String relativePath) {
		setIcon(new ImageIcon(getClass().getResource(relativePath)));
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
