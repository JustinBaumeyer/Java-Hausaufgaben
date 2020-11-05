package implementations;

import interfaces.GefangenenStrategie;

public class TitForTat implements GefangenenStrategie {
    @Override
    public boolean getNextDecision() {
        return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {

    }
}
