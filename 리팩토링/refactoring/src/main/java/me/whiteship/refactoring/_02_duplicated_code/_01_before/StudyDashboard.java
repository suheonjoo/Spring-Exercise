package me.whiteship.refactoring._02_duplicated_code._01_before;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudyDashboard {

    /**
     * 전에 말했듣이 주석이 좋은 메서드 이름을 추출하는 단서가 된다고 했던거 기억하면서 주석 보기! -> 리팩토링 이후 주석 없애도 됨ㅎ ㅎㅎㅎㅎㅎ
     * @param eventId
     * @throws IOException
     */
    private void printParticipants(int eventId) throws IOException {
        // Get github issue to check homework
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);

        // Get participants
        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));

        // Print participants
        participants.forEach(System.out::println);

        //-->여기까지가 구현이라고 볼수 있음 무슨일하는지 우리가 코드를 읽어야 하지 않냐? ㅎ
    }

    private void printReviewers() throws IOException {
        // Get github issue to check reviews
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        // Get reviewers
        Set<String> reviewers = new HashSet<>();
        issue.getComments().forEach(c -> reviewers.add(c.getUserName()));

        // Print reviewers
        reviewers.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
