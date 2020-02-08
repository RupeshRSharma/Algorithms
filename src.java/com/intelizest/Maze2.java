package com.intelizest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Maze2 {

	public int counter = 0;
	public int N, M;

	// Get the start location (x,y) and try to solve the maze
	public void solve(List<List<Integer>> array, int x, int y) {

		Integer[][] maze = array.stream().map(l -> l.stream().toArray(Integer[]::new)).toArray(Integer[][]::new);
		N = x;
		M = y;

		if (step(maze, x, y)) {
			maze[x][y] = 1;
		}
	}

	// Backtracking method
	public boolean step(Integer[][] maze, int x, int y) {

		
		
		
		counter++;

		// System.out.println(this.toString());

		/** Accept case - we found the exit **/
		if (x == 0 && y == 0) {
			return true;
		}

		/** Reject case - we hit a wall or our path **/
		if (maze[x][y] == 1) {
			return false;
		}

		/** Backtracking Step **/

		// Mark this location as part of our path
		maze[x][y] = 0;
		boolean result;

		// Try to go Right
		result = step(maze, x, y + 1);
		if (result) {
			return true;
		}

		// Try to go Up
		result = step(maze, x - 1, y);
		if (result) {
			return true;
		}

		// Try to go Left
		result = step(maze, x, y - 1);
		if (result) {
			return true;
		}

		// Try to go Down
		result = step(maze, x + 1, y);
		if (result) {
			return true;
		}

		/** Deadend - this location can't be part of the solution **/

		// Unmark this location
		maze[x][y] = 0;

		// Go back
		return false;
	}

	/*
	 * public String toString() { String output = ""; for (int x = 0; x < 10; x++) {
	 * for (int y = 0; y < 10; y++) { output += maze[x][y] + " "; } output += "\n";
	 * } return output; }
	 */

	public static void main(String[] args) {
		Maze2 m = new Maze2();
		// Locate the exit
		// m.maze[1][1] = 'X';

		// Start solving the maze from (8, 1)

		Integer maze[][] = { { 0, 2, 0 }, { 1, 1, 2 }, { 1, 0, 0 } };

		List<List<Integer>> array = Arrays.stream(maze).map(Arrays::asList).collect(Collectors.toList());

		m.solve(array, 2, 1);
		//System.out.println(m);
		System.out.println("Total calls: " + m.counter);
	}

}
