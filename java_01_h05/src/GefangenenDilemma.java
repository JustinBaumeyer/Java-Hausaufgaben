import interfaces.GefangenenStrategie;

public class GefangenenDilemma {
    GefangenenStrategie player1,player2;

    /**
     * Nimmt zur initialisierung die Strategien der beiden Spieler.
     * @param p1 Strategie Spieler 1
     * @param p2 Strategie Spieler 2
     */
    public GefangenenDilemma(GefangenenStrategie p1, GefangenenStrategie p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    /**
     * Vergibt die Strafpunkte je nach Entscheidung der Strategien der jeweiligen Spieler
     * und verkündet am Ende den Gewinner.
     * @param n Die Anzahl der Spielzüge, die gespielt werden sollen.
     */
    public void spiele(int n) {
        int p1 = 0, p2 = 0;
        boolean t1,t2;
        while(n-- > 0) {
            t1 = player1.getNextDecision();
            t2 = player2.getNextDecision();

            if(t1 && t2) {
                p1+=2;
                p2+=2;
            } else if(!t1 && !t2) {
                p1+=4;
                p2+=4;
            } else if(t1) {
                p1 += 6;
                p2 += 1;
            }else {
                p2 += 6;
                p1 += 1;
            }


            player1.setOpponentsLastDecision(t2);
            player2.setOpponentsLastDecision(t1);
        }

        System.out.println("Spieler 1: " + p1);
        System.out.println("Spieler 2: " + p2);
        System.out.println("Gewonnen hat : " + ((p1 < p2) ? "Spieler 1" : ((p1 == p2) ? "Unentschieden" : "Spieler 2")));
    }
}
