package spring.service.dice.play;

import spring.service.dice.impl.DiceAImpl;

public class Player01 {

	private DiceAImpl diceA = new DiceAImpl();
	
	private int totalValue;
	
	public Player01() {
		// TODO Auto-generated constructor stub
	}
	
	public DiceAImpl getDiceA() {
		return diceA;
	}

	public void setDiceA(DiceAImpl diceA) {
		this.diceA = diceA;
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
			diceA.selectedNumber();
			System.out.println("::[ "+diceA.getClass().getName()+" ] 의 선택된수 : "+diceA.getValue());
			totalValue += diceA.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}
}
