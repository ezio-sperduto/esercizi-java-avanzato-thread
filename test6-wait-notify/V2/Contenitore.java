public class Contenitore{

	private Integer contenuto;

	synchronized public void send(int contenuto){
		this.contenuto = contenuto;
		notify();
	}

	synchronized public int receive(){
		try{
			while(contenuto==null){
				wait();
			}
		}catch(InterruptedException ie){

		}

		int res = contenuto;
		contenuto = null;
		return res;
	}
}