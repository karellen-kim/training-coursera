package unionfind;

public class QuickUnion extends QuickFinder {
    // initialize union-find data structure with N objects (0 to N – 1)
    public QuickUnion(int N) {
        super(N);
    }

    // add connection between p and q
    public void union(int p, int q) {
        int rootId = find(p);
        int childId = find(q);
        grid[childId] = rootId;
    }

    // component identifier for p (0 to N – 1)
    public int find(int p) {
        if (grid[p] == p) {
            return p;
        } else {
            return find(grid[p]);
        }
        // OR
        // while (p != id[p]) p = id[p];
        // return p;
    }
}
