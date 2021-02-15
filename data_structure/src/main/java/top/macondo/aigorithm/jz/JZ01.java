package top.macondo.aigorithm.jz;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: zhangchong
 * @Date: 2020/9/22 10:46
 **/
public class JZ01 {
	public boolean Find(int target, int[][] array) {
		if(array.length == 0 || array[0].length == 0){
			return false;
		}


		// 1. 边界和起点（右上角，左侧比当前点小，下方比当前点大，好处是不用考虑右侧的值）
		int colLength = array[0].length;
		int rowLength = array.length;
		int colIndex = colLength -1;
		int rowIndex = 0;
		// 2. target大，下移；target小，左移
		while (colIndex >= 0 && rowIndex <= rowLength - 1) {
			if(target == array[rowIndex][colIndex]){
				return true;
			} else if (target > array[rowIndex][colIndex]) {
				rowIndex++;
			} else if (target < array[rowIndex][colIndex]) {
				colIndex--;
			}
		}
		return false;

	}
}
