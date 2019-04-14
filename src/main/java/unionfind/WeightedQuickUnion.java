package unionfind;

public class WeightedQuickUnion extends QuickUnion {
    // initialize union-find data structure with N objects (0 to N – 1)
    public WeightedQuickUnion(int N) {
        super(N);
    }

    // add connection between p and q
    public void union(int p, int q) {

    }

    // are p and q in the same component?
    public boolean connected(int p, int q) {
        return false;
    }

    // component identifier for p (0 to N – 1)
    public int find(int p) {
        return 0;
    }
    // number of components
    public int count()  {
        return 0;
    }
}
