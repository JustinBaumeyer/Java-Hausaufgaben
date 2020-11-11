package implementations;

import interfaces.GefangenenStrategie;

public class AlwaysCooperate implements GefangenenStrategie {

    /**
     * Kooperiert immer, egal was der Spielpartner tut.
     * @return
     */
    @Override
    public boolean getNextDecision() {
        return true;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {}
}
