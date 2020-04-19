package davidponce.utils;

import davidponce.objects.State;
import davidponce.objects.TuringMachine;

import java.io.*;
import java.util.*;

public class ConfigurationRules {
    public static TuringMachine setConfigurationRules(File file, TuringMachine turingMachine) throws IOException {
        if(file.canRead()) {
            BufferedReader reader = new BufferedReader( new FileReader(file));
            List<String> line = Arrays.asList(reader.readLine().split(" "));
            turingMachine.setStates(Integer.parseInt(line.get(0)));
            turingMachine.setSymbols(Integer.parseInt(line.get(1)));
            line = Arrays.asList(reader.readLine().split(""));
            turingMachine.setAlphabet(line);
            line = Arrays.asList(reader.readLine().split(" "));
            for (int i = 0; i < turingMachine.getSymbols(); i++) {
                new State(
                    Integer.parseInt(line.get(i)),
                    line.get(i + 1),
                    line.get(i + 2)
                );
            }
            System.out.println(line);
            Map<Integer, List<State>> table = new HashMap<>();
        }else {
            // Alert (Error file)
            System.out.println("Alert (Error file)");
        }
        return turingMachine;
    }
}
