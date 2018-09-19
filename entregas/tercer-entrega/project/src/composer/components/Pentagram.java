package composer.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Pentagram extends JLayeredPane {
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 826942905931491973L;

	public Pentagram() {
		super();
		initialize();
	}
	
	public void initialize() {
		JLabel claveDeSol = new JLabel("");
		claveDeSol.setBounds(0, 5, 66, 89);
		add(claveDeSol);
		claveDeSol.setHorizontalAlignment(SwingConstants.CENTER);
		claveDeSol.setIcon(new ImageIcon(getClass().getResource("../images/clavesol.png")));
		
		PentagramLine penta_1 = new PentagramLine("G");
		penta_1.setBounds(0, 5, 450, 12);
		add(penta_1);
		penta_1.setBorder(null);
		penta_1.setBackground(Color.WHITE);
		
		PentagramLine penta_2 = new PentagramLine("F");
		penta_2.setBounds(0, 17, 450, 3);
		add(penta_2);
		penta_2.setBackground(Color.BLACK);
		
		PentagramLine penta_3 = new PentagramLine("E");
		penta_3.setBounds(0, 20, 450, 12);
		add(penta_3);
		penta_3.setBorder(null);
		penta_3.setBackground(Color.WHITE);
		
		PentagramLine penta_4 = new PentagramLine("D");
		penta_4.setBounds(0, 32, 450, 3);
		add(penta_4);
		penta_4.setBackground(Color.BLACK);
		
		PentagramLine penta_5 = new PentagramLine("C");
		penta_5.setBounds(0, 35, 450, 12);
		add(penta_5);
		penta_5.setBorder(null);
		penta_5.setBackground(Color.WHITE);
		
		PentagramLine penta_6 = new PentagramLine("B6");
		penta_6.setBounds(0, 47, 450, 3);
		add(penta_6);
		penta_6.setBackground(Color.BLACK);
		
		PentagramLine penta_7 = new PentagramLine("A6");
		penta_7.setBounds(0, 50, 450, 12);
		add(penta_7);
		penta_7.setBorder(null);
		penta_7.setBackground(Color.WHITE);
		
		PentagramLine penta_8 = new PentagramLine("G6");
		penta_8.setBounds(0, 62, 450, 3);
		add(penta_8);
		penta_8.setBackground(Color.BLACK);
		
		PentagramLine penta_9 = new PentagramLine("F6");
		penta_9.setBounds(0, 65, 450, 12);
		add(penta_9);
		penta_9.setBorder(null);
		penta_9.setBackground(Color.WHITE);
		
		PentagramLine penta_10 = new PentagramLine("E6");
		penta_10.setBounds(0, 77, 450, 3);
		add(penta_10);
		penta_10.setBackground(Color.BLACK);
		
		PentagramLine penta_11 = new PentagramLine("D6");
		penta_11.setBounds(0, 80, 450, 12);
		add(penta_11);
		penta_11.setBorder(null);
		penta_11.setBackground(Color.WHITE);
		
		PentagramLine penta_12 = new PentagramLine("C6");
		penta_12.setBounds(0, 92, 450, 3);
		add(penta_12);
		penta_12.setBackground(Color.WHITE);

		JPanel[] components = new PentagramLine[] {
			penta_1,
			penta_2,
			penta_3,
			penta_4,
			penta_5,
			penta_6,
			penta_7,
			penta_8,
			penta_9,
			penta_10,
			penta_11,
			penta_12,
		};

		setFocusTraversalPolicy(new FocusTraversalOnArray(components));
	}
}
