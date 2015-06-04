package com.renho.e90.section;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.renho.e90.section.Desc.Color;

public class Client {
	// ģ��ҵ�����
	public static void main(String[] args) {
		Bird bird = BirdNest.Sparrow.reproduce();
		Color color = bird.getColor();
		System.out.println("Bird's color is: " + color);
	}
}

// ��ĳ�����
@Desc(c = Color.White)
abstract class Bird {
	// �����ɫ
	public abstract Color getColor();
}

// ��ȸ
class Sparrow extends Bird {
	private Color color;

	// Ĭ����ǳ��ɫ
	public Sparrow() {
		color = Color.Grayish;
	}

	// ���캯�����������ɫ
	public Sparrow(Color _color) {
		color = _color;
	}

	@Override
	public Color getColor() {
		return color;
	}
}

// �񳲣���������ģʽ
enum BirdNest {
	Sparrow;
	// ���෱ֳ
	public Bird reproduce() {
		Desc bd = Sparrow.class.getAnnotation(Desc.class);
		return bd == null ? new Sparrow() : new Sparrow(bd.c());
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Desc {
	enum Color {
		White, Grayish, Yellow;
	}

	// Ĭ����ɫ�ǰ�ɫ��
	Color c() default Color.White;
}