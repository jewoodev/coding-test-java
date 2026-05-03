package coding.test.besuccessfulapplicants.hash.bestalbum;

import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        var genreMap = new HashMap<String, Integer>();
        var songMap = new HashMap<String, List<Song>>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        var genreRank = genreMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        var answer = new ArrayList<Integer>();
        for (String s : genreRank) {
            var songList = songMap.get(s);
            songList.sort(Comparator.naturalOrder());
            int limit = Math.min(2, songList.size());
            for (int i = 0; i < limit; i++) {
                answer.add(songList.get(i).num);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Song implements Comparable<Song> {
        int num, plays;

        Song(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song o) {
            if (o.plays != this.plays) return Integer.compare(o.plays, this.plays);
            return Integer.compare(this.num, o.num);
        }
    }
}
