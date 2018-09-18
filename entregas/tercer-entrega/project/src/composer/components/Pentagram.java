package composer.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pentagram extends JComponent {
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 826942905931491973L;

	public JComponent render() {
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.BLUE);
		layeredPane.setBounds(0, 0, 450, 101);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 5, 66, 89);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("../images/clavesol.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 5, 450, 12);
		layeredPane.add(panel_1);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 17, 450, 3);
		layeredPane.add(panel_2);
		panel_2.setBackground(Color.BLACK);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 20, 450, 12);
		layeredPane.add(panel_3);
		panel_3.setBorder(null);
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 32, 450, 3);
		layeredPane.add(panel_4);
		panel_4.setBackground(Color.BLACK);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 35, 450, 12);
		layeredPane.add(panel_5);
		panel_5.setBorder(null);
		panel_5.setBackground(Color.WHITE);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 47, 450, 3);
		layeredPane.add(panel_6);
		panel_6.setBackground(Color.BLACK);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 50, 450, 12);
		layeredPane.add(panel_7);
		panel_7.setBorder(null);
		panel_7.setBackground(Color.WHITE);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 62, 450, 3);
		layeredPane.add(panel_8);
		panel_8.setBackground(Color.BLACK);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 65, 450, 12);
		layeredPane.add(panel_9);
		panel_9.setBorder(null);
		panel_9.setBackground(Color.WHITE);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(0, 77, 450, 3);
		layeredPane.add(panel_10);
		panel_10.setBackground(Color.BLACK);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 80, 450, 12);
		layeredPane.add(panel_11);
		panel_11.setBorder(null);
		panel_11.setBackground(Color.WHITE);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 92, 450, 3);
		layeredPane.add(panel_12);
		panel_12.setBackground(Color.WHITE);
		
		return layeredPane;
	}
}
