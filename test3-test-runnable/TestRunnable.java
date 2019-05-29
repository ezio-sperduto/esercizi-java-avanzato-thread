public class TestRunnable{

	static int j=0;

	public static void main(String...args){
		System.out.println("Simple-Main!");

		new Thread(new Contatore()).start();

		Contatore r=new Contatore();
		Thread t1=new Thread(r);

		t1.start();

		Thread t2=new Thread(()->{System.out.println("Arrivederci!");});
		t2.start();



		new Thread(()->{

			System.out.println("Bau!!!");

		}).start();


		System.out.println("\n\n");

		for(int i=0;i<100;i++)
			new Thread(()->{System.out.println("Thread n."+(++j));}).start();

	}
}




class Contatore implements Runnable{

	@Override
	public void run(){

		System.out.println("Ciao!");
	}

}