package test;

public class ThreadTest {
	
	
	public static void main(String[] args) {
	}
}

class MyThread implements Runnable {
	private boolean flag = true;
	
	@Override
	public void run() {
		while (flag) {
		}
	}
	public void stopRunning() {
		this.flag = false;
	}
}


class ControlThread {
	private MyThread r = new MyThread();
	private Thread t = new Thread(r);
	
	public void startThread() {
		t.start();
	}
	
	public void stopThread() {
		r.stopRunning();
	}
}


class Bank {
	private int money = 1000;
	 
	public int money() {
		return this.money;
	}
	public int getMoney(int number) {
		if (number < 0) {
			return -1;
		} else if (number > money) {
			return -2;
		} else {
			try {
				Thread.sleep(1000); // 模拟取钱
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			money -= number;
			System.out.println("剩下多少钱 -- " + this.money());
			return number;
		}
	}
}


class MoneyThread extends Thread {
	private Bank bank;
	
	public MoneyThread(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		System.out.println(bank.getMoney(800));
	}
}


class FetchMoney {
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		MoneyThread t1 = new MoneyThread(bank);
		MoneyThread t2 = new MoneyThread(bank);
				
		t1.start();
		t2.start();
	}
}





















