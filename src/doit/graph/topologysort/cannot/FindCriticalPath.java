package doit.graph.topologysort.cannot;

//임계 경로 구하기 p309 backjoon 1948
//public class FindCriticalPath {
//    public static void Main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        List<ArrayList<Integer[]>> list = new ArrayList<>(); //도로 리스트
//        int[] inDegree = new int[N + 1];
//        int[] result = new int[N + 1];
//        for (int i = 0; i < M + 3; i++) { //1번부터 M + 2 줄까지
//            list.add(new ArrayList<>());
//        }
//        StringTokenizer st;
//        for (int i = 1; i < M + 2; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int dst = Integer.parseInt(st.nextToken());
//            int timeTaken = Integer.parseInt(st.nextToken());
//            list.get(start).set(new int[]{dst, timeTaken}));
//            inDegree[dst]++;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 1; i < N + 1; i++) {
//            if (inDegree[i] == 0) queue.offer(i);
//        }
//        while (!queue.isEmpty()) {
//            int now = queue.poll();
//            int dst = list.get(now).i
//        }
//        st = new StringTokenizer(br.readLine());
//        int SDC = Integer.parseInt(st.nextToken()); //그리는 사람들이 출발하는 도시
//        int DDC = Integer.parseInt(st.nextToken()); //그리는 사람들이 도착하는 도시
//    }
//}
