package cuartaentrega;


public class Piano implements InstrumentoMusical {

	public Piano() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hacerSonar() {
		System.out.println("Sonido de piano");
	}

	@Override
	public void hacerSonar(Notas n, int duracion) {
		System.out.println("Sonido de piano: " + n.getName() + " " + n.getNote() + " y dura: " + new Integer(duracion).toString());
	}

	@Override
	public String queEs() {
		return "Piano";
	}

	@Override
	public void afinar() {
		System.out.println("Afinando por default(Bach)");
	}

	@Override
	public void afinar(FrecuenciaDeLA f) {
		System.out.println("Afinando en frecuencia: " + f.getFrecuency() + "hz - tambien llamado..." + f.getName());
	}

}
