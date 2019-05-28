public class Receiver extends Thread{
	
	Contenitore c;

	Receiver(Contenitore c){
		this.c=c;
	}

	@Override
	public void run(){

		while(true){
			int res=c.receive();
			System.out.println("[RECEIVER] ho ricevuto:"+res);
		}

	}
}