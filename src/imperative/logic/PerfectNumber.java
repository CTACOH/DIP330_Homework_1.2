package imperative.logic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class PerfectNumber {
		
	public static STATE process(int n) {		
		Integer divisorsSum = IntStream
					.rangeClosed(2, (int) Math.sqrt(n))
					.reduce(1, (sum, i) -> n % i == 0 ? i*i == n ? (sum + i + (n/i)) - i : sum + i + (n/i) : sum);		
		return divisorsSum == 1 ? STATE.DEFICIENT : (divisorsSum == n ? STATE.PERFECT : (divisorsSum < n ? STATE.DEFICIENT : STATE.ABUNDANT));
	}

	public  static Set<Integer> divisors(int n)	{				
		return IntStream
					.rangeClosed(1, n)
					.filter((i) -> n % i == 0)
					.boxed()
					.collect(Collectors.toCollection(HashSet::new));
	}

}
