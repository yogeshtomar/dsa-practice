package com.yogesh.graphs.traversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordSearchTest {
    @Test
    public void testExample1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        assertTrue(new WordSearch().exist(board, word));
    }

    @Test
    public void testExample2() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        assertTrue(new WordSearch().exist(board, word));
    }

    @Test
    public void testExample3() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        assertFalse(new WordSearch().exist(board, word));
    }

    @Test
    public void testEmptyBoard() {
        char[][] board = {};
        String word = "A";
        assertFalse(new WordSearch().exist(board, word));
    }

    @Test
    public void testSingleCellBoard() {
        char[][] board = {{'A'}};
        String word = "A";
        assertTrue(new WordSearch().exist(board, word));
    }

    @Test
    public void testWordLongerThanBoard() {
        char[][] board = {
                {'A', 'B'},
                {'C', 'D'}
        };
        String word = "ABCDE";
        assertFalse(new WordSearch().exist(board, word));
    }

    @Test
    public void testMissingCharacter() {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "ABCFZ";
        assertFalse(new WordSearch().exist(board, word));
    }
}
