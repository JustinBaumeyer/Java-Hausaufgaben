import Exceptions.UnknownNameException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EMailAdressBuch {
    HashMap<String,String> daten;

    /**
     * Erzeugt ein neues EMailAdressBuch und initialisiert die HashMap.
     */
    public EMailAdressBuch () {
        daten = new HashMap<>();
    }

    /**
     * Fügt Name und E-Mail in die HashMap ein. Wenn der Name schon vorhanden ist, wird die E-Mail aktualisiert.
     * @param name Name der Person
     * @param email E-Mail der Person
     */
    public void einfuegen(String name, String email) {
        daten.put(name,email);

    }

    /**
     * Gibt die zugehörige E-Mail der Person zurück. Wenn die Person nicht bekannt ist, wird eine
     * UnknownNameException geworfen.
     * @param name Name der Person
     * @return E-Mail der Person
     * @throws UnknownNameException
     */
    public String abfrage(String name) throws UnknownNameException {
        if(!daten.containsKey(name)) throw new UnknownNameException("Der Name ist nicht bekannt!");

        return daten.get(name);
    }

    /**
     * Ließt eine Datei mit Namen und E-Mail Adressen ein, welche pro Zeile vorliegen
     * Der Name und die E-Mail ist mit einem ';' getrennt.
     * @param dateiname Datei mit den Daten
     * @throws FileNotFoundException
     */
    public void einlesen(String dateiname) throws FileNotFoundException {
        File f = new File(dateiname);
        Scanner sc = new Scanner(f);

        String[] line;
        while(sc.hasNextLine()) {
            line=sc.nextLine().split(";");
            if(line.length == 2) einfuegen(line[0],line[1]);
        }
    }

    /**
     * @return
     * Gibt das EMailAdressBuch im gewünschten Format
     * {<name1>=<email1>, <name2>=<email2>, <name3>=<email3>}
     * zurück.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("{");
        daten.forEach((name,email)-> {
            output.append(name).append("=").append(email).append(", ");
        });
        output.setLength(output.length()-2);
        output.append("}");

        return output.toString();
    }
}
