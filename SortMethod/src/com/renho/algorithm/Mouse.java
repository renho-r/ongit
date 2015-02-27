package com.renho.algorithm;
/**
 * �������Թ�
 * @author renho
 *
 */
public class Mouse {
	private int startI, startJ;// ���
	private int endI, endJ; // ����
	private boolean success = false;

	public static void main(String[] args) {
		int[][] maze = { { 2, 2, 2, 2, 2, 2, 2 }, { 2, 0, 0, 0, 0, 0, 2 },
				{ 2, 0, 2, 0, 2, 0, 2 }, { 2, 0, 0, 2, 0, 2, 2 },
				{ 2, 2, 0, 2, 0, 2, 2 }, { 2, 0, 0, 0, 0, 0, 2 },
				{ 2, 2, 2, 2, 2, 2, 2 } };
		System.out.println("�@ʾ�Ԍm��");
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++)
				if (maze[i][j] == 2)
					System.out.print("��");
				else
					System.out.print(" ");
			System.out.println();
		}
		Mouse mouse = new Mouse();
		mouse.setStart(1, 1);
		mouse.setEnd(5, 5);
		if (!mouse.go(maze)) {
			System.out.println("\n�]���ҵ����ڣ�");
		} else {
			System.out.println("\n�ҵ����ڣ�");
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					if (maze[i][j] == 2)
						System.out.print("��");
					else if (maze[i][j] == 1)
						System.out.print("$");
					else
						System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

	public void setStart(int i, int j) {
		this.startI = i;
		this.startJ = j;
	}

	public void setEnd(int i, int j) {
		this.endI = i;
		this.endJ = j;
	}

	public boolean go(int[][] maze) {
		return visit(maze, startI, startJ);
	}

	private boolean visit(int[][] maze, int i, int j) {
		maze[i][j] = 1;
		if (i == endI && j == endJ)
			success = true;
		if (!success && maze[i][j + 1] == 0)
			visit(maze, i, j + 1);
		if (!success && maze[i + 1][j] == 0)
			visit(maze, i + 1, j);
		if (!success && maze[i][j - 1] == 0)
			visit(maze, i, j - 1);
		if (!success && maze[i - 1][j] == 0)
			visit(maze, i - 1, j);
		if (!success)
			maze[i][j] = 0;
		return success;
	}
}
