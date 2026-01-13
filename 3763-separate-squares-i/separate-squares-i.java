import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

class Solution {
    public double separateSquares(int[][] squares) {
        double low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int[] square : squares) {
            int y = square[1], l = square[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double EPSILON = 1e-6; 
        while (high - low > EPSILON) {
            double mid = (low + high) / 2;
            double areaDiff = getAreaDifference(mid, squares);

            if (areaDiff > 0) { 
                low = mid;
            } else {
                high = mid;
            }
        }
        return new BigDecimal(low).setScale(5, RoundingMode.HALF_UP).doubleValue();
    }

    private double getAreaDifference(double yMid, int[][] squares) {
        double areaAbove = 0, areaBelow = 0;

        for (int[] square : squares) {
            int y = square[1], l = square[2];
            int topY = y + l;

            if (yMid >= topY) {
                areaBelow += (double) l * l; // Entirely below
            } else if (yMid <= y) {
                areaAbove += (double) l * l; // Entirely above
            } else {
                double abovePart = (topY - yMid) * l;
                double belowPart = (yMid - y) * l;
                areaAbove += abovePart;
                areaBelow += belowPart;
            }
        }

        return areaAbove - areaBelow;
    }
}
