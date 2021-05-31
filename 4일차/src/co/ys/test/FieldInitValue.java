package co.ys.test;

import java.util.Arrays;

// 기본 데이터형 8타입은 기본값음 0으로 초기화, 참조 변수(String, [])는 null
public class FieldInitValue {
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	boolean bool;
	char c;
	String str;
	int[] arr;
	
	FieldInitValue() {}
	FieldInitValue (int num, double db) {
		i = num;
		d = db;
	}
	
	@Override
	public String toString() {
		return "FieldInitValue [b=" + b + ", s=" + s + ", i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + ", bool="
				+ bool + ", c=" + c + ", str=" + str + ", arr=" + Arrays.toString(arr) + "]";
	}
}
