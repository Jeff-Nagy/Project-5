/*
Hangman
Written by Robert Amero, Bat-Erdene Battur, and Jeff Nagy
 */

import java.io.*;
import java.util.*;

public class HangmanDriver {

	public static void main(String[] args) {
		
		final String FILE_NAME = "words.txt";

		try {
			play(FILE_NAME);
			
		} catch(FileNotFoundException e) {
			System.out.println("Invalid or missing input file.");
		} 
	}
	
	
	public static void play(String FILE_NAME) throws FileNotFoundException {
		boolean playing = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Hangman!");
		do {
			System.out.println("Start a new game? (y/n)");
			String input = scan.next().toLowerCase();
			char c = input.charAt(0);
			if(c == 'y') {
				Hangman theWord = new Hangman(FILE_NAME);
				theWord.newGame();
				printResults();
			} else {
				playing = false;
			}
		}while(playing == true);
		scan.close();
	}
		

	public static void printResults() {
		int totalGames = Hangman.wins + Hangman.losses;
		Double winRate = (100 * (((double) Hangman.wins) / totalGames));
		Integer winPercentage = winRate.intValue();
		
		System.out.println("Total games: " + totalGames);
		System.out.println("Wins: " + Hangman.wins);
		System.out.println("Losses: " + Hangman.losses);
		System.out.println("Win rate: " + winPercentage + "%");
	}

		
}
