package implementations;

import interfaces.GefangenenStrategie;

public class PerKind implements GefangenenStrategie {
    int n;

    public PerKind() {
        this.n = 1;
    }

    @Override
    public boolean getNextDecision() {
        return !(n++ % 3 == 0);
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {}
}
