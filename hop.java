import java.io.*;
import java.net.*;
import java.lang.*;

class Traceroute
{
    public static void main(String args[]){

    BufferedReader in;

        try{
            Runtime r   =   Runtime.getRuntime();
            Process p   =   r.exec("tracert -h 1 www.tce.edu");
            in  =   new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            if(p==null)
                System.out.println("could not connect");
            while((line=in.readLine())!=null){
                System.out.println(line);
                //in.close();
            }[-0]
        }catch(IOException e){
        System.out.println(e.toString());
        }
    }
}
