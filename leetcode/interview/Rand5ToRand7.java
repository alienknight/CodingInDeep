
public class Rand5ToRand7 {
	int num = 5 * rand5() + rand5();
	if(num < 21)
		return num % 21;
}
