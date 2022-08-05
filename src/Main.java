import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter a number to check is good or not : ");
        Integer enteredNumber = scanner.nextInt();
        sumCubeOfDigits(enteredNumber);
    }

    private static void sumCubeOfDigits(Integer number) {
        try {
            String[] digitsOfNum = number.toString().split("");
            Double sumOfPowDigitNum = Arrays.stream(digitsOfNum).
                    map(x -> Math.pow(Integer.parseInt(x), 2)).
                    reduce(0.0, (a, b) -> a + b);
//            System.out.println(sumOfPowDigitNum);
            if (sumOfPowDigitNum==1){
                System.out.println("this number is happy");

            }else{
                sumCubeOfDigits(sumOfPowDigitNum.intValue());
            }
        } catch(StackOverflowError e) {
            System.out.println("Caught : 00 "+e);
            System.out.println("nooo  this number is not happy");
            e.getMessage();
        }
    }
}
