package model.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextServices {
	
	protected static List<String> separateSentences(String text) {
		List<String> sentencesList = new ArrayList<>(Arrays.asList(text.split("[.!?]+")));
		if (sentencesList.get(sentencesList.size() - 1) == "") {
			sentencesList.remove(sentencesList.size() - 1);
		}
		return sentencesList;
	}
	
	protected static List<String> separatePhrases(String sentence) {
		List<String> PhraseList = new ArrayList<>(Arrays.asList(sentence.split("[,:;]+")));
		return PhraseList;
	}
	
	protected static List<String> separateWords(String phrase) {
		List<String> wordList = new ArrayList<>(Arrays.asList(phrase.split(" ")));
		return wordList;
	}
	
	protected static double uniqueWords(List<String> wordList) {
		Map<String, Double> map = new HashMap<>();
		double singleWordCounter = 0.0;
		
		for (String word : wordList) {			
			String lowerCaseWord = word.toLowerCase();

			if (map.isEmpty()) {
				map.put(lowerCaseWord, 1.0);
				singleWordCounter += 1.0;
			}
			else {
				if (map.containsKey(lowerCaseWord)) {
					if (map.get(lowerCaseWord) == 1.0) {
						singleWordCounter -= 1.0;
					}
					map.put(lowerCaseWord, map.get(lowerCaseWord) + 1.0);
				}
				else {
					map.put(lowerCaseWord, 1.0);
					singleWordCounter += 1.0;
				}
			}
		}
		return singleWordCounter;
	}
	
	protected static double differentWords(List<String> wordList) {
		Map<String, Double> map = new HashMap<>();
		for (String word : wordList) {
			String lowerCaseWord = word.toLowerCase();
			
			if (map.isEmpty()) {
				map.put(lowerCaseWord, 1.0);
			}
			else {
				if (map.containsKey(lowerCaseWord)) {
					map.put(lowerCaseWord, map.get(lowerCaseWord) + 1.0);
				}
				else {
					map.put(lowerCaseWord, 1.0);
				}
			}
		}
		return map.size();
	}
}
