package implementations;

import interfaces.GefangenenStrategie;

public class Spite implements GefangenenStrategie {
    boolean cooperate;

    public Spite() {
        this.cooperate = true;
    }

    @Override
    public boolean getNextDecision() {
        return cooperate;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        if(!decision) cooperate = false;
    }
}
