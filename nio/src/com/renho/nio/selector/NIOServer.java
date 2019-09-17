package com.renho.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
	// ͨ��������
	private Selector selector;

	public void initServer(int port) throws Exception {
		// ���һ��ServerSocketͨ��
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		// ����ͨ��Ϊ ������
		serverChannel.configureBlocking(false);
		// ����ͨ�����ڵ�serverSocket�󶨵�port�˿�
		serverChannel.socket().bind(new InetSocketAddress(port));
		// ���һ����ͨ��������
		this.selector = Selector.open();

		// ��ͨ���������͸�ͨ���󶨣���Ϊ��ͨ��ע��selectionKey.OP_ACCEPT�¼�
		// ע����¼��󣬵��¼������ʱ��selector.select()�᷵�أ�
		// ����¼�û�е���selector.select()��һֱ����

		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}

	// ������ѵ�ķ�ʽ����selector���Ƿ�����Ҫ������¼�������У����д���
	@SuppressWarnings("rawtypes")
	public void listen() throws Exception {
		System.out.println("start server");
		// ��ѯ����selector
		while (true) {
			// ��ע���¼�����ʱ���������أ�����÷�����һֱ����
			selector.select();
			// ���selector��ѡ�е���ĵ�������ѡ�е���Ϊע����¼�
			Iterator ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {
				SelectionKey key = (SelectionKey) ite.next();
				// ɾ����ѡ��key �Է��ظ�����
				ite.remove();
				// �ͻ������������¼�
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					// ��úͿͻ������ӵ�ͨ��
					SocketChannel channel = server.accept();
					// ���óɷ�����
					channel.configureBlocking(false);
					// ��������Է�����Ϣ���ͻ���
					channel.write(ByteBuffer.wrap(new String("hello client").getBytes()));
					// �ڿͻ��� ���ӳɹ�֮��Ϊ�˿��Խ��յ��ͻ��˵���Ϣ����Ҫ��ͨ�����ö���Ȩ��
					channel.register(this.selector, SelectionKey.OP_READ);
					// ����˿ɶ����¼�

				} else if (key.isReadable()) {
					read(key);
				}

			}
		}
	}

	// ���� ��ȡ�ͻ��˷�������Ϣ�¼�
	private void read(SelectionKey key) throws Exception {
		// �������ɶ���Ϣ���õ��¼�������socketͨ��
		SocketChannel channel = (SocketChannel) key.channel();
		// ������ȡ�Ļ�����
		ByteBuffer buffer = ByteBuffer.allocate(10);
		int len = channel.read(buffer);
		if (-1 == len) {
			channel.close();
			return;
		}
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("server receive from client: " + msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);
	}

	public static void main(String[] args) throws Throwable {
		NIOServer server = new NIOServer();
		server.initServer(8989);
		server.listen();
	}
}
