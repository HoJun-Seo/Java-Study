package classExam02;

public class ProductSaleUse {

	public static void main(String[] args) {

		ProductSale sale = new ProductSale(1, "냉장고", "삼성", "2021-01-01", 500000, 10);
		sale.calc();
		sale.print();
		System.out.println();
		sale.Input(2, "TV", "LG", "2021-1-2", 1000000, 10);
		sale.calc();
		sale.print();
	}

}
