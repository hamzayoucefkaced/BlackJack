package Players;
/**Player class to represent the player
 * 
 * @author Hamza Kaced
 *
 */
public class Player {
    /**
     * Represents the hand of the player
     */
    private Hand hand;
    /**
     * Player calss constructor, initializes hand variable
     */
    public Player() {
        hand = new Hand();
    }
    /**
     * Hand getter
     * @return Hand held by player
     */
    public Hand getHand() {
        return hand;
    }
    /**
     * Hand setter
     * @param hand to replace current hand
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }
}