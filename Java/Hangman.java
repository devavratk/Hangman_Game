/**
  file name: Hangman.java
*/

import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 * class name: Hangman
 * description: The holds the logic for game Hangman and takes file as an argument
 * @author      Devavrat Kalam
 */
public class Hangman
{
		static int numberOfLines=0;
		public static Scanner in=new Scanner(System.in);


	/**
	 * method name: main
	*/
	public static void main(String[] args)
	{
		if(args.length>0)
		{
			try
			{
				//Loading the words from the file to String list
				Scanner word_file = new Scanner( new File ( args[0] ) );
				List<String> fileArray = new ArrayList<String>();

				while ( word_file.hasNextLine() )
				{
					String line = word_file.nextLine();
					fileArray.add(line);
					numberOfLines++;
				}

				int arrPosition= 0;
				word_file.close();

				//Main loop to begin or end a game
				for(int numberOfGames=1; numberOfGames<200 ; numberOfGames++)
				{

					System.out.println("Do you wish to play Hangman? yes/no");
					String question= in.next();

					if(question.equals("yes") || question.equals("Yes") || question.equals("Y") || question.equals("y")
						|| question.equals("YES"))
					{
						System.out.println("Lets Play!!");
						//generates a random number to refer to a random word from the list @fileArray
						int randomPosition= (int)(Math.random()*numberOfLines);
						game(fileArray.get(randomPosition)); // call the game function

					}
					else if(question.equals("no") || question.equals("No") || question.equals("N") || question.equals("n")
						|| question.equals("NO"))
					{
						System.out.println("OK. Bye!");
						break;
					}
					else
					{
						System.out.println("Not a valid Input. Try again!");
					}
				}
			}
			catch ( Exception e )
			{
				System.out.println("FileNotFoundException");
			}
		}
  }


  /**
   * method name: game
   * description: This method holds the flow of the game
   * @param word Current word for the user to be guessed
   * @return    None
  */
	public static void game(String word)
	{
		int wordLength= word.length();
		StringBuilder strGame=new StringBuilder("");

	  //initialising the main string
		for(int strlength= wordLength; strlength>0; strlength--)
			strGame.append('_');

		System.out.println(strGame);
		char guessInput;
		int numOfGuesses=0;

		//while ends when 9 incorrect guesses have been made
		while(numOfGuesses < 9 )
		{

			System.out.print("Guess " +(numOfGuesses+1)+": ");
			guessInput=in.next().charAt(0);

			//if user guessed a correct character then statements in if are executed
			if(word.indexOf(Character.toString(guessInput))>=0)
			{
				for(int strindex=0; strindex<wordLength; strindex++)
				{
					if(word.charAt(strindex)==guessInput)
					strGame.setCharAt(strindex, guessInput);
				}
				if(strGame.indexOf("_")<0)
				{
					System.out.println("word was = " + word);
					System.out.println("You Win!!");
					break;
				}
				System.out.println(strGame);
			}
			//with each incorrect guess a hangman drawing progresses
			else
			{
				System.out.println("Not found! Try again!!");
				switch(numOfGuesses)
				{
					case 0:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|       |  |"
						+"\n|       |  |\n|       |  |\n|       |  |\n|__________|\n");
						break;
					case 1:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|       |  |\n|       |  |\n|       |  |\n|__________|\n");
						break;
					case 2:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   /   |  |\n|       |  |\n|       |  |\n|__________|\n");
						break;
					case 3:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   / \\ |  |\n|       |  |\n|       |  |\n|__________|\n");
						break;
					case 4:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   /|\\ |  |\n|       |  |\n|       |  |\n|__________|\n");
						break;
					case 5:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   /|\\ |  |\n|    |  |  |\n|       |  |\n|__________|\n");
						break;
					case 6:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   /|\\ |  |\n|    |  |  |\n|     \\ |  |\n|__________|\n");
						break;
					case 7:System.out.print(" __________ \n|    ----  |\n|       |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   /|\\ |  |\n|    |  |  |\n|   / \\ |  |\n|__________|\n");
						break;
					case 8:System.out.print(" __________ \n|    ----  |\n|    |  |  |\n|    O  |  |\n|    |  |  |"
						+"\n|   /|\\ |  |\n|    |  |  |\n|   / \\ |  |\n|__________|\n");
						System.out.println("You lose!! \n The word is "+ word+".");
						break;
				}
			  numOfGuesses++;
			}
		}
	}
}
