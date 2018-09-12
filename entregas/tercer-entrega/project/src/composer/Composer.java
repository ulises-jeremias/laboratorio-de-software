package composer;

import org.jfugue.player.Player;

import composer.actions.MusicalNotes;

public class Composer {

	public static void main(String[] args) {
		boolean success = MusicalNotes.addNote("gh");
		System.out.println(success);
		
		Player player = new Player();
	    player.play("C D E F G A B");
	}

}
