package implementations;

import interfaces.GefangenenStrategie;

public class TitForTat implements GefangenenStrategie {
    int round;
    boolean opponentsLastDecision;

    public TitForTat() {
        this.round = 0;
    }

    /**
     * Kooperiert in der ersten Runde und kopiert in den nächsten Runden den vorherigen Spielzug des Spielpartners.
     * @return
     */
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
