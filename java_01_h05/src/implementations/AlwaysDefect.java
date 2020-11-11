package implementations;

import interfaces.GefangenenStrategie;

public class AlwaysDefect implements GefangenenStrategie {

    /**
     * Verrät immer, egal was der Spielpartner tut.
     * @return
     */
    @Override
    public boolean getNextDecision() {
        return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {}
}
