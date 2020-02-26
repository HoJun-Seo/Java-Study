package access_control;

public class Point3D extends Point{
	int z;
	Point3D(int x, int y, int z){
		super(x, y);
		this.z = z;
	}
	protected int getX() {
		return x;
	}
	protected int getY() {
		return y;
	}
	//오버라이드 하는 메소드는 상속받은 메소드의 접근 허용 범위보다 같거나 더 넓은 범위의 접근을 허용해야 한다.
	//상속받은 메소드가 protected 메소드일 경우, 오버라이드 하는 메소드는 protected 나 public 키워드 중 하나를 사용해야 한다.
	//다시 말해 private 키워드를 사용하거나, 접근 제어 수식어를 사용하지 않으면 안된다는 뜻.
	int getZ() {
		return y;
	}
}
