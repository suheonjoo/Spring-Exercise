package hello.proxy.purepoxy.decorator.code.myEx;

public class StarDecorator extends Decorator {

	public StarDecorator(Behave behave) {
		super(behave);
	}

	@Override
	public void execute() {
		System.out.println("***");
		super.execute();
		System.out.println("***");
	}
}
