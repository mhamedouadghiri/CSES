package GraphAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Labyrinth {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static final int FLOOR = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int END = 3;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[][] labyrinth;
    private static boolean[][] visited;
    private static Coordinate start;

    private static int n;
    private static int m;
    private static String[] lines;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        in();
        init();
        List<Coordinate> path = solve();
        Collections.reverse(path);
        List<Character> dir = coordinateToDirection(path);
        pw.println(dir.isEmpty() ? "NO" : "YES\n" + dir.size());
        dir.forEach(pw::print);
        pw.close();
    }

    private static void in() {
        n = nextInt();
        m = nextInt();
        lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = nextLine();
        }
    }

    private static void init() {
        labyrinth = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = lines[i].charAt(j);
                if (c == '#') {
                    labyrinth[i][j] = WALL;
                } else if (c == '.') {
                    labyrinth[i][j] = FLOOR;
                } else if (c == 'A') {
                    labyrinth[i][j] = START;
                    start = new Coordinate(i, j);
                } else if (c == 'B') {
                    labyrinth[i][j] = END;
                }
            }
        }
    }

    private static List<Character> coordinateToDirection(List<Coordinate> path) {
        List<Character> directions = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i).x - path.get(i + 1).x == 0) {
                if (path.get(i).y - path.get(i + 1).y == 1)
                    directions.add('L');
                else
                    directions.add('R');
            } else if (path.get(i).x - path.get(i + 1).x == -1) {
                directions.add('D');
            } else {
                directions.add('U');
            }
        }
        return directions;
    }

    private static List<Coordinate> backtrackPath(Coordinate coordinate) {
        List<Coordinate> list = new ArrayList<>();
        Coordinate c = coordinate;
        while (c != null) {
            list.add(c);
            c = c.parent;
        }
        return list;
    }

    private static List<Coordinate> solve() {
        LinkedList<Coordinate> next = new LinkedList<>();
        next.add(start);
        while (!next.isEmpty()) {
            Coordinate current = next.remove();
            if (!isValidLocation(current.x, current.y) || visited[current.x][current.y])
                continue;
            if (labyrinth[current.x][current.y] == WALL) {
                visited[current.x][current.y] = true;
                continue;
            }
            if (labyrinth[current.x][current.y] == END) {
                return backtrackPath(current);
            }
            for (int[] dir : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(current.x + dir[0], current.y + dir[1], current);
                next.add(coordinate);
                visited[current.x][current.y] = true;
            }
        }
        return new LinkedList<>();
    }

    private static boolean isValidLocation(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    private static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }
}

class Coordinate {
    int x;
    int y;
    Coordinate parent;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(int x, int y, Coordinate parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
}
