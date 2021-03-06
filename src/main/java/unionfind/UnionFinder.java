package unionfind;

public interface UnionFinder {
    // add connection between p and q
    void union(int p, int q);

    // are p and q in the same component?
    boolean connected(int p, int q);

    // component identifier for p (0 to N – 1)
    int find(int p);
    // number of components
    int count();
}
