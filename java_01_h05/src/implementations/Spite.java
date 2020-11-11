package implementations;

import interfaces.GefangenenStrategie;

public class Spite implements GefangenenStrategie {
    boolean cooperate;

    public Spite() {
        this.cooperate = true;
    }

    /**
     * Kooperiert solange, bis der Mitspieler zum ersten Mal verrät. Verrät danach immer.
     * @return
     */
    @Override
    public boolean getNextDecision() {
        return cooperate;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        if(!decision) cooperate = false;
    }
}
