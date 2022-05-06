public class CurriculumTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];//以课程数量为入度数组长度
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;//p里的第一位这个数字作为索引？然后这个索引上的元素+1
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);//offer添加一个元素并返回true
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();//poll移除并返问队列头部的元素 如果队列为空，则返回null
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr){//如果它前面必须要学的课就是这个可以学完的课，入度减一
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);//如果P0入度减到0了，可以学完了，把它放进队列
                }
            }
        }
        if (count == numCourses) return res;//count是从0开始加的，所以如果加到满了课程数量可以返回结果了
        return new int[0];  
        }
}
