package me.whiteship.refactoring._02_duplicated_code._06_pull_up_method.before;

import me.whiteship.refactoring._02_duplicated_code._06_pull_up_method.after.ParticipantDashboard;
import me.whiteship.refactoring._02_duplicated_code._06_pull_up_method.after.ReviewerDashboard;

import java.io.IOException;

public class Dashboard {

    public static void main(String[] args) throws IOException {
        ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
        reviewerDashboard.printReviewers();

        ParticipantDashboard participantDashboard = new ParticipantDashboard();
        participantDashboard.printUsernames(15);
    }
}
