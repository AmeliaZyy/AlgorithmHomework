package algorithm;

public class MaxSlidingWindow{
    public int[] maxSlidingWindow(int[] nums, int k) {
        //窗口个数len-k+1
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();

        int left = 0;
        for(int right = 0 ; right < nums.length; right++){
            //如果队列不为空，且队尾元素小于右指针对应数组元素，把队列队尾拿走
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.removeLast();
            }
            // 队列为空或当前nums[right] <= 小于新的队尾元素,那就把right放进去
            deque.addLast(right);

            //right>= k-1的时候，说明窗口已经形成
            if(right >= k-1){
                //存的第一个下标大于左指针的时候去掉队首
                if(deque.peekFirst()<left){
                deque.removeFirst();
                }
                // 否则下一个新队首一定在窗口内(因为每次只滑动一个距离)
                // 新队首就是窗口最大值，放进答案。
                res[left] = nums[deque.getFirst()];
                //左指针右移
                left++;
            }
            
        }
        return res;
    }
}