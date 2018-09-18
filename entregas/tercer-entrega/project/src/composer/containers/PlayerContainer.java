package composer.containers;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import composer.components.Pentagram;

public class PlayerContainer {
	private JFrame frame;
	private JTextField textField;

	public PlayerContainer() {

	}

	public JFrame render() {
		frame = new JFrame();

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Pentagram pane = new Pentagram();

		frame.getContentPane().add(pane.render());

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(49, 178, 215, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("InternalFrame.paletteBorder"));
		panel.setBounds(49, 108, 349, 58);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("../images/redonda.png"));

		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("../images/blanca.png"));

		JLabel lblNewLabel_6 = new JLabel("");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon("../images/semicorchea.png"));

		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("../images/negra.png"));

		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		label_1.setIcon(new ImageIcon("../images/fusa.png"));

		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		label_2.setIcon(new ImageIcon("../images/semifusa.png"));

		JLabel lblNewLabel_5 = new JLabel("");
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon("../images/corchea.png"));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new JComponent[]{lblNewLabel_2, lblNewLabel_3, lblNewLabel_6, lblNewLabel_4, label_1, label_2, lblNewLabel_5}));

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("../images/play.png"));
		label_3.setBounds(275, 169, 32, 32);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("../images/play.png"));
		label_4.setBounds(316, 225, 32, 32);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("../images/escoba.png"));
		label_5.setBounds(319, 169, 32, 32);
		frame.getContentPane().add(label_5);

		return frame;
	}
}
