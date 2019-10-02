import java.io.*;
public class ping 
{
 
    public static void main(String[] args) 
    {
         
       
        String hostname = "www.google.com";
         
       
        Pinger pinger = new Pinger(hostname);
         
      
        boolean response = pinger.commandLinePing();
         
        if(response)
        {
            System.out.println("Successfull Ping of "+hostname);
        }
        else
        {
            System.out.println("Unsuccessfull Ping of "+hostname);
        }
 
    }
 
}
 

class Pinger
{
    String pingCommand;
     
     
    public Pinger(String hostname)
    {
      
        if(System.getProperty("os.name").startsWith("Windows")) 
        {
            pingCommand = "ping -n 1 " + hostname;
        } 
        else
        {
            pingCommand = "ping -c 1 " + hostname;
        }
    }
     
    public boolean commandLinePing() 
    {
        boolean result = false;
         
        try
        {   
            Process myProcess = Runtime.getRuntime().exec(pingCommand);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(myProcess.getInputStream()));
           System.out.println("Here is the standard output of the command:\n");
           String s = null;
           while ((s = stdInput.readLine()) != null) {
           System.out.println(s);  }
           
            myProcess.waitFor();
          
         
            if(myProcess.exitValue() == 0) 
            { 
                result = true; 
            }
            else
            { 
                result = false; 
            }
         
            
            myProcess.destroy();
        }
        catch(Exception ex)
        {
            System.out.println("Exception:"+ex.toString());
        }
         
        
        return result;
    }
     
}