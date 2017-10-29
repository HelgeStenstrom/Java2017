/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3B;

import java.util.ArrayList;

class IssueTracker {

    ArrayList<Issue> getIssues() {
        return issues;
    }

    private ArrayList<Issue> issues = new ArrayList<>();


    void add(Issue issue) {
        issues.add(issue);
    }

    void resolveByindes(int index) {
        issues.get(index).resolve();
    }

    ArrayList<Issue> getUnresolved() {
        ArrayList<Issue> unresolved = new ArrayList<>();
        for (Issue issue: issues) {
            if (! issue.isResolved())
                unresolved.add(issue);
        }
        return unresolved;
    }

    ArrayList<Issue> getResolved() {
        ArrayList<Issue> resolved = new ArrayList<>();
        for (Issue issue: issues) {
            if (issue.isResolved())
                resolved.add(issue);
        }
        return resolved;
    }
}
