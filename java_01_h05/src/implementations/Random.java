package implementations;

import interfaces.GefangenenStrategie;

public class Random implements GefangenenStrategie {
    java.util.Random rnd = new java.util.Random();

    /**
     * Verrät oder kooperiert aufgrund eines 50:50-Zufallsentscheids.
     * @return
     */
    @Override
    public boolean getNextDecision() {
        return rnd.nextBoolean();
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {}
}
