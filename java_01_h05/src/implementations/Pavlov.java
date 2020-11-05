package implementations;

import interfaces.GefangenenStrategie;

public class Pavlov implements GefangenenStrategie {
    boolean opponentsLastDecision;
    boolean lastDecision;
    int round = 0;

    public Pavlov() {
        this.round = 0;
    }

    @Override
    public boolean getNextDecision() {
        if(round++ == 0) return true;
        boolean decision = true;
        if(opponentsLastDecision != lastDecision) decision = false;
        lastDecision = decision;
        return decision;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision = decision;
    }
}
