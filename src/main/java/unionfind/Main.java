package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Main {

    public static void find(IntFunction<UnionFinder> func) throws IOException {
        In In = new FileIn("unionfind/input.txt");
        Out Out = new StdOut();

        int N = In.readInt();
        UnionFinder uf = func.apply(N);
        Out.println("####### " + uf.getClass().getSimpleName());
        while (!In.isEmpty())
        {
            int p = In.readInt();
            int q = In.readInt();
            if (!uf.connected(p, q)) {
                Out.println("Not connected : " + p + " " + q);
                uf.union(p, q);
            } else {
                Out.println("Connected : " + p + " " + q);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        find((initial) -> new QuickFinder(initial));
        find((initial) -> new QuickUnion(initial));
        find((initial) -> new WeightedQuickUnion(initial));
    }
}

interface In {
    int readInt();
    boolean isEmpty();
}

interface Out {
    void println(String str);
}

class FileIn implements In {
    ArrayList<Integer> inputs;
    int currentIndex = 0;

    public FileIn(String filePath) throws IOException {
        inputs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/" + filePath)
        ))) {
            String line;
            while((line = reader.readLine()) != null) {
                for (String str : Arrays.asList(line.split(" ")))
                inputs.add(Integer.parseInt(str));
            }
        }
    }

    @Override
    public int readInt() {
        Integer currentValue = inputs.get(currentIndex);
        currentIndex++;
        return currentValue;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex >= inputs.size();
    }
}

class StdOut implements Out {

    @Override
    public void println(String str) {
        System.out.println(str);
    }
}