
import org.opt4j.core.problem.Evaluator;

import java.util.ArrayList;

import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;

public class MOEvaluator implements Evaluator<String> {
	Reader r = new Reader();

	@Override
	public Objectives evaluate(String phenotype) {

		r.fileScanner();
		Objectives objectives = new Objectives();
		objectives.add("Requirement Cost", Sign.MIN, evaluateReqCostFitness(phenotype));
		objectives.add("Requirement Score", Sign.MAX, evaluateReqScoreFitness(phenotype));
		return objectives;
	}

	private int evaluateReqCostFitness(String phenotype) {
		int cost = 0;
		char[] pheno = phenotype.toCharArray();
		for (int i = 0; i < pheno.length; i++) {
			if (pheno[i] == '1') {
				cost += r.getReq(i);
			}
		}
		// Possibly need to add cost ratio multiplication here
		return cost;

	}

	private double evaluateReqScoreFitness(String phenotype) {
		double score = 0;
		char[] pheno = phenotype.toCharArray();
		ArrayList<Chromosome> customers = r.getCust();
		for (int i = 0; i < pheno.length; i++) {
			if (pheno[i] == '1') {
			
				for (int j = 0; j < customers.size(); j++) {
					double customerValue = ((double) customers.get(j).getCustomerProfit() / (double)customers.size());
					double customerReqValue = 0;
					if (customers.get(j).getCustomerRequirements().contains(i)) {
					customerReqValue= customers.get(j).getCustomerRequirements().indexOf(i)+1.0; //Adding plus oneto make important 1 instead of 0
					}
					else {
						customerReqValue = 0;
					}
					score += (customerValue * customerReqValue);
				}
			}
		}
		return score;
	}

}
