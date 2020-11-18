import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Blatt {
	private int[] values;

	/**
	 * Konstruktor der Klasse Blatt.
	 * @param v Symbolisiert die Werte der Karten
	 */
	public Blatt(int[] v) {
		this.setValues(v);
	}

	/**
	 * Setter des Attributs values, welcher überprüft, ob die Länge des Arrays genau 3 beträgt. Falls dem nicht so ist,
	 * wird eine IllegalArgumentException geworfen!
	 * @param values
	 */
	public void setValues(int[] values) {
		if(values.length != 3) {
			throw new IllegalArgumentException("Length of v must be 3!");
		}
		this.values = values;
	}

	/**
	 * Gibt ein Entry zurück, welcher die Information enthält, welche Karte wie oft in der Hand enthalten ist.
	 * Bsp:
	 * Hand: [5,5,9]
	 * Return: {5=2,9=1}
	 * @return
	 */
	public Map.Entry<Integer,Integer> getMaxDuplicates() {
		Map<Integer, Integer> res = new HashMap<>();
		IntStream.of(this.values).forEach(i -> {
				res.put(i,Optional.ofNullable(res.get(i)).orElse(0)+1);
		});
		return res.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	}

	/**
	 * Gibt den Wert der Karte zurück, die nicht im Paar zu finden ist. Falls es ein Drilling ist, wird
	 * einfach der Wert der Karte ausgegeben, aus welchem der Drilling besteht, da sonst eine ArrayIndexOutOfBoundsException droht.
	 * @return
	 */
	public int getAdditionalCard() {
		Map.Entry<Integer,Integer> res = getMaxDuplicates();
		if(res.getValue() == values.length) return res.getKey();
		return IntStream.of(this.values).filter(x -> x != res.getKey()).limit(1).toArray()[0];
	}

	/**
	 * Gibt die Summe der Einträge im values Array zurück.
	 * @return
	 */
	public int getSum() {
		return IntStream.of(this.values).sum();
	}

	/**
	 * Gibt das Objekt Blatt als String aus, welcher aus den Komma-Separierten Einträgen des Attributs values besteht.
	 * @return
	 */
	@Override
	public String toString() {
		return IntStream.of(this.values).mapToObj(Integer::toString).collect(Collectors.joining(", "));
	}

	
}
