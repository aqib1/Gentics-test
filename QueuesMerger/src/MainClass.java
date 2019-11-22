import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

	public static void main(String[] args) {
		// 2, 9, 15
		// 3, 6, 8
		// 9, 10, 12
		Queue<Integer> queue1 = new LinkedList<>(Arrays.asList(2, 9, 15));
		System.out.println(queue1.poll());
		System.out.println(queue1);
	}

}
