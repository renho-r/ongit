package com.renho.testlong;

/**
 * 这段代码虽然没有volatile，但是另外的线程设置为true的时候，其他的四个线程依然停止了运行。 与书上不一致。为啥？
 * 书上说，如果不是volatile的，则另外的线程更新这个值的时候，其他的线程是不会感知到的。所以其他线程就不会停止执行。
 * 
 * @author naughty
 * 
 */
class T {

	public static boolean asleep = false;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					judge();
				}
			}).start();
		}
		Thread.sleep(3000);
		new Thread(new Runnable() {

			public void run() {
				asleep = true;
				//System.out.println("end");
			}
		}).start();

	}

	public static void judge() {
		while (!asleep) {
			/*try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			//CMS();
		}
	}

	public static void CMS() {
		//System.out.println("@");
	}
}