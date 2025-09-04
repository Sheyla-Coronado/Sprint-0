package com.rockpaperscissors;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	
    public static void main(String[] args) {
        String humanChoice = getUserInput();
        String result = play(humanChoice);
        System.out.println(result);
    }
    
    public static String play(String humanChoice) {
        String computerChoice = generateComputerChoice();
        
     // AI was used here since i had issues getting the computer randomized choice from the main code to the GUI
        String result = determineWinner(humanChoice, computerChoice);
        return result + "|" + computerChoice;
    }
    
    public static String generateComputerChoice() {
    	Random random = new Random();
    	int randomNumber = random.nextInt(3); // options are 0, 1, 2!
    	
    	if (randomNumber == 0) {
    		return "rock";
    	}
    	
    	else if (randomNumber == 1) {
    		return "paper";
    	}
    	
    	else  {
    		return "scissors";
    	}
    }
    
    public static String getUserInput() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("User, enter your choice (rock, paper, scissors): ");
    	String player_choice = scanner.nextLine().toLowerCase();
    	scanner.close();
    	return player_choice;
    }
    
    public static boolean isValidChoice(String choice) {
    	if (choice.equals("rock") || choice.equals("paper") || choice.equals("scissors")) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    public static String determineWinner(String human, String computer) {

    	if (human.equals("rock")) {
    		if (human.equals(computer)) {
                return "It's a draw!";
            }
    		else if (computer.equals("paper")) {
                return "User, you lost!";
            }
            else if (computer.equals("scissors"))  {
                return "User, you won!";
            }
        }
        else if (human.equals("scissors")) {
    		if (human.equals(computer)) {
                return "It's a draw!";
            }
    		else if (computer.equals("rock")) { 
                return "User, you lost!";
            }
            else if (computer.equals("paper"))  {
                return "User, you won!";
            }
        }
        else if (human.equals("paper")) {
    		if (human.equals(computer)) {
                return "It's a draw!";
            }
    		else if (computer.equals("scissors")) {
                return "User, you lost!";
            }
            else if (computer.equals("rock"))  {
                return "User, you won!";
            }
        }
        
        return "Invalid input"; 
    }
}