import java.util.*;
import java.util.Scanner;

public class Controller
{
	public static void main(String [] args)
	{
		ArrayList<Product> pr = new ArrayList<Product>();

		Store JadeStore = new Store("JadeStore" , pr );
		JadeStore.cli();

	}

}