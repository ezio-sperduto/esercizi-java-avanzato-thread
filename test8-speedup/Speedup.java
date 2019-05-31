public class Speedup{


	static boolean primo(int p){
		for(int d=2;d<p;d++)
			if(p%d==0)
				return false;

		return true;
	}


	static int simulazioneSincrona(int from, int to){		
		int tot=0;

		for(int i=from;i<to;i++)
			if(primo(i))
				tot++;

		return tot;
	}

	static int simulazioneAsincrona(int from, int to){		

		int bloccoCalcolo = (to-from)/4;

		Calcolatore c1=new Calcolatore(from,					from+bloccoCalcolo);
		Calcolatore c2=new Calcolatore(from+bloccoCalcolo+1,	from+bloccoCalcolo*2);
		Calcolatore c3=new Calcolatore(from+bloccoCalcolo*2+1,	from+bloccoCalcolo*3);
		Calcolatore c4=new Calcolatore(from+bloccoCalcolo*3+1,	to);


		c1.start();
		c2.start();
		c3.start();
		c4.start();

		try{
			c1.join();
			c2.join();
			c3.join();
			c4.join();
		}catch(Exception e){}

		int tot = c1.risultato + c2.risultato + c3.risultato + c4.risultato;

		return tot;
	}

	public static void main(String...args){
		
		// recupero parametri
		if(args.length<2){
			System.out.println("Errore. SINTASSI: java Speedup sincrona 400000");
			return;
		}

		if(!"sincrona".equals(args[0]) && !"asincrona".equals(args[0])){
			System.out.println("Errore. SINTASSI: java Speedup sincrona 400000");
			return;
		}

		int range=-1;
		try{
			range=Integer.parseInt(args[1]);
		}catch(Exception e){
			System.out.println("Errore. SINTASSI: java Speedup sincrona 400000");
			return;
		}





		long prima=System.currentTimeMillis();		// LOG TEMPO
		


		////// CALCOLO
		int quantitaPrimi=-1;
		if("sincrona".equals(args[0]))
			quantitaPrimi = simulazioneSincrona(2,range);

		else
			quantitaPrimi = simulazioneAsincrona(2,range);

		System.out.println("\n\nI numeri primi tra 2 e "+range+" sono in totale:"+quantitaPrimi);
		////// CALCOLO




		long dopo=System.currentTimeMillis();		// LOG e STAMPA TEMPO
		System.out.println("Tempo di calcolo (secondi):"+(dopo-prima)/1000.0+"\n\n");

	}
}

class Calcolatore extends Thread{
	int from,to;
	int risultato;

	Calcolatore(int from,int to){
		this.from=from;
		this.to=to;
		System.out.println("Calcolatore ("+from+";"+to+")");
	}

	public void run(){
		risultato=Speedup.simulazioneSincrona(from,to);
	}
}