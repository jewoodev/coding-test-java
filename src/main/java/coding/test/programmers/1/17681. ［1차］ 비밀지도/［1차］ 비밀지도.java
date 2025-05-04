class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
       
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
           
            StringBuilder str = new StringBuilder();
            for (int idx = 0; idx < n - s.length(); idx++) {
                str.append(" ");
            }
           
            for (int idx = 0; idx < s.length(); idx++) {
                str.append((s.charAt(idx) == '1') ? "#" : " ");
            }
                       
            answer[i] = str.toString();
        }
       
        return answer;
    }
}
