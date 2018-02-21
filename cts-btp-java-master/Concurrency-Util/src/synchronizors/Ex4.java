package synchronizors;

import java.util.concurrent.Semaphore;

public class Ex4 {

	public static void main(String[] args) {

		Semaphore questionPaperPool = new Semaphore(4);

		TechLead techLead1 = new TechLead(questionPaperPool, "John TL");
		TechLead techLead2 = new TechLead(questionPaperPool, "Doe TL");
		TechLead techLead3 = new TechLead(questionPaperPool, "Mark TL");
		TechLead techLead4 = new TechLead(questionPaperPool, "Albert TL");

		techLead1.start();
		techLead2.start();
		techLead3.start();
		techLead4.start();

		System.out.println("No work for HR manager");

	}

	static class TechLead extends Thread {

		Semaphore questionPaperPool;

		public TechLead(Semaphore questionPaperPool, String name) {
			super(name);
			this.questionPaperPool = questionPaperPool;

		}

		@Override
		public void run() {

			try {

				System.out.println(Thread.currentThread().getName() + " Waiting for test question paper");
				// Acquiring one question paper
				questionPaperPool.acquire();
				System.out.println(Thread.currentThread().getName() + " acquired test paper");
				System.out.println(Thread.currentThread().getName() + " Conducting test");
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() + " Test done giving back the paper");
				// Giving back the acquired question paper
				questionPaperPool.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
