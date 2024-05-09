import java.util.Scanner;

public class App {
    public static void main(String agrs[]){
        Scanner scanner = new Scanner( System.in);

        String mathOperation;
        PolishNotationConvertion polishNotationConvertion = new PolishNotationConvertion();
        String result;

        while(!(mathOperation = scanner.nextLine()).equals("FIM")){

            result = polishNotationConvertion.mathExpressionConversion(mathOperation);


            System.out.print(result +"\n");
        }

        scanner.close();
    }
}
