public class Receiver extends Thread{
	
	Contenitore c;

	Receiver(Contenitore c){
		this.c=c;
		setDaemon(true);
	}

	@Override
	public void run(){

		while(true){
			System.out.println("[RECEIVER] ricevo");
			int res=c.receive();
			System.out.println("[RECEIVER] ho ricevuto:"+res);
		}

	}
}