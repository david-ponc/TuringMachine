package davidponce.objects;

import java.util.List;
import java.util.Map;

public class TuringMachine {
    private Integer statesNumber;
    private Integer symbolsNumber;
    private List<String> alphabet;
    private Map<Integer, Map<String, State>> table;
    private Integer initialState;
    private Integer finalState;

    public Integer getStatesNumber() {
        return statesNumber;
    }

    public void setStatesNumber(Integer states) {
        this.statesNumber = states;
    }

    public Integer getSymbolsNumber() {
        return symbolsNumber;
    }

    public void setSymbolsNumber(Integer symbols) {
        this.symbolsNumber = symbols;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public String getAlphabetItem(int index) { return alphabet.get(index); }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

    public Map<Integer, Map<String, State>> getTable() { return table; }

    public void setTable(Map<Integer, Map<String, State>> table) { this.table = table; }

    public Integer getInitialState() {
        return initialState;
    }

    public void setInitialState(Integer initialState) {
        this.initialState = initialState;
    }

    public Integer getFinalState() {
        return finalState;
    }

    public void setFinalState(Integer finalState) {
        this.finalState = finalState;
    }
}
