package com.renho.algorithm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * 巴斯卡三角
 * 
 * @author renho
 * 
 */
public class Pascal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Pascal pascal = new Pascal();
		pascal.show();
	}

	/**
	 * nCr的计算 nCr = n! / [(n-r)! * r!] 巴斯卡内 nCr = [(n-r+1)/r] * nC(r-1)
	 */

	public long combi(int n, int r) {
		long p = 1;
		for (int i = 1; i <= r; i++) {
			p = p * (n - i + 1) / i;
		}
		return p;
	}

	public void paint(Graphics g) {
		final int N = 12;
		int n, r;
		for (n = 0; n <= N; n++) {
			for (r = 0; r <= n; r++){
				g.drawString(" " + combi(n, r), (N - n) * 20 + r * 40, n * 20 + 50);
			}
		}
	}

	public Pascal() {
		setBackground(Color.white);
		setTitle("巴斯卡三角形");
		setSize(520, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
