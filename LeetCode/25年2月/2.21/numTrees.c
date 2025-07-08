// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
int numTrees(int n) {
    int G[n + 1];
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; i++) {
        G[i] = 0;
        for (int j = 1; j <= i; j++) {
            G[i] += G[j - 1] * G[i - j];
        }
    }

    return G[n];
}

//卡特兰数问题
//怎么看出来的？
//题解https://leetcode.cn/problems/unique-binary-search-trees/solutions/329807/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/?envType=study-plan-v2&envId=dynamic-programming

//二叉搜索树 是什么？
//二叉搜索树是一种特殊的二叉树，它的左子树上的所有节点的值都小于根节点的值，右子树上的所有节点的值都大于根节点的值。
//二叉搜索树的中序遍历是一个递增的有序序列。
