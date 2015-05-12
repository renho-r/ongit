package com.renho.e34;

/**
 *
 * @author Phenix 2011-3-18
 */
public class Client {
	public static void main(String[] args) {
		Server s = new SimpleServer(1000);
	}
}

// ����һ������
abstract class Server {
	public final static int DEFAULT_PORT = 40000;

	public Server() {
		// ��������ṩ�Ķ˿ں�
		int port = getPort();
		System.out.println("�˿ںţ�" + port);
		/* ���м������� */
	}

	// �������ṩ�˿ںţ����������Լ��
	protected abstract int getPort();
}

class SimpleServer extends Server {
	private int port = 100;

	// ��ʼ������һ���˿ں�
	public SimpleServer(int _port) {
		port = _port;
	}

	// ���˿ں��Ƿ���Ч����Ч��ʹ��Ĭ�϶˿ڣ�����ʹ�������ģ��
	@Override
	protected int getPort() {
		return Math.random() > 0.5 ? port : DEFAULT_PORT;
	}
}
