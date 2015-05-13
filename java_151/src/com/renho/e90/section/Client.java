package com.renho.e90.section;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.renho.e90.section.Desc.Color;

public class Client {
	// 模拟业务调用
	public static void main(String[] args) {
		Bird bird = BirdNest.Sparrow.reproduce();
		Color color = bird.getColor();
		System.out.println("Bird's color is: " + color);
	}
}

// 鸟的抽象类
@Desc(c = Color.White)
abstract class Bird {
	// 鸟的颜色
	public abstract Color getColor();
}

// 麻雀
class Sparrow extends Bird {
	private Color color;

	// 默认是浅灰色
	public Sparrow() {
		color = Color.Grayish;
	}

	// 构造函数定义鸟的颜色
	public Sparrow(Color _color) {
		color = _color;
	}

	@Override
	public Color getColor() {
		return color;
	}
}

// 鸟巢，工厂方法模式
enum BirdNest {
	Sparrow;
	// 鸟类繁殖
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

	// 默认颜色是白色的
	Color c() default Color.White;
}