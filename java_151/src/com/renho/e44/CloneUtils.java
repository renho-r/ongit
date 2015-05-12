package com.renho.e44;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtils {
	// ��¡һ������
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		// ��¡�����Ķ���
		T clonedObj = null;
		try {
			// ��ȡ�����ֽ�����
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			// �����ڴ�ռ䣬д��ԭʼ���������¶���
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			// �����¶��󣬲�������ת��
			clonedObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clonedObj;
	}
}
