package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Cards.Card;
import Cards.Card.CardSuite;
import Cards.Card.CardType;
import Players.Player;
/**
 * @author Hamza Kaced
 * This tests Ace functionality in the hand
 * 
 */
class GameTest {
	Player player;

	@Test
	void AceTest1() {
		player = new Player();
		Card x = new Card(CardType.ACE,CardSuite.CLUB);
		Card z = new Card(CardType.QUEEN,CardSuite.CLUB);
		player.getHand().add(x);
		player.getHand().add(z);
		assertTrue(player.getHand().ace());		
	}
	
	@Test
	void AceTest2() {
		player = new Player();
		Card z = new Card(CardType.ACE,CardSuite.CLUB);
		player.getHand().add(z);
		assertTrue(player.getHand().ace());	
	}
	
	@Test
	void AceTest3() {
		player = new Player();
		Card z = new Card(CardType.QUEEN,CardSuite.CLUB);
		Card e = new Card(CardType.JACK,CardSuite.SPADE);
		player.getHand().add(z);
		player.getHand().add(e);
		assertFalse(player.getHand().ace());	
	}
	
	
	@Test
	void AceTest4() {
		Player player = new Player();
		Card z = new Card(CardType.ACE,CardSuite.CLUB);
		Card e = new Card(CardType.JACK,CardSuite.SPADE);
		player.getHand().add(z);
		player.getHand().add(e);
		
		assertEquals(player.getHand().cardValue(),21);
	}
	
	@Test
	void AceTest5() {
		Player player = new Player();
		Card z = new Card(CardType.ACE,CardSuite.CLUB);
		Card e = new Card(CardType.JACK,CardSuite.SPADE);
		Card b = new Card(CardType.NINE,CardSuite.DIAMOND);
		player.getHand().add(z);
		player.getHand().add(e);
		player.getHand().add(b);

		assertEquals(player.getHand().cardValue(),20);
	}
	

}
