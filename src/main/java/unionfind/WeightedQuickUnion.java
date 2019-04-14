package unionfind;

public class WeightedQuickUnion extends QuickUnion {
    int size[];

    // initialize union-find data structure with N objects (0 to N – 1)
    public WeightedQuickUnion(int N) {
        super(N);

        size = new int[N];
        for (int i = 0 ; i < N ; i++) {
            size[i] = 1;
        }
    }

    // add connection between p and q
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (size[pId] > size[qId]) {
            grid[qId] = pId; // pId is root
            size[pId] += size[qId];
        } else {
            grid[pId] = qId; // qId is root
            size[qId] += size[pId];
        }
    }
}
