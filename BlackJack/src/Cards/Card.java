package Cards;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**Card class to use in the game
 * 
 * @author Hamza Kaced
 *
 */
public class Card {
/**
 * value of card
 */
private int value;
/**
 * how card looks like
 */
private Image image; 
/**
 * type of card, this determines the value
 */
private CardType type;
/**
 * suite of card, doesnt matter much, more of a visual addition to the gui
 */
private CardSuite suite;

/**Enum class for the constants
 * 
 * @author Hamza Kaced
 *
 */
public static enum CardSuite {
SPADE,HEART,DIAMOND,CLUB;
}

/**Enum class for the constants
 * 
 * @author Hamza Kaced
 *
 */
public static enum CardType { 
	ACE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	QUEEN,
	KING,
	JACK
	
}
public Card() {
	value = 0;
	image = null;
	
}

public Card(int v, Image i) {
	value = v;
	image = i;
}

/**Main constructor for the card, takes in the enum type and suite to determine the value of the card
 * 
 * @param b the cardtype of the card
 * @param c the suite of the card
 */

public Card(CardType b,CardSuite c) {
	//Switch Statements to determine card type and suite using enums, it first determines the value through its type,
	//then the image through the suite
	type = b;
	suite = c;
	File img;
	switch(b) {
	case ACE:
		
		value = 1;
		switch(c) {
		case SPADE:
			img = new File("Pictures/AS.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/AD.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/AH.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/AC.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case TWO: 
		value = 2;
		switch(c) {
		case SPADE:
			img = new File("Pictures/2S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/2D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/2H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/2C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case THREE: 
		value = 3;
		switch(c) {
		case SPADE:
			img = new File("Pictures/3S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/3D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/3H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/3C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case FOUR: 
		value = 4;
		switch(c) {
		case SPADE:
			img = new File("Pictures/4S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/4D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/4H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/4C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case FIVE: 
		value = 5;
		switch(c) {
		case SPADE:
			img = new File("Pictures/5S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/5D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/5H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/5C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case SIX: 
		value = 6;
		switch(c) {
		case SPADE:
			img = new File("Pictures/6S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/6D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/6H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/6C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case SEVEN: 
		value = 7;
		switch(c) {
		case SPADE:
			img = new File("Pictures/7S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/7D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/7H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/7C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case EIGHT: 
		value = 8;
		switch(c) {
		case SPADE:
			img = new File("Pictures/8S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/8D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/8H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/8C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case NINE: 
		value = 9;
		switch(c) {
		case SPADE:
			img = new File("Pictures/9S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/9D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/9H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/9C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case TEN: 
		value = 10;
		switch(c) {
		case SPADE:
			img = new File("Pictures/10S.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/10D.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/10H.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/10C.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case QUEEN: 
		value = 10;
		switch(c) {
		case SPADE:
			img = new File("Pictures/QS.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/QD.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/QH.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/QC.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case KING: 
		value = 10;
		switch(c) {
		case SPADE:
			img = new File("Pictures/KS.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/KD.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/KH.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/KC.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	case JACK: 
		value = 10;
		switch(c) {
		case SPADE:
			img = new File("Pictures/JS.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case DIAMOND:
			img = new File("Pictures/JD.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case HEART:
			img = new File("Pictures/JH.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		case CLUB:
			img = new File("Pictures/JC.png");
			  try {
				   image = ImageIO.read(img);
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			break;
		}
		break;
	}
}

public Card(Card c) {
	value = c.getValue();
	image = c.getImage();
}

public void setValue(int v) {
	value = v;
}

public int getValue(){
	return value;
}


public void setImage(Image i) 
{image = i;}


public Image getImage(){
	return image;
}

public CardType getCardType() {
	return type;
}

public void setCardType(CardType c) {
	type = c;
}

public CardSuite getCardSuite() {
	return suite;
}

public void setCardSuite(CardSuite c) {
	suite = c;
}




}