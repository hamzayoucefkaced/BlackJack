package Players;
/**
 * Class that extends player, basically this is meant for the blackjack players who use money 
 * to play the game unlike the dealers
 * 
 * @author Hamza Kaced
 *
 */
public class Better extends Player{
	private int money;	
	/**
	 * Constructor that sets the money to 200
	 */
	public Better(){
	super();
	money = 200;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int mon) {
		money = mon;
	}

	public void addMoney(int newmoney){
		money += newmoney;
		
	}

	public void removeMoney(int newmoney){
		money -= newmoney;
		
	}

}
