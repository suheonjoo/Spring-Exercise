package me.whiteship.designpatterns._02_structural_patterns._09_decorator._01_before;

public class SpamFilteringCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        boolean isSpam = isSpam(comment);
        if (!isSpam) {
            super.addComment(comment);
        }
    }
    //http가 있으면 출력을 하지 않음
    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
