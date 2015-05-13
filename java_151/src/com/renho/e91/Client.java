package com.renho.e91;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Client {
	public static void main(String[] args) {
		// ��ʼ����ҵ�߼�
		Foo b = new Foo();
		// ��ȡע��
		Access access = b.getClass().getAnnotation(Access.class);
		// û��Accessע����߼�Ȩʧ��
		if (access == null || !access.level().identify()) {
			// û��Accessע����߼�Ȩʧ��
			System.out.println(access.level().REFUSE_WORD);
		}

	}

}

// ��ҵ�߼���Ĭ�Ϸ���Ȩ����Admin
@Access(level = CommonIdentifier.Author)
class Foo {

}

// ��Ȩ�߽ӿ�
interface Identifier {
	// ��Ȩ����ʱ����ò��
	String REFUSE_WORD = "����Ȩ����";

	// ��Ȩ
	public boolean identify();
}

// ���ü�Ȩ��
enum CommonIdentifier implements Identifier {
	// Ȩ�޼���
	Reader, Author, Admin;

	// ʵ�ּ�Ȩ
	public boolean identify() {
		return false;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Access {
	// ȷ��ʲô������Է���
	CommonIdentifier level() default CommonIdentifier.Admin;
}
