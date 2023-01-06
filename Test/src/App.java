import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class App
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
        String a = text.readLine();
        System.out.println(a);
    }
}