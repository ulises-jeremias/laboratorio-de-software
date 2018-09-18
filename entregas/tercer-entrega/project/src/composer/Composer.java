package composer;

import java.awt.EventQueue;

import org.jfugue.player.Player;

import composer.actions.MusicalNotes;
import composer.containers.PlayerContainer;

public class Composer {
	public static void main(String[] args) {
		test();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PlayerContainer()
						.render()
						.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void test() {
		String[] notes = "Ch Dh Eh Fh Gh Ah Bh".split(" ");
		
		for (String note: notes) {
			if (!MusicalNotes.addNote(note)) {
				System.exit(-1);
			}
		}
		
		System.out.println(MusicalNotes.getNotesAsString());
		Player player = new Player();
	    player.play(MusicalNotes.getNotesAsString());
	}

}
