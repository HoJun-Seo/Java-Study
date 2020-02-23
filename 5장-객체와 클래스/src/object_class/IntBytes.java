package object_class;

public class IntBytes {
	static byte firstByte(int num) { //int 타입 데이터의 첫번째 바이트를 리턴
		num = (num >> 24) & 0xFF;
		return (byte)num;
	}
	static byte secondByte(int num) { //int 타입 데이터의 두번째 바이트를 리턴
		num = (num >> 16) & 0xFF;
		return (byte)num;
	}
	static byte thirdByte(int num) { //int 타입 데이터의 세번째 바이트를 리턴
		num = (num >> 8) & 0xFF;
		return (byte)num;
	}
	static byte forthByte(int num) { //int 타입 데이터의 네번째 바이트를 리턴
		num = num & 0xFF;
		return (byte)num;
	}
}
