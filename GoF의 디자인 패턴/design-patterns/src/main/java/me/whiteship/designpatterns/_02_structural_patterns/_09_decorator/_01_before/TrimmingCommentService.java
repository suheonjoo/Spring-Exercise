package me.whiteship.designpatterns._02_structural_patterns._09_decorator._01_before;

public class TrimmingCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    //...이 출력안되게 하는 trim임
    private String trim(String comment) {
        return comment.replace("...", "");
    }

}
