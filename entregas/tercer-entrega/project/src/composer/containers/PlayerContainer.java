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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfugue.player.Player;

import composer.actions.MusicActions;
import composer.components.Instrument;
import composer.components.Instruments;
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
	protected Instrument selectedInstrument;

	public PlayerContainer() {
		super();
		initialize();
	}

	public void initialize() {
		player = new Player();

		setBounds(100, 100, 450, 500);
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

		// Instruments definition
		JPanel instruments = new Instruments();
		getContentPane().add(instruments);
		instruments.setBounds(49, 170, 349, 58);
		
		// Buttons definition
		JLabel pentagramPlayButton = new JLabel("");
		pentagramPlayButton.setIcon(new ImageIcon(getClass().getResource("../images/play.png")));
		pentagramPlayButton.setBounds(275, 243, 32, 32);
		getContentPane().add(pentagramPlayButton);

		JLabel clean = new JLabel("");
		clean.setIcon(new ImageIcon(getClass().getResource("../images/clear.png")));
		clean.setBounds(319, 243, 32, 32);
		getContentPane().add(clean);
		
		JLabel undo = new JLabel("");
		undo.setIcon(new ImageIcon(getClass().getResource("../images/undo.png")));
		undo.setBounds(365, 245, 30, 30);
		getContentPane().add(undo);
		
		JLabel playTextFieldButton = new JLabel("");
		playTextFieldButton.setIcon(new ImageIcon(getClass().getResource("../images/play.png")));
		playTextFieldButton.setBounds(275, 305, 32, 32);
		getContentPane().add(playTextFieldButton);

		// Inputs definition
		textField1 = new JTextField();
		textField1.setEnabled(false);
		textField1.setDisabledTextColor(Color.BLACK);
		textField1.setBounds(49, 249, 215, 24);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(49, 310, 215, 24);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		
		// Event handlers definitions
		for (Component staveLine : pentagram.getComponents()) {
			staveLine.addMouseListener(new MouseAdapter() {
			   
				@Override
			    public void mouseClicked(MouseEvent e) {
				    PentagramLine line = (PentagramLine) staveLine;
				    
					char duration = selectedNote != null ? 
						selectedNote.getMusicalNote().getDuration() : 
						'q';

					System.out.println(duration);
						
					MusicActions.addNote(line.getNote(), duration);
					textField1.setText(MusicActions.getPatternsAsString());
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

		for (Component instrument : instruments.getComponents()) {
			instrument.addMouseListener(new MouseAdapter() {
			   
			    @Override
			    public void mouseClicked(MouseEvent e) {
				    ((Instrument) instrument).toggleSelected();
				   
				    if (!((Instrument) instrument).isSelected()) {
				        MusicActions.addInstrument("Piano");
					    selectedInstrument = null;
					    return;
				    }
				   
				    if (selectedInstrument != null)
					    selectedInstrument.toggleSelected();
				   
				    selectedInstrument = (Instrument) instrument;
				   
				    MusicActions.addInstrument(selectedInstrument.getMusicalInstrument());
				    textField1.setText(MusicActions.getPatternsAsString());
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
				MusicActions.onTextFieldChange(textField2.getText());
			}
		}); 

		pentagramPlayButton.addMouseListener(new MouseAdapter() {

			@Override
		    public void mouseClicked(MouseEvent e) {
			    player.play(MusicActions.getPatternsAsString());
		    }
	    });
		
		playTextFieldButton.addMouseListener(new MouseAdapter() {

			@Override
		    public void mouseClicked(MouseEvent e) {
			    player.play(MusicActions.getPatternsString());
		    }
		});
		
		clean.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MusicActions.removePatterns();
				textField1.setText(MusicActions.getPatternsAsString());
			}
		});

		undo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MusicActions.removePatterns(1);
				textField1.setText(MusicActions.getPatternsAsString());
			}
		});
	}
}
