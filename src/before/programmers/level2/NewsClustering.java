package before.programmers.level2;

import java.util.HashMap;

public class NewsClustering {
    static class Solution {
        public static int solution(String str1, String str2) {
            HashMap<String, Integer> cluster = new HashMap<>();
            HashMap<String, Integer> cluster1 = new HashMap<>();
            HashMap<String, Integer> cluster2 = new HashMap<>();

            for (int i = 0; i < str1.length() - 1; i++) {
                String key = str1.substring(i, i+2).toUpperCase();
                if (key.replaceAll("[^A-Z]","").length()==2) {
                    cluster.put(key, cluster.getOrDefault(key, 0) + 1);
                    cluster1.put(key, cluster1.getOrDefault(key, 0) + 1);
                }
            }

            for (int i = 0; i < str2.length() - 1; i++) {
                String key = str2.substring(i, i+2).toUpperCase();
                if (key.replaceAll("[^A-Z]","").length()==2) {
                    cluster.put(key, cluster.getOrDefault(key, 0) + 1);
                    cluster2.put(key, cluster2.getOrDefault(key, 0) + 1);
                }
            }

            int union = 0;
            int intersection = 0;
            for (String k : cluster.keySet()) {
                Integer a = cluster1.get(k);
                Integer b = cluster2.get(k);
                if (cluster.get(k) > 1 && a != null && b != null) {
                    intersection += Math.min(a, b);
                }
                union += Math.max(cluster1.getOrDefault(k, 0), cluster2.getOrDefault(k,0));
            }

            if (cluster1.isEmpty() && cluster2.isEmpty()) {
                return 65536;
            }

            return (int) Math.floor((double)intersection / union * 65536);
        }
    }

    public static void main(String[] args) {
        String str1 = "a+c";
        String str2 = "def";

        System.out.println(Solution.solution(str1, str2));
    }

}
