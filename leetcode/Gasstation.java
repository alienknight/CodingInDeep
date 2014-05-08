public class Gasstation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (gas.length != cost.length)
			return -1;
		for (int i = 0; i < gas.length; i++) {
			int vol = 0;
			int j = i;
			boolean mark = false;
			for (; j < gas.length; j++) {
				vol += gas[j] - cost[j];
				if (vol < 0) {
					mark = true;
					break;
				}
			}
			if (mark)
				continue;
			for (j = 0; j < i; j++) {
				vol += gas[j] - cost[j];
				if (vol < 0)
					break;
			}
			if (j == i)
				return i;
		}
		return -1;
	}
}

/*
 *     public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(gas.length != cost.length)
            return -1;
        int sum = 0;
        int res = 0;
        int j = -1;
        for(int i=0;i<gas.length;i++) {
            sum += gas[i] - cost[i];
            res += gas[i] - cost[i];
            if(sum < 0) {
                j = i;
                sum = 0;
            }
        }
        return res < 0 ? -1 : j+1;
    }*/
