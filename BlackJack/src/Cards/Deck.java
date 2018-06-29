package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import Players.Player;
/**Deck that provides the cards dealt to the players
 * @author Hamza Kaced
 */
public class Deck extends Stack <Card> {
	private static final long serialVersionUID = -8651974295381033925L;
    ArrayList < Card.CardType > type = new ArrayList < Card.CardType > (13); //contains the enum names
    ArrayList < Card.CardSuite > suite = new ArrayList < Card.CardSuite > (4);
    /** Constructor for deck
     * adds Cardtypes and suites to their respective arraylists, 
     * then adds each of cardtype with each cardsuite to the deck
     */
    public Deck() {
        type.add(Card.CardType.ACE);
        type.add(Card.CardType.TWO);
        type.add(Card.CardType.THREE);
        type.add(Card.CardType.FOUR);
        type.add(Card.CardType.FIVE);
        type.add(Card.CardType.SIX);
        type.add(Card.CardType.SEVEN);
        type.add(Card.CardType.EIGHT);
        type.add(Card.CardType.NINE);
        type.add(Card.CardType.TEN);
        type.add(Card.CardType.QUEEN);
        type.add(Card.CardType.KING);
        type.add(Card.CardType.JACK);
        suite.add(Card.CardSuite.CLUB);
        suite.add(Card.CardSuite.SPADE);
        suite.add(Card.CardSuite.HEART);
        suite.add(Card.CardSuite.DIAMOND);

        for (int i = 0; i < 13; i++) {

            for (int x = 0; x < 4; x++) {
                //adds the cards to the deck, each number with its own suite for a total of 52 cards
                push(new Card(type.get(i), suite.get(x)));

            }
        }
    }
    /**
     * Shuffles deck, to not get repetitive patterns in the cards
     */
    public void shuffle() {
        Collections.shuffle(this);
    }
    /**
     * pulls out a card from the deck and deals it to player x
     * @param x Player recieveing the card from deck
     */
    public void deal(Player x) {
        x.getHand().add(pop());
    }
}