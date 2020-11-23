package com.renho.test.mybatisplus.common.core.idgenerator.redis;

public class ServerNode {

	private String host;
	private int port;

	public ServerNode(String host, int port){
		this.host = host;
		this.port = port;
	}
	public String getHost() {
		return host;
	}
	public int getPort() {
		return port;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(host).append(":").append(port);
		return builder.toString();
	}
}
