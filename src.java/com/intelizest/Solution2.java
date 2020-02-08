package com.intelizest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Java program to solve Rat in a Maze problem using 
backtracking */

public class Solution2 {

	// Size of the maze
	static int N, M, count, countof2;

	/*
	 * A utility function to check if x, y is valid index for N*N maze
	 */
	public static boolean isSafe(Integer maze[][], int x, int y) {
		boolean flag = (x >= 0 && x <= N && y >= 0 && y <= M && (maze[x][y] == 0 || maze[x][y] == 2));
		if(flag)count++;
		if(maze[x][y] == 2) countof2++;
		System.out.println(maze[x][y]+" "+x+" "+y+" "+flag);
		return flag;
	}

	public static int minMoves(List<List<Integer>> maze, int x, int y) {
		N=x;
		M=y;
		Integer[][] mazearr = maze.stream().map(l -> l.stream().toArray(Integer[]::new)).toArray(Integer[][]::new);		
		//solveMazeUtil(mazearr, 0, 0);
		
		
		  if (!solveMazeUtil(mazearr, 0, 0)) {
		  //System.out.print("Solution doesn't exist"); return -1; 
			return -1;  
		  }
		 
		return count;
	}	

	 /*
	 * A recursive utility function to solve Maze problem
	 */
	public static boolean solveMazeUtil(Integer[][] maze, int x, int y) {

		if(maze[x][y]==1)
			return false;
		
		if (x == N && y == M) {
			System.out.println(x+" "+y);
			return true;
		}
		
		
		// Check if maze[x][y] is valid
		if (isSafe(maze, x, y)) {		
			

			/* Move forward in x direction */
			if (solveMazeUtil(maze, x + 1, y)) {
				
				return true;
			}

			/*
			 * If moving in x direction doesn't give solution then Move down in y direction
			 */
			if (solveMazeUtil(maze, x, y + 1)) {
				
				return true;
			}
			
			return false;
		}

		return false;
	}

	public static void main(String args[]) {
		Solution2 rat = new Solution2();
		Integer maze[][] = { { 0,2,0 }, { 0,0,1 }, { 1,1,1}};
		
		List<List<Integer>> array = Arrays.stream(maze)
        .map(Arrays::asList)
        .collect(Collectors.toList());
		
		System.out.println(rat.minMoves(array, 1, 1));
	}
		
}