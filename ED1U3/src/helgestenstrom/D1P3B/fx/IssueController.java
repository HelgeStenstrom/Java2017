package helgestenstrom.D1P3B.fx;

import helgestenstrom.D1P3B.Issue;
import helgestenstrom.D1P3B.IssueTracker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static helgestenstrom.D1P3B.fx.WhatToShow.*;

public class IssueController {
    public TextField txtIssue;
    public ListView<String> lstvIssues;
    private IssueTracker issueTracker = new IssueTracker();
    private WhatToShow whatToShow = all;




    public void createIssue() {
        String desc = txtIssue.getText();
        Issue issue = new Issue(desc);
        issueTracker.add(issue);
        txtIssue.clear();
        updateGui();
    }

    public void enterInIssue() {
        createIssue();
    }

    private void updateGui() {
        lstvIssues.refresh();
        ArrayList<Issue> issues;
        switch (whatToShow) {
            case all:
                issues = issueTracker.getIssues();
                break;
            case resolved:
                issues = issueTracker.getResolved();
                break;
            case unresolved:
                issues = issueTracker.getUnresolved();
                break;
            default:
                issues = issueTracker.getIssues();
                break;
        }
        ArrayList<String> issueTxts = new ArrayList<>();
        for (Issue iss : issues) {
            issueTxts.add(iss.toString());
        }
        ObservableList<String> items = FXCollections.observableArrayList(issueTxts);
        lstvIssues.setItems(items);

    }

    public void markResolved() {
        int marked;
        marked = lstvIssues.getSelectionModel().getSelectedIndex();
        Issue toChange;
        ArrayList<Issue> issueList;
        switch (whatToShow) {
            case all:
                issueList = issueTracker.getIssues();
                break;
            case unresolved:
                issueList = issueTracker.getUnresolved();
                break;
            default:
                issueList = issueTracker.getResolved();
                break;
        }

        try {
            toChange = issueList.get(marked);
            toChange.resolve();
            // System.out.printf("Du klickade %d. \n", marked);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // Nothing to do, but ignore the unresolve attempt.
        }
        updateGui();
    }

    public void viewResolved() {
        whatToShow = resolved;
        updateGui();
    }

    public void viewUnresolved() {
        whatToShow = unresolved;
        updateGui();
    }

    public void viewAll() {
        whatToShow = all;
        updateGui();
    }


}
