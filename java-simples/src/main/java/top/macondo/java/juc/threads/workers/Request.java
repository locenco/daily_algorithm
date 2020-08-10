package top.macondo.java.juc.threads.workers;

/**
 * @author: zhangchong
 * @Date: 2020/8/10 11:00
 **/
public class Request {
	private final String name;
	private final int number;

	public Request(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public void execute(){
		System.out.println(Thread.currentThread().getName() + " executed " + this);
	}

	@Override
	public String toString() {
		return "Request{" +
				"name='" + name + '\'' +
				", number=" + number +
				'}';
	}
}
