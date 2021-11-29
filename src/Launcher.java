import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print( "Veuillez saisir un premier entier : " );
        Scanner scanner = new Scanner( System.in );
        String a = scanner.nextLine();

        if(a.equals("quit")){

        }else{
            System.out.print( "Unknown command" );
        }

    }
}