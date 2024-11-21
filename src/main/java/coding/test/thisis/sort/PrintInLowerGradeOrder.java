package coding.test.thisis.sort;

import java.io.*;
import java.util.*;

public class PrintInLowerGradeOrder { //p180
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.getName()).append(" ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static class Student implements Comparable<Student>{
        String name;
        int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        private String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            return this.grade - o.grade;
        }
    }
}
