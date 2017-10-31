/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3B;

public class Issue {
    // Ett ärende i ärendehanteringssystemet.
    private boolean resolved;
    private String description;

    // Constructor med beskrivning som argument. Alla ärenden skapas "unresolved".
    Issue(String description) {
        this.description = description;
        resolved = false;
    }

    // Getter
    String getDescription() {
        return description;
    }

    // Getter
    boolean isResolved() {
        return resolved;
    }

    void resolve() {
        resolved = true;
    }

    void unresolve() {
        resolved = false;
    }

    // Sträng-represenation av ett ärdende.
    @Override
    public String toString() {
        String r;
        if (resolved)
            r = "Resolved";
        else
            r = "Unresolved";
        return String.format("%s: %s", r, description);
    }
}
