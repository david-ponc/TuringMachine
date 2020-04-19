package davidponce.objects;

import java.util.List;

public class TuringMachine {
    private Integer states;
    private Integer symbols;
    private List<String> alphabet;
    private Integer initialState;
    private Integer finalState;

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Integer getSymbols() {
        return symbols;
    }

    public void setSymbols(Integer symbols) {
        this.symbols = symbols;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

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
