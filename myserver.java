    import java.io.*;  
    import java.net.*;  
    public class myserver {  
    public static void main(String[] args){  
    try{  
    ServerSocket ss=new ServerSocket(6666);  
    Socket s=ss.accept(); 
    DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
    DataInputStream dis=new DataInputStream(s.getInputStream());  
    String  str=(String)dis.readUTF();  
    dout.writeUTF("Hello client");
    System.out.println("message= "+str);  
    ss.close();  
    }catch(Exception e){System.out.println(e);}  
    }  
    }  