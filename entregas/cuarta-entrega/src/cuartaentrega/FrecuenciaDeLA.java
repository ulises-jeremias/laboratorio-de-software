package cuartaentrega;

public enum FrecuenciaDeLA {
	ISO("ISO", 440),
	CAMERA("Camera tunning", 444),
	RENAISSANCE("Renaissance tunning", 446),
	BACH("Bach", 480);
	
	private String name;
	private int frecuency;
	
	FrecuenciaDeLA(String name, int frecuency){
		this.setName(name);
		this.setFrecuency(frecuency);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(int frecuency) {
		this.frecuency = frecuency;
	}
}
