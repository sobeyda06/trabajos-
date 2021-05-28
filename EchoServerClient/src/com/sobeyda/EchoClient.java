package com.sobeyda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author sobeyda - 18/5/21
 * @project EchoServerClient
 */

public class EchoClient {

    public static void main(String... args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader input = null;

        try {
            socket = new Socket(Configurations.host, Configurations.port);
            out = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException exception) {
            exception.printStackTrace();
            System.exit(0);
        }

        // Se usara para leer loe mensajes
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String message;
        System.out.println("Entrada: ");
        while((message = stdin.readLine()) != null) {
            if(message.equalsIgnoreCase("")) break;
            out.println(message);
            System.out.println("Echo: " + input.readLine());
            System.out.println("Entrada: ");
        }

        out.close();
        input.close();
        stdin.close();
        socket.close();
    }
}
