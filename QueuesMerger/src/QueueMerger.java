import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class QueueMerger {

	public Queue<Integer> merger(HashMap<Integer, Queue<Integer>> queues) {
		Queue<Integer> merger = new LinkedList<Integer>();
		HashMap<Integer, Integer> minMap = new HashMap<>();
		fillWithZeroIndexValues(minMap, queues);
		do {
			fillMinValues(minMap, merger, queues);

		} while (!queues.isEmpty());
		for (int x = 0; x <= minMap.size(); x++) {
			int[] val = getMinValueWithIndex(minMap);
			merger.add(val[1]);
		}
		return merger;
	}

	private void fillMinValues(HashMap<Integer, Integer> minMap, Queue<Integer> merger,
			HashMap<Integer, Queue<Integer>> queues) {
		if (queues.isEmpty())
			return;
		emptyQueueIndex(queues);
		int[] val = getMinValueWithIndex(minMap);
		merger.add(val[1]);
		try {
			minMap.put(val[0], queues.get(val[0]).poll());
			return;
		} catch (NullPointerException e) {
			fillMinValues(minMap, merger, queues);
		}

	}

	private int[] getMinValueWithIndex(HashMap<Integer, Integer> minMap) {
		int[] minVal = new int[2];
		Entry<Integer, Integer> entry = minMap.entrySet().stream().min(Comparator.comparing(Entry::getValue))
				.orElse(null);
		if (entry == null)
			return minVal;
		minVal[0] = entry.getKey();
		minVal[1] = entry.getValue();
		minMap.remove(minVal[0]);
		return minVal;
	}

	private void fillWithZeroIndexValues(HashMap<Integer, Integer> minMap, HashMap<Integer, Queue<Integer>> queues) {
		Set<Integer> keys = queues.keySet();
		for (int x : keys) {
			minMap.put(x, queues.get(x).poll());
		}
	}

	private void emptyQueueIndex(HashMap<Integer, Queue<Integer>> queues) {
		Entry<Integer, Queue<Integer>> entry = queues.entrySet().parallelStream().filter(x -> x.getValue().isEmpty())
				.findFirst().orElse(null);
		if (entry != null)
			queues.remove(entry.getKey());
	}
}
