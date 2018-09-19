package cuartaentrega;

public class Guitarra implements InstrumentoMusical {

	public Guitarra() {
	}

	@Override
	public void hacerSonar() {
		System.out.println("Sonido de guitarra");
	}

	@Override
	public void hacerSonar(Notas n, int duracion) {
		System.out.println("Sonido de guitarra: " + n.getName() + " " + n.getNote() + " y dura: " + new Integer(duracion).toString());
	}

	@Override
	public String queEs() {
		return "Guitarra";
	}

	@Override
	public void afinar() {
		System.out.println("Afinando por default...");
	}

	@Override
	public void afinar(FrecuenciaDeLA f) {
		System.out.println("Afinando en frecuencia: " + f.getFrecuency() + "hz - tambien llamado..." + f.getName());
	}

}
