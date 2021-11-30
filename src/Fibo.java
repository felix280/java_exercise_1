import java.util.Scanner;
public class Fibo implements Command{
    @Override
    public String name(){
        String fibo = "fibo";
        return fibo;
    }
    public boolean run(Scanner scanner){
        System.out.printf( "Entrez un nombre :");
        int number = scanner.nextInt();

        int fn1 =0, fn2=1;
        int result =0;
        if(number<2){
            System.out.printf( "Resultat : %d\n", number );
            return true;
        }else{
            for (int i=1; i<number; i++)
            {
                result= fn1 + fn2;
                fn1 =fn2;
                fn2= result;
            }
            System.out.printf( "Resultat : %d\n", result );
            return true;
        }
    }

}