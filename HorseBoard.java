import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HorseBoard extends JPanel {


    public static ArrayList<ArrayList<Integer>> obstacles = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> finalMoves = new ArrayList<ArrayList<Integer>>();

    public static JFrame f = new JFrame();
    public static JButton[][] btns;

    public static void main(String[] args) throws InterruptedException {
        JButton b1 = new JButton("");
        JButton b2 = new JButton("");
        JButton b3 = new JButton("");
        JButton b4 = new JButton("");
        JButton b5 = new JButton("");
        JButton b6 = new JButton("");
        JButton b7 = new JButton("");
        JButton b8 = new JButton("");
        JButton b9 = new JButton("");
        JButton b10 = new JButton("");
        JButton b11 = new JButton("");
        JButton b12 = new JButton("");
        JButton b13 = new JButton("");
        JButton b14 = new JButton("");
        JButton b15 = new JButton("");
        JButton b16 = new JButton("");
        JButton b17 = new JButton("");
        JButton b18 = new JButton("");
        JButton b19 = new JButton("");
        JButton b20 = new JButton("");
        JButton b21 = new JButton("");
        JButton b22 = new JButton("");
        JButton b23 = new JButton("");
        JButton b24 = new JButton("");
        JButton b25 = new JButton("");
        JButton b26 = new JButton("");
        JButton b27 = new JButton("");
        JButton b28 = new JButton("");
        JButton b29 = new JButton("");
        JButton b30 = new JButton("");
        JButton b31 = new JButton("");
        JButton b32 = new JButton("");
        JButton b33 = new JButton("");
        JButton b34 = new JButton("");
        JButton b35 = new JButton("");
        JButton b36 = new JButton("");
        JButton b37 = new JButton("");
        JButton b38 = new JButton("");
        JButton b39 = new JButton("");
        JButton b40 = new JButton("");
        JButton b41 = new JButton("");
        JButton b42 = new JButton("");
        JButton b43 = new JButton("");
        JButton b44 = new JButton("");
        JButton b45 = new JButton("");
        JButton b46 = new JButton("");
        JButton b47 = new JButton("");
        JButton b48 = new JButton("");
        JButton b49 = new JButton("");
        JButton b50 = new JButton("");
        JButton b51 = new JButton("");
        JButton b52 = new JButton("");
        JButton b53 = new JButton("");
        JButton b54 = new JButton("");
        JButton b55 = new JButton("");
        JButton b56 = new JButton("");
        JButton b57 = new JButton("");
        JButton b58 = new JButton("");
        JButton b59 = new JButton("");
        JButton b60 = new JButton("");
        JButton b61 = new JButton("");
        JButton b62 = new JButton("");
        JButton b63 = new JButton("");
        JButton b64 = new JButton("");

        btns = new JButton[][]{
                {b1, b2, b3, b4, b5, b6, b7, b8},
                {b9, b10, b11, b12, b13, b14, b15, b16},
                {b17, b18, b19, b20, b21, b22, b23, b24},
                {b25, b26, b27, b28, b29, b30, b31, b32},
                {b33, b34, b35, b36, b37, b38, b39, b40},
                {b41, b42, b43, b44, b45, b46, b47, b48},
                {b49, b50, b51, b52, b53, b54, b55, b56},
                {b57, b58, b59, b60, b61, b62, b63, b64},
        };

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b11);
        f.add(b12);
        f.add(b13);
        f.add(b14);
        f.add(b15);
        f.add(b16);
        f.add(b17);
        f.add(b18);
        f.add(b19);
        f.add(b20);
        f.add(b21);
        f.add(b22);
        f.add(b23);
        f.add(b24);
        f.add(b25);
        f.add(b26);
        f.add(b27);
        f.add(b28);
        f.add(b29);
        f.add(b30);
        f.add(b31);
        f.add(b32);
        f.add(b33);
        f.add(b34);
        f.add(b35);
        f.add(b36);
        f.add(b37);
        f.add(b38);
        f.add(b39);
        f.add(b40);
        f.add(b41);
        f.add(b42);
        f.add(b43);
        f.add(b44);
        f.add(b45);
        f.add(b46);
        f.add(b47);
        f.add(b48);
        f.add(b49);
        f.add(b50);
        f.add(b51);
        f.add(b52);
        f.add(b53);
        f.add(b54);
        f.add(b55);
        f.add(b56);
        f.add(b57);
        f.add(b58);
        f.add(b59);
        f.add(b60);
        f.add(b61);
        f.add(b62);
        f.add(b63);
        f.add(b64);

        //************************************* START ********************************************

        int[][] board = new int[8][8];
        for (int[] row : board)
            Arrays.fill(row, 0); // 0 for empty
        Scanner scanner = new Scanner(System.in);
        int x, y;
        System.out.print("Enter Horse State: ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        //*************************************************

        board[x][y] = 1;
        btns[x][y].setText("Horse");
        make();

        int gx, gy;
        System.out.print("Enter Goal State: ");
        gx = scanner.nextInt();
        gy = scanner.nextInt();
        //*************************************************

        board[gx][gy] = 9; // 9 - > goal

        btns[gx][gy].setText("Goal");
        btns[gx][gy].setBackground(Color.red);
        btns[gx][gy].setForeground(Color.white);

        int numberOfBorders;
        System.out.print("Enter number of obstacles: ");
        numberOfBorders = scanner.nextInt();
        int bx, by;
        for (int i = 0; i < numberOfBorders; i++) {
            System.out.print("Enter Obstacle #" + (i + 1) + " : ");
            bx = scanner.nextInt();
            by = scanner.nextInt();
            obstacles.add(new ArrayList<>(Arrays.asList(bx, by)));
            board[bx][by] = 2; // 2 -> obstacle

            btns[bx][by].setText("Obstacle");
            btns[bx][by].setBackground(Color.black);
            btns[bx][by].setForeground(Color.white);

        }
        int mnm = start(x, y, gx, gy, board);
        System.out.println("Minimum number of moves: " + mnm);


        if (mnm != -1) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
            }
            Collections.reverse(finalMoves);
            System.out.println(finalMoves);
            finalMoves.remove(0);

            for (int i = 0; i < finalMoves.size(); i++) {
                btns[finalMoves.get(i).get(0)][finalMoves.get(i).get(1)].setText("Move #" + (i + 1));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            JOptionPane.showMessageDialog(f, "Minimum number of moves = " + mnm);
        }
    }

    // The following function to check if the next move is valid [not out of the scope of the board]
    static boolean canMoveToPosition(int x, int y) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8) {
            return false;
        }
        if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
            return false;
        }
        return true;
    }

    public static int start(int sx, int sy, int dx, int dy, int[][] board) {
        // Possible moves according to letter 'L' 2*1 or 1*2 to represent it.
        int[] rightLeft = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] upDown = {-1, 1, 1, -1, 2, -2, 2, -2};
        //Array to store visited nodes.
        ArrayList<ArrayList<Integer>> visitedCells = new ArrayList<ArrayList<Integer>>();
        //Array to store next moves
        ArrayList<ArrayList<Integer>> nextMoves = new ArrayList<ArrayList<Integer>>();
        nextMoves.add(new ArrayList<Integer>(Arrays.asList(sx, sy, 0)));
        // iterate till array list is empty
        while (!nextMoves.isEmpty()) {
            // Get the first element attributes in the array
            int x = nextMoves.get(0).get(0);
            int y = nextMoves.get(0).get(1);
            int dist = nextMoves.get(0).get(2);
            nextMoves.remove(0);
            // if the destination is reached, return distance
            if (x == dx && y == dy) {
                visitedCells.add(new ArrayList<>(Arrays.asList(x, y, dist)));
                getPaths(visitedCells, dist, board, finalMoves);
                return dist;
            }
            // skip if the location is visited before
            if (!visitedCells.contains(new ArrayList<>(Arrays.asList(x, y, dist)))) {
                // mark the current node as visited
                visitedCells.add(new ArrayList<>(Arrays.asList(x, y, dist)));
                //Find all possible moves to the current state - These moves are 8 but not all will be valid to move
                for (int i = 0; i < 8; i++) {
                    //Get next possible move
                    int x1 = x + rightLeft[i];
                    int y1 = y + upDown[i];
                    // Check of the next move we can use it again
                    if (canMoveToPosition(x1, y1)) {
                        if (!checkObstacleX(x, y, x1, y1)) {
                            if (!checkObstacleY(x, y, x1, y1)) {
                                continue;
                            }
                        }
                        nextMoves.add(new ArrayList<>(Arrays.asList(x1, y1, dist + 1)));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean checkObstacleX(int x, int y, int x1, int y1) {
        int a = Math.abs(x1 - x);
        int b = Math.abs(y1 - y);
        if ((x1 - x) < 0) {
            for (int i = 1; i <= a; i++) {
                x--;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= a; i++) {
                x++;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        }

        if ((y1 - y) < 0) {
            for (int i = 1; i <= b; i++) {
                y--;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= b; i++) {
                y++;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkObstacleY(int x, int y, int x1, int y1) {
        int a = Math.abs(x1 - x);
        int b = Math.abs(y1 - y);
        if ((y1 - y) < 0) {
            for (int i = 1; i <= b; i++) {
                y--;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= b; i++) {
                y++;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        }
        if ((x1 - x) < 0) {
            for (int i = 1; i <= a; i++) {
                x--;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= a; i++) {
                x++;
                if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void getPaths(ArrayList<ArrayList<Integer>> visited, int dist, int[][] board, ArrayList<ArrayList<Integer>> fMoves) {

        int[] rightLeft = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] upDown = {-1, 1, 1, -1, 2, -2, 2, -2};
        int x, y, d;
        x = visited.get(visited.size() - 1).get(0);
        y = visited.get(visited.size() - 1).get(1);
        d = visited.get(visited.size() - 1).get(2);
        fMoves.add(new ArrayList<>(Arrays.asList(x, y, d)));
        int k = dist;
        dist--;
        int flag = 0;
        for (int i = 0; i < k; i++) {
            flag = 0;
            for (int j = 0; j < 8; j++) {
                int x1 = x - rightLeft[j];
                int y1 = y - upDown[j];
                for (int h = 0; h < visited.size(); h++) {
                    if (visited.get(h).get(0) == x1 && visited.get(h).get(1) == y1 && visited.get(h).get(2) == dist) {
                        dist--;
                        board[visited.get(h).get(0)][visited.get(h).get(1)] = 1;
                        fMoves.add(new ArrayList<>(Arrays.asList(visited.get(h).get(0), visited.get(h).get(1), visited.get(h).get(2))));
                        x = visited.get(h).get(0);
                        y = visited.get(h).get(1);
                        d = visited.get(h).get(2);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {

                    break;
                }
            }
        }
    }

    public static void make() {
        f.setLayout(new GridLayout(8, 8));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);
        f.setVisible(true);
    }
}
