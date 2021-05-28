package com.sobeyda;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author derian-cordoba - 25/5/21
 * @project CalculadoraRmi
 */
public class Calculadora extends UnicastRemoteObject implements ICalculadora {
    private double operandouno, operandodos;

    public Calculadora() throws RemoteException {}

    @Override //sobreescribir metodo
    public double suma() throws RemoteException {
        return getOperandouno() + getOperandodos();
    }

    @Override
    public double resta() throws RemoteException {
        return getOperandouno() - getOperandodos();
    }

    @Override
    public double multiplicacion() throws RemoteException {
        return getOperandouno() * getOperandodos();
    }

    @Override
    public double division() throws RemoteException {
        try {
            return (getOperandodos() == 0 || getOperandouno() == 0) ? 0 : getOperandodos() > getOperandouno() ? getOperandodos() / getOperandouno() : getOperandouno() / getOperandodos();
        } catch (ArithmeticException exception) {
            System.out.println("Error al realizar division por 0");
            return 0;
        }
    }

    @Override
    public double getOperandouno() {
        return operandouno;
    }

    @Override
    public void setOperandouno(double operandouno) {
        this.operandouno = operandouno;
    }

    @Override
    public double getOperandodos() {
        return operandodos;
    }

    @Override
    public void setOperandodos(double operandodos) {
        this.operandodos = operandodos;
    }
}
