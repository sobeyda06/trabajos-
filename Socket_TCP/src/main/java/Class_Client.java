import java.net.*;
import java.io.*;
import static java.time.Clock.system;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yulian
 */
public class Class_Client
{
 
    
    public static void main(String[] args)
    {
        
        DataOutputStream ValorSalida; //output
        BufferedInputStream BuffInput; //bis
        BufferedOutputStream BuffOutput; //bos
    
        byte[] ArrayBytes; //receiveData
        int ValorNum; //in
        String Directorio; //file
        
        Scanner sc = new Scanner(System.in);
        String ip = JOptionPane.showInputDialog("Ingresa la ip");
        
        try
        {          //client     
            Socket Sck_Client = new Socket(ip, 5000);
            
            ValorSalida = new DataOutputStream(Sck_Client.getOutputStream());
        
            ArrayBytes = new byte[1024];
            BuffInput = new BufferedInputStream(Sck_Client.getInputStream());
                            //dis
            DataInputStream DInputS = new DataInputStream(Sck_Client.getInputStream());
            
            System.out.println("Ingrese el nombre del archivo");
            String nombre = sc.nextLine();
            
            ValorSalida.writeUTF(nombre);
            
            
            
            
            Directorio = DInputS.readUTF();
            
           
            BuffOutput = new BufferedOutputStream(new FileOutputStream(Directorio));//rut en ves de Directorii
            ValorNum = BuffInput.read(ArrayBytes);
            BuffOutput.write(ArrayBytes, 0, ValorNum);
        
             BuffOutput.close();
             DInputS.close();
             
             JOptionPane.showMessageDialog(null, "Exito");

        }
        catch (Exception ValorExcecion)
        {
            System.err.println(ValorExcecion.getCause());
        
        }
    
    }
    
}//Cierre
