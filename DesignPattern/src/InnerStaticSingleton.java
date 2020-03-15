
public class InnerStaticSingleton {
	private InnerStaticSingleton() {}
	
	private static class Impl{
		private static final InnerStaticSingleton instance = new InnerStaticSingleton();
	}
	
	public static InnerStaticSingleton getInstance() {
		return Impl.instance;
	}

}
