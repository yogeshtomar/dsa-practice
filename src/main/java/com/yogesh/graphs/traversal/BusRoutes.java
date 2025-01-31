package com.yogesh.graphs.traversal;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i =  0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {source, 0});

        Set<Integer> visitedRoutes = new HashSet<>();

        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentStop = current[0];
            int busCount = current[1];

            List<Integer> routesAtStop = stopToRoutes.get(currentStop);

            if (routesAtStop != null) {
                for (int route : routesAtStop) {
                    if (!visitedRoutes.contains(route)) {
                        visitedRoutes.add(route);

                        for (int nextStop : routes[route]) {
                            if (nextStop == target) {
                                return busCount + 1;
                            }

                            if (!visitedStops.contains(nextStop)) {
                                visitedStops.add(nextStop);
                                queue.add(new int[] {nextStop, busCount + 1});
                            }
                        }


                    }
                }
            }
        }
        return -1;
    }
}
