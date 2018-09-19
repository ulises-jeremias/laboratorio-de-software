package composer.components;

import javax.swing.ImageIcon;
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
		JLabel redonda = new Note("", 'w');
		add(redonda);
		redonda.setIcon(new ImageIcon(getClass().getResource("../images/redonda.png")));
		
		JLabel blanca = new Note("", 'h');
		add(blanca);
		blanca.setIcon(new ImageIcon(getClass().getResource("../images/blanca.png")));
		
		JLabel negra = new Note("", 'q');
		add(negra);
		negra.setIcon(new ImageIcon(getClass().getResource("../images/negra.png")));
		
		JLabel corchea = new Note("", 'i');
		add(corchea);
		corchea.setIcon(new ImageIcon(getClass().getResource("../images/corchea.png")));
		
		JLabel semicorchea = new Note("", 's');
		add(semicorchea);
		semicorchea.setIcon(new ImageIcon(getClass().getResource("../images/semicorchea.png")));
		
		JLabel fusa = new Note("", 't');
		add(fusa);
		fusa.setIcon(new ImageIcon(getClass().getResource("../images/fusa.png")));
		
		JLabel semifusa = new Note("", 'x');
		add(semifusa);
		semifusa.setIcon(new ImageIcon(getClass().getResource("../images/semifusa.png")));
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new JLabel[]{redonda, blanca, semicorchea, negra, fusa, semifusa, corchea}));
	}
}
