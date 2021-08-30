package kr.smhrd.util;


public class MyUtil {
	   
	public int hab() {
		int sum = 0;
		for (int i = 1; i <=100; i++) {
			sum+=i;
		}
		return sum;
	}
	
	// 오버로딩
	public int hab(int su1, int su2) {
		int sum = 0;
		for (int i = su1; i <=su2; i++) {
			sum+=i;
		}
		return sum;
	}

	
}
