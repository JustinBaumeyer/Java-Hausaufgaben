package implementations;

import interfaces.GefangenenStrategie;

public class TitForTat implements GefangenenStrategie {
    int round;
    boolean opponentsLastDecision;

    public TitForTat() {
        this.round = 0;
    }

    @Override
    public boolean getNextDecision() {
        if(round++ == 0) return true;
        return opponentsLastDecision;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        this.opponentsLastDecision = decision;
    }
}
