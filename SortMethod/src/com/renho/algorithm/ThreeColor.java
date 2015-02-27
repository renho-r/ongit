package com.renho.algorithm;

/**
 * ��ɫ��
 * @author renho
 *
 */
public class ThreeColor {
	private static final char WHITE = 'w';
	private static final char BLUE = 'b';
	private static final char RED = 'r';

	public void Three_color_flag(int color[], int n) { // ����Ϊ��,��,��
		int white = 0;
		int blue = 0;
		int red = n - 1;
		while (white <= red) {
			if (color[white] == WHITE) // ��ɫ����Ϊ����,white++
				white++;
			else if (color[white] == BLUE) { // ��ɫ����Ϊ��ɫ,�򽻻�,���߶�������,��+1
				swap(color[blue], color[white]);
				blue++;
				white++;
			} else {
				while (white < red && color[red] == RED) {// Ϊ��ɫ�����ɫ���򽻻�,��ɫ-1,��ɫ����,��Ϊ�������Ĳ�֪����ʲô��ɫ��
					red--;
				}
				swap(color[red], color[white]);
				red--;
			}
		}
	}

	public void swap(int a, int b) {

	}
}
