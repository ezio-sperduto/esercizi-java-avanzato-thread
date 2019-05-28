public class Banca{

	static Integer saldo = 0;

	public static void main(String...args){
		System.out.println("[BANCA] Test sincronizzazione: il saldo è:"+Banca.saldo);
				
		Bonificatore t1=new Bonificatore(1,11);
		Bonificatore t2=new Bonificatore(2,12);
		Bonificatore t3=new Bonificatore(3,13);

		t1.start();
		t2.start();
		t3.start();

		UtilConcorrenza.waitMillis(6000);							// attendi la fine di tutti
		System.out.println("[BANCA] Il saldo è:"+Banca.saldo);
	}
}


class Bonificatore extends Thread{
	int nome;
	int daBonificare;

	Bonificatore(int nome,int daBonificare){
		this.nome=nome;
		this.daBonificare = daBonificare;
	}

	@Override
	synchronized public void run(){

		//synchronized(Banca.saldo){
		
			UtilConcorrenza.waitMillisRandom(500);	// calcolo

		int variabileLocale = Banca.saldo;
		System.out.println("["+nome+"] leggo il saldo:"+variabileLocale);

			UtilConcorrenza.waitMillisRandom(500);	// calcolo

		variabileLocale += daBonificare;
		System.out.println("["+nome+"] incremento di:"+daBonificare);

			UtilConcorrenza.waitMillisRandom(500);	// calcolo

		Banca.saldo = variabileLocale;
		System.out.println("["+nome+"] salvo il saldo di:"+variabileLocale);

			UtilConcorrenza.waitMillisRandom(500);	// calcolo

		//}
	}
}