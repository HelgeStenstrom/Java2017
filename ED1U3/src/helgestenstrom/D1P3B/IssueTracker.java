/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3B;

import java.util.ArrayList;

// Klass för att hantera ärenden. Ingen interaktion med användaren här,
// det sköts av anropande klassen MainProblemB, som skapar objektet av denna klass.
class IssueTracker {

    // Trackern skapas med en tom lista.
    // Default constructor duger bra.
    private ArrayList<Issue> issues = new ArrayList<>();


    ArrayList<Issue> getIssues() {
        return issues;
    }


    // Lägg till ett ärdende. Det hamnar i slutet av listan.
    void add(Issue issue) {
        issues.add(issue);
    }

    // Lös ett ärende. Det finns kvar i listan, men markeras som löst.
    void resolveByindes(int index) {
        issues.get(index).resolve();
    }

    // Returnera en lista över olösta ärenden
    ArrayList<Issue> getUnresolved() {
        ArrayList<Issue> unresolved = new ArrayList<>();
        for (Issue issue: issues) {
            if (! issue.isResolved())
                unresolved.add(issue);
        }
        return unresolved;
    }

    // Returnera en lista över lösta ärenden
    // Här fins duplicerad kod relativt föregående funktion.
    // Jag hade kunnat göra en gemensam funktion.
    ArrayList<Issue> getResolved() {
        ArrayList<Issue> resolved = new ArrayList<>();
        for (Issue issue: issues) {
            if (issue.isResolved())
                resolved.add(issue);
        }
        return resolved;
    }
}
