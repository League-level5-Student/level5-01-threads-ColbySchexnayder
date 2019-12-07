package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting extends Thread{
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
	
	int nThreadID = 1;
	static int nThread = 0;
	public static void main(String[] args) {
		new ThreadedReverseGreeting(1).start();
	}
	
	public ThreadedReverseGreeting(int n) {
		nThread++;
		nThreadID = n;
		if (nThread < 50)
			new ThreadedReverseGreeting(++n).start();
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100000/nThreadID);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from thread num" + nThreadID);
	}
}
