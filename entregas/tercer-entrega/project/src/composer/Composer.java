package composer;

import org.jfugue.player.Player;

import composer.actions.MusicalNotes;

public class Composer {

	public static void main(String[] args) {
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
