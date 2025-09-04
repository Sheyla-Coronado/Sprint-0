package com.rockpaperscissors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RockPaperScissorsTest {

	@Test
	void testValidChoices() {
		assertTrue(RockPaperScissors.isValidChoice("rock"));
		assertTrue(RockPaperScissors.isValidChoice("paper"));
		assertTrue(RockPaperScissors.isValidChoice("scissors"));
		
		assertFalse(RockPaperScissors.isValidChoice(""));
		
		
	}
	
	@Test
    void testWinnerDetermination() {
        assertEquals("User, you won!", RockPaperScissors.determineWinner("rock", "scissors"));
        assertEquals("User, you lost!", RockPaperScissors.determineWinner("rock", "paper"));
        assertEquals("It's a draw!", RockPaperScissors.determineWinner("rock", "rock"));
        
        assertEquals("User, you won!", RockPaperScissors.determineWinner("paper", "rock"));
        assertEquals("User, you lost!", RockPaperScissors.determineWinner("paper", "scissors"));
        assertEquals("It's a draw!", RockPaperScissors.determineWinner("paper", "paper"));
        
        assertEquals("User, you won!", RockPaperScissors.determineWinner("scissors", "paper"));
        assertEquals("User, you lost!", RockPaperScissors.determineWinner("scissors", "rock"));
        assertEquals("It's a draw!", RockPaperScissors.determineWinner("scissors", "scissors"));
    }
}
