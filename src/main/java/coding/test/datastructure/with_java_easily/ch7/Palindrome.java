package coding.test.datastructure.with_java_easily.ch7;

import coding.test.datastructure.with_java_easily.ch6.LinkedStack;

public class Palindrome {
    public static boolean isPalindrome(String A) {
        LinkedStack s = new LinkedStack();
        LinkedQueue q = new LinkedQueue();
        for (int i = 0; i < A.length(); i++) {
            s.push(A.charAt(i));
            q.enqueue(A.charAt(i));
        }
        while (!s.isEmpty() && s.pop() == q.dequeue()) {
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }
}
