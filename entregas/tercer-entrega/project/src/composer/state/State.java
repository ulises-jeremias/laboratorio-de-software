package composer.state;

import java.util.ArrayList;

import composer.utils.MusicalPattern;

public class State {	
	private ArrayList<MusicalPattern> patterns;
	private String patternsStr;

	public State() {
		setPatterns(new ArrayList<MusicalPattern>());
		setPatternsStr("");
	}

	/**
	 * @return the patternsStr
	 */
	public String getPatternsStr() {
		return patternsStr;
	}

	/**
	 * @param patternsStr the patternsStr to set
	 */
	public void setPatternsStr(String patternsStr) {
		this.patternsStr = patternsStr;
	}

	public ArrayList<MusicalPattern> getPatterns() {
		return patterns;
	}

	public void setPatterns(ArrayList<MusicalPattern> patterns) {
		this.patterns = patterns;
	}
	
	public void update(State nextState) {
		patterns.addAll(nextState.getPatterns());
		setPatternsStr(nextState.getPatternsStr());
	}

	public void setPatternsFromState(State nextState) {
		setPatterns(nextState.getPatterns());
	}
	
	public void reset() {
		setPatterns(new ArrayList<MusicalPattern>());
		setPatternsStr("");
	}
}
