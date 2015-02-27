package com.renho.algorithm;
/**
 * 骑士
 * @author renho
 *
 */
public class Knight {
	public boolean travel(int startX, int startY, int[][] board) {
		// 对应骑士可走的八个方向
		int[] ktmove1 = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] ktmove2 = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// 下一步出路的位置
		int[] nexti = new int[board.length];
		int[] nextj = new int[board.length];

		// 记录出路的个数
		int[] exists = new int[board.length];

		int x = startX;
		int y = startY;

		board[x][y] = 1;

		for (int m = 2; m <= Math.pow(board.length, 2); m++) {
			for (int k = 0; k < board.length; k++) {
				exists[k] = 0;
			}

			int count = 0;
			// 试探八个方向
			for (int k = 0; k < board.length; k++) {
				int tmpi = x + ktmove1[k];
				int tmpj = y + ktmove2[k];

				// 如果是边界了，不可走
				if (tmpi < 0 || tmpj < 0 || tmpi > 7 || tmpj > 7) {
					continue;
				}

				// 如果这个方向可走，记录下来
				if (board[tmpi][tmpj] == 0) {
					nexti[count] = tmpi;
					nextj[count] = tmpj;
					// 可走的方向加一个
					count++;
				}
			}

			int min = -1;
			if (count == 0) {
				return false;
			} else if (count == 1) {
				min = 0;
			} else {
				// 找出下一个位置的出路数
				for (int l = 0; l < count; l++) {
					for (int k = 0; k < board.length; k++) {
						int tmpi = nexti[l] + ktmove1[k];
						int tmpj = nextj[l] + ktmove2[k];

						if (tmpi < 0 || tmpj < 0 || tmpi > 7 || tmpj > 7) {
							continue;
						}

						if (board[tmpi][tmpj] == 0)
							exists[l]++;
					}
				}

				int tmp = exists[0];
				min = 0;

				// 从可走的方向中寻找最少出路的方向
				for (int l = 1; l < count; l++) {
					if (exists[l] < tmp) {
						tmp = exists[l];
						min = l;
					}
				}
			}

			// 走最少出路的方向
			x = nexti[min];
			y = nextj[min];
			board[x][y] = m;
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] board = new int[8][8];
		Knight knight = new Knight();

		if (knight.travel(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
				board)) {
			System.out.println("游历完成！");
		} else {
			System.out.println("游历失败！");
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] < 10) {
					System.out.print(" " + board[i][j]);
				} else {
					System.out.print(board[i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}