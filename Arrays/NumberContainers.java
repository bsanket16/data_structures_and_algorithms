package Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberContainers {

    HashMap<Integer, Integer> hm;

    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        obj.change(1, 10);
        int x = obj.find(10);
        System.out.println(x);
    }

    public NumberContainers() {
        hm = new HashMap<>();
    }

    public void change(int index, int number) {
        hm.put(index, number);
    }

    public int find(int number) {

        int ret = -1;

        for(Map.Entry<Integer, Integer> e : hm.entrySet()) {

            if (e.getValue() == number) {
                if (ret == -1) {
                    ret = e.getKey();
                }
                else {
                    if (ret > e.getKey()) {
                        ret = e.getKey();
                    }
                }
            }
        }

        return ret;
    }
}
