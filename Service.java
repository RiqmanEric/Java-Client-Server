public class Service {

    private double principal = 0.00;
    private double rate = 0.00;
    private double times = 0.00;
    private double time = 0.00;
    private int request;

    public String service(int req) {
        switch (req) {
        case 1:
            request = req;
            return "Simple Interest Calculator";
        case 2:
            request = req;
            return "Compound Interest Calculator";
        case 3:
            request = req;
            return "Future Value Calculator";
        default:
            return "Invalid selection. Enter 1 or 2";
        }

    }

    public Double variablesExtract(String variables) {
        Double amount;
        String array1[] = variables.split(" ");
        principal = Double.parseDouble(array1[0]);
        rate = Double.parseDouble(array1[1]);
        time = Double.parseDouble(array1[2]);
        if (array1.length == 4) {
            times = Double.parseDouble(array1[2]);
            time = Double.parseDouble(array1[3]);
        }

        switch (request) {
        case 1:
            amount = simpleInterest();
            break;

        case 2:
            amount = compoundInterest();
            break;

        case 3:
            amount = futureValue();
            break;

        default:
            amount = 0.00;
            break;
        }

        return amount;

    }

    public Double simpleInterest() {
        Double simpleInterest = principal * (1 + (rate / 100 * time));

        return simpleInterest;
    }

    public Double compoundInterest() {
        Double compoundInterest = principal * Math.pow((1 + ((rate / 100) / times)), (times * time));
        return compoundInterest;
    }

    public Double futureValue() {
        Double futureValue = principal
                * (((Math.pow((1 + ((rate / 100) / times)), (times * time))) - 1) / ((rate / 100) / times));
        return futureValue;
    }
}