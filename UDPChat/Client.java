import java.net.*;
import java.io.*;
/**
 *
 * @author JacobSamro
 */
public class Client {
    
    public static void main(String args[]){
        
DatagramSocket s= null;
InetAddress host = null;
DataInputStream reader = new DataInputStream(System.in);
    try{
    s = new DatagramSocket();
    host = InetAddress.getByName("localhost");
    
    
    while(true){
        byte[] receivingData = new byte[1024];
        System.out.print("Client : ");
        String sendData = reader.readLine();
        byte[] data = sendData.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(data, data.length, host, 9000);    
        s.send(sendPacket);

        DatagramPacket receivingPacket = new DatagramPacket(receivingData, receivingData.length);

        s.receive(receivingPacket);
        System.out.println("Server Data Length: " + data.length);
        System.out.println("Server : " + new String(receivingPacket.getData()));

    
    }
   
    }catch(Exception e){
                System.out.println(e.toString());
                s.close();
    }        
    
    }

}
