package my.test.zookeeper.ZookeeperDevelopTest01;

public class DistributedLockTest {
	static int n = 10;

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				DistributedLock lock = null;
				try {
					System.out.println(Thread.currentThread().getName() + "正在运行");
					lock = new DistributedLock("localhost:2181", "DistributedLockTest");
					lock.lock();
					/**
					 * 模拟消费时间，等待半秒
					 */
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(lock != null){
						lock.unlock();
					}
				}
			}
		};
		//创建500个线程，获取分布式锁
		for (int i = 0; i < n; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
	}
}
