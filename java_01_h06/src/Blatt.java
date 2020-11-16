import java.util.*;
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

	
	public Map.Entry<Integer,Integer> getMaxDuplicates() {
		Map<Integer, Integer> res = new HashMap<>();
		for(int i : this.values) {
			if(res.containsKey(i)) {
				res.put(i,res.get(i)+1);
			} else {
				res.put(i,1);
			}
		}
		return res.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	}

	public int getAdditionalCard() {
		Map.Entry<Integer,Integer> res = getMaxDuplicates();
		if(res.getValue() == 3) return res.getKey();
		return IntStream.of(this.values).filter(x -> x != res.getKey()).limit(1).toArray()[0];
	}

	public int getSum() {
		return IntStream.of(this.values).sum();
	}
	
	@Override
	public String toString() {
		return IntStream.of(this.values).mapToObj(Integer::toString).collect(Collectors.joining(", "));
	}

	
}
