package cuartaentrega;

public enum Notas {
	SOL("SOL", "G"),
	FA("FA", "F"),
	MI("MI", "E"),
	RE("RE", "D"),
	DO("DO", "C"),
	SI6("SI6", "B6"),
	LA6("LA6", "A6"),
	SOL6("SOL6", "G6"),
	FA6("FA6", "F6"),
	MI6("MI6", "E6"),
	RE6("RE6", "D6"),
	DO6("DO6", "C6");
	
	private String note;
	private String name;
	
	Notas(String name, String note) {
		this.setNote(note);
		this.setName(name);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
