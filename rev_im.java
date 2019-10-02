import java.rmi.server.*;
import java.io.*;
public class rev_im extends UnicastRemoteObject implements rev_in
{
  public rev_im() throws Exception
  {
    super();
  }
 public int reverse(int x)
 {
   int res = 0;
    while(x!=0)
    {
      int d=x%10;
      res=(res*10)+d;
      x=x/10;
    }
		return res;
 }
}
