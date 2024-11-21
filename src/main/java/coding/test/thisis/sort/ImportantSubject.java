package coding.test.thisis.sort;

import java.io.*;
import java.util.*;

public class ImportantSubject { //p359
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int lang = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, lang, eng, math));
        }

        Collections.sort(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.getName()).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static class Student implements Comparable<Student>{
        String name;
        int lang, math, eng;

        public Student(String name, int lang, int eng, int math) { //여기서 과목 순서를 잘못 넣어서 답이 안나왔다;;
            this.name = name;
            this.lang = lang;
            this.math = math;
            this.eng = eng;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.lang == o.lang) {
                if (this.eng == o.eng) {
                    if (this.math == o.math) {
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.eng - o.eng;
            }
            return o.lang - this.lang;
        }
    }
}
