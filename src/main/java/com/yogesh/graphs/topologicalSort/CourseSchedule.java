package com.yogesh.graphs.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisites[i] = [ai, bi] => take bi before ai => b = parent, ai = child
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int parent = pre[1];
            int child = pre[0];
            adjList.get(parent).add(child);
            inDegree[child]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;
            for ( int nextCourse : adjList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        return coursesTaken == numCourses;
    }
}
