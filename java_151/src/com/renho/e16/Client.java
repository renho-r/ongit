package com.renho.e16;

import java.io.FileReader;
import java.util.Scanner;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 
 * ʹ�����õĽű�����
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		// ���һ��javascript��ִ������
		ScriptEngine engine = new ScriptEngineManager()
				.getEngineByName("javascript");
		// ���������ı���
		Bindings bind = engine.createBindings();
		bind.put("factor", 1);
		// �������ģ��������ǵ�ǰ���淶Χ
		engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int first = input.nextInt();
			int sec = input.nextInt();
			System.out.println("��������ǣ�" + first + "," + sec);
			// ִ��js����
			engine.eval(new FileReader("c:/model.js"));
			// �Ƿ�ɵ��÷���
			if (engine instanceof Invocable) {
				Invocable in = (Invocable) engine;
				// ִ��js�еĺ���
				Double result = (Double) in.invokeFunction("formula", first,
						sec);
				System.out.println("��������" + result.intValue());
			}
		}
	}
}
