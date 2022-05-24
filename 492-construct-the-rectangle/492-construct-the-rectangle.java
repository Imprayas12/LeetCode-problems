import java.util.*;
class Solution {
   public static int[] constructRectangle(int area) {
        if (area == 0)
            return new int[]{0};

        return constructRectangle(area, (int) Math.sqrt(area));
    }

    private static int[] constructRectangle(int area, int l) {

        if (area % l == 0)
            return new int[]{(area / l), l};

        return constructRectangle(area, l - 1);
    }
}