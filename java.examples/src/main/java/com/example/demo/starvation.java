package com.example.demo;
public class starvation
	implements Runnable
{
	private final Object resource_;
	private final String message_;
	private final boolean fair_;

	// program entry point
	public static void main(String[] args)
	{
		boolean fair = false;
		if (args != null && args.length >= 1 && args[0].equals("fair")) {
			fair = true;
		}

		// get the number of available cpus; do twice as much threads
		final int cpus = Runtime.getRuntime().availableProcessors();
		System.out.println("" + cpus + " available cpus found");
		final int runners = cpus * 2;
		System.out.println("starting " + runners + " runners");

		final Object resource = new Object();

		// create sample runners and start them
		for (int i = 1; i <= runners; i++) {
			(new Thread(new starvation(resource, String.valueOf(i), fair))).start();
		}

		// suspend main thread
		synchronized (starvation.class) {
			try {
				starvation.class.wait();
			} catch (InterruptedException ignored) {
			}
		}
	}

	public starvation(Object resource, String message, boolean fair)
	{
		resource_ = resource;
		message_ = message;
		fair_ = fair;
	}

	public void run()
	{
		synchronized (this) {
			for (;;) {
				synchronized (resource_) {
					print(message_);

					// some delay;
					// if we keep synchronized on the contended resource,
					// scheduling isn't fair,
					// (possibly leading to thread starvation)
					try {
						(fair_ ? resource_ : this).wait(100);
					} catch (InterruptedException ignored) {
					}
				}
			}
		}
	}

	private static void print(String s)
	{
		synchronized (System.out) {
			System.out.print(s);
			System.out.flush();
		}
	}
}