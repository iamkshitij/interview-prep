package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {

    public static List<TreeNode> traverseRightView(TreeNode root){
        List<TreeNode> result = new ArrayList<>();

        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelNode = queue.size();
            for (int i = 0; i < levelNode; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelNode - 1) result.add(currentNode);
                if(currentNode.leftNode != null) queue.offer(currentNode.leftNode);
                if(currentNode.rightNode != null) queue.offer(currentNode.rightNode);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.leftNode = new TreeNode(7);
        root.rightNode = new TreeNode(1);
        root.leftNode.leftNode = new TreeNode(9);
        root.rightNode.leftNode = new TreeNode(10);
        root.rightNode.rightNode = new TreeNode(5);
        root.leftNode.leftNode.leftNode = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverseRightView(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }

}
