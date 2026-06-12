public class Test {
    public static void main(String[] args) {

        int number1 = 0;
        int number2 = 0;

        try{
            number1 = Integer.parseInt(args[0]);
            number2 = Integer.parseInt(args[1]);

            double result = number1/number2;

            System.out.println("Resule");
        } catch (ArithmeticException e)
        {
            System.out.println("Devider can not be zero.");
        }
        catch (NumberFormatException e)
        {
            System.out.println("You must enter numbers only");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("You must have enter two numbers");
        }

        System.out.println("Exiting");
    }
}
