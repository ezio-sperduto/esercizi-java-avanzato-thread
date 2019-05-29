public class Banca{

	static Integer saldo = 0;

	public static void main(String...args){
		System.out.println("[BANCA] Test sincronizzazione: il saldo è:"+Banca.saldo);
				
		Bagno b=new Bagno();

		Bonificatore t1=new Bonificatore(1,11,b);
		Bonificatore t2=new Bonificatore(2,12,b);
		Bonificatore t3=new Bonificatore(3,13,b);

		t1.start();
		t2.start();
		t3.start();

		UtilConcorrenza.waitMillis(6000);							// attendi la fine di tutti
		System.out.println("[BANCA] Il saldo è:"+Banca.saldo);


		Object chiave1=new Object();
		Object chiave2=new Object();
	}
}


class Bonificatore extends Thread{
	int nome;
	int daBonificare;

	Bagno b;

	Bonificatore(int nome,int daBonificare,Bagno b){
		this.nome=nome;
		this.daBonificare = daBonificare;
		this.b=b;
	}

	@Override
	public void run(){

			UtilConcorrenza.waitMillisRandom(500);	// calcolo

	synchronized(Banca.saldo){

		int variabileLocale = Banca.saldo;
		System.out.println("["+Thread.currentThread().getName()+"] leggo il saldo:"+variabileLocale);

			UtilConcorrenza.waitMillisRandom(500);	// calcolo

		variabileLocale += daBonificare;
		System.out.println("["+Thread.currentThread().getName()+"] incremento di:"+daBonificare);

			UtilConcorrenza.waitMillisRandom(500);	// calcolo

		Banca.saldo = variabileLocale;
		
		System.out.println("["+Thread.currentThread().getName()+"] salvo il saldo di:"+variabileLocale);
	}




			UtilConcorrenza.waitMillisRandom(500);	// calcolo
		
	}
}

