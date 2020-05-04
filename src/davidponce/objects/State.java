package davidponce.objects;

public class State {
    private Integer state;
    private String symbol;
    private Integer direction;

    public State(Integer state, String symbol, Integer direction) {
        this.state = state;
        this.symbol = symbol;
        this.direction = direction;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}
