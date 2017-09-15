package helloworld;

public class StringBuilderExample {
    public static void main(String [] args) {
        // Reverse a string
        String forward = "A man a plan a canal Panama";
        StringBuilder sb = new StringBuilder();
        sb.append(forward);
        String rev = sb.reverse().toString();

        System.out.println(rev);
    }
}
