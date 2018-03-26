/*
Hangman
Written by Robert Amero, Bat-Erdene Battur, and Jeff Nagy
 */

import java.io.*;
import java.util.*;

public class RandomWordGenerator {
	
	private ArrayList<String> words;
	private Scanner fileScan;
	private String gameWord;
	private Random randomIndex;
	
	public RandomWordGenerator(String textFile) throws FileNotFoundException {
		this.fileScan = new Scanner(new FileReader(new File(textFile)));
		this.words = new ArrayList<String>();
	}
	
	public String getGameWord() {
		return gameWord;
	}
	
	public String generateWord() {
		randomIndex = new Random();
		while(fileScan.hasNext()) {
			String word = fileScan.nextLine();
			words.add(word);
		}
		int index = randomIndex.nextInt(words.size()); 
		gameWord = words.get(index);
		return gameWord;
	}

}
