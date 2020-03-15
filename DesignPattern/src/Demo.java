
public class Demo {
	public static void main(String[] args) {
		BasicSinglton s = BasicSinglton.getInstance();
		s.setVal(123);
		System.out.println(s.getVal());
		
		StaticSingleton s1 = StaticSingleton.getInstance();
		s1.setVal(222);
		System.out.println(s1.getVal());
	}
}
