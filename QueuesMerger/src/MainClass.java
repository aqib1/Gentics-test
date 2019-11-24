import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

	public static void main(String[] args) {
		// 2, 9, 15
		// 3, 6, 8
		// 9, 10, 12
		Queue<Integer> queue1 = new LinkedList<>(Arrays.asList(2, 9, 15, 22 , 38));
		Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(3, 6, 8, 21, 23));
		Queue<Integer> queue3 = new LinkedList<>(Arrays.asList(9, 10, 12, 25, 27));
		HashMap<Integer, Queue<Integer>> queueMap = new HashMap<>();
		queueMap.put(0, queue1);
		queueMap.put(1, queue2);
		queueMap.put(2, queue3);
		QueueMerger merger = new QueueMerger();
		System.out.println(merger.merger(queueMap));
		
	}

}
