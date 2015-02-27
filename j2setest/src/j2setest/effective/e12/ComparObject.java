package j2setest.effective.e12;

public class ComparObject implements Comparable<ComparObject> {

	private int i;
	@Override
	public int compareTo(ComparObject o) {
		return (i < o.i) ? -1 : ((i == o.i) ? 0 : 1);
	}
}
