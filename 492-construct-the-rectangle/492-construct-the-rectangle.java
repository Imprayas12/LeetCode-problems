import java.util.*;
class Solution {
   public static int[] constructRectangle(int area) {
        if (area == 0)// Edge Case
            return new int[]{0};
        return constructRectangle(area,(int)Math.sqrt(area)); 
       //Calling helper method, passing width as max possible width.
    }

    private static int[] constructRectangle(int area, int w) {
        if (area % w == 0) //Wherever current width is a factor, difference b/w length and current width will be minimum.
            return new int[]{(area / w), w};
        return constructRectangle(area, w - 1); //Decreasing width by 1.
    }
}