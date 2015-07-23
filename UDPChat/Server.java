import java.net.*;
import java.io.*;
/**
 *
 * @author JacobSamro
 */
public class Server {
    public static void main(String args[]){
        DatagramSocket s = null;                

       
        try{
            s = new DatagramSocket(9000);
            
            while(true){
                
                byte[] receivingData = new byte[1024];
                DatagramPacket receivingPacket = new DatagramPacket(receivingData,receivingData.length);
                s.receive(receivingPacket);
                System.out.println("Client :" + new String(receivingPacket.getData()));
                System.out.println("Length : " + receivingPacket.getData().length);
               
                InetAddress host = receivingPacket.getAddress();
                int port = receivingPacket.getPort();
                
                System.out.print("Server :");
                DataInputStream reader = new DataInputStream(System.in);
                String sendData = reader.readLine();
                
                byte[] sendDataByte = sendData.getBytes();
                DatagramPacket sendingPacket = new DatagramPacket(sendDataByte,sendDataByte.length,host, port);
                s.send(sendingPacket);
            }                      
            
        }
        catch(Exception e){
         System.out.println(e);
         s.close();
        }
    }    
}
