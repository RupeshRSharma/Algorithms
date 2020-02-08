package com.intelizest;

public class RatInAMaze {

	public static int counter;

	public static void main(String[] args) {
		Integer[][] maze = { { 0, 2, 0 }, { 1, 1, 2 }, { 1, 1, 0 } };
		System.out.println(ratInMaze(maze, maze.length));
		System.out.println(counter);
	}

	public static boolean ratInMaze(Integer[][] maze, int dim) {
		Integer[][] movement = new Integer[dim][dim];
		movement[0][0] = 0;
		boolean ratInMaze = ratInMaze(0, 0, movement, maze, dim);

		return ratInMaze;
	}

	public static boolean ratInMaze(int rowIdx, int colIdx, Integer[][] movement, Integer[][] maze, int dim) {
		if (rowIdx == colIdx && rowIdx == (dim - 1)) {
			return true;
		}
		int prevMove = movement[rowIdx][colIdx];
		int curMove = prevMove + 1;
		int newRowIdx = rowIdx;
		int newColIdx = colIdx;
		// move forward
		newColIdx = colIdx + 1;
		if (maze[newRowIdx][newColIdx] == 1) {
			movement[newRowIdx][newColIdx] = curMove;
			boolean ratInMaze = ratInMaze(newRowIdx, newColIdx, movement, maze, dim);
			if (ratInMaze) {
				return true;
			}
		}
		// move down
		newRowIdx = rowIdx + 1;
		newColIdx = colIdx;
		if (maze[newRowIdx][newColIdx] == 1) {
			movement[newRowIdx][newColIdx] = curMove;
			boolean ratInMaze = ratInMaze(newRowIdx, newColIdx, movement, maze, dim);
			if (ratInMaze) {
				return true;
			}
		}
		movement[newRowIdx][newColIdx] = null;
		return false;
	}

	public static boolean isSafe(int rowIdx, int colIdx, int dim) {
		counter++;
		boolean isValidIdx = (rowIdx < dim && rowIdx >= 0 && colIdx < dim && colIdx >= 0);
		return isValidIdx;
	}
}
