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
public class Freq implements Command{

    @Override
    public String name() {
        String freq = "freq";
        return freq;
    }
    public boolean run(Scanner scanner){
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


            return true;
        }
        catch(IOException e) {
            System.out.print("Unreadable file: error :\n" + e + "\n" );
            return true;
        }
    }

}