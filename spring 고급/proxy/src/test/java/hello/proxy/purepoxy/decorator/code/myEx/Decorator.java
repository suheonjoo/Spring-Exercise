package hello.proxy.purepoxy.decorator.code.myEx;

public abstract class Decorator implements Behave {

	private Behave behave;

	public Decorator(Behave behave) {
		this.behave = behave;
	}

	public void execute() {
		behave.execute();
	}
}
