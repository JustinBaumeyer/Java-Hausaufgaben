package implementations;

import interfaces.GefangenenStrategie;

public class Random implements GefangenenStrategie {
    java.util.Random rnd = new java.util.Random();
    @Override
    public boolean getNextDecision() {
        return rnd.nextBoolean();
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {}
}
