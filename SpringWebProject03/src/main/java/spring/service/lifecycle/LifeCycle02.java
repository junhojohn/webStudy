package spring.service.lifecycle;

public class LifeCycle02 {

	private static volatile LifeCycle02 lifecycle02;
	
	private LifeCycle02() {
		System.out.println(getClass().getName() + " Default constructor.");
	}
	
	public static LifeCycle02 getInstance() {
		System.out.println("LifeCycle02.getInstance()");
		if(lifecycle02 == null) {
			synchronized (LifeCycle02.class) {
				if(lifecycle02 == null) {
					lifecycle02 = new LifeCycle02();
				}
			}
		}
		return lifecycle02;
	}
	
}
