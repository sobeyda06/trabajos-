package com.sobeyda;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author sobeyda - 23/5/21
 * @project CalculadoraRmi
 */

public class Servidor {

    public static void main(String[] args) throws RemoteException {
        ICalculadora calculadora = new Calculadora();
        Registry registry = LocateRegistry.createRegistry(1099); //cra un registro propio
        registry.rebind("Calculadora", calculadora); //objetos que estan siendo exportados 
        System.out.println("Servidor de la calculadora encendido");
    }
}
