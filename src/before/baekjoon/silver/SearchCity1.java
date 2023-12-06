package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.comparingInt;

public class SearchCity1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<City> cities = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            cities.add(new City(i, Integer.MAX_VALUE));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cities.get(x).linkedCities.add(cities.get(y));
        }

        search(cities, X);
        cities.stream()
                .filter(city -> city.weight == K)
                .forEach(city -> sb.append(city.cityNumber).append("\n"));

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    private static void search(List<City> cities, int startCityNumber) {
        PriorityQueue<City> queue = new PriorityQueue<>(comparingInt(City::getWeight));

        cities.get(startCityNumber).weight = 0;
        queue.offer(cities.get(startCityNumber));

        while (!queue.isEmpty()) {
            City city = queue.poll();

            for (City linkedCity : cities.get(city.cityNumber).linkedCities) {
                if (linkedCity.canGo(city.weight)) {
                    linkedCity.weight = city.weight + 1;
                    queue.offer(linkedCity);
                }
            }
        }
    }

    static class City {
        int cityNumber;
        int weight;
        List<City> linkedCities;

        public City(int cityNum, int weight) {
            this.cityNumber = cityNum;
            this.weight = weight;
            this.linkedCities = new ArrayList<>();
        }

        public int getWeight() {
            return weight;
        }

        public boolean canGo(int weight) {
            return this.weight == Integer.MAX_VALUE || this.weight > weight + 1;
        }
    }
}
