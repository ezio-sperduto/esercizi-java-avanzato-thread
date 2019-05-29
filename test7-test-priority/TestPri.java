public class TestPri{
	public static void main(String...args){
		System.out.println("\n\n ******* Test PRIORITY *******");

		// lancio alcuni thread stupidi con elevata differenza di priorità, e che vanno in concorrenza
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(1).start();
		new ThreadTipo1(9).start();


		for(int i=0;i<1000;i++)
			new ThreadTipo2().start();		// thread fittizi solo per intasare il processore


		//UtilConcorrenza.waitMillis(2000);

		System.out.println("\n\n");
	}
}





class ThreadTipo1 extends Thread{
	
	static Object chiave=new Object();		// ATTENZIONE: questo è il lock per la sincronizzazione

	ThreadTipo1(int pri){
		setPriority(pri);
	}


	public void run(){

		stampa("+++ Sono Nato!");

		for(int i=0;i<1000;i++){

			synchronized(chiave){
				UtilConcorrenza.waitMillisRandom(3);		// FINTA lavorazione
				//stampa(" | Sto Lavorando");
			}
		
		}
			
		stampa("--- Sto Morendo!");
	}



	void stampa(String msg){
		Thread t=Thread.currentThread();
		System.out.println("["+t.getName()+";priority="+t.getPriority()+"] "+msg);
	}
}




class ThreadTipo2 extends Thread{		// thread fittizi solo per intasare il processore
	public void run(){
		double d=0;
		for(int i=0;i<10000;i++){
			d += (Math.random() + Math.random() + Math.pow(5,7)/2)*(d+i*(d+i))/(2-5*Math.floor(3.7));
		}
		d *= d*d+3*d/5;	
	}
}