package me.whiteship.designpatterns._02_structural_patterns._09_decorator._02_after.myEx;

public class Service {

	private final FunctionToCall function;

	public Service(FunctionToCall function) {
		this.function = function;
	}

	public void run() {
		System.out.println("뭐 좀 하다가...");
		function.call();
	}

	public static void main(String[] args) {
		FunctionToCall bobFunction = new BobFunction();
		FunctionToCall bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
		Service service = new Service(bobFunctionWrapper);
		service.run();

	}
}