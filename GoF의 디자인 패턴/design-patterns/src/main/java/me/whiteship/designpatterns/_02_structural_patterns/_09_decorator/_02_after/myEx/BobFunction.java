package me.whiteship.designpatterns._02_structural_patterns._09_decorator._02_after.myEx;

class BobFunction implements FunctionToCall {

	@Override
	public void call() {
		System.out.println("밥을 먹을까..");
	}

}