package spring.service.dice.play;

import spring.service.dice.Dice;

public class Player02 {

	private Dice dice;
	
	private int totalValue;
	
	public Player02() {
		// TODO Auto-generated constructor stub
	}
	
	public Player02(Dice dice) {
		this.dice = dice;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}	
	
	public void playDice(int count) {
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}
}
