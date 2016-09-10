package intellipaat;

import java.util.LinkedList;

public class SynchronizedExample {
	public static void main(String args[]){
		LinkedList<String> list = new LinkedList<String>();
		producer p = new producer("producer", list);
		p.start();
		
		producer p2 = new producer("producer2", list);
		p2.start();
		
		producer p3 = new producer("producer3", list);
		p3.start();
		
		producer p4 = new producer("producer4", list);
		p4.start();
		
		consumer c = new consumer("consumer", list);
		c.start();
		
		consumer c2 = new consumer("consumer2", list);
		c2.start();
		
		consumer c3 = new consumer("consumer3", list);
		c3.start();
		
		consumer c4 = new consumer("consumer4", list);
		c4.start();
		
		
	}
}

class producer extends Thread {
	LinkedList<String> ll;
	
	producer(String name, LinkedList<String> list){
		this.setName(name);
		//currentThread().setName(name);
		ll=list;
	}
	
	public void run(){
		addEntry();
	}
	
	void addEntry(){
		synchronized(ll){
			try{
				for(int i=0;i<10;i++){
					if(ll.size() < 5){
						ll.add("Hi");
						System.out.println("addEntry success!! by: "+Thread.currentThread().getName());
						ll.notifyAll();
					} else {
						System.out.println("addEntry failed, hence waiting to consume!! by: "+Thread.currentThread().getName());
						ll.wait();
						i--;
					}
				}
			} catch (InterruptedException ie){
				System.out.println("InterruptedException occured by Thread: "+Thread.currentThread().getName()+" and exception details: "+ie.getMessage());
			}
		}
	}
}

class consumer extends Thread {
	LinkedList<String> ll;
	
	consumer(String name, LinkedList<String> list){
		this.setName(name);
		//currentThread().setName(name);
		ll=list;
	}
	
	public void run(){
		removeEntry();
	}
	
	void removeEntry(){
		synchronized(ll){
			try{
				for(int i=0;i<10;i++){
					if(ll.remove("Hi")) {
						System.out.println("removeEntry success!! by: "+Thread.currentThread().getName());
						ll.notifyAll();
					}
					else {
						System.out.println("removeEntry failed !! by: "+Thread.currentThread().getName());
						ll.wait();
						i--;
					}
				}
			} catch(InterruptedException ie){
				System.out.println("InterruptedException occured by Thread: "+Thread.currentThread().getName()+" and exception details: "+ie.getMessage());
			}
		}
	}
}
