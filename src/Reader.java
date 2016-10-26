import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	ArrayList<Integer> requirements = new ArrayList<Integer>();
	ArrayList<Chromosome> customers = new ArrayList<Chromosome>();

	public int getReq(int position) {
		return requirements.get(position);

	}

	public ArrayList<Chromosome> getCust() {
		return customers;

	}

	public void fileScanner() {

		try {
			// String title ="";

			int i = 1;
			Scanner scanner = new Scanner(new FileReader("nrp1.txt"));
			while (scanner.hasNextInt()) {
				// System.out.println(i);
				// scanner.nextLine();
				if (i == 3 || i == 5 || i == 7) {
					String line = scanner.nextLine();
					Scanner miniScan = new Scanner(line);
					while (miniScan.hasNextInt()) {
						requirements.add(miniScan.nextInt());
					}
					miniScan.close();
					// System.out.println(requirements);
				}

				else if (i == 107 || i > 107) {
					String line = scanner.nextLine();
					Scanner miniScan2 = new Scanner(line);
					int custProf = miniScan2.nextInt();

					int requestNo = miniScan2.nextInt();
					ArrayList<Integer> reqs = new ArrayList<Integer>();
					for (int j = 0; j < requestNo; j++) {
						reqs.add(miniScan2.nextInt());
					}
					System.out.println(custProf + " " + requestNo + " " + reqs);
					customers.add(new Chromosome(custProf, requestNo, reqs));

				} else {
					scanner.nextLine();
				}

				i++;

			}
		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
