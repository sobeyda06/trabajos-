package com.sobeyda;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author sobeyda - 23/5/21
 * @project CalculadoraRmi
 */

public class Cliente {

    public static void main(String[] args) throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry();
        ICalculadora calculadora = (ICalculadora) registry.lookup("Calculadora");

        do {
            System.out.println("1. Suma\n2. Resta\n3. Multiplicacion\n4. Division\n");
            int opcion = new Scanner(System.in).nextInt();

            System.out.println("Ingrese el primer operando");
            calculadora.setOperandouno(new Scanner(System.in).nextDouble());

            System.out.println("Ingrese el segundo operando");
            calculadora.setOperandodos(new Scanner(System.in).nextDouble());

            System.out.print("Resultado: ");
            switch (opcion) {
                case 1 -> System.out.println(calculadora.suma());

                case 2 -> System.out.println(calculadora.resta());

                case 3 -> System.out.println(calculadora.multiplicacion());

                case 4 -> System.out.println(calculadora.division());

                default -> System.out.println("Operacion no valida");
            }
        } while(true);
    }
}
