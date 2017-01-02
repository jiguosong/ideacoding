package dp.src;

import java.util.ArrayDeque;
import java.util.Deque;

/**
* Created by songjiguo on 1/2/17.
*/ //	Moving Average from Data Stream
class MovingAverage {
    Deque<Integer> queue = null;
    int sum = 0;
    int size = 0;
    int avg = 0;

    MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<Integer>();
    }

    public int next(int val){
        queue.offer(val);
        sum += val;

        if(queue.size() <= 3 && queue.size() > 0) {
            avg = sum/queue.size();
        } else {
            int tmp = queue.peek();
            sum -= tmp;
            avg = sum/size;
            queue.poll();
        }
        return avg;
    }
}
