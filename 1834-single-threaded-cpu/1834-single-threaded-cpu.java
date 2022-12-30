class Solution {
    class Task {
        int index;
        int execTime;
        Task(int index,int execTime) {
            this.index = index;
            this.execTime = execTime;
        }
    }
    public int[] getOrder(int[][] tasks_without_index) {
        /*Sort the tasks according to arrival time*/
        int[][] tasks = new int[tasks_without_index.length][3];
        for(int i = 0; i < tasks_without_index.length; i++) {
            tasks[i][0] = tasks_without_index[i][0];
            tasks[i][1] = tasks_without_index[i][1];
            tasks[i][2] = i;
        }
        Arrays.sort(tasks,(task1,task2) -> task1[0] - task2[0]);
        /* Priority Queue to store all the tasks with same or lesser arrival time than 
        the time CPU has been running, sorted according to increasing execution time else
        increasing indices.*/
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            public int compare(Task o1,Task o2) {
                if(o2.execTime == o1.execTime) {
                    return (o1.index > o2.index) ? 1 : -1;
                }
                else return (o1.execTime > o2.execTime) ? 1 : -1;
            }
        });
        int[] ans = new int[tasks.length];
        int idx = 0;
        int k = 0;
        int time = 0;
        while(k < tasks.length) {
            //If any task has become available while the CPU has been running
            while(idx < tasks.length && tasks[idx][0] <= time) {
                pq.add(new Task(tasks[idx][2],tasks[idx++][1]));
            }
            //No task was available so let CPU run till next task arrives.
            //That is, one with the minimum arrival time.
            if(pq.isEmpty()) {
                time = tasks[k][0];
                continue;
            }
            //Let the task execute one by one and increase time by execution time of tasks in queue.
            ans[k++] = pq.peek().index;
            time += pq.peek().execTime;
            pq.poll();
        }
        return ans;
    }
}