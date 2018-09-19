package composer.utils;

public class MusicalInstrument implements MusicalPattern, Comparable<MusicalInstrument> {
	private String instrument;

	public MusicalInstrument(String instrument) {
		setInstrument(instrument);
	}

	/**
     * @return the instrument
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * @param instrument the instrument to set
     */
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String toString() {
        return "I[" + instrument + "]";
    }

    @Override
	public int compareTo(MusicalInstrument instrument) {
		return toString().equals(instrument.toString()) ? 1 : 0;
	}
}
