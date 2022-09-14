package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverages {

    public static List<Double> levelAverage(TreeNode root){
        List<Double> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();
                levelSum+= currentNode.val;


                if (currentNode.leftNode != null) queue.offer(currentNode.leftNode);
                if(currentNode.rightNode != null) queue.offer(currentNode.rightNode);
            }
            result.add(levelSum/levelSize);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.leftNode = new TreeNode(7);
        root.rightNode = new TreeNode(1);
        root.leftNode.leftNode = new TreeNode(9);
        root.leftNode.rightNode = new TreeNode(2);
        root.rightNode.leftNode = new TreeNode(10);
        root.rightNode.rightNode = new TreeNode(5);
        List<Double> result = LevelAverages.levelAverage(root);
        System.out.print("Level averages are: " + result);
    }

}
