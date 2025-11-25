import java.util.concurrent.*;

public class GKDay2
{
	public static void main(String[] args)
	{
		try {

			ExecutorService executor = Executors.newFixedThreadPool(1000);
			int[] nums = new int[1000];
			for(int i = 0; i < 1000; i++)
			{
				Future<Integer> future = executor.submit(new Callable<Integer>() {
					public Integer call()
					{
						int num = 0;
						for(int i = 0; i < 1000000; i++)
							num += 1;
						return num;
					}
				});
				nums[i] = future.get();
			}
			int total = 0;
			for(int i = 0; i < 1000; i++)
				total += nums[i];
			System.out.println("Total: " +total);
			executor.shutdown();
		}
		catch(InterruptedException e)
		{
			System.err.println(e);
		}
		catch(ExecutionException e)
		{
			System.err.println(e);
		}
	}
}