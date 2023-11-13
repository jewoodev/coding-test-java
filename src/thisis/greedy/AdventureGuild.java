package thisis.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class AdventureGuild { //p311
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int adventurerNum = Integer.parseInt(br.readLine()); //모험가 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>(); //주어지는 모험가 무리

        for (int i = 0; i < adventurerNum; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList); //공포도 오름차순 정렬을 해서

        int answer = 0; //그룹 수
        int cnt = 0; //모험가 수

        for (int i = 0; i < adventurerNum; i++) { //순서대로 공포도를 체크하는데
            cnt += 1; //모험가를 그룹에 추가하다가
            if (cnt >= arrayList.get(i)) { //그룹의 모험가 수가 새로운 모험가의 공포도보다 크면
                answer += 1; //그룹 완성
                cnt = 0; //초기화
            }
        }
        System.out.println(answer);
    }
}
