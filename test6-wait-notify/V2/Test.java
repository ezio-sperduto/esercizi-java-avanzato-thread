public class Test{
	public static void main(String...args){

		System.out.println("[TEST] istanzio le classi");
		Contenitore c=new Contenitore();
		Sender t1=new Sender(c);
		Receiver t2=new Receiver(c);

		System.out.println("[TEST] lancio i thread");
		t1.start();
		t2.start();

		System.out.println("[TEST] attendo i miei figli");
		try{
			t1.join();
			//t2.join();
		}catch(InterruptedException ie){}

		//UtilConcorrenza.waitMillis(2000);

		System.out.println("[TEST] muoio");

		System.exit(0);
	}
}