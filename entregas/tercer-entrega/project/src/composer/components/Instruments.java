package composer.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Instruments extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8072933254621442511L;

	public Instruments() {
		super();
		initialize();
	}
	
	public void initialize() {
		Instrument piano = new Instrument("Piano");
		add(piano);
		piano.setImage("../images/piano.png");
        
        Instrument guitar = new Instrument("Guitar");
		add(guitar);
        guitar.setImage("../images/guitar.png");
        
        Instrument flute = new Instrument("Flute");
		add(flute);
		flute.setImage("../images/flute.png");

		Instrument voice = new Instrument("Voice");
		add(voice);
		voice.setImage("../images/voice.gif");
		
		JLabel[] components = new Instrument[] { 
            piano,
            guitar,
			flute,
			voice,
		};
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(components));
	}
}
