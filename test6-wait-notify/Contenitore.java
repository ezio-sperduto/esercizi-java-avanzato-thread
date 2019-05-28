public class Contenitore{

	private int contenuto;

	public void send(int contenuto){
		this.contenuto = contenuto;
	}

	public int receive(){
		return contenuto;
	}
}