import java.io.*;
import java.net.*;

public class EchoServer
{
	public EchoServer(int portnum)
	{
		try
		{
			server = new ServerSocket(portnum);
		}
		catch (Exception err)
		{
			System.out.println(err);
		}
	}

	public void serve()
	{
		try
		{
			while (true)
			{
				Socket client = server.accept();
				BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter w = new PrintWriter(client.getOutputStream(), true);
				w.println(" Send message!!.  Type 'bye' to close.");
				String line;
				do
				{
					line = r.readLine();
					if ( line != null ){
						System.out.println("message recieved in server "+line);
						w.println("Got: "+ line);}
				}
				while ( !line.trim().equals("bye") );
				client.close();
			}
		}
		catch (Exception err)
		{
			System.err.println(err);
		}
	}

	public static void main(String[] args)
	{
		EchoServer s = new EchoServer(9999);
		System.out.println("server connected");
		s.serve();
	}

	private ServerSocket server;
}



