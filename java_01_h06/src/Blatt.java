import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Blatt {
	private int[] values;
	
	public Blatt(int[] v) {
		this.setValues(v);
	}

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		if(values.length != 3) {
			throw new IllegalArgumentException("Length of v must be 3!");
		}
		this.values = values;
	}
	
	public int getHighestCard() {
		return IntStream.of(values).max().getAsInt();
	}
	
	public int getMaxDuplicates() {
		Map<Integer, Integer> res = new Map;
		return 
	}
	
	@Override
	public String toString() {
		
		return IntStream.of(values).mapToObj(Integer::toString).collect(Collectors.joining(", "));
	}

	
}
