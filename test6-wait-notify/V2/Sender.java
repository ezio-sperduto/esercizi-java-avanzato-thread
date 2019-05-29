public class Sender extends Thread{
	
	Contenitore c;

	Sender(Contenitore c){
		this.c=c;
	}


	@Override
	public void run(){

		for(int i=1;i<11;i++){

			UtilConcorrenza.waitMillisRandom(500);
			
			System.out.println("[SENDER] mando:"+(i*7));
			c.send(i*7);
		}

	}

}