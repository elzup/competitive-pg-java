package aoj.intoroduction.itp1;

import java.util.Arrays;
import java.util.Scanner;

public class Q11DiceII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static class Dice {

        public static int UP = 0;
        public static int FRONT = 1;
        public static int RIGHT = 2;
        public static int LEFT = 3;
        public static int BACK = 4;
        public static int DOWN = 5;
        private int[] nums;
        private int[] ids;

        /**
         *
         * @param nums
         * - 0 - -
         * 3 1 2 4
         * - 5 - -
         */
        public Dice(int[] nums) {
            this.nums = nums;
            this.ids = new int[]{ 0, 1, 2, 3, 4, 5 };
        }

        public int getUp() { return nums[ids[UP]]; }
        public int getDown() { return nums[ids[DOWN]]; }
        public int getRight() { return nums[ids[RIGHT]]; }
        public int getLeft() { return nums[ids[LEFT]]; }
        public int getFront() { return nums[ids[FRONT]]; }
        public int getBack() { return nums[ids[BACK]]; }

        public void turnDisp(int[] order) {
            int tmp = ids[order[0]];
            int l = order.length;
            for (int i = 1; i < l; i++) {
                ids[order[i - 1]] = ids[order[i]];
            }
            ids[order[l - 1]] = tmp;
        }

        /**
         * turn{FaceName} メソッド
         * FaceName を中心に時計回り
         */
        public void turnFront() { turnDisp(new int[]{ UP, LEFT, DOWN, RIGHT }); }
        public void turnBack() { turnDisp(new int[]{ UP, RIGHT, DOWN, LEFT }); }
        public void turnLeft() { turnDisp(new int[]{ UP, BACK, DOWN, FRONT }); }
        public void turnRight() { turnDisp(new int[]{ UP, FRONT, DOWN, BACK }); }
        public void turnUp() { turnDisp(new int[]{ FRONT, RIGHT, BACK, LEFT }); }
        public void turnDown() { turnDisp(new int[]{ FRONT, LEFT, BACK, RIGHT }); }

        /** optional aliases */
        public void turnFrontRev() { turnBack(); }
        public void turnBackRev() { turnFront(); }
        public void turnLeftRev() { turnRight(); }
        public void turnRightRev() { turnLeft(); }
        public void turnUpRev() { turnDown(); }
        public void turnDownRev() { turnUp(); }

        /**
         * 手前をFrontと見て
         */
        public void turnToUp() { turnLeft(); }
        public void turnToDown() { turnLeftRev(); }
        public void turnToLeft() { turnUp(); }
        public void turnToRight() { turnUpRev(); }

        /**
         * 手前を南, 奥(前進方向)を北とした場合
         */
        public void turnSouth() { turnToUp(); }
        public void turnNorth() { turnToDown(); }
        public void turnEast() { turnFront(); }
        public void turnWest() { turnFrontRev(); }

        public int FTtoR(int x, int y) {
            int[] lib = new int[36];
            getId(x);
            getId(y);
            return 0;
        }

        public int getId(int x) {
            return indexOf(this.ids, indexOf(this.nums, x));
        }

        public static int indexOf(int[] a, int v) {
            for (int i = 0, l = a.length; i < l; i++) {
                if (v == a[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}

