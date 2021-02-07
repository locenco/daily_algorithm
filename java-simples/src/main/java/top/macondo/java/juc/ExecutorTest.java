package top.macondo.java.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author: zhangchong
 * @Date: 2020/10/30 16:19
 **/
@Slf4j
public class ExecutorTest {
	class Invoker implements Executor {

		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}
	@Test
	public void testExecutor(){
		Executor executor = new Invoker();
		executor.execute(()->{
			System.out.println("running");
		});
	}
	// ########################start ExecutorService########################
	/**
	 *
	 * ExecutorService 异步处理 它管理内存中的队列并根据线程可用性安排已提交的任务。
	 */
	public class Task implements Runnable {

		@Override
		public void run() {
			//task detail
			System.out.println("task is running");
		}
	}
	ExecutorService executor = Executors.newFixedThreadPool(10);

	public void execute() {
		executor.submit(new Task());
	}
	@Test
	public void testExecutorService() {
		execute();
		//or
		executor.submit(Task::new);
		Future f = executor.submit(() -> new Task());

		try {
			System.out.println(f.isDone());
			executor.awaitTermination(20L, TimeUnit.NANOSECONDS );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ########################end ExecutorService########################
	// ########################start  ScheduledExecutorService########################
	public void executeScheduled() {
		ScheduledExecutorService executorService =
				Executors.newSingleThreadScheduledExecutor();
		Future future = executorService.schedule(() -> {
			return "result1";
		}, 1, TimeUnit.SECONDS);
		ScheduledFuture scheduledFuture = executorService.schedule(() -> {
			return "scheduled result";
		}, 1, TimeUnit.SECONDS);
		//executorService.shutdown();
		long startTime = System.currentTimeMillis();
		System.out.println(new Date().toString()+ "  ");
		//固定频率执行，开始延迟1s，间隔10s（任务开始即计时，任务时间大于间隔时，任务结束直接执行下一任务）
		/*executorService.scheduleAtFixedRate(() -> {
			System.out.print(new Date().toString()+ "  ");
			System.out.println((System.currentTimeMillis() - startTime) / 1000);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 1, 10, TimeUnit.SECONDS);*/
		//固定延迟执行，开始延迟1s，间隔10s（任务结束后间隔10s）
		executorService.scheduleWithFixedDelay(() -> {
			System.out.print(new Date().toString()+ "  ");
			System.out.println((System.currentTimeMillis() - startTime) / 1000);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 1, 10, TimeUnit.SECONDS);
		try {
			executorService.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testScheduledExecutorService() {
		executeScheduled();
	}
// ########################end  ScheduledExecutorService########################
// ########################start  Future########################
	@Test
	public void invoke(){
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(()->{
			Thread.sleep(5000L);
			return "future";
		});
		//
		if (future.isDone() && !future.isCancelled()) {
			try {
				Assert.assertEquals("future",future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		//or
		try {
			Assert.assertEquals("future", future.get(10, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

// ########################end  Future########################

// ########################start CountDownLatch########################

	// ########################end CountDownLatch########################
// ########################start CyclicBarrier ########################
	 class Task1 implements Runnable {
		private CyclicBarrier cyclicBarrier;

		public Task1(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is waiting");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is released");
		}
	}

	@Test
	public void testCyclicBarrier() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
			System.out.println("All previos tasks are complated");
		});
		Thread thread1 = new Thread(new Task1(cyclicBarrier), "task1");
		Thread thread2 = new Thread(new Task1(cyclicBarrier), "task2");
		Thread thread3 = new Thread(new Task1(cyclicBarrier), "task3");
		if (!cyclicBarrier.isBroken()) {
			thread1.start();
			thread2.start();
			thread3.start();
		}
	}
// ########################end CyclicBarrier ########################
// ########################start Semaphore ########################
	@Test
	public static void executeSemaphore(Semaphore semaphore)  {

		log.info("Available permit : " + semaphore.availablePermits());
		log.info("Number of threads waiting to acquire: " +
				semaphore.getQueueLength());

			try {
				semaphore.tryAcquire();
				System.out.println(Thread.currentThread().getName());
				Thread.sleep((long) (Math.random() * 10000));
				System.out.println("-----------------" + semaphore.availablePermits());
				//semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}

	}

	@Test
	public static void testSemaphone() {
		Semaphore semaphore = new Semaphore(5);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		// 模拟20个客户端访问

		for (int index = 0; index < 20; index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						// 获取许可
						semaphore.acquire();
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 10000));
						// 访问完后，释放
						semaphore.release();
						System.out.println("-----------------" + semaphore.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(run);
		}
		executorService.shutdown();

	}
// ########################end Semaphore ########################
public static void main(String[] args) {
	//testSemaphone();
	Semaphore semaphore = new Semaphore(5);
	ExecutorService executorService = Executors.newFixedThreadPool(10);
	for (int i = 0; i < 1000; i++) {
	    executorService.execute(()->{
			executeSemaphore(semaphore);
	    });
	}

}
}
