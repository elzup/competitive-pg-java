package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q11DiceI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = sc.nextInt();
        }
        sc.nextLine();
        String line = sc.nextLine();
        Dice dice = new Dice(nums);
        for (int i = 0, l = line.length(); i < l; i++) {
            char o = line.charAt(i);
            if (o == 'S') {
                dice.turnSouth();
            } else if (o == 'E') {
                dice.turnEast();
            } else if (o == 'W') {
                dice.turnWest();
            } else if (o == 'N') {
                dice.turnNorth();
            }
        }
        System.out.println(dice.getUp());
    }
}

class Dice {

    public static byte UP = 0;
    public static byte FRONT = 1;
    public static byte RIGHT = 2;
    public static byte LEFT = 3;
    public static byte BACK = 4;
    public static byte DOWN = 5;
    private int[] nums;
    private byte[] ids;

    /**
     *
     * @param nums
     * - 0 - -
     * 3 1 2 4
     * - 5 - -
     */
    public Dice(int[] nums) {
        this.nums = nums;
        this.ids = new byte[]{ 0, 1, 2, 3, 4, 5 };
    }

    public int getUp() { return nums[ids[UP]]; }
    public int getDown() { return nums[ids[DOWN]]; }
    public int getRight() { return nums[ids[RIGHT]]; }
    public int getLeft() { return nums[ids[LEFT]]; }
    public int getFront() { return nums[ids[FRONT]]; }
    public int getBack() { return nums[ids[BACK]]; }

    public void turnDisp(byte[] order) {
        byte tmp = ids[order[0]];
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
    public void turnFront() { turnDisp(new byte[]{ UP, LEFT, DOWN, RIGHT }); }
    public void turnBack() { turnDisp(new byte[]{ UP, RIGHT, DOWN, LEFT }); }
    public void turnLeft() { turnDisp(new byte[]{ UP, BACK, DOWN, FRONT }); }
    public void turnRight() { turnDisp(new byte[]{ UP, FRONT, DOWN, BACK }); }
    public void turnUp() { turnDisp(new byte[]{ FRONT, RIGHT, BACK, LEFT }); }
    public void turnDown() { turnDisp(new byte[]{ FRONT, LEFT, BACK, RIGHT }); }

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
}