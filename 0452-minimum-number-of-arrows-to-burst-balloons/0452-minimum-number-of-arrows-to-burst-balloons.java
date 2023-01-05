class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));
        int arrows = 0;
        int index = 0;
        while(index < points.length) {
            int high = points[index][1];
            System.out.println(high);
            while(index < points.length && points[index][0] <= high) {
                index++;  
            } 
            arrows++;
            System.out.println(arrows);
        }
        return arrows;
    }
}