import java.io.File;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	ArrayList<Integer> requirements = new ArrayList<Integer>();
	ArrayList<Chromosome> customers = new ArrayList<Chromosome>();
	ArrayList<Double> scores = new ArrayList<Double>();

	public Reader(){
		try {
			System.out.println("HELLO");
			// String title ="";
			// FilePermission permission = new
			// FilePermission("C:/Users/Robbie/Documents/Classic-nrp/nrp1.txt",
			// "read");
			int i = 1;
			File infile = new File("C:/Users/Robbie/Documents/Classic-nrp/nrp1.txt");
			if (!infile.canRead()) {
				infile.setReadable(true);
			}
			Scanner scanner = new Scanner(infile);
			// + "nrp1.txt"));
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
					// System.out.println(custProf + " " + requestNo + " " +
					// reqs);
					customers.add(new Chromosome(custProf, requestNo, reqs));

				} else {
					scanner.nextLine();
				}

				i++;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// working out score

		for (int l = 0; l < requirements.size(); l++) {
			double score = 0.0;
			for (int m = 0; m < customers.size(); m++) {
				double customerValue = ((double) customers.get(m).getCustomerProfit() / (double) customers.size());
				int customerReqValue = 0;
				if (customers.get(m).getCustomerRequirements().contains(l)) {
					customerReqValue = customers.get(m).getCustomerRequirements().indexOf(l) + 1;
				} else {
					customerReqValue = 0;
				}
				score += (customerValue * (double) customerReqValue);
			}
			scores.add(score);
		}
	}
	
	public int getReq(int position) {
		return requirements.get(position);

	}

	public double getScore(int position) {
		return scores.get(position);
	}

	public ArrayList<Chromosome> getCust() {
		return customers;

	}

	public void fileScanner() {

		

	}
}
