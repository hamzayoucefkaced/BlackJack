package Players;

 import java.util.ArrayList;

 import Cards.Card;
 import Cards.Card.CardType;
 /**Hand of the player (set of cards player currently holds)
  * @author Hamza Kaced
  */
 public class Hand extends ArrayList < Card > {
     private static final long serialVersionUID = -6872329547542558019L;
     /**Checks if the hand contains an ace
      * @return true if the hand contains an ace
      * @return false if the hand does not contain an ace
      */
     public boolean ace() {
         for (Card i : this) {
             if (i.getCardType().equals(CardType.ACE)) {
                 return true;
             }
         }
         return false;

     }

     /**Returns the card at position of of the hand
      * @param x is the position of the card thats wanted
      * @return Card at position x
      */
     public Card returnCard(int x) {
         return get(x);
     }

     /**Adds a card to the hand, and adjusts ace value
      * @param x The card added
      * @return true
      */
     @Override
    public boolean add(Card x) {
        if (!ace()) {
            if (cardValue() < 11) {
                if (x.getCardType().equals(CardType.ACE) || (cardValue() == 10 && x.getCardType().equals(CardType.ACE))) {
                    x.setValue(11);
                }
            }
        }

        if (ace() && cardValue() + x.getValue() > 21) {
            for (Card b: this) {
                if (b.getCardType() == CardType.ACE) {
                    if (b.getValue() == 11) {
                        b.setValue(1);
                        break;
                    }
                }
            }
        }
        	 
        	 
         
         super.add(x);
         return true;
     }
     /** Returns the hand being used
      * @return The hand thats currently being used
      */
     public Hand getCards() {
         return this;
     }



     /**Counts the value of the cards being held in the hand
      * @return value of cards
      */
     public int cardValue() {
         int x = 0;
         for (Card i: this) {
             x += i.getValue();
         }
         return x;

     }


     /** Clears the hand of the cards
      */
     public void removeCards() {
         clear();
     }

 }
