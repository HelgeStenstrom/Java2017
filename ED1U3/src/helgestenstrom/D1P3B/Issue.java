package helgestenstrom.D1P3B;

public class Issue {
    boolean resolved;

    public String getText() {
        return text;
    }

    String text;

    public Issue(String text) {
        this.text = text;
        resolved = false;
    }

    public void resolve() {
        resolved = true;
    }

    public void unresolve() {
        resolved = false;
    }

    public boolean isResolved() {
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
