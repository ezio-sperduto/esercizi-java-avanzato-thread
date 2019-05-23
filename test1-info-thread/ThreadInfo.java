public class ThreadInfo{
	public static void main(String...args)throws Exception{

		System.out.println("\nStart-Main!");
		Thread.sleep(2500);		
		System.out.println("Continue-Main!\n");

		Thread t=Thread.currentThread();
		System.out.println("nome:"+t.getName());
		System.out.println("id:"+t.getId());
		System.out.println("priorita':"+t.getPriority());
		System.out.println("demone?:"+t.isDaemon());
		ThreadGroup gruppo=t.getThreadGroup();
		System.out.println("nome-gruppo:"+gruppo.getName());

		System.out.println("\n\n");
		for(StackTraceElement ste:t.getStackTrace())
			System.out.println(ste);


		System.out.println("\n\n");
		throw new Exception("PROVAAAAA");
	}
}