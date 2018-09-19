package composer;

import java.awt.EventQueue;

import org.jfugue.player.Player;

import composer.actions.MusicActions;
import composer.containers.PlayerContainer;

public class Composer {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PlayerContainer()
						.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void test() {
		String[] notes = "Cs Ds Es Fs Gs As Bs".split(" ");
		
		for (String note: notes) {
			if (!MusicActions.addNote(note)) {
				System.exit(-1);
			}
		}
		
		System.out.println(MusicActions.getPatternsAsString());
		Player player = new Player();
	    player.play(MusicActions.getPatternsAsString());
	}

}
