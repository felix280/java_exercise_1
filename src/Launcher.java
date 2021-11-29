import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print( "Bonjour vueillez entrer une commande : " );
        Scanner scanner = new Scanner( System.in );
        String a = scanner.nextLine();
        while(true)
            if(a.equals("quit")){
                return;
            }else{
                System.out.print( "Unknown command\n" );
                a = scanner.nextLine();
            }

    }
}