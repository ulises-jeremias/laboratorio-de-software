package composer.containers;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfugue.player.Player;

import composer.actions.MusicalNotes;
import composer.components.Note;
import composer.components.Notes;
import composer.components.Pentagram;

public class PlayerContainer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9213674316794588532L;
	
	private Player player;
	private JTextField textField1;
	private JTextField textField2;

	protected Note selectedNote;

	public PlayerContainer() {
		super();
		initialize();
	}

	public void initialize() {
		player = new Player();

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Add pentagram to UI
		getContentPane().add(new Pentagram());

		// Notes definition
		JPanel notes = new Notes();
		notes.setBorder(UIManager.getBorder("InternalFrame.paletteBorder"));
		notes.setBounds(49, 108, 349, 58);
		
		// Buttons definition
		JLabel play_1 = new JLabel("");
		play_1.setIcon(new ImageIcon(getClass().getResource("../images/play.png")));
		play_1.setBounds(275, 169, 32, 32);
		getContentPane().add(play_1);
		
		JLabel play_2 = new JLabel("");
		play_2.setIcon(new ImageIcon(getClass().getResource("../images/play.png")));
		play_2.setBounds(316, 225, 32, 32);
		getContentPane().add(play_2);
		
		JLabel clean = new JLabel("");
		clean.setIcon(new ImageIcon(getClass().getResource("../images/clear.png")));
		clean.setBounds(319, 169, 32, 32);
		getContentPane().add(clean);
		
		// Inputs definition
		JLabel undo = new JLabel("");
		undo.setIcon(new ImageIcon(getClass().getResource("../images/undo.png")));
		undo.setBounds(365, 178, 30, 30);
		getContentPane().add(undo);
		
		textField1 = new JTextField();
		textField1.setEnabled(false);
		textField1.setBounds(49, 178, 215, 24);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(86, 233, 215, 24);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		
		// Event handlers definitions
		
		textField2.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    update();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    update();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    update();
			  }

			  public void update() {
			     MusicalNotes.onTextFieldChange(textField2.getText());
			  }
			});
		
		for (Component note : notes.getComponents()) {
		     note.addMouseListener(new MouseAdapter() {
				
			    public void mouseClicked(MouseEvent e) {
			    	((Note) note).toggleSelected();
			    	
				    if (!((Note) note).isSelected()) {
				    	selectedNote = null;
				    	return;
				    }
				    
				    if (selectedNote != null)
			    		selectedNote.toggleSelected();
			    	
			    	selectedNote = (Note) note;
			    }
		    });
		}
		
		play_2.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
			    player.play(MusicalNotes.getNotesAsString());
		    }
	    });
	}
}
