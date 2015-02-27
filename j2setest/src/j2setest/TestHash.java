package j2setest;

public class TestHash {

	@Override
	public int hashCode() {
		int result = 17;
		return 37 * result + in;
//		 int result = 17;   
//		 3.  result = 37 * result + Float.floatToIntBits(this.re);   
//		 4.  result = 37 * result + Float.floatToIntBits(this.im);   
//		 5.  return result;   

	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof TestHash) {
			if(in == ((TestHash)obj).in) {
				return true;
			}
		}
		return false;
	}

	public int in;
	
	public TestHash(int in) {
		this.in = in;
	}
	
	
}
