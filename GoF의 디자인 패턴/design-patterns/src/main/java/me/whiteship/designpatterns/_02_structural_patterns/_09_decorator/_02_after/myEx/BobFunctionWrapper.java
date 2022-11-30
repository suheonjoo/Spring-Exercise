package me.whiteship.designpatterns._02_structural_patterns._09_decorator._02_after.myEx;

public class BobFunctionWrapper implements FunctionToCall {

	/**
	 * 여기서 자기상 상속한 것을 필드로 놓야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 이거 BobFunction 와 다른 부분임!
	 */
	private final FunctionToCall function;

	BobFunctionWrapper(FunctionToCall function) {
		this.function = function;
	}

	@Override
	public void call() {
		System.out.println("커피도 마실까...");
		function.call();
	}
}