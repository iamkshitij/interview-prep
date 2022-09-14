package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

    public static List<List<Integer>> reverseTraversal(TreeNode root){
        List<List<Integer>> result =  new LinkedList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.rightNode != null)
                    queue.offer(currentNode.rightNode);
                if(currentNode.leftNode != null)
                    queue.offer(currentNode.leftNode);
            }
            // insertion of currentLevel to beginning
            result.add(0,currentLevel);
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
            List<List<Integer>> result = ReverseLevelOrderTraversal.reverseTraversal(root);
            System.out.println("Reverse level order traversal: " + result);
    }
}
