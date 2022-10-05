package me.whiteship.designpatterns._03_behavioral_patterns._13_chain_of_responsibilities._02_after;

public class App {
    public static void main(String[] args) {
        RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));
        Client client = new Client(chain);
        client.doWork();
    }


}
