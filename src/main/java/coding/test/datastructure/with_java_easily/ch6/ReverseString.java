package coding.test.datastructure.with_java_easily.ch6;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Test Seq 12345";
        String t = reverse(input);
        System.out.println("Input string: " + input);
        System.out.println("Reversed string: " + t);
    }

    private static String reverse(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        String output = "";
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
        return output;
    }
}
