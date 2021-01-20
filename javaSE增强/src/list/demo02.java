package list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * ʹ��LinkedListʵ�ֶ�ջ�Ͷ��е����ݽṹ 
 * 
 */
// LinkedList

public class demo02 {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.addFirst("1111"); // �Ƚ�
		llist.addFirst("2222");
		llist.addFirst("3333");
		llist.addFirst("4444"); // ���
		
		Iterator it = llist.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

// ���С��Ƚ��ȳ���First In First Out��FIFO
//add        ����һ��Ԫ��                     ����������������׳�һ��IIIegaISlabEepeplian�쳣
//remove     �Ƴ������ض���ͷ����Ԫ��    �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
//element    ���ض���ͷ����Ԫ��             �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
//offer      ���һ��Ԫ�ز�����true       ��������������򷵻�false
//poll       �Ƴ������ʶ���ͷ����Ԫ��    �������Ϊ�գ��򷵻�null
//peek       ���ض���ͷ����Ԫ��             �������Ϊ�գ��򷵻�null
//put        ���һ��Ԫ��                      �����������������
//take       �Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ�������
class MyQueue {
	private LinkedList llist;
	
	// 
	public MyQueue (LinkedList list) {
		llist = new LinkedList();
	}
	
	// ����һ��Ԫ��
	public void add (Object e) {
		llist.addFirst(e);
	}
	
	// ���ض���ͷ����Ԫ�� 
	public Object peek () {
		return llist.getLast(); // ��ȡ
	}
	
	// �Ƴ������ض���ͷ����Ԫ��    �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
	public Object remove () {
		
		return null;
	}
}
