
import java.util.*;

class TimeMap {

    private int timestamp;
    private Map<String, List<String[]>> history;

    public TimeMap() {
        this.timestamp = 0;
        this.history = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (history.get(key) == null) {
            history.put(key, new ArrayList<>());
        }
        history.get(key).add(new String[]{(String.valueOf(timestamp)), value});
        // timestamp++;
    }

    public String get(String key, int timestamp) {
        List<String[]> ls = history.get(key);
        if (ls == null) {
            return "";     //第二次卡手
        }
        int left = 0;
        int right = ls.size();
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (Integer.parseInt(ls.get(mid)[0]) > timestamp) {
                right = mid;      //right及其右侧一定大于timestamp
            } else {
                left = mid + 1;
            }
        }
        if (left == 0) {
            return "";   //第一次卡手
        }
        return ls.get(left - 1)[1];
    }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
