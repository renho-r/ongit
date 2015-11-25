package com.renho.internet.nio.netty;

import io.netty.bootstrap.ServerBootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Discards any incoming data.
 */
public class DiscardServer {

	private int port;

	public DiscardServer(int port) {
		this.port = port;
	}

	public void run() throws Exception {
		/**NioEventLoopGroup ����������I/O�����Ķ��߳��¼�ѭ������
		 * Netty�ṩ����಻ͬ��EventLoopGroup��ʵ����������ͬ����Э�顣
		 * ���������������ʵ����һ������˵�Ӧ�ã���˻���2��NioEventLoopGroup�ᱻʹ�á�
		 * ��һ��������������boss�����������ս��������ӡ��ڶ���������������worker����
		 * ���������Ѿ������յ����ӣ�һ����boss�����յ����ӣ��ͻ��������Ϣע�ᵽ��worker���ϡ�
		 * ���֪�����ٸ��߳��Ѿ���ʹ�ã����ӳ�䵽�Ѿ�������Channels�϶���Ҫ������EventLoopGroup��ʵ�֣�
		 * ���ҿ���ͨ�����캯�����������ǵĹ�ϵ��
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			/**
			 * ServerBootstrap ��һ������NIO����ĸ��������ࡣ����������������ֱ��ʹ��Channel�����������һ�����ӵĴ�����̣��ںܶ�������㲢����Ҫ��������
			 */
			ServerBootstrap b = new ServerBootstrap();
			/**
			 * ��������ָ��ʹ��NioServerSocketChannel��������˵��һ���µ�Channel��ν��ս��������ӡ�
			 */
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
			/**
			 * ������¼������ྭ���ᱻ��������һ��������Ѿ����յ�Channel��
			 * ChannelInitializer��һ������Ĵ����࣬����Ŀ���ǰ���ʹ��������һ���µ�Channel��
			 * Ҳ������ͨ������һЩ���������DiscardServerHandle������һ���µ�Channel�������Ӧ��ChannelPipeline��ʵ������������
			 * ����ĳ����ĸ���ʱ������������Ӹ���Ĵ����ൽpipline�ϣ�Ȼ����ȡ��Щ�����ൽ�������ϡ�
			 */
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new TimeServerHandler(), new DiscardServerHandler());
//							ch.pipeline().addLast(new DiscardServerHandler(), new TimeServerHandler());
						}
						/**
						 * �������������ָ����ͨ��ʵ�ֵ����ò�������������дһ��TCP/IP�ķ���ˣ�
						 * ������Ǳ���������socket�Ĳ���ѡ�����tcpNoDelay��keepAlive��
						 * ��ο�ChannelOption����ϸ��ChannelConfigʵ�ֵĽӿ��ĵ��Դ˿��Զ�ChannelOptions����һ����ŵ���ʶ��
						 */
					}).option(ChannelOption.SO_BACKLOG, 128)
					/**
					 * ���ע��option()��childOption()��
					 * option()���ṩ��NioServerSocketChannel�������ս��������ӡ�
					 * childOption()���ṩ���ɸ��ܵ�ServerChannel���յ������ӣ�
					 * �����������Ҳ��NioServerSocketChannel��
					 */
					.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

			// Bind and start to accept incoming connections.
			ChannelFuture f = b.bind(port).sync(); // (7)

			// Wait until the server socket is closed.
			// In this example, this does not happen, but you can do that to
			// gracefully
			// shut down your server.
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8080;
		}
		new DiscardServer(port).run();
	}
}