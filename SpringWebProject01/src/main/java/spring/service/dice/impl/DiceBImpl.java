package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceBImpl implements Dice {

	private int value;
	
	public DiceBImpl() {
		System.out.println("::" + getClass().getName() + " Constructor...");
	}
	
	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}

}
