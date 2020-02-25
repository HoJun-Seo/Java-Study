package Inheritance;

interface Changeable extends Resizeable, Colorable{
	//인터페이스 다중 상속
	void setFont(String font);
}
