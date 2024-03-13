package hanghae.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//호텔 대실
public class BorrowHotelTemp {
    public static int solution(String[][] book_time) {
        int inputLen = book_time.length;
        Integer[][] BTArr = new Integer[inputLen][2]; //분 단위 시간으로 변환된 예약 시간 배열
        List<Integer[]> roomList = new ArrayList<>(); //방
        //분 단위 시간으로 변환하는 루프
        for (int i = 0; i < inputLen; i++) {
            String[] split1 = book_time[i][0].split(":");
            int entryTime = Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);
            BTArr[i][0] = entryTime; //입장 시간
            String[] split2 = book_time[i][1].split(":");
            int checkoutTime = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);
            BTArr[i][1] = checkoutTime; //퇴실 시간
        }
        Arrays.sort(BTArr, (s1, s2) -> s1[0] - s2[0]); //입장 시간을 기준으로 asc 정렬
        roomList.add(BTArr[0]); //첫 손님 입장
        for (int i = 0; i < inputLen - 1; i++) {
            //루프마다 사용된 방 중에 가장 빨리 체크아웃하는 방을 찾기 쉽도록 정렬
            Collections.sort(roomList, (t1, t2) -> t1[1] - t2[1]);
            //가장 빨리 퇴실하는 방의 퇴실 시간보다 다음 사람이 입장하는 입장시간이 이르면 방이 하나 더 필요함
            if (roomList.get(0)[1] > BTArr[i+1][0]) {
                roomList.add(BTArr[i+1]);
            }
            //가장 빨리 퇴실하는 방을 청소하는 시간 10분이 지나지 않은 시간에 다음 사람이 입장하면 방이 하나 더 필요함
            else if (BTArr[i+1][0] - roomList.get(0)[1] < 10) {
                roomList.add(BTArr[i+1]);
            }
            //그렇지 않으면 청소된 방을 사용함
            else {
                roomList.set(0, BTArr[i+1]);
            }
        }
        return roomList.size();
    }

    public static void main(String[] args) {
        System.out.println(
                solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
    }
}
