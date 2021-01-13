package top.macondo.aigorithm.newcoder;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 题目描述
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 * 示例1
 * 输入
 * <p>
 * {1,2,3}
 * 返回值
 * <p>
 * [[1,2,3],[2,1,3],[2,3,1]]
 * 备注:
 * n \leq 10^6n≤10
 * 6
 *
 * @author: zhangchong
 * @Date: 2021/1/13 15:18
 **/
public class NC45 {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		NC45 nc45 = new NC45();
		int[][]  a= nc45.threeOrders(treeNode);
	}

	private List<Integer> preOrder = new ArrayList<>();
	private List<Integer> inOrder = new ArrayList<>();
	private List<Integer> postOrder = new ArrayList<>();

	/**
	 * @param root TreeNode类 the root of binary tree
	 * @return int整型二维数组
	 */
	public int[][] threeOrders(TreeNode root) {
		preOrder = new ArrayList<>();
		inOrder = new ArrayList<>();
		postOrder = new ArrayList<>();

		// write code here
		int[][] result = new int[3][];
		getPreOrder(root);
		getInOrder(root);
		getPostOrder(root);

		Function<List<Integer>, int[]> toIntArr = list -> list.stream().mapToInt(Integer::intValue).toArray();
		result[0] = toIntArr.apply(preOrder);
		result[1] = toIntArr.apply(inOrder);
		result[2] = toIntArr.apply(postOrder);
		return result;
	}

	public void getPreOrder(TreeNode root) {
		if (root != null) {
			preOrder.add(root.val);
			getPreOrder(root.left);
			getPreOrder(root.right);
		}
	}

	public void getInOrder(TreeNode root) {
		if (root != null) {
			getInOrder(root.left);
			inOrder.add(root.val);
			getInOrder(root.right);
		}
	}

	public void getPostOrder(TreeNode root) {
		if (root != null) {
			getPostOrder(root.left);
			getPostOrder(root.right);
			postOrder.add(root.val);
		}
	}

}
