package com.fengmanfei.ch21;

import java.io.IOException;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;

public class ResourceManager {
	
	private ResourceManager(){}//����Ϊprivate����������������
	private static ColorRegistry colorRegistry;//������ɫ�Ķ���
	//�����ɫע��������
	public static ColorRegistry getColorRegistry() {
		if (colorRegistry == null) {
			colorRegistry = new ColorRegistry();
			initColor();
		}
		return colorRegistry;
	}
	//�����ɫע�����е���ɫ����Ĺ��߷���
	public static Color getColor( String key ) {
		Color color = getColorRegistry().get(key);
		return color;
	}
	//��ʼ����ѡ���ļ������õĸ��ִ������ɫ
	private static void initColor() {
		colorRegistry.put(Constants.COLOR_COMMENT,StringConverter.asRGB(getPreferenceStore().getString(Constants.COLOR_COMMENT)));
		colorRegistry.put(Constants.COLOR_KEYWORD,StringConverter.asRGB(getPreferenceStore().getString(Constants.COLOR_KEYWORD)));
		colorRegistry.put(Constants.COLOR_STRING,StringConverter.asRGB(getPreferenceStore().getString(Constants.COLOR_STRING)));
		colorRegistry.put(Constants.COLOR_OBJECT,StringConverter.asRGB(getPreferenceStore().getString(Constants.COLOR_OBJECT)));
	}
	//�������ѡ�������ļ�
	private static PreferenceStore preference ;
	//������ѡ���ļ�
	public static PreferenceStore getPreferenceStore() {
		if (preference == null) {
			preference = new PreferenceStore( "C:\\jsEditor.properties");
			try {
				preference.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return preference;
	}
}