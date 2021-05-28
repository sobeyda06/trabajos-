package com.sobeyda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sobeyda - 18/5/21
 * @project EchoServerClient
 */

public class EchoServer {

    public static void main(String... args) throws IOException {
        String message;

        // Socket donde el servidor escuchara peticiones
        ServerSocket serverSocket = new ServerSocket(Configurations.port);
        // socket del cliente que sera aceptado por el servidor gracias al metodo accept
        Socket socket = serverSocket.accept();
        System.out.println("Servidor esperando por mensajes");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while((message = input.readLine()) != null) {
            if(message.equalsIgnoreCase("")) break;
            System.out.println("Servidor => " + message);
            out.println(message);
        }

        input.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}
