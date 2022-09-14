package tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthTree {

    public static int findDepth(TreeNode root){

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int minDepth = 0;
        while (!queue.isEmpty()){
            minDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.leftNode == null && currentNode.rightNode == null)
                    return minDepth;
                if(currentNode.leftNode != null) queue.offer(currentNode.leftNode);
                if(currentNode.rightNode != null) queue.offer(currentNode.rightNode);
            }
        }

        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.leftNode = new TreeNode(7);
        root.rightNode = new TreeNode(1);
        root.rightNode.leftNode = new TreeNode(10);
        root.rightNode.rightNode = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumDepthTree.findDepth(root));
        root.leftNode.leftNode = new TreeNode(9);
        root.rightNode.leftNode.leftNode = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumDepthTree.findDepth(root));

    }

}
