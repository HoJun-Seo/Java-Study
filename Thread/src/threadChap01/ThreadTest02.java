package threadChap01;

public class ThreadTest02 {
	
	public static void main(String[] args) {
		
		// 익명으로 runnable구현 
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Runnable 구현");
				
				for (int i=0; i<10; i++) {
					System.out.println("Runnable implements : "+i+", name : "+Thread.currentThread().getName());
					// 쓰레드가 수행하는 동안 1초동안 잠시 중단 시킴
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// 람다식 표현 : 익명으로 runnable구현  //
		Thread t2 = new Thread( ()->{
			System.out.println("Runnable 구현: 람다식");
			
			for (int i=0; i<10; i++) {
				System.out.println("Runnable implements 람다식 : "+i+", name : "+Thread.currentThread().getName());
				// 쓰레드가 수행하는 동안 1초동안 잠시 중단 시킴
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		});
		
		// -------------------
		t1.start();
		t2.start();
		
	}

}
