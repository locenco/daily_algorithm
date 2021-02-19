package top.macondo.aigorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangchong
 * @Date: 2021/2/19 14:44
 **/
public class Lc_yanghhui {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>(numRows);
		for (int i = 1; i <= numRows; i++) {
			List<Integer> row = new ArrayList<>();
			if (i == 1) {
				row.add(1);
				result.add(row);
				continue;
			}
			List<Integer> row1 = result.get(i - 2);
			row.add(1);
			for (int j = 1; j < i - 1; j++) {
				row.add(row1.get(j-1) + row1.get(j));
			}
			row.add(1);
			result.add(row);
		}
		return result;
	}
	public List<List<Integer>> generate2(int numRows) {
		if (numRows == 1) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> row = new ArrayList<>();
			row.add(1);
			result.add(row);
			return result;
		}
		List<List<Integer>> result = generate2(numRows - 1);

		List<Integer> row1 = result.get(numRows - 1);
		List<Integer> row = new ArrayList<>();
		row.add(1);
		for (int j = 1; j < numRows - 1; j++) {
			row.add(row1.get(j-1) + row1.get(j));
		}
		row.add(1);
		result.add(row);
		return result;
	}

	/**
	 * 返回第k行，O(k)空间复杂度
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>(rowIndex);
		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			result.add(0);
			for (int j = i; j > 0; j--) {
				result.set(j, result.get(j - 1) + result.get(j));
			}
		}
		return result;
	}
	@Test
	public void test(){
		List<List<Integer>> result = generate(5);
		List<Integer> result1 = getRow(5);

	}
}
