package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class SearchCity {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<City>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(new City(y, 1));
        }

        search(list, dist, X);
        IntStream.range(1, dist.length)
                .filter(i -> dist[i] == K)
                .forEach(i -> sb.append(i).append("\n"));

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    private static void search(List<List<City>> list, int[] dist, int cityNum) {
        PriorityQueue<City> queue = new PriorityQueue<>(comparingInt(City::getWeight));
        dist[cityNum] = 0;
        queue.offer(new City(cityNum, 0));

        while (!queue.isEmpty()) {
            City city = queue.poll();
            int currentCityNumber = city.cityNumber;

            for (City c : list.get(currentCityNumber)) {
                if (dist[c.cityNumber] > (c.weight + dist[currentCityNumber])) {
                    dist[c.cityNumber] = c.weight + dist[currentCityNumber];
                    queue.offer(new City(c.cityNumber, dist[c.cityNumber]));
                }
            }
        }

    }

    static class City {
        int cityNumber;
        int weight;

        public City(int cityNum, int weight) {
            this.cityNumber = cityNum;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}
