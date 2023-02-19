package hello.proxy.purepoxy.decorator.code.myEx;

public class SmileDecorator extends Decorator{
	public SmileDecorator(Behave behave) {
		super(behave);
	}

	@Override
	public void execute() {
		System.out.println("^^");
		super.execute();
		System.out.println("^^");
	}
}
