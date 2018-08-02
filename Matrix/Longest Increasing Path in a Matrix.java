Problem : 
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Thought :cache 里放的是以原矩阵当前位置的元素为起始点，最长的递增路径的长度 
以  [              为例
	  [9,9,4],
	  [6,6,8],
	  [2,1,1]
	]

走完第一行  cache 为 [ 
					  [1,1,2],
					  [0,0,1],
					  [0,0,0]
					] 
走完第二行  cache 为 [ 
					  [1,1,2],
					  [2,2,1],
					  [0,0,0]
					] 					
走完第三行  cache 为 [ 
					  [1,1,2],
					  [2,2,1],
					  [3,4,2]
					] 					

Complexity Analysis :
Time Complexity: O(n*m),  

Space Complexity: O(n*m),  


public class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//directions 

	public int longestIncreasingPath(int[][] matrix) {
	    if(matrix.length == 0) return 0;
	    int m = matrix.length, n = matrix[0].length;
	    int[][] cache = new int[m][n];
	    int max = 1;
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            int len = dfs(matrix, i, j, m, n, cache);
	            max = Math.max(max, len);
	        }
	    }   
	    return max;
	}

	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
	    if(cache[i][j] != 0) return cache[i][j];//cache 上如果有数了，那个数代表的就是以该位置为起始位置的递增路径的最长长度
	    int max = 1;
	    for(int[] dir: dirs) {
	        int x = i + dir[0], y = j + dir[1];
	        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
	        int len = 1 + dfs(matrix, x, y, m, n, cache);
	        max = Math.max(max, len);
	    }
	    cache[i][j] = max;
	    return max;
	}
}
