package davidponce.utils;

import davidponce.objects.State;
import davidponce.objects.TuringMachine;

import java.io.*;
import java.util.*;

public class ConfigurationRules {
    public static void setConfigurationRules(
            File file,
            TuringMachine turingMachine
    ) throws IOException {
        if(file.canRead()) {
            BufferedReader reader = new BufferedReader( new FileReader(file));
            List<String> line = Arrays.asList(reader.readLine().split(" "));
            turingMachine.setStatesNumber(Integer.parseInt(line.get(0)));
            turingMachine.setSymbolsNumber(Integer.parseInt(line.get(1)));
            line = Arrays.asList(reader.readLine().split(""));
            turingMachine.setAlphabet(line);
            Map<Integer, Map<String, State>> table = new HashMap<>();
            for (int stateIndex = 0; stateIndex < turingMachine.getStatesNumber(); stateIndex++) {
                line = Arrays.asList(reader.readLine().split(" "));
                int j = 0;
                Map<String, State> states = new HashMap<>();
                for (int symbolIndex = 0; symbolIndex < turingMachine.getSymbolsNumber(); symbolIndex++) {
                    states.put(turingMachine.getAlphabetItem(symbolIndex), new State(
                            Integer.parseInt(line.get(j)),
                            line.get(j + 1),
                            Integer.parseInt(line.get(j + 2))
                    ));
                    table.put(stateIndex, states);
                    j += 3;
                }
            }
            turingMachine.setTable(table);
            line = Arrays.asList(reader.readLine().split(" "));
            turingMachine.setInitialState(Integer.parseInt(line.get(0)));
            line = Arrays.asList(reader.readLine().split(" "));
            turingMachine.setFinalState(Integer.parseInt(line.get(0)));
        }else {
            // Alert (Error file)
            System.out.println("Alert (Error file)");
        }
    }
}
