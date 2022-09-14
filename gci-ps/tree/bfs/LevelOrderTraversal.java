package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(int val){
        this.val = val;
    }
}

public class LevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root){

        // create a result variable
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        // 1.push the root to queue.
        queue.offer(root);

        // 2.iterate till queue is empty
        while(!queue.isEmpty()){

            // 3.count the number of element in queue
            int levelSize = queue.size();

            // 4.create a new array list whose size is equal to size of queue.
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                // 4.1.remove the nodes from the queue
                TreeNode currentNode = queue.poll();

                // 4.2.push the value to currentlevel
                currentLevel.add(currentNode.val);

                // insert the children to current node
                if(currentNode.leftNode != null)
                    queue.offer(currentNode.leftNode);
                if(currentNode.rightNode != null)
                    queue.offer(currentNode.rightNode);
            }
            result.add(currentLevel);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }

}
