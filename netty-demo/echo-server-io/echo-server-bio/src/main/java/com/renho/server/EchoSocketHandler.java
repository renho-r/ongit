package com.renho.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class EchoSocketHandler implements Runnable {

    private Socket clientSocket;
    private Scanner scanner;
    private PrintStream print;
    private boolean isOpen = false;

    public EchoSocketHandler() {}

    public EchoSocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            this.scanner = new Scanner(this.clientSocket.getInputStream());
            this.scanner.useDelimiter("\n");
            this.print = new PrintStream(this.clientSocket.getOutputStream());
            this.isOpen = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.isOpen) {
            if (this.scanner.hasNext()) {
                String msg = this.scanner.next().trim();
                System.out.printf("%s: rec: %s \n", Thread.currentThread().getName(), msg);
                print.println("[echo]" + msg);
                if("bye".equalsIgnoreCase(msg)) {
                    try {
                        this.print.close();
                        this.scanner.close();
                        this.clientSocket.close();
                        this.isOpen = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
