import java.util.Arrays;

public class Prim {
    private static final int INF = Integer.MAX_VALUE;

    // 查找具有最小键值的顶点的函数
    private static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // 打印MST的函数
    private static void printMST(int[] parent, int[][] graph, int V) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // 使用邻接矩阵表示实现Prim算法
    public static void primMST(int[][] graph) {
        int V = graph.length;
        
        // 存储构造的MST
        int[] parent = new int[V];
        
        // 用于选择最小权重边的键值
        int[] key = new int[V];
        
        // 表示顶点是否已包含在MST中
        boolean[] mstSet = new boolean[V];

        // 初始化所有键为无穷大
        Arrays.fill(key, INF);
        Arrays.fill(mstSet, false);

        // 第一个顶点始终是MST的第一个顶点
        key[0] = 0;     // 使第一个顶点被选择
        parent[0] = -1; // 第一个节点是MST的根

        // MST将有V个顶点
        for (int count = 0; count < V - 1; count++) {
            // 选择未包含在mstSet中的键值最小的顶点
            int u = minKey(key, mstSet, V);
            
            // 将选定的顶点添加到MST集合
            mstSet[u] = true;

            // 更新相邻顶点的键值和父节点索引
            for (int v = 0; v < V; v++) {
                // graph[u][v]非0仅对于相邻顶点
                // mstSet[v]为false表示顶点v尚未包含在MST中
                // 如果graph[u][v]小于key[v]，则更新key[v]
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // 打印构造的MST
        printMST(parent, graph, V);
    }

    public static void main(String[] args) {
        // 示例图
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        // 运行Prim算法
        primMST(graph);
    }
}