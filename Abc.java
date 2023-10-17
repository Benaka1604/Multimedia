
import java.util.Scanner;

public class Abc {
    public static int v[][] = new int[15][15];

    public void knapsackDP(int n, int m, int w[], int p[]) {
        int i, j;
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else if (w[i] > j)
                    v[i][j] = v[i - 1][j];
                else {
                    if (v[i - 1][j] < (v[i - 1][j - w[i]] + p[i]))
                        v[i][j] = v[i - 1][j - w[i]] + p[i];
                    else
                        v[i][j] = v[i - 1][j];
                }
            }
        }
        System.out.println("\n profit table");
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("\n the optimal solution is" + v[n][m]);
    }

    public void ObjectSelection(int n, int m, int w[], int v[][]) {
        int x[] = new int[n + 1];
        int i, j;
        for (i = 1; i <= n; i++)
            x[i] = 0;
        i = n;
        j = m;
        while (i > 0 && j > 0) {
            if (v[i][j] != v[i - 1][j]) {
                x[i] = 1;
                j = j - w[i];
            }
            i--;
        }
        System.out.println("\n objects selected are:");
        for (i = 1; i <= n; i++)
            if (x[i] == 1)
                System.out.println("object" + i);
    }

    public static void main(String args[]) {
        int w[] = new int[10];
        int p[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of objects");
        int n = sc.nextInt();

        System.out.println("\nenter weight for " + n + " objects");
        for (int i = 1; i <= n; i++)
            w[i] = sc.nextInt();

        System.out.println("\nenter profit for " + n + " objects");
        for (int i = 1; i <= n; i++)
            p[i] = sc.nextInt();

        System.out.println("enter the capacity of the bag");
        int m = sc.nextInt();

        Abc obj = new Abc();
        obj.knapsackDP(n, m, w, p);
        obj.ObjectSelection(n, m, w, v);
        sc.close();
    }
}
