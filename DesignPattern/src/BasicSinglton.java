
public class BasicSinglton {

	private BasicSinglton() {}
	
	private static final BasicSinglton INSTANCE = new BasicSinglton();
	
	public static BasicSinglton getInstance() {
		return INSTANCE;
	}
	
	int val;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
}
