package com.renho.largemappedfiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * �������ö��߳̽����ļ���д����
 */
public class Client {

	public static void main(String[] args) throws Exception {
		// Ԥ�����ļ���ռ�Ĵ��̿ռ䣬�����лᴴ��һ��ָ����С���ļ�
		RandomAccessFile raf = new RandomAccessFile("D://abc.txt", "rw");
		raf.setLength(1024 * 1024); // Ԥ���� 1M ���ļ��ռ�
		raf.close();

		// ��Ҫд����ļ�����
		String s1 = "��һ���ַ���";
		String s2 = "�ڶ����ַ���";
		String s3 = "�������ַ���";
		String s4 = "���ĸ��ַ���";
		String s5 = "������ַ���";

		// ���ö��߳�ͬʱд��һ���ļ�
		new FileWriteThread(1024 * 1, s1.getBytes("UTF-8")).start(); // ���ļ���1024�ֽ�֮��ʼд������
		new FileWriteThread(1024 * 2, s2.getBytes("UTF-8")).start(); // ���ļ���2048�ֽ�֮��ʼд������
		new FileWriteThread(1024 * 3, s3.getBytes("UTF-8")).start(); // ���ļ���3072�ֽ�֮��ʼд������
		new FileWriteThread(1024 * 4, s4.getBytes("UTF-8")).start(); // ���ļ���4096�ֽ�֮��ʼд������
		new FileWriteThread(1024 * 5, s5.getBytes("UTF-8")).start(); // ���ļ���5120�ֽ�֮��ʼд������
	}

	// �����߳����ļ���ָ��λ��д��ָ������
	static class FileWriteThread extends Thread {
		private int skip;
		private byte[] content;

		public FileWriteThread(int skip, byte[] content) throws UnsupportedEncodingException {
			this.skip = skip;
			this.content = content;
		}

		public void run() {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile("D://abc.txt", "rw");
				raf.seek(skip);
				raf.write(content);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					raf.close();
				} catch (Exception e) {
				}
			}
		}
	}

}