package davidponce.objects;

import java.util.List;

public class Tape {
    private List<String> tape;
    private Integer initialState;
    private Integer actualState;
    private Integer finalState;
    public Integer pointerPosition;

    public Tape(List<String> symbols, Integer initialState, Integer finalState) {
        this.tape = symbols;
        this.initialState = initialState;
        this.actualState = this.initialState;
        this.finalState = finalState;
        this.pointerPosition = 0;
    }

    public List<String> getTape() { return tape; }

    public void setTape(List<String> tape) { this.tape = tape; }

    public void setTapeItem(String symbol) { this.tape.set(this.pointerPosition, symbol); };

    public Integer getInitialState() { return initialState; }

    public void setInitialState(Integer initialState) { this.initialState = initialState; }

    public Integer getActualState() { return actualState; }

    public void setActualState(Integer actualState) { this.actualState = actualState; }

    public Integer getFinalState() { return finalState; }

    public void setFinalState(Integer finalState) { this.finalState = finalState; }

    public void movePointer(Integer direction) { this.pointerPosition += direction; };
}
