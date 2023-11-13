package thisis.realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ViewPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int hour = 0; hour < n + 1; hour++) {
            for (int min = 0; min < 60; min++) {
                for (int sec = 0; sec < 60; sec++) {
                    String temp = "";
                    temp += "" + hour + min + sec;
                    if (temp.contains("3")) cnt++;
                }
            }
        }

        System.out.println("cnt = " + cnt);
    }
}
