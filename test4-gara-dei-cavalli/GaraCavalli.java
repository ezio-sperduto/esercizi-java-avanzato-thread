import java.util.stream.*;

public class GaraCavalli{
	public static void main(String...args){
		System.out.println("\t\t\t--- LA GARA DEI CAVALLI ---");

		for(int i=1;i<=5;i++)
			new TCavallo(i).start();
	}
}

class TCavallo extends Thread{

	int indice;
	TCavallo(int indice){
		this.indice=indice;
	}

	static int random(int range){
		return ((int)(Math.random()*range))+1;
	}

	String tabulazioni(){
		return Stream.generate(()->"\t").limit(indice).reduce("",String::concat);
	}

	@Override
	public void run(){

		for(int i=0;i<10;i++){

			try{Thread.sleep(random(2000));}catch(Exception e){}
			System.out.println("["+indice+"]"+tabulazioni()+"|");
		}

		System.out.println("["+indice+"] Sto MORENDO!!!!");
	}

}