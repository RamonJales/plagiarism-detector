package model.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.entities.Signature;

public class SignatureServices {
	protected static double characterSum(String text) {
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
	
	protected static double wordSum(String text) {
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
	
	protected static double averageWordSize(String text) {
		double characterSum =  (double) characterSum(text);
		double wordSum = (double) wordSum(text);
		return characterSum / wordSum;
	}
	
	protected static double TypeToken(String text) {
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
	
	protected static double Hapax(String text) {
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
	
	protected static double averageSentenceSize(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		List<String> characterList = new ArrayList<>();
		
		for (String phrases : sentences) {
			characterList.addAll(Arrays.asList(phrases.split("")));
		}
		double sentencesize = sentences.size();
		double totalCharacter = characterList.size();
		
		return totalCharacter / sentencesize;
	}
	
	protected static double sentenceComplexity(String text) {
		List<String> sentences = TextServices.separateSentences(text);
		double phraseSum = 0.0;
		for (String sentence : sentences) {
			List<String> phraseList = TextServices.separatePhrases(sentence);
			phraseSum += phraseList.size(); 
		}
		return phraseSum / (double)sentences.size();
	}
	
	protected static double averagePhraseSize(String text) {
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
	
	public static Signature signatureCalculation(String text) {
		double a1 = averageWordSize(text);
		double a2 = TypeToken(text);
		double a3 = Hapax(text);
		double a4 = averageSentenceSize(text);
		double a5 = sentenceComplexity(text);
		double a6 = averagePhraseSize(text);
		Signature signature = new Signature(a1, a2, a3, a4, a5, a6);
		return signature;
	}
	
	public static double compareSignature(Signature asA, Signature asB) {
		
		double sum1 = asA.getAveragePhraseLenght() - asB.getAveragePhraseLenght();
		double sum2 = asA.getAverageSentenceComplexity() - asB.getAverageSentenceComplexity();
		double sum3 = asA.getAverageSentenceLenght() - asB.getAverageSentenceLenght();
		double sum4 = asA.getAverageWordLenght() - asB.getAverageWordLenght();
		double sum5 = asA.getHapaxLegomana() - asB.getHapaxLegomana();
		double sum6 = asA.getTypeToken() - asB.getTypeToken();
		
		double sumOfDifference = sum1 + sum2 + sum3 + sum4 + sum5 + sum6;
		
		return sumOfDifference / 6;
	}
}
