package spring.service.dice.test;

import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceCImpl;
import spring.service.dice.play.Player02;

public class DiceTestApp02 {

	public static void main(String[] args) {
		Player02 player01 = new Player02();
		player01.setDice(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player02 = new Player02();
		player02.setDice(new DiceCImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player02.getTotalValue());
		System.out.println("=======================");
	}

}
