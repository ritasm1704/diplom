package org.suai.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int x, y;
    private List<Node> nodes = new ArrayList<>();

    public Node(int x, int y, int[][] arena){
        this.x = x;
        this.y = y;
        arena[x][y] = 1;

        if (x - 1 >= 0) {
            if (arena[x - 1] [y] != 1) {
                nodes.add(new Node(x - 1, y, arena));
            }
            if (y - 1 >= 0) {
                if (arena[x - 1] [y - 1] != 1) {
                    nodes.add(new Node(x - 1, y - 1, arena));
                }
            }
            if (y + 1 < arena[0].length) {
                if (arena[x - 1] [y + 1] != 1) {
                    nodes.add(new Node(x - 1, y + 1, arena));
                }
            }
        }
        if (y - 1 >= 0) {
            if (arena[x] [y - 1] != 1) {
                nodes.add(new Node(x, y - 1, arena));
            }
        }
        if (x + 1 < arena.length) {
            if (arena[x + 1] [y] != 1) {
                nodes.add(new Node(x + 1, y, arena));
            }
            if (y + 1 < arena[0].length) {
                if (arena[x + 1] [y + 1] != 1) {
                    nodes.add(new Node(x + 1, y + 1, arena));
                }
            }
            if (y - 1 >= 0) {
                if (arena[x + 1] [y - 1] != 1) {
                    nodes.add(new Node(x + 1, y - 1, arena));
                }
            }
        }
        if (y + 1 < arena[0].length) {
            if (arena[x] [y + 1] != 1) {
                nodes.add(new Node(x, y + 1, arena));
            }
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
