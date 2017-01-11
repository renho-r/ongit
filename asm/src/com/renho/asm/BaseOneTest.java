package com.renho.asm;

import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class BaseOneTest {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		ClassWriter cw = new ClassWriter(0);
		cw.visit(Opcodes.V1_1, Opcodes.ACC_PUBLIC, "com/renho/asm/basetest/SubBaseOne", null, "com/renho/asm/basetest/BaseOne", null);
		
		MethodVisitor mw = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mw.visitVarInsn(Opcodes.ALOAD, 0);
        mw.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/renho/asm/basetest/BaseOne", "<init>", "()V", false);
        mw.visitInsn(Opcodes.RETURN);
        mw.visitMaxs(1, 1);
        mw.visitEnd();
		
		cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, new Integer(-1));
		cw.visitEnd();
		byte[] subBaseOneBytes = cw.toByteArray();
		
//		FileOutputStream out = new FileOutputStream("C:/Users/renho/Desktop/SubBaseOne.class");
//		out.write(subBaseOneBytes);
//		out.close();
		
		MyClassLoader myClassLoader = new MyClassLoader();
		Class<?> c = myClassLoader.defineClass("com.renho.asm.basetest.SubBaseOne", subBaseOneBytes);
		Object subBaseOne = c.newInstance();
		System.out.println(subBaseOne);
		
	}

}
