import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print( "Bonjour vueillez entrer une commande : " );
        Scanner scanner = new Scanner( System.in );
        String a = scanner.nextLine();
        while(true)
            if(a.equals("quit")){
                return;
            }
            else if(a.equals("fibo")){
                System.out.printf( "Entrez un nombre :");
                int number = scanner.nextInt();

                int fn1 =0, fn2=1;
                int result =0;
                if(number<2){
                    System.out.printf( "Resultat : %d\n", number );
                    return;
                }else{
                    for (int i=1; i<number; i++)
                    {
                        result= fn1 + fn2;
                        fn1 =fn2;
                        fn2= result;
                    }
                    System.out.printf( "Resultat : %d\n", result );
                    return ;
                }

            }
            else{
                System.out.print( "Unknown command\n" );
                a = scanner.nextLine();
            }

    }
}