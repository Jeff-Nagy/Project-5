import java.util.*;
import java.io.*;

public class Hangman {

	public static void main(String[] args) {
		
		Random randomIndex;
		Scanner fileScan = null;				
		
		ArrayList<String> words;				//create an array from the text file
		String word = "";						//the selected word
		int index = 0;							//index that will be used by Random
		
		//recommended counters
		int numLetters = 0;
		int numIncorrectGuesses = 0;
		int numLettersGuessedCorrectly = 0;		
		
		//recommended variables
		char[] selectedWordArray;				//keep characters of selected word in array to loop through and compare guess
		boolean[] guessedLetter; 				//represents whether the letter at each position has been guessed
		ArrayList<Character> lettersGuessed;	//keep track of which letters have been guessed
		
		final int MAX_GUESSES = 7;				//constant max guesses
		
		try {
			words = new ArrayList<String>();
			fileScan = new Scanner(new FileReader(new File("words.txt")));
			fileScan.nextLine();
			
			while(fileScan.hasNext()) {
				word = fileScan.nextLine();
				words.add(word);
			}
			
			randomIndex = new Random();
			index = randomIndex.nextInt(words.size());
			
			System.out.println(words.get(index));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if(fileScan != null) {
				fileScan.close();
			}
		}

	}

}
