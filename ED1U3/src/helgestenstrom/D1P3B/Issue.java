package helgestenstrom.D1P3B;

public class Issue {
    private boolean resolved;

    String getText() {
        return text;
    }

    private String text;

    Issue(String text) {
        this.text = text;
        resolved = false;
    }

    void resolve() {
        resolved = true;
    }

    void unresolve() {
        resolved = false;
    }

    boolean isResolved() {
        return resolved;
    }

    @Override
    public String toString() {
        String r;
        if (resolved)
            r = "Resolved";
        else
            r = "Unresolved";
        return String.format("%s: %s", r, text);
    }
}
