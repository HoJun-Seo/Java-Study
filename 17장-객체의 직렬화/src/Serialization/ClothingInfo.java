package Serialization;

public class ClothingInfo extends GoodsInfo{
	String color;
	char size;
	ClothingInfo(String name, String code, int price, String color, char size){
		super(name, code, price);
		this.color = color;
		this.size = size;
	}
}
