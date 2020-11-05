import implementations.*;

public class DasSpiel {
    public static void main(String[] args) {
        //Neues Objekt vom Typ GefangenenDilemma mit 2 Spielern
        GefangenenDilemma gd = new GefangenenDilemma(
                new TitForTat(),new PerKind());
        //100 mal spielen
        gd.spiele(100);


        //Neues Objekt vom Typ GefangenenDilemma mit 2 Spielern
        GefangenenDilemma gd2 = new GefangenenDilemma(
                new Pavlov(),new PerKind());
        //100 mal spielen
        gd2.spiele(100);
    }

}
