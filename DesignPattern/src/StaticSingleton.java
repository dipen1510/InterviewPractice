import java.io.File;

public class StaticSingleton {

	private StaticSingleton() throws Exception {
		File f = new File("xyz");
	}
	
	private static  StaticSingleton INSTANCE;
	
	static {
		try {
			INSTANCE = new StaticSingleton();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static StaticSingleton getInstance() {
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
