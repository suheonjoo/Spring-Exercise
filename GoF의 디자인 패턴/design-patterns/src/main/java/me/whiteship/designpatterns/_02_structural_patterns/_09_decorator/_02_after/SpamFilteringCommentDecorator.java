package me.whiteship.designpatterns._02_structural_patterns._09_decorator._02_after;

public class SpamFilteringCommentDecorator extends CommentDecorator {

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        if (isNotSpam(comment)) {
            /**
             * 여기서 super 은 App 에서 자기를 감자주는 CommentDecorator 임
             */
            super.addComment(comment);
        }
    }

    private boolean isNotSpam(String comment) {
        return !comment.contains("http");
    }
}
