package thisis.realization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RealignStr { //p322
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArrayList<Character> strVal = new ArrayList<>();
        int intVal = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) strVal.add(input.charAt(i));
            else intVal += input.charAt(i) - '0';
        }

        Collections.sort(strVal);
        for (char c : strVal) System.out.print(c);
        System.out.print(intVal);

    } //Main
}
