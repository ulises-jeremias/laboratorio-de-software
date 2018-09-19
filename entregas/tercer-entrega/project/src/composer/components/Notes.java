package composer.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Notes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8072933254621442511L;

	public Notes() {
		super();
		initialize();
	}
	
	public void initialize() {
		Note redonda = new Note('w');
		add(redonda);
		redonda.setImage("../images/redonda.png");
		
		Note blanca = new Note('h');
		add(blanca);
		blanca.setImage("../images/blanca.png");
		
		Note negra = new Note('q');
		add(negra);
		negra.setImage("../images/negra.png");
		
		Note corchea = new Note('i');
		add(corchea);
		corchea.setImage("../images/corchea.png");
		
		Note semicorchea = new Note('s');
		add(semicorchea);
		semicorchea.setImage("../images/semicorchea.png");
		
		Note fusa = new Note('t');
		add(fusa);
		fusa.setImage("../images/fusa.png");
		
		Note semifusa = new Note('x');
		add(semifusa);
		semifusa.setImage("../images/semifusa.png");
		
		
		JLabel[] components = new Note[] { 
			redonda, 
			blanca, 
			semicorchea, 
			negra, 
			fusa, 
			semifusa, 
			corchea,
		};
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(components));
	}
}
