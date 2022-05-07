package hello.jdbc.connection;

public abstract class ConnectionConst {//상수로 쓸꺼라 추상클래스로 객체 생성을 막아놓음

    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
}