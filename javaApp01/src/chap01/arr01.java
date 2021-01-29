package chap01;

public class arr01 {

	public static void main(String[] args) {
		
		int[] score = new int[3];
		int number = 100;
		for(int i = 0; i < score.length; i++) {
			score[i] = number;
			number += 100;
		}
		
		System.out.println(score[0] + "," + score[1] + "," + score[2]);
	}

}
