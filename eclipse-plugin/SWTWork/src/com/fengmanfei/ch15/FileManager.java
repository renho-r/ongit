package com.fengmanfei.ch15;

import java.io.*;

public class FileManager {
	
	private String fileName;//�ļ���
	private boolean dirty = false;//�ļ��Ƿ��޸Ĺ�
	private String content;//�ļ����ַ���
	public FileManager() {
	}
	public void load(String name) {//����һ���ļ�
		final String textString;
		try {
			File file = new File(name);
			FileInputStream stream = new FileInputStream(file.getPath());
			Reader in = new BufferedReader(new InputStreamReader(stream));
			char[] readBuffer = new char[2048];
			StringBuffer buffer = new StringBuffer((int) file.length());
			int n;
			while ((n = in.read(readBuffer)) > 0) {
				buffer.append(readBuffer, 0, n);
			}
			textString = buffer.toString();
			stream.close();
		} catch (FileNotFoundException e) {//������ļ�������������Ϣ��ʾ��״̬��
			MainWindow.getApp().getStatusLineManager().setMessage("�ļ�δ�ҵ�:" + fileName);
			return;
		} catch (IOException e) {
			MainWindow.getApp().getStatusLineManager().setMessage("���ļ�����:" + fileName);
			return;
		}
		content = textString;//���ļ����ַ����浽content��
		this.fileName = name;
	}

	public void save(String name) {//����һ���ļ�
		final String textString = content;
		try {
			File file = new File(name);
			FileOutputStream stream = new FileOutputStream(file.getPath());
			Writer out = new OutputStreamWriter( stream );
			out.write( textString );
			out.flush();
			stream.close();
		} catch (FileNotFoundException e) {
			MainWindow.getApp().getStatusLineManager().setMessage("�ļ�δ�ҵ�:" + fileName);
			return;
		} catch (IOException e) {
			MainWindow.getApp().getStatusLineManager().setMessage("�����ļ�����:" + fileName);
			return;
		}
	}
	/**
	 * @return ���� content��
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content Ҫ���õ� content��
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return ���� dirty��
	 */
	public boolean isDirty() {
		return dirty;
	}
	/**
	 * @param dirty Ҫ���õ� dirty��
	 */
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	/**
	 * @return ���� fileName��
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName Ҫ���õ� fileName��
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
