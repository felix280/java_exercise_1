import java.util.Scanner;
import java.util.List;
import java.util.*;


public class Launcher {
    public static void main(String[] args) {
        System.out.print("Bonjour vueillez entrer une commande : ");
        int CmdConnue =0;
        boolean verif;
        List<Command> Listcommandes = new LinkedList<>();
        Listcommandes.add(new Quit());
        Listcommandes.add(new Fibo());
        Listcommandes.add(new Freq());
        Scanner scanner = new Scanner(System.in);
        do {
            String a = scanner.nextLine();
            for(int i=0 ; i<Listcommandes.size(); i++){
                if(a.equals(Listcommandes.get(i).name())) {
                    verif = Listcommandes.get(i).run(scanner);
                    if(verif == true){
                        CmdConnue++;
                    }
                    else{
                        return;
                    }

                }
            }
            if(CmdConnue == 0){
                System.out.print("Unknown Command\n");
            }

        }while (CmdConnue == 0);


    }
}