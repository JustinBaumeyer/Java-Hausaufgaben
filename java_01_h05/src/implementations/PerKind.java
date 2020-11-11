package implementations;

import interfaces.GefangenenStrategie;

public class PerKind implements GefangenenStrategie {
    int n;

    public PerKind() {
        this.n = 1;
    }

    /**
     * Spielt periodisch die Folge kooperieren/kooperieren/verraten.
     * @return
     */
    @Override
    public boolean getNextDecision() {
        return !(n++ % 3 == 0);
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {}
}
