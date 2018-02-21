package com.live;

public abstract class LivingThing {

	// common-state

	// common-behav
	public void eat() {
		System.out.println("LT eat");
	}

	public void sleep() {
		System.out.println("LT sleep");
	}

	// public void work() {
	// System.out.println("LT work");
	// }

	public abstract void work();

}
