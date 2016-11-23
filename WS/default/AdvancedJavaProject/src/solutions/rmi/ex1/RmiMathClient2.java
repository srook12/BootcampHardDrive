package solutions.rmi.ex1;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class RmiMathClient2
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("USAGE: java RmiMathClient <ip of server host>");
            ;
            System.exit(1);
        }

        String sServerName = args[0];

        try
        {
            // bind server object to object in client
            MathServices2 serverObject =
                (MathServices2) Naming.lookup(
                    "rmi://" + sServerName + "/MathServer");

            double sqroot = serverObject.sqroot(25.00);
            double square = serverObject.square(25.00);
            System.out.println("Square of 25 is " + square);
            System.out.println("Square root of 25 is " + sqroot);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("RMI Connection successful");
    }
}
