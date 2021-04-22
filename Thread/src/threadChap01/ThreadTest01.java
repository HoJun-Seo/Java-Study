package threadChap01;

public class ThreadTest01 {

	public static void main(String[] args) {
		System.out.println("main ������");
		System.out.println("main ������");
		
		System.out.println("main: "+ Thread.currentThread().getName());
		System.out.println("-----");
		
		ThreadExtend t1 = new ThreadExtend();
		
		Runnable r1 = new RunnableImple();
		Thread t2 = new Thread(r1);
		
		// start()�޼��带 ���� run()�޼��带 ȣ����.
		t1.start();
		t2.start();
		
		System.out.println("-----");
		System.out.println("main: "+ Thread.currentThread().getName());

	}

}


// ThreadŬ������ ���� ����� �޴� ���
class ThreadExtend extends  Thread{
	public void run() {
		System.out.println("Thread ���");
		for (int i=0; i<10; i++) {
			System.out.println("Thread Extend : "+i+"name : "+Thread.currentThread().getName());
			// �����尡 �����ϴ� ���� 1�ʵ��� ��� �ߴ� ��Ŵ
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
// Runnable�������̽� �����ϴ� ���
class RunnableImple  implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable ����");
		for (int i=0; i<10; i++) {
			System.out.println("Runnable implements : "+i+"name : "+Thread.currentThread().getName());
			// �����尡 �����ϴ� ���� 1�ʵ��� ��� �ߴ� ��Ŵ
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}



/*
���μ��� : �������� ���α׷��� �ǹ�
��� ���μ����ȿ��� �۾��� �����ϴ� ������ ������  ������.

�ϳ��� ���μ����� �������� �����带 ���� �� ����.
��Ƽ ������ ����.
cpu, �޸𸮸� ȿ�������� ���
����ڿ� ���� ���伺�� ����
�۾��� ������ ������ �и��ؼ� ����ð��� ���� �� �ִ�.
  
  
  1.��� -> Thread Ŭ���� ���
  2.��� -> Runnable �������̽� ����
 */