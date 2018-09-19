package cuartaentrega;

import java.util.ArrayList;

import javafx.util.Pair;

public class CharlyGarcia {
	private static CharlyGarcia instance = null;
	private String pattern;
	private InstrumentoMusical instrumento;
	
	private CharlyGarcia() {
		setPattern("");
		setInstrumento(new Piano());
	}
	
	public static CharlyGarcia getSingletone() {
		if (instance == null) {
			instance = new CharlyGarcia(); 
		}
		return instance;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public InstrumentoMusical getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(InstrumentoMusical instrumento) {
		this.instrumento = instrumento;
	}
	
	public void tocateUna(ArrayList<Pair<Notas, Integer>> notas) {
		instrumento.afinar(FrecuenciaDeLA.BACH);
		for(Pair<Notas, Integer> nota : notas) {
			instrumento.hacerSonar(nota.getKey(), nota.getValue());
		}
	}
}
