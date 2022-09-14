package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {


    public static List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if(leftToRight) currentLevel.add(currentNode.val);
                else currentLevel.add(0,currentNode.val);

                if(currentNode.leftNode != null)
                    queue.offer(currentNode.leftNode);
                if(currentNode.rightNode != null)
                    queue.offer(currentNode.rightNode);


            }
            result.add(currentLevel);
            leftToRight = !leftToRight;

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
        root.rightNode.leftNode.leftNode = new TreeNode(20);
        root.rightNode.leftNode.rightNode = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.zigzagTraversal(root);
        System.out.println("Zigzag traversal: " + result);
    }

}
