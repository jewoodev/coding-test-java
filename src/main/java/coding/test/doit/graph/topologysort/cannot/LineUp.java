package coding.test.doit.graph.topologysort.cannot;

//줄 세우기 p 300 백준 2252
//public class LineUp {
//    public static void Main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); //학생 번호의 최대값
//        int m = Integer.parseInt(st.nextToken()); //키를 비교한 횟수
//        List<Integer>[] list = new ArrayList[n + 1]; //학생 리스트
//        for (int i = 1; i < n + 1; i++) {
//            list[i].add(0);
//        }
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int prev = Integer.parseInt(st.nextToken());
//            int next = Integer.parseInt(st.nextToken());
//            int prevCnt = list.get(next);
//            list.set(next - 1, prevCnt + 1);
//        }
//        Collections.sort(list);
//        StringBuilder sb = new StringBuilder();
//        for (Integer i : list) {
//            sb.append(i);
//        }
//        System.out.println(sb);
//    }
//}
