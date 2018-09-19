package composer.containers;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
import composer.components.PentagramLine;

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

		JLayeredPane pentagram = new Pentagram();
		getContentPane().add(pentagram);
		pentagram.setBounds(0, 0, 450, 101);

		// Notes definition
		JPanel notes = new Notes();
		getContentPane().add(notes);
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
		
		JLabel undo = new JLabel("");
		undo.setIcon(new ImageIcon(getClass().getResource("../images/undo.png")));
		undo.setBounds(365, 178, 30, 30);
		getContentPane().add(undo);

		// Inputs definition
		textField1 = new JTextField();
		textField1.setEnabled(false);
		textField1.setDisabledTextColor(Color.BLACK);
		textField1.setBounds(49, 178, 215, 24);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(86, 233, 215, 24);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		
		// Event handlers definitions
		for (Component staveLine : pentagram.getComponents()) {
			staveLine.addMouseListener(new MouseAdapter() {
			   
				@Override
			    public void mouseClicked(MouseEvent e) {
				    PentagramLine line = (PentagramLine) staveLine;
				    System.out.println(line.getNote());

					char duration = !selectedNote.equals(null) ? 
						selectedNote.getMusicalNote().getDuration() : 
						'q';
						
					MusicalNotes.addNote(line.getNote(), duration);
					textField1.setText(MusicalNotes.getNotesAsString());
			    }
		    });
	    }

		for (Component note : notes.getComponents()) {
		     note.addMouseListener(new MouseAdapter() {
				
				@Override
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

		textField2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
			  	update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			  	update();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
			  	update();
			}

			public void update() {
				MusicalNotes.onTextFieldChange(textField2.getText());
			}
		}); 

		play_1.addMouseListener(new MouseAdapter() {

			@Override
		    public void mouseClicked(MouseEvent e) {
			    player.play(MusicalNotes.getNotesAsString());
		    }
	    });
		
		play_2.addMouseListener(new MouseAdapter() {

			@Override
		    public void mouseClicked(MouseEvent e) {
			    player.play(MusicalNotes.getNotesString());
		    }
		});
		
		clean.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MusicalNotes.removeNotes();
				textField1.setText(MusicalNotes.getNotesAsString());
			}
		});

		undo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MusicalNotes.removeNotes(1);
				textField1.setText(MusicalNotes.getNotesAsString());
			}
		});
	}
}
