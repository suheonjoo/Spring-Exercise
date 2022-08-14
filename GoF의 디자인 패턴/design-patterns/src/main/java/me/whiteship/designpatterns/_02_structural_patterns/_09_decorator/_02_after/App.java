package me.whiteship.designpatterns._02_structural_patterns._09_decorator._02_after;

public class App {

    private static boolean enabledSpamFilter = true;

    private static boolean enabledTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();// 이미 default 구현체로 시작함! ㅋ

        if (enabledSpamFilter) {
            //여기서 위에 있는 commentService 는 SpamFilteringCommentDecorator 인자로 주고, 기존의 commentService 를 덮어씌우는 것임
            commentService = new SpamFilteringCommentDecorator(commentService);
        }

        if (enabledTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        //지금 보면 조건을 if 문 조건을 만족하게 되면 commentService 에 계속 덮어 씌우는 것임

        Client client = new Client(commentService);
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }
}
