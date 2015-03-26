package com.renho.structural.decorator;

import com.renho.structural.decorator.impl.BigTrouser;
import com.renho.structural.decorator.impl.TShirts;

public class Client {

	public static void main(String[] args) {
		Person person = new Person("renho");
		
		IClothes tShirts = new TShirts();
		IClothes bigTrouser = new BigTrouser();
		
		tShirts.decorator(person);
		bigTrouser.decorator(tShirts);
		
		bigTrouser.show();
	}
}
