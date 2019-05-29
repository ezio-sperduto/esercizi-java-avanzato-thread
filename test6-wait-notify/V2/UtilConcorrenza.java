public class UtilConcorrenza{

	static int random(int range){
		return ((int)(Math.random()*range))+1;
	}

	static void waitMillisRandom(int millis){
		try{Thread.sleep(random(millis));}catch(Exception e){}
	}

	static void waitMillis(int millis){
		try{Thread.sleep(millis);}catch(Exception e){}
	}

}