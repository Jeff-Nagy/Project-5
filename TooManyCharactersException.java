/*
Hangman
Written by Robert Amero, Bat-Erdene Battur, and Jeff Nagy
 */

public class TooManyCharactersException extends Exception {

	public TooManyCharactersException() {
		super("Guesses must be one character only.");
	}
	
}
