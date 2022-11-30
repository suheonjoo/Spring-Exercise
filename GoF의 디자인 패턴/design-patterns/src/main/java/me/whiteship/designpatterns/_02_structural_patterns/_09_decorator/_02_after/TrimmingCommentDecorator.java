package me.whiteship.designpatterns._02_structural_patterns._09_decorator._02_after;

public class TrimmingCommentDecorator extends CommentDecorator {

    public TrimmingCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        /**
         * 여기서 super 은 App 에서 자기를 감자주는 CommentDecorator 임
         */
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }
}
