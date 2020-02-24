package Inheritance;

public class InterfaceExample1 {
	public static void main(String[] args) {
		SeperateVolume obj1 = new SeperateVolume("863?774개", "개미", "베르베르");
		AppCDInfo obj2 = new AppCDInfo("2005-7001", "Redhat Fedora");
		obj1.checkOut("김영숙", "20060315");
		obj2.checkOut("박희경", "20060317");
		obj1.checkIn();
		obj2.checkIn();
	}
}
