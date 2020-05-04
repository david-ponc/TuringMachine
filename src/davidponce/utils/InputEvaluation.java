package davidponce.utils;

import davidponce.controllers.AppController;
import davidponce.objects.State;
import davidponce.objects.Tape;
import davidponce.objects.TuringMachine;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.util.Pair;

import java.util.*;

public class InputEvaluation {
    public final AppController appController;

    public InputEvaluation(AppController appController) {
        this.appController = appController;
    }

    public Map<String, Object> evaluate(TuringMachine turingMachine, List<String> input) {
        ArrayList<String> steps = new ArrayList<>();
        List<List<String>> tapeStates = new ArrayList<List<String>>();
        List<Integer> pointerPositions = new ArrayList<>();
        Map<Integer, Map<String, State>> table = turingMachine.getTable();
        input.add("B");
        Integer i = 0;
        Tape tape = new Tape(
                input,
                turingMachine.getInitialState(),
                turingMachine.getFinalState()
        );
        while(!tape.getActualState().equals(tape.getFinalState())) {
            try {
                tapeStates.add(new ArrayList<>(tape.getTape()));
                pointerPositions.add(tape.pointerPosition);
                State state = table
                        .get(tape.getActualState())
                        .get(tape.getTape().get(tape.pointerPosition));
                tape.setActualState(state.getState());
                tape.setTapeItem(state.getSymbol());
                tape.movePointer(state.getDirection());
                String dir = state.getDirection() == 1 ? "R" : "L";
                steps.add("(q" + state.getState() + ", " + state.getSymbol() + " , " + dir + ")");
            }catch (Exception e) {
                Map<String, Object> data = new HashMap<>();
                data.put("steps", steps);
                data.put("tapeStates", tapeStates);
                data.put("inputResult", false);
                data.put("pointerPositions", pointerPositions);
                return data;
            }
        }
        Map<String, Object> data = new HashMap<>();
        data.put("steps", steps);
        data.put("tapeStates", tapeStates);
        data.put("inputResult", true);
        data.put("pointerPositions", pointerPositions);
        return data;
    }
}
