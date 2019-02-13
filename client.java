import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class client {
    public static void main(String[] args) throws IOException {
        Boolean connected = true;

        Socket s = new Socket("localhost", 9994);
        System.out.println("The Finacial Guide.");

        do {
            System.out.println("\nSelect a service");
            System.out.println("1 : Simple Interest");
            System.out.println("2 : Compound Interest");
            System.out.println("3 : Future Value ");
            Scanner req = new Scanner(System.in);
            int request = req.nextInt();

            PrintWriter out1 = new PrintWriter(s.getOutputStream());
            out1.println(request);
            out1.flush();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String str = br.readLine();
            System.out.println("\n\t" + str);

            Scanner input = new Scanner(System.in);
            double principal = 0.00;
            double rate = 0.00;
            double times = 0.00;
            double time = 0.00;
            String variables = "";

            switch (request) {
            case 1:
                System.out.println("Enter The Principal Annual Interest rate and Time in years");
                System.out.println("Principal: ");
                principal = input.nextDouble();
                System.out.println("Interest: ");
                rate = input.nextDouble();
                System.out.println("Time");
                time = input.nextDouble();
                variables = "" + principal + " " + rate + " " + time;
                break;

            case 2:
                System.out.println(
                        "Enter The Principal, Annual Interest Rate, Number of times interest is compounded per year and Time in years");
                System.out.println("Principal: ");
                principal = input.nextDouble();
                System.out.println("Interest: ");
                rate = input.nextDouble();
                System.out.println("Times intersted is compounded: ");
                times = input.nextDouble();
                System.out.println("Time");
                time = input.nextDouble();
                variables = "" + principal + " " + rate + " " + times + " " + time;
                break;

            case 3:
                System.out.println(
                        "Enter The Principal (payment amount per period), Annual Interest Rate, Number of times interest is compounded per year and Time in years");
                System.out.println("Principal: ");
                principal = input.nextDouble();
                System.out.println("Interest: ");
                rate = input.nextDouble();
                System.out.println("Times intersted is compounded: ");
                times = input.nextDouble();
                System.out.println("Time");
                time = input.nextDouble();
                variables = "" + principal + " " + rate + " " + times + " " + time;
                break;

            }

            PrintStream out2 = new PrintStream(s.getOutputStream());
            out2.println(variables);
            out2.flush();

            Double amount = Double.parseDouble(br.readLine());
            DecimalFormat df2 = new DecimalFormat(".##");
            System.out.println("Your Total Amount is: " + df2.format(amount));

            System.out.println("\nAny other service?");
            System.out.println("1 : Yes\nSelect other to exit");
            int option = req.nextInt();

            PrintStream out3 = new PrintStream(s.getOutputStream());
            if (option == 1) {
                connected = true;
                out3.println(connected);
                out3.flush();
            } else {
                connected = false;
                out3.println(connected);
                out3.flush();
            }

        } while (connected);

    }
}