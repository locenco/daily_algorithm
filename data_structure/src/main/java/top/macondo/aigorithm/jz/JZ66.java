package top.macondo.aigorithm.jz;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author: zhangchong
 * @Date: 2020/9/21 14:16
 **/
public class JZ66 {
	public int movingCount(int threshold, int rows, int cols){
		boolean[][] visited = new boolean[rows][cols];
		return movingCountHelper(threshold, rows, cols, 0, 0, visited);
	}

	public int movingCountHelper(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
		if ( curRow < 0 || curCol < 0|| curRow >= rows || curCol >= cols || visited[curRow][curCol] || (bitSum(curRow) + bitSum(curCol) > threshold)) {
			return 0;
		}
		visited[curRow][curCol] = true;
		return movingCountHelper(threshold, rows, cols, curRow - 1, curCol, visited) +
						movingCountHelper(threshold, rows, cols, curRow, curCol - 1, visited) +
						movingCountHelper(threshold, rows, cols, curRow, curCol + 1, visited) +
						movingCountHelper(threshold, rows, cols, curRow+ 1, curCol , visited) + 1;
	}

	public int bitSum(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}
