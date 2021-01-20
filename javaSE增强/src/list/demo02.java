package list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 使用LinkedList实现堆栈和队列的数据结构 
 * 
 */
// LinkedList

public class demo02 {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.addFirst("1111"); // 先进
		llist.addFirst("2222");
		llist.addFirst("3333");
		llist.addFirst("4444"); // 后进
		
		Iterator it = llist.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

// 队列。先进先出。First In First Out。FIFO
//add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
//remove     移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
//element    返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
//offer      添加一个元素并返回true       如果队列已满，则返回false
//poll       移除并返问队列头部的元素    如果队列为空，则返回null
//peek       返回队列头部的元素             如果队列为空，则返回null
//put        添加一个元素                      如果队列满，则阻塞
//take       移除并返回队列头部的元素     如果队列为空，则阻塞
class MyQueue {
	private LinkedList llist;
	
	// 
	public MyQueue (LinkedList list) {
		llist = new LinkedList();
	}
	
	// 增加一个元素
	public void add (Object e) {
		llist.addFirst(e);
	}
	
	// 返回队列头部的元素 
	public Object peek () {
		return llist.getLast(); // 获取
	}
	
	// 移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
	public Object remove () {
		
		return null;
	}
}
