
public class LazySingleton {

	private LazySingleton() {
		System.out.println("nothing");
	}
	
	private static LazySingleton instance;
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		
		return instance;
	}
	
	/*
	 * for multithreading multiple instance would be created so use
	 * 1) syncronized method
	 * 2) double check lock
	 */
	
	
	/*public static sunchronized LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		
		return instance;
	}*/
	
	//Double check
	
	/*public static LazySingleton getInstance() {
		if(instance == null) {
			synchronized(LazySingleton.class) {
				if(instance == null) {
					instance = new LazySingleton();
				}
			}
			
		}
		
		return instance;
	}*/
}
