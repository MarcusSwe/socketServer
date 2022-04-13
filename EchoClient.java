
/*
package me.code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient implements Runnable {

    private final Socket socket;
    private Thread thread;

    public EchoClient(Socket socket) {
        this.socket = socket;
        System.out.println(("XXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
    }

    public void start() {
        System.out.println(("yoo was up"));
        byte[] buffer = new byte[256];
        try {
            InputStream inputStream = this.socket.getInputStream();
            OutputStream outputStream = this.socket.getOutputStream();

            while (!socket.isClosed()) {
                int count = inputStream.read(buffer);

                System.out.println("From client: " + new String(buffer, 0, count));

                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }

            socket.close(); // la bara till som princip..
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {


    }
}
*/






package me.code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient implements Runnable {

    private final Socket socket;
    private Thread thread;

    public EchoClient(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        byte[] buffer = new byte[256];
        try {
            InputStream inputStream = this.socket.getInputStream();
            OutputStream outputStream = this.socket.getOutputStream();

            while (!socket.isClosed()) {
                int count = inputStream.read(buffer);  //hur långt orden är som man får in..så skickar inte med tomma saker..kom ihåg hela arrayen är ju annars 256 som vi satt ovan.
                // inputStream read gör två saker läser in bytesen och sparar dem i parametern, buffer.. men sedan också returnerar antalet bytes den fick in ..

                System.out.println(buffer[0]); // får char koden, ett nummer, för tecknet den får in
                System.out.println(buffer[1]);
                System.out.println(count);
                System.out.println("From client: " + new String(buffer, 0, count)); // skapar en string av en byte array


                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }

            socket.close(); // la bara till som princip..
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



