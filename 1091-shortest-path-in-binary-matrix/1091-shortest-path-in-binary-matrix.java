class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0,0});
        int[] dx = {-1,1,0,0,-1,1,-1,1};
        int[] dy = {0,0,1,-1,-1,1,1,-1};
        while(!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.peek()[1];
            int dist = queue.peek()[2];
            queue.poll();
            if(a == grid.length - 1 && b == grid.length - 1) {
                return dist + 1; 
            } 
           
            for(int i = 0; i < 8; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] != 0) continue;
                grid[x][y] = -1;
                queue.add(new int[]{x,y,dist + 1});
            } 
        }
        return -1;
    }
}