package implementations;

import interfaces.GefangenenStrategie;

public class Spite implements GefangenenStrategie {
    @Override
    public boolean getNextDecision() {
        return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {

    }
}
