package Ds.topK;

/**
* TopK问题：
* 
* (1)大数据情景下：
* 
*  采用大根堆或者小根堆，
*  特别注意：当需要topK大的时候，使用小根堆；当需要topK小的时候，使用大根堆。
*  
*  以topK大为例:
*     1：先建立一个小根堆，
*     2：扫描剩下的N-k个元素，
*        对每个元素，
*        如果大于小根堆的根节点，则覆盖根节点为该数据，并调整至小根堆
*        如果小于根节点，无变化。  
* 	
*  时间复杂度：O(nlogk),每次调整堆的时间复杂度为O(logk),一共大约n个元素
*  
*     
*/
public class TopK {

	public static void main(String[] args) {
		
	}

}
