import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        Boolean connected = true;

        ServerSocket ss = new ServerSocket(9994);
        Socket s = ss.accept();

        System.out.println("Connection established");

        do {
            InputStreamReader in1 = new InputStreamReader(s.getInputStream());
            BufferedReader br1 = new BufferedReader(in1);
            int request = Integer.parseInt(br1.readLine());

            Service service = new Service();
            String serve = service.service(request);

            System.out.println("Received : " + serve);

            PrintWriter out2 = new PrintWriter(s.getOutputStream());
            out2.println(serve);
            out2.flush();

            String variables = br1.readLine();
            System.out.println("Received : " + variables);

            Double amount = service.variablesExtract(variables);
            PrintWriter out3 = new PrintWriter(s.getOutputStream());
            out3.println(amount.toString());
            out3.flush();

            connected = Boolean.parseBoolean(br1.readLine());

        } while (connected);

    }
}