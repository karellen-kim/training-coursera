package unionfind;

public class QuickFinder implements UnionFinder {
    protected int[] grid;

    // initialize union-find data structure with N objects (0 to N – 1)
    public QuickFinder(int N) {
        grid = new int[N];
        for (int i = 0 ; i < N ; i++) {
            grid[i] = i;
        }
    }

    // add connection between p and q
    public void union(int p, int q) {
        int mergeId = find(p);
        int shouldReplaceId = find(q);

        for (int i = 0 ; i < grid.length ; i++) {
            if (find(i) == shouldReplaceId) {
                this.grid[i] = mergeId;
            }
        }
    }

    // are p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // component identifier for p (0 to N – 1)
    public int find(int p) {
        return grid[p];
    }

    // number of components
    public int count()  {
        return grid.length;
    }
}
