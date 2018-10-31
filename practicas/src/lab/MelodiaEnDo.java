package lab;

import lab.annotations.Duracion;
import lab.annotations.Escala;
import lab.annotations.Melodia;

@Melodia
public class MelodiaEnDo {
	@Escala({"C", "D", "E", "F", "G", "A", "B"})
	private String nota;
	
	@Duracion({"w", "h", "q", "i", "s", "t", "x", "n"})
	private String duracion;
}
