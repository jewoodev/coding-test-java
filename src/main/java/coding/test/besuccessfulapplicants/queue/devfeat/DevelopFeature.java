package coding.test.besuccessfulapplicants.queue.devfeat;

import java.util.*;

class DevelopFeature {
    private static int order = 0;

    public int[] solution(int[] progresses, int[] speeds) {
        var answer = new ArrayList<Integer>();
        var q = new ArrayDeque<Feature>();
        for (int i = 0; i < speeds.length; i++) {
            q.offerLast(new Feature(progresses[i], i));
        }

        while (!q.isEmpty()) {
            var f = q.pollFirst();
            if (f.p > 99) {
                if (f.idx == order) {
                    q.offerLast(f);
                    distribute(f, q, answer);
                }
                else q.offerLast(f);
            }
            else q.offerLast(f.updateFeat(speeds[f.idx]));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void distribute(Feature f, Deque<Feature> q, List<Integer> answer) {
        int cnt = 1;
        while (!q.isEmpty()) {
            var now = q.pollFirst();
            order++;
            if (now == f) break;
            else if (now.p > 99 && now.idx == order) cnt++;
            else {
                order--;
                q.offerLast(now);
            }
        }
        answer.add(cnt);
    }

    static class Feature {
        int p, idx;

        private Feature updateFeat(int plus) {
            this.p += plus;
            return this;
        }

        private Feature(int p, int idx) {
            this.p = p;
            this.idx = idx;
        }
    }
}
