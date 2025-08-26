import java.util.*;

class Router {

    private static class Packet {
        int source, destination, timestamp;

        Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }
    }

    int memoryLimit;
    ArrayDeque<Packet> queue;       // 存储数据包
    Set<String> packetSet;          // 存储source dest timestamp唯一记录
    Map<Integer, List<Integer>> destTimeList; // 存储dest - 有序timestamp列表

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.destTimeList = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) {
            return false;
        }

        if (queue.size() == memoryLimit) {
            Packet old = queue.pollFirst();
            String oldKey = old.source + "#" + old.destination + "#" + old.timestamp;
            packetSet.remove(oldKey);

            List<Integer> timeList = destTimeList.get(old.destination);
            int idx = Collections.binarySearch(timeList, old.timestamp);
            timeList.remove(idx);
            if (timeList.isEmpty()) {
                destTimeList.remove(old.destination);
            }
        }

        Packet p = new Packet(source, destination, timestamp);
        queue.offerLast(p);
        packetSet.add(key);

        List<Integer> timeList = destTimeList.computeIfAbsent(destination, k -> new ArrayList<>());
        int idx = Collections.binarySearch(timeList, timestamp);
        if (idx < 0) idx = -idx - 1;
        timeList.add(idx, timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[0];
        }

        Packet p = queue.pollFirst();
        String key = p.source + "#" + p.destination + "#" + p.timestamp;
        packetSet.remove(key);

        List<Integer> timeList = destTimeList.get(p.destination);
        int idx = Collections.binarySearch(timeList, p.timestamp);
        timeList.remove(idx);
        if (timeList.isEmpty()) {
            destTimeList.remove(p.destination);
        }

        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimeList.containsKey(destination)) {
            return 0;
        }
        List<Integer> timeList = destTimeList.get(destination);
        int left = lowerBound(timeList, startTime);
        int right = upperBound(timeList, endTime);
        return right - left;
    }

    // 二分查找第一个 >= target 的下标
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // 二分查找第一个 > target 的下标
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */