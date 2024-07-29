package BJ;

import java.io.*;
import java.util.*;

public class BJ2263 {
    static int n;
    static int[] inorder;
    static int[] postorder;
    static int[] preorder;
    static int preorderIndex;
    static Map<Integer, Integer> inorderIndexMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIndexMap.put(inorder[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        buildPreorder(0, n - 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(preorder[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void buildPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int rootValue = postorder[postEnd];
        preorder[preorderIndex++] = rootValue;

        int rootIndex = inorderIndexMap.get(rootValue);
        int leftTreeSize = rootIndex - inStart;

        buildPreorder(inStart, rootIndex - 1, postStart, postStart + leftTreeSize - 1);
        buildPreorder(rootIndex + 1, inEnd, postStart + leftTreeSize, postEnd - 1);
    }
}
