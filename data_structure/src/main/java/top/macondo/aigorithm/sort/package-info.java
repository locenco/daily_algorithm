/**
 * @author: zhangchong
 * @Date: 2020/9/28 10:08
 **/
package top.macondo.aigorithm.sort;
/**
 * 一句话快速记忆排序
 * 1. 插入排序 ；每次从未排序的数中取一个数插入到已排好序队列中
 * 2. 选择排序： 每次选个最大或最小的值，排到已排序的队列中
 * 3. 冒泡排序： 相邻比大小交换，每趟冒泡选出最大最小
 * 4. 快速排序： 分治思想，选个基数，左边放比他小，右边放比他大的。递归左边右边
 * 5. 希尔排序： 弄个增量序列当步长，每次比较相同步长的值，最终步长为1
 * 6. 归并排序： 将数组分为两部分分别排序，然后再合并
 * 7. 堆排序： 先弄个大顶堆，每次提出根后放到排序队列，再循环
 * 8. 桶排序： 先分几个桶（从小到大的区间），将对应的数据放入桶中后排序，再合并
 * 9. 计数排序： 新数组累计原数组值的次数，在遍历新数组填充原数组（新数组下标对应原数组的值）
 * 10. 基数排序：按位比较排序，先比较个位->十位->百位...
 **/