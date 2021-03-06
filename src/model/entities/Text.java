package model.entities;

import java.util.List;
import java.util.Objects;

public class Text {
	
	private String text;
	private List<String> sentences;
	private List<String> phrases;
	private List<String> words;
	private List<String> uniqueWords;
	private List<String> differentWords;
	
	public Text() {}

	public Text(String text, List<String> sentences, List<String> phrases, List<String> words, List<String> uniqueWords, List<String> differentWords) {
		this.text = text;
		this.sentences = sentences;
		this.phrases = phrases;
		this.words = words;
		this.uniqueWords = uniqueWords;
		this.differentWords = differentWords;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getSentences() {
		return sentences;
	}

	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}

	public List<String> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<String> phrases) {
		this.phrases = phrases;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public List<String> getUniqueWords() {
		return uniqueWords;
	}

	public void setUniqueWords(List<String> uniqueWords) {
		this.uniqueWords = uniqueWords;
	}

	public List<String> getDifferentWords() {
		return differentWords;
	}

	public void setDifferentWords(List<String> differentWords) {
		this.differentWords = differentWords;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Text other = (Text) obj;
		return Objects.equals(text, other.text);
	}
}
