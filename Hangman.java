/*
Hangman
Written by Robert Amero, Bat-Erdene Battur, and Jeff Nagy
 */

import java.io.*;
import java.util.*;

public class Hangman extends RandomWordGenerator {
	private String progressWord;
	private int numIncorrectGuesses;
	private int numLettersGuessedCorrectly;
	private boolean[] correctlyGuessed;
	private ArrayList<Character> lettersGuessed;
	private Scanner scan;
	private String userInput;
	private char guessedLetter;
	
	public static int wins = 0;
	public static int losses = 0;
	public static final int MAX_GUESSES = 7;
	
	public Hangman(String textFile) throws FileNotFoundException {
		super(textFile);
	}
	
	public void newGame() {
		generateWord();
		scan = new Scanner(System.in);
		lettersGuessed = new ArrayList<Character>();
		correctlyGuessed = new boolean[this.getGameWord().length()];

		System.out.println("Starting new game.\n");
		do {
			System.out.println(getProgressWord());
			
			System.out.println("You have " + (MAX_GUESSES - numIncorrectGuesses) 
					+ " guesses remaining.");
			if(!lettersGuessed.isEmpty()) {
				System.out.println("You have guessed " + lettersGuessed);
			}

			try {
				userInput = scan.next();
				if(userInput.length() == 1) {
					guessedLetter = userInput.charAt(0);
					if(Character.isLetter(guessedLetter)) {
						if(!checkGuess(guessedLetter)) {
							numIncorrectGuesses++;
						}
					} else {
						throw new InvalidCharacterException();
					}
				}else {
					throw new TooManyCharactersException();
				}
				
			} catch(InvalidCharacterException e) {
				System.out.println("Invalid character. Please try again.");
			} catch(TooManyCharactersException e) {
				System.out.println("Guesses must be one character only.");
			}
			
		} while(numIncorrectGuesses < MAX_GUESSES && numLettersGuessedCorrectly < this.getGameWord().length());
		
		if(gameResult()) {
			wins++;
			displayWin();
			System.out.println();
		}else {
			losses++;
			displayLoss();
			System.out.println();
		}
	}


	

	private String getProgressWord() {
		progressWord = "";
		for(int i = 0; i < this.getGameWord().length(); i++) {
			if(correctlyGuessed[i]) {
				progressWord += this.getGameWord().charAt(i) + " ";
			} else {
				progressWord += "_ ";
			}
		}
		return progressWord;
	}

	
	private boolean checkGuess(char guess) {
		if(isLetterGuessed(guess)) {
			System.out.println(guess + " has already been used.");
			return true;
		} else if(this.getGameWord().indexOf(guess) >= 0) {
			
			for(int i = 0; i < this.getGameWord().length(); i++) {		
				if(this.getGameWord().charAt(i) == guess) {
					correctlyGuessed[i] = true;
					numLettersGuessedCorrectly++;
				}
			}
			return true;
		}
		return false;
	}
	
	
	private boolean isLetterGuessed(char guess) {
		for(char c : lettersGuessed) {
			if(guess == c) {
				return true;
			}
		}
		lettersGuessed.add(guess);
		return false;
	}
	
	
	private boolean gameResult() {
		for(boolean b : correctlyGuessed) {
			if(b == false) {
				return false;
			}
		}
		return true;
	}

	public void displayWin() {
		System.out.println(getProgressWord());
		System.out.println("Congratulations! You guessed it!");
	}

	public void displayLoss() {
		System.out.println("Sorry, you did not guess it. The word was \"" + this.getGameWord() + "\"");
	}
	

	

}
