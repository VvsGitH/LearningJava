package ex10;

public class Utilities {
	static public Comparable maxOfThree(Comparable x, Comparable y, Comparable z) {
		if (x.graterOrEqual(y) && x.graterOrEqual(z))
			return x;
		else if (y.graterOrEqual(x) && y.graterOrEqual(z))
			return y;
		else
			return z;
	}

	static public Comparable max(Comparable[] v) {
		Comparable max = v[0];
		for (Comparable elm : v) {
			if (elm.greater(max))
				max = elm;
		}
		return max;
	}

	static public int maxNum(Comparable[] v) {
		int maxNum = 1;
		Comparable max = v[0];
		for (Comparable elm : v) {
			if (elm.greater(max)) {
				max = elm;
				maxNum = 1;
			} else if (elm.equal(max)) {
				maxNum++;
			}
		}
		return maxNum;
	}
}
