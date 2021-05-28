package com.sobeyda;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author sobeyda - 23/5/21
 * @project CalculadoraRmi
 */

public interface ICalculadora extends Remote { //sub clase remote 
    double suma() throws RemoteException;
    double resta() throws RemoteException;
    double multiplicacion() throws RemoteException;
    double division() throws RemoteException;
    double getOperandouno() throws RemoteException; //mostrar
    double getOperandodos() throws RemoteException;
    void setOperandouno(double operandouno) throws RemoteException; //modificar
    void setOperandodos(double operandodos) throws RemoteException;
}
