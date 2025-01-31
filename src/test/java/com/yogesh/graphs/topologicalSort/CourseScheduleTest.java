package com.yogesh.graphs.topologicalSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {
    CourseSchedule courseSchedule = new CourseSchedule();

    @Test
    public void simple() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        assertTrue(courseSchedule.canFinish(numCourses,  prerequisites));
    }

    @Test
    public void simpleCyclic() {
        int numCourses = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        assertFalse(courseSchedule.canFinish(numCourses, prerequisites2));
    }

    @Test
    public void multipleDependencies() {
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        assertTrue(courseSchedule.canFinish(numCourses3, prerequisites3));
    }

    @Test
    public void complexCycle() {
        int numCourses4 = 4;
        int[][] prerequisites4 = {{1, 0}, {2, 1}, {3, 2}, {0, 3}};
        assertFalse(courseSchedule.canFinish(numCourses4, prerequisites4));
    }

    @Test
    public void noPrerequisites() {
        int numCourses5 = 5;
        int[][] prerequisites5 = {};
        assertTrue(courseSchedule.canFinish(numCourses5, prerequisites5));
    }

    @Test
    public void multipleIndependentChain() {
        int numCourses7 = 6;
        int[][] prerequisites7 = {{1, 0}, {2, 1}, {4, 3}, {5, 4}};
        assertTrue(courseSchedule.canFinish(numCourses7, prerequisites7));
    }

    @Test
    public void langeChain() {
        int numCourses8 = 1000;
        int[][] prerequisites8 = {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {5, 4}};
        assertTrue(courseSchedule.canFinish(numCourses8, prerequisites8));
    }

    @Test
    public void largeChainWithCycle() {
        int numCourses9 = 1000;
        int[][] prerequisites9 = {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {5, 4}, {0, 5}};
        assertFalse(courseSchedule.canFinish(numCourses9, prerequisites9));
    }

    @Test
    public void disconnectedPrerequesites() {
        int numCourses10 = 6;
        int[][] prerequisites10 = {{1, 0}, {2, 1}, {4, 3}};
        assertTrue(courseSchedule.canFinish(numCourses10, prerequisites10));
    }
}
