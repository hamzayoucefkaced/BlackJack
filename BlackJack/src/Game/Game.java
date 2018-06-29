package Game;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Cards.Card;
import Cards.Deck;
import Players.Player;
import Players.Better;
/**Game class, driver class that runs blackjack
 * 
 * @author Hamza Kaced
 *
 */
public class Game extends JFrame implements ActionListener {

    //Variables neccesary for the GUI and game
    private static final long serialVersionUID = 2371806225000517974L;
    @SuppressWarnings("unused")
    private Image d1, d2, d3, d4, d5, d6;
    @SuppressWarnings("unused")
    private Image p1, p2, p3, p4, p5, p6;
    private static Deck deck = new Deck();
    private static Better player = new Better();
    private static Player dealer = new Player();
    private static JLabel PStatus = new JLabel(String.valueOf(player.getHand().cardValue()), SwingConstants.CENTER);
    private static JLabel bidlabel = new JLabel("", SwingConstants.CENTER);
    private static JLabel PMoney = new JLabel("", SwingConstants.CENTER);
    private static JLabel DStatus = new JLabel("", SwingConstants.CENTER);
    private static JLabel playerind = new JLabel("Player:", SwingConstants.CENTER);
    private static JLabel houseind = new JLabel("House:", SwingConstants.CENTER);
    private static JLabel bidind = new JLabel("Current bid:", SwingConstants.CENTER);
    private static JLabel moneyind = new JLabel("Money available:", SwingConstants.CENTER);
    private static boolean deal1 = true;
    private JButton increase = new JButton("Increase bid");
    private JButton decrease = new JButton("Decrease bid");
    private JButton deal = new JButton("Deal");
    private JButton hit = new JButton("Hit");
    private JButton stand = new JButton("Stand");
    private JButton surr = new JButton("Surrender");
    private JButton DD = new JButton("Double Down");
    private JPanel Game = new JPanel(new GridLayout(3, 1));
    private JPanel buttons = new JPanel(new GridLayout(1, 7));
    private JPanel pic = new JPanel(new GridLayout(2, 6));
    private JPanel gamescore = new JPanel(new GridLayout(1, 3));
    private JPanel score = new JPanel(new GridLayout(4, 1));
    private JPanel bids = new JPanel(new GridLayout(2, 1));
    private JPanel moneys = new JPanel(new GridLayout(2, 1));
    private static boolean finish = false;
    private static int bid = 4;
    private static int g = 0;
    private static ArrayList < JLabel > Plabels = new ArrayList < JLabel > (11);
    private static ArrayList < JLabel > Dlabels = new ArrayList < JLabel > (11);
    private static ArrayList < JLabel > labels = new ArrayList < JLabel > (6);

    /**
     * Constructor that puts all the gui componenets in places, and initializes the important variables
     * @throws InterruptedException
     */
    public Game() throws InterruptedException {
        labels.add(playerind);
        labels.add(houseind);
        labels.add(DStatus);
        labels.add(PStatus);
        labels.add(bidlabel);
        labels.add(PMoney);
        labels.add(moneyind);
        labels.add(bidind);

        increase.addActionListener(this);
        decrease.addActionListener(this);
        hit.addActionListener(this);
        stand.addActionListener(this);
        deal.addActionListener(this);
        surr.addActionListener(this);
        DD.addActionListener(this);
        pic.setVisible(true);
        moneys.setVisible(true);
        bids.setVisible(true);
        for (JLabel i: labels) {
            i.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        for (int i = 0; i <= 11; i++) {
            Plabels.add(new JLabel());
            Dlabels.add(new JLabel());
        }
        for (int i = 0; i <= 11; i++) {
            pic.add(Dlabels.get(i));
        }
        for (int i = 0; i <= 11; i++) {
            pic.add(Plabels.get(i));
        }
        bids.add(bidind);
        bids.add(bidlabel);
        moneys.add(moneyind);
        moneys.add(PMoney);
        buttons.add(increase);
        buttons.add(decrease);
        buttons.add(deal);
        buttons.add(hit);
        buttons.add(stand);
        buttons.add(surr);
        buttons.add(DD);
        buttons.setVisible(true);
        gamescore.add(bids);
        gamescore.add(score);
        score.add(houseind);
        score.add(DStatus);
        score.add(playerind);
        score.add(PStatus);
        gamescore.add(moneys);
        gamescore.setVisible(true);
        Game.add(pic);
        Game.add(buttons);
        Game.add(gamescore);
        Game.setVisible(true);
        add(Game);

    }

    /**
     * Replaces the blank image icons on the game window with the cards at the player's hands
     * @param x is the Better (Overloaded method)
     * @throws InterruptedException
     */

    public static void showCard(Better x) throws InterruptedException {
        int a = 0;
        for (Card i: x.getHand().getCards()) {
            Thread.sleep(200);
            Plabels.get(a).setIcon(new ImageIcon(i.getImage().getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
            a++;
        }
    }


    /**
     * Replaces the blank image icons on the game window with the cards at the player's hands
     * @param x is the Dealer
     * @throws InterruptedException
     */

    public static void showCard(Player x) throws InterruptedException {
        int a = 0;
        for (Card i: x.getHand().getCards()) {
            Thread.sleep(200);
            Dlabels.get(a).setIcon(new ImageIcon(i.getImage().getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
            a++;
        }
    }

    /**
     * Shows the first card of the dealer and hides the second one
     * @throws InterruptedException
     */
    public static void showFCard() throws InterruptedException {
        Thread.sleep(200);
        Image image = null;
        File frames = new File("Pictures/qm.png");
        try {
            image = ImageIO.read(frames);
        } catch (IOException e) {
            e.printStackTrace();
        };
        Dlabels.get(0).setIcon(new ImageIcon(
        		dealer.
        		getHand().
        		getCards().
        		get(0).
        		getImage().
        		getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
        Thread.sleep(200);
        Dlabels.get(1).setIcon(new ImageIcon(image.getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
    }


    /**
     * Replaces the card image icons on the game window with blank images
     * @param x is the Better (Overloaded method)
     * @throws InterruptedException
     */
    public static void removeCard(Better x) {
        Image image = null;
        File frames = new File("Pictures/b.png");
        try {
            image = ImageIO.read(frames);
        } catch (IOException e) {
            e.printStackTrace();
        };
        for (JLabel a: Plabels) {
            a.setIcon(new ImageIcon(image.getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
        }
    }

    /**
     * Replaces the card image icons on the game window with blank images
     * @param x is the Dealer (Overloaded method)
     * @throws InterruptedException
     */
    public static void removeCard(Player x) {
        Image image = null;
        File frames = new File("Pictures/b.png");
        try {
            image = ImageIO.read(frames);
        } catch (IOException e) {
            e.printStackTrace();
        };
        for (JLabel a: Dlabels) {
            a.setIcon(new ImageIcon(image.getScaledInstance(83, 127, Image.SCALE_DEFAULT)));
        }
    }


    /**
     * Compares the values of the player and the dealer, and make the decision accordingly
     * if the dealer's hand value is bigger than 21, the game adds money to the players hands and the next
     * round starts, if the values are equal, nothing happens and the next round starts, however if dealer's cards are more than the player's
     * cards by the time the next round starts and they are less than 21, the dealer wins and the same is true player
     * 
     *
     * @param x Dealer
     * @param z Player
     * @throws InterruptedException
     */
    public static void compare(Player x, Better z) throws InterruptedException {
        if (x.getHand().cardValue() > 21) {
            PStatus.setText("You won");
            DStatus.setText("Dealer lost");
            z.addMoney(bid);
            Thread.sleep(2000);
        } else if (x.getHand().cardValue() == z.getHand().cardValue()) {
            PStatus.setText("Draw");
            DStatus.setText("Draw");
            Thread.sleep(5000);
        } else if (x.getHand().cardValue() < z.getHand().cardValue()) {
            PStatus.setText("You won");
            DStatus.setText("Dealer lost");
            z.addMoney(bid);
            Thread.sleep(5000);
        } else if (x.getHand().cardValue() > z.getHand().cardValue()) {
            z.removeMoney(bid);
            DStatus.setText("Dealer won");
            if (x.getHand().cardValue() == 21) {
                DStatus.setText("BlackJack!");
            }
            PStatus.setText("You lost");
            Thread.sleep(5000);
        }
        player.getHand().removeCards();
        dealer.getHand().removeCards();
        removeCard(player);
        removeCard(dealer);
        PStatus.setText(String.valueOf(player.getHand().cardValue()));
        DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
        PMoney.setText(String.valueOf(player.getMoney()));
    }




    public static void main(String[] args) throws InterruptedException {
        Game playerPlayer = new Game();
        playerPlayer.setTitle("BlackJack");
        playerPlayer.setSize(2000, 1000);
        playerPlayer.setVisible(true);
        removeCard(player);
        removeCard(dealer);
        playerPlayer.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        bidlabel.setText(String.valueOf(bid));
        PMoney.setText(String.valueOf(player.getMoney()));
        PStatus.setText(String.valueOf(player.getHand().cardValue()));
        DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
        deck.shuffle();
        while (!finish) {
            //the heart of the game, the finish variable is not true unless the players money is less than or equal to zero
            //then the game sets the finish variable to true and stops the game
            if (player.getMoney() <= 0) {
                PStatus.setText("Game over!");
                DStatus.setText("Game over!");
                finish = true;
            }
            try {
                //the main mechanic for the game; g represents what decision the player has made in regard to his deck and allows the game to proceed based on it
                switch (g) {
                    //If the state variable is 1, that means the player has hit and hence the card is dealt and if
                    //the card leads the hand value to be greater than 21, the player loses the round, if it is 21
                    //the player wins
                
                    //hit
                    case 1:
                        {
                            deck.deal(player);
                            showCard(player);
                            PStatus.setText(String.valueOf(player.getHand().cardValue()));
                            if (player.getHand().cardValue() > 21) {
                                showCard(dealer);
                                player.removeMoney(bid);
                                DStatus.setText("Dealer won");
                                PStatus.setText("You lost");
                                Thread.sleep(5000);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                removeCard(player);
                                removeCard(dealer);
                                DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                bidlabel.setText(String.valueOf(bid));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                deal1 = true;
                            } else
                            if (player.getHand().cardValue() == 21) {
                                showCard(dealer);
                                player.addMoney(bid);
                                PStatus.setText("BlackJack!");
                                Thread.sleep(5000);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                removeCard(dealer);
                                removeCard(player);
                                bidlabel.setText(String.valueOf(bid));
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                DStatus.setText(String.valueOf(player.getHand().cardValue()));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                deal1 = true;
                                //deal1 is the boolean variable that decides wether 
                                //the deal button is being able to be pressed, only used at start of the round
                                //this being true basically disables all other functions until the cards are dealt
                                //and it being false means the card cannot be dealt until the next round

                            } else {
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                Thread.sleep(5000);
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                bidlabel.setText(String.valueOf(bid));
                            }
                        }
                        g = 0;
                        //g is the state variable, meaning it is the number that determines what game function is applied
                        //(hit, surrender, double down, etc.)
                        break;

                        //stand
                    case 2:
                        {
                            { //this code occurs when the player has decided he is satisfied with his hand and stands
                                //the dealer keeps getting dealing as long as the player has more cards than him,
                                //but if he reaches equal card values and is less than 3 points or equal shy from blackjack, he will deal one more card to risk
                                //the blackjack
                                while (dealer.getHand().cardValue() < player.getHand().cardValue()) {
                                    deck.deal(dealer);
                                }
                                if (dealer.getHand().cardValue() + 3 <= 21) {
                                    deck.deal(dealer);
                                }
                                showCard(dealer);
                                DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
                                compare(dealer, player);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                removeCard(player);
                                removeCard(dealer);
                                deal1 = true;
                            }
                            g = 0;
                            break;
                        }
                        //deal
                    case 3:
                        //here the players are dealt the cards at the start of the round, with both the player's cards shown
                        //and only one of the dealer's
                        {
                            deck.deal(dealer);
                            deck.deal(dealer);
                            deck.deal(player);
                            deck.deal(player);
                            showFCard();
                            showCard(player);
                            PStatus.setText(String.valueOf(player.getHand().cardValue()));
                            DStatus.setText(String.valueOf(dealer.getHand().getCards().get(0).getValue()));
                            if (player.getHand().cardValue() == 21) {
                                player.addMoney(bid);
                                PStatus.setText("BlackJack!");
                                Thread.sleep(5000);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                removeCard(player);
                                removeCard(dealer);
                                bidlabel.setText(String.valueOf(bid));
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                player.getHand().removeCards();
                                DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
                                deal1 = true;
                            } else {
                                deal1 = false;
                            }
                            g = 0;
                            break;
                        }
                        //surrender
                    case 4:
                        {
                            //player can surrender the round and lose only half the bid, but only if the dealer has an ace or card which contains a value of 10 as his shown card
                            if (dealer.getHand().getCards().get(0).getValue() == 10 || dealer.getHand().getCards().get(0).getCardType() == Card.CardType.ACE) {
                                player.removeMoney(bid / 2);
                                showCard(dealer);
                                DStatus.setText("Dealer won");
                                Thread.sleep(5000);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
                                removeCard(player);
                                removeCard(dealer);
                                removeCard(dealer);
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                bidlabel.setText(String.valueOf(bid));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                deal1 = true;
                                g = 0;
                            }
                            break;
                        }
                        //doubledown
                    case 5:
                        {
                            //the player gets dealt one extra card and doubles the bid then stands
                            deck.deal(player);
                            showCard(player);
                            if (player.getHand().cardValue() == 21) {
                                player.addMoney(bid * 2);
                                PStatus.setText("BlackJack!");
                                Thread.sleep(5000);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                removeCard(player);
                                removeCard(dealer);
                                bidlabel.setText(String.valueOf(bid));
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                player.getHand().removeCards();
                            }

                            if (player.getHand().cardValue() > 21) {
                                player.removeMoney(bid * 2);
                                DStatus.setText("Dealer won");
                                Thread.sleep(5000);
                                player.getHand().removeCards();
                                dealer.getHand().removeCards();
                                DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
                                removeCard(player);
                                removeCard(dealer);
                                removeCard(dealer);
                                PStatus.setText(String.valueOf(player.getHand().cardValue()));
                                bidlabel.setText(String.valueOf(bid));
                                PMoney.setText(String.valueOf(player.getMoney()));
                                deal1 = true;
                                g = 0;
                                break;
                            }

                            {
                                while ((dealer.getHand().cardValue() + 3) < 21) {
                                    deck.deal(dealer);
                                }
                                if (player.getHand().cardValue() > dealer.getHand().cardValue()) {
                                    deck.deal(dealer);
                                }
                                showCard(dealer);
                                DStatus.setText(String.valueOf(dealer.getHand().cardValue()));
                            }
                            compare(dealer, player);
                            showCard(dealer);
                            removeCard(player);
                            removeCard(dealer);
                            player.getHand().removeCards();
                            dealer.getHand().removeCards();
                            deal1 = true;
                            g = 0;
                            break;
                        }
                }
            } catch (EmptyStackException e) {
                //adds a new deck after the deck used becomes empty
                deck = new Deck();
                deck.shuffle();
            }
        }
    }




    @Override
    public void actionPerformed(ActionEvent arg0) {
        //this is the button listener, basically each button pressed sets the state variable (g) into a different value
        //thats handled by the switch case inside the main method
        if (!finish) {
            //those buttons increase and decrease the bid, but they only work if the game is stil on going
            //hence the boolean check at the start
            if (arg0.getSource() == increase) {
                if (bid < player.getMoney())
                    bid += 4;
                    bidlabel.setText(String.valueOf(bid));
            }
            if (arg0.getSource() == decrease) {
                if (bid > 4) {
                    bid -= 4;
                    bidlabel.setText(String.valueOf(bid));
                }

            }
            if (arg0.getSource() == hit) {
                if (!deal1) {
                    g = 1;
                }
            }

            if (arg0.getSource() == stand) {
                if (!deal1) {
                    g = 2;
                }
            }

            if (arg0.getSource() == deal) {
                if (deal1) {
                    g = 3;
                }
            }
            if (arg0.getSource() == surr) {
                if (!deal1) {
                    g = 4;
                }
            }
            if (arg0.getSource() == DD) {
                if (!deal1) {
                    g = 5;
                }
            }


        }
    }
}