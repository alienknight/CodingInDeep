import java.io.*;
import java.util.*;

public class Test {
//	public static int count(int a) {
//		int res = 0;
//		for(int i=0;i<32;i++) {
//			int temp = (1<<i) & a;
//			res = temp == 0 ? res : res+1;
//		}
//		return res;
//	}
	public static int count(int a) {
		int res = 0;
		for(int i=0;i<32;i++) {
			res = ((a>>i) & 1) == 0 ? res : res+1;
		}
		return res;
	}
	public static void main(String[] args) {
		int a = 7
				;
		System.out.print(count(a));
	}
}
