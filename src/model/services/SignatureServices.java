package model.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignatureServices {
	public static double characterSum(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> characterList = new ArrayList<>();
		
		for (String phrases : sentences) {
			List<String> phraseList = TextServices.separatePhrases(phrases);
			for (String phrase : phraseList) {
				characterList.addAll(Arrays.asList(phrase.split("")));
			}
		}
		characterList.removeIf(t -> t.equals(" "));
		return (double)characterList.size();
	}
	
	public static double wordSum(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> wordList = new ArrayList<>();
		
		for (String phrases : sentences) {
			List<String> phraseList = TextServices.separatePhrases(phrases);
			for (String phrase : phraseList) {
				wordList.addAll(Arrays.asList(phrase.split(" ")));
			}
		}
		wordList.removeIf(t -> t.equals(""));
		return (double)wordList.size();
	}
	
	public static double averageWordSize(String text) {
		double characterSum =  (double) characterSum(text);
		double wordSum = (double) wordSum(text);
		return characterSum / wordSum;
	}
	
	public static double TypeToken(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> wordList = new ArrayList<>();
		
		for (String phrases : sentences) {
			List<String> phraseList = TextServices.separatePhrases(phrases);
			for (String phrase : phraseList) {
				wordList.addAll(Arrays.asList(phrase.split(" ")));
			}
		}
		wordList.removeIf(t -> t.equals(""));
		double wordSum = wordSum(text);
		double differentWords = TextServices.differentWords(wordList);
		
		return differentWords / wordSum;
	}
	
	public static double Hapax(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> wordList = new ArrayList<>();
		
		for (String phrases : sentences) {
			List<String> phraseList = TextServices.separatePhrases(phrases);
			for (String phrase : phraseList) {
				wordList.addAll(Arrays.asList(phrase.split(" ")));
			}
		}
		wordList.removeIf(t -> t.equals(""));
		
		double wordSum = wordSum(text);
		double uniqueWords = TextServices.uniqueWords(wordList);
		
		return uniqueWords / wordSum;
	}
	
	public static double averageSentenceSize(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> characterList = new ArrayList<>();
		
		for (String phrases : sentences) {
			characterList.addAll(Arrays.asList(phrases.split("")));
		}
		double sentencesize = sentences.size();
		double totalCharacter = characterList.size();
		
		return totalCharacter / sentencesize;
	}
	
	public static double sentenceComplexity(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		double phraseSum = 0.0;
		for (String sentence : sentences) {
			List<String> phraseList = TextServices.separatePhrases(sentence);
			phraseSum += phraseList.size(); 
		}
		return phraseSum / (double)sentences.size();
	}
	
	public static double averagePhraseSize(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> phraseList = new ArrayList<>();
		double phraseSum = 0.0;
		double characterSum = 0.0;
		
		for (String sentence : sentences) {
			phraseList = TextServices.separatePhrases(sentence);
			for (String phrase : phraseList) {
				characterSum += phrase.length();
				phraseSum += 1;
			}
		}
		return characterSum / phraseSum;
	}
	
	public static List<Double> subscriptionCalculation(String text) {
		double a1 = averageWordSize(text);
		double a2 = TypeToken(text);
		double a3 = Hapax(text);
		double a4 = averageSentenceSize(text);
		double a5 = sentenceComplexity(text);
		double a6 = averagePhraseSize(text);
		List<Double> subscription = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));
		return subscription;
	}
	
	public static double compareSubscriptions(List<Double> asA, List<Double> asB) {
		double sumOfDifference = 0.0;
		for (int i = 0; i < 6; i++) {
			double fA = asA.get(i);
			double fB = asB.get(i);
			sumOfDifference += Math.abs(fA - fB);
		}
		return sumOfDifference / 6;
	}
}
