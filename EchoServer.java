package me.code;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private final int port;
    private ServerSocket serverSocket;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("CPPPPPPPPPPPPPPP");
        new testIfNewObjectIsNewThread().start();
        new testIfNewObjectIsNewThread().start();
        Thread current = Thread.currentThread();
        System.out.println("current thread för servern: " + current.getId());
        new testIfNewObjectIsNewThread().start();
        try {
            this.serverSocket = new ServerSocket(this.port);

            while (!this.serverSocket.isClosed()) {

                Socket clientSocket = this.serverSocket.accept(); // ligger och väntar och koden fortsätter inte förrän en client har anslutet
                System.out.println("A client has connected from: " + clientSocket.getInetAddress().getHostAddress());

                new EchoClient(clientSocket).start();
            }

            this.serverSocket.close(); // la bara till som princip..
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
