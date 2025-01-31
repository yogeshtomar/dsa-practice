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

/**
 * Tackling the "Bus Routes" problem (or any graph-based problem) in an interview requires a structured approach.
 * Here's how you can approach it, along with the clarifications you should seek from the interviewer:
 *
 * Complexity:
 * Time Complexity: O(N * M), where N is the number of routes and M is the maximum number of stops in a route.
 *
 * Space Complexity: O(N * M) for storing the graph and the BFS queue.
 *
 * ---
 *
 * ### **1. Understand the Problem**
 * Before jumping into coding, ensure you fully understand the problem. Restate it in your own words and confirm with the interviewer.
 *
 * **Example Clarifications:**
 * - Are the bus routes circular? (Yes, they repeat forever.)
 * - Can a bus stop be part of multiple routes? (Yes, a stop can belong to multiple routes.)
 * - Is it possible for the source and target stops to be the same? (Yes, in which case the answer is 0.)
 * - Are the bus stops unique across all routes? (Yes, each stop is uniquely identified.)
 * - Can there be multiple routes with the same sequence of stops? (Yes, but they are treated as separate routes.)
 *
 * ---
 *
 * ### **2. Break Down the Problem**
 * Explain how you plan to model the problem. For this question, it's a graph problem where:
 * - **Nodes**: Bus routes (not stops, as stops can belong to multiple routes).
 * - **Edges**: Two routes are connected if they share at least one common stop.
 *
 * **Clarify the Approach:**
 * - "I plan to model this as a graph where each bus route is a node, and edges connect routes that share at least one common stop.
 * Then, I'll use BFS to find the minimum number of buses (routes) needed to travel from the source to the target."
 *
 * ---
 *
 * ### **3. Discuss Edge Cases**
 * Mention edge cases and how you plan to handle them. This shows you're thinking critically.
 *
 * **Edge Cases:**
 * - Source and target are the same (return 0).
 * - No possible route between source and target (return -1).
 * - Multiple routes share the same stop (handle by mapping stops to routes).
 * - Large input size (optimize BFS to avoid revisiting routes or stops).
 *
 * ---
 *
 * ### **4. Propose a Solution**
 * Explain your solution step-by-step before coding. For this problem:
 * 1. Build a mapping from each stop to all routes that pass through it.
 * 2. Use BFS starting from the source stop, exploring all routes that pass through it.
 * 3. Keep track of visited routes and stops to avoid cycles.
 * 4. If the target stop is reached, return the number of buses taken.
 * 5. If the queue is exhausted, return -1.
 *
 * ---
 *
 * ### **5. Ask for Feedback**
 * After explaining your approach, ask the interviewer if they have any concerns or suggestions. This shows you're collaborative and open to feedback.
 *
 * **Example Questions:**
 * - "Does this approach make sense?"
 * - "Should I optimize for space or time complexity?"
 * - "Is there a specific edge case I should focus on?"
 *
 * ---
 *
 * ### **6. Write the Code**
 * Once the interviewer approves your approach, start coding. Write clean, modular code with comments explaining key steps.
 *
 * ---
 *
 * ### **7. Test Your Code**
 * After writing the code, walk through a small example to verify it works. Use the sample input provided in the problem or create your own.
 *
 * **Example Test Case:**
 * ```java
 * Input: routes = [[1, 2, 7], [3, 6, 7]], S = 1, T = 6
 * Output: 2
 * Explanation: Take route 0 (1 -> 2 -> 7), then switch to route 1 (7 -> 3 -> 6).
 * ```
 *
 * ---
 *
 * ### **8. Optimize (If Asked)**
 * If the interviewer asks for optimizations, discuss:
 * - Using a bidirectional BFS to reduce the search space.
 * - Preprocessing the routes to group stops efficiently.
 * - Handling large inputs by limiting the BFS depth.
 *
 * ---
 *
 * ### **9. Summarize**
 * Finally, summarize your solution and its time/space complexity. This shows you can analyze your code and communicate effectively.
 *
 * ---
 *
 * ### **Key Clarifications to Ask**
 * 1. **Input Constraints**:
 *    - How many bus routes and stops are there? (To decide on time/space optimizations.)
 *    - Are the stops integers or strings? (Assume integers unless specified otherwise.)
 *
 * 2. **Edge Cases**:
 *    - Can the source and target be the same? (Yes, return 0.)
 *    - Can there be no possible route? (Yes, return -1.)
 *
 * 3. **Output Expectations**:
 *    - Should I return the number of buses or the sequence of routes? (Number of buses.)
 *
 * 4. **Performance**:
 *    - Should I optimize for time or space? (Usually time for BFS problems.)
 *
 * ---
 *
 * ### **Interviewer's Perspective**
 * The interviewer is evaluating:
 * - Your ability to break down a problem and model it effectively.
 * - Your communication skills in explaining your approach.
 * - Your coding skills and attention to edge cases.
 * - Your ability to analyze time and space complexity.
 *
 * By following this structured approach, you'll demonstrate all these skills effectively.
 */
