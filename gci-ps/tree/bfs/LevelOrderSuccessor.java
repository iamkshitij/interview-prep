package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key){

        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
                TreeNode currentNode = queue.poll();

                if(currentNode.leftNode != null) queue.offer(currentNode.leftNode);
                if(currentNode.rightNode != null) queue.offer(currentNode.rightNode);

                if(currentNode.val == key) break; ;
        }

        return queue.peek();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.rightNode = new TreeNode(3);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.rightNode = new TreeNode(5);

        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
        if (result != null)
            System.out.println(result.val + " ");

        root = new TreeNode(12);
        root.leftNode = new TreeNode(7);
        root.rightNode = new TreeNode(1);
        root.leftNode.leftNode = new TreeNode(9);
        root.rightNode.leftNode = new TreeNode(10);
        root.rightNode.rightNode = new TreeNode(5);

        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");

        result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
    }



}
