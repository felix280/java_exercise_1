import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;


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
            else if(a.equals("freq")){
                System.out.printf( "Entrez le chemin absolue du fichier texte :");
                String Chemin = scanner.nextLine();
                try{
                    Path fichier = Paths.get(Chemin);
                    String content = Files.readString(fichier);
                    String[] words = content.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
                    Stream<String> stream = Arrays.stream(words);
                    Map<String, Long> result =
                            stream.collect(
                                    Collectors.groupingBy(
                                            Function.identity(), Collectors.counting()
                                    )
                            );
                    Map<String, Long> finalMap = new LinkedHashMap<>();
                    result.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                                    .reversed()).limit(3).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
                    for (Map.Entry<String, Long> pair : finalMap.entrySet()) {
                        System.out.print(String.format("%s ", pair.getKey()));
                    }


                    return;
                }
                catch(IOException e) {
                    System.out.print("Unreadable file: error :\n" + e + "\n" );

                }

            }
            else{
                System.out.print("Unknown command\n" );
                a = scanner.nextLine();
            }

    }
}