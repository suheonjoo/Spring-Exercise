package me.whiteship.refactoring._02_duplicated_code._06_pull_up_method.before;

import me.whiteship.refactoring._02_duplicated_code._06_pull_up_method.after.Dashboard;

import java.io.IOException;

public class ParticipantDashboard extends Dashboard {

    public void printUsernames(int eventId) throws IOException {
        // Get github issue to check homework
        super.printUsernames(eventId);
    }

}
