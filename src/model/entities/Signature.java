package model.entities;

public class Signature {
	
	private Double averageWordLenght;
	private Double typeToken;
	private Double hapaxLegomana;
	private Double averageSentenceLenght;
	private Double averageSentenceComplexity;
	private Double averagePhraseLenght;
	
	public Signature() {}

	public Signature(Double averageWordLenght, Double typeToken, Double hapaxLegomana, Double averageSentenceLenght, Double averageSentenceComplexity, Double averagePhraseLenght) {
		this.averageWordLenght = averageWordLenght;
		this.typeToken = typeToken;
		this.hapaxLegomana = hapaxLegomana;
		this.averageSentenceLenght = averageSentenceLenght;
		this.averageSentenceComplexity = averageSentenceComplexity;
		this.averagePhraseLenght = averagePhraseLenght;
	}

	public Double getAverageWordLenght() {
		return averageWordLenght;
	}

	public void setAverageWordLenght(Double averageWordLenght) {
		this.averageWordLenght = averageWordLenght;
	}

	public Double getTypeToken() {
		return typeToken;
	}

	public void setTypeToken(Double typeToken) {
		this.typeToken = typeToken;
	}

	public Double getHapaxLegomana() {
		return hapaxLegomana;
	}

	public void setHapaxLegomana(Double hapaxLegomana) {
		this.hapaxLegomana = hapaxLegomana;
	}

	public Double getAverageSentenceLenght() {
		return averageSentenceLenght;
	}

	public void setAverageSentenceLenght(Double averageSentenceLenght) {
		this.averageSentenceLenght = averageSentenceLenght;
	}

	public Double getAverageSentenceComplexity() {
		return averageSentenceComplexity;
	}

	public void setAverageSentenceComplexity(Double averageSentenceComplexity) {
		this.averageSentenceComplexity = averageSentenceComplexity;
	}

	public Double getAveragePhraseLenght() {
		return averagePhraseLenght;
	}

	public void setAveragePhraseLenght(Double averagePhraseLenght) {
		this.averagePhraseLenght = averagePhraseLenght;
	}

	@Override
	public String toString() {
		return "Signature [averageWordLenght=" + averageWordLenght + ", typeToken=" + typeToken + ", hapaxLegomana="
				+ hapaxLegomana + ", averageSentenceLenght=" + averageSentenceLenght + ", averageSentenceComplexity="
				+ averageSentenceComplexity + ", averagePhraseLenght=" + averagePhraseLenght + "]";
	}
}
