import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> obstacles = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> finalMoves = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        for (int[] row : board)
            Arrays.fill(row, 0); // 0 for empty
        Scanner scanner = new Scanner(System.in);
        int x, y;
        System.out.print("Enter Hours State: ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        //*************************************************

        board[x][y] = 1;

        int gx, gy;
        System.out.print("Enter Goal State: ");
        gx = scanner.nextInt();
        gy = scanner.nextInt();
        //*************************************************

        board[gx][gy] = 9; // 9 - > goal
        int numberOfBorders;
        System.out.print("Enter number of borders: ");
        numberOfBorders = scanner.nextInt();
        int bx, by;
        for (int i = 0; i < numberOfBorders; i++) {
            System.out.print("Enter Border #" + (i + 1) + " state: ");
            bx = scanner.nextInt();
            by = scanner.nextInt();
            obstacles.add(new ArrayList<>(Arrays.asList(bx, by)));
            board[bx][by] = 2; // 2 -> obstacle
        }
        System.out.println("Minimum number of moves: " + start(x, y, gx, gy, board));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        Collections.reverse(finalMoves);
        System.out.println(finalMoves);
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
                getPaths(visitedCells, dist,board,finalMoves);
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
        for (int i = 1; i <= a; i++) {
            x++;
            if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                return false;
            }
        }
        for (int i = 1; i <= b; i++) {
            y++;
            if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkObstacleY(int x, int y, int x1, int y1) {
        int a = Math.abs(x1 - x);
        int b = Math.abs(y1 - y);
        for (int i = 1; i <= b; i++) {
            y++;
            if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                return false;
            }
        }
        for (int i = 1; i <= a; i++) {
            x++;
            if (obstacles.contains(new ArrayList<>(Arrays.asList(x, y)))) {
                return false;
            }
        }

        return true;
    }

    public static void getPaths(ArrayList<ArrayList<Integer>> visited, int dist,int[][] board,ArrayList<ArrayList<Integer>> fMoves) {

        int[] rightLeft = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] upDown = {-1, 1, 1, -1, 2, -2, 2, -2};
        int x, y, d;
        x = visited.get(visited.size() - 1).get(0);
        y = visited.get(visited.size() - 1).get(1);
        d = visited.get(visited.size() - 1).get(2);
        fMoves.add(new ArrayList<>(Arrays.asList(x,y,d)));
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
                        fMoves.add(new ArrayList<>(Arrays.asList(visited.get(h).get(0),visited.get(h).get(1),visited.get(h).get(2))));
                        x = visited.get(h).get(0);
                        y = visited.get(h).get(1);
                        d = visited.get(h).get(2);
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){

                    break;
                }
            }
        }
    }
}
