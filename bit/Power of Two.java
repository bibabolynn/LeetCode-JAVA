Problem : 
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 2^0 = 1
Example 2:

Input: 16
Output: true
Explanation: 2^4 = 16
Example 3:

Input: 218
Output: false


Thought : 循环除以2，直到1，看看有没有余数大于0的情况，有就是false;

Complexity Analysis :
Time Complexity: O(m),  m是n的二进制表示的位数
Space Complexity: O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
		while( n >1 ){
		     if( (n&1) > 0){
				return false;
			 }
			 n = n>>>2;
		}
		return true;
        
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
       return (Integer.bitCount(n) == 1 && n > 0);
        
    }
}

如果自己实现bitCount的话如下，源码实在是看不懂
public  int bitCount(int n) {
	int count=0;
	while(n!=0){
		count+=n&1;  //末尾是不是1
		n=n>>>1;  //向右位移1，高位补零
	}
	return count;
}
