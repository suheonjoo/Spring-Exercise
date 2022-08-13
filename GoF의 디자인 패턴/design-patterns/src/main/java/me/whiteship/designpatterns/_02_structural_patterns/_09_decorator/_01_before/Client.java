package me.whiteship.designpatterns._02_structural_patterns._09_decorator._01_before;

public class Client {

    private CommentService commentService; //댓글을 남기는 서비스

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }


    //부가가능 2개 둘다 사용하고 싶은 경우 에 문제가 됨, 상속의 문제점
    public static void main(String[] args) {//App이라는 클래스 만들어서 밖으로 빼도 되 ㅋ
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }

}
