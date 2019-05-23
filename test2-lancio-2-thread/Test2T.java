public class Test2T{
	public static void main(String...args) throws InterruptedException{
		System.out.println("Simple-Main!");


		Thread t1=new Stampatore("stampatore1");
		Thread t2=new Stampatore("stampatore2");

		t1.start();
		t2.start();

		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("[padre] ciao a tutti!");
	}
}


class Stampatore extends Thread{

	private String nome;

	Stampatore(String n){
		nome=n;
	}


	@Override
	public void run(){

		try{
			for(int i=1;i<=10;i++){
				System.out.println("["+nome+"] Conteggio: "+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}