package cuartaentrega;

import java.util.ArrayList;

import javafx.util.Pair;

public class CharlyTocando {
	public static void main(String[] args) {
		CharlyGarcia elCharly = CharlyGarcia.getSingletone();
		ArrayList<Pair<Notas, Integer>> notas = new ArrayList<Pair<Notas, Integer>>();
		notas.add(new Pair<Notas, Integer>(Notas.SOL, 10));
		notas.add(new Pair<Notas, Integer>(Notas.SOL, 10));
		notas.add(new Pair<Notas, Integer>(Notas.MI, 25));
		notas.add(new Pair<Notas, Integer>(Notas.LA6, 2));
		notas.add(new Pair<Notas, Integer>(Notas.RE, 98));
		elCharly.tocateUna(notas);
	}

}
