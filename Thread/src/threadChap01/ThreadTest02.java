package threadChap01;

public class ThreadTest02 {
	
	public static void main(String[] args) {
		
		// �͸����� runnable���� 
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Runnable ����");
				
				for (int i=0; i<10; i++) {
					System.out.println("Runnable implements : "+i+", name : "+Thread.currentThread().getName());
					// �����尡 �����ϴ� ���� 1�ʵ��� ��� �ߴ� ��Ŵ
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// ���ٽ� ǥ�� : �͸����� runnable����  //
		Thread t2 = new Thread( ()->{
			System.out.println("Runnable ����: ���ٽ�");
			
			for (int i=0; i<10; i++) {
				System.out.println("Runnable implements ���ٽ� : "+i+", name : "+Thread.currentThread().getName());
				// �����尡 �����ϴ� ���� 1�ʵ��� ��� �ߴ� ��Ŵ
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
