package helgestenstrom.D1P3B;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;

public class IssueTracker {

    public ArrayList<Issue> getIssues() {
        return issues;
    }

    ArrayList<Issue> issues = new ArrayList<Issue>();

    void printMenu() {
        System.out.println("1. Create a new issue");
        System.out.println("2. Mark issue as solved");
        System.out.println("3. View unsolved issues");
        System.out.println("4. View solved issues");
        System.out.println("5. Exit");
    }

    public void add(Issue issue) {
        issues.add(issue);
    }

    public void resolve(Issue issue) {
        throw new NotImplementedException();
    }

    public void getUnsolved() {
        throw new NotImplementedException();
    }

    public void getSolved() {
        throw new NotImplementedException();
    }

    public void exit() {
        throw new NotImplementedException();
    }

}
