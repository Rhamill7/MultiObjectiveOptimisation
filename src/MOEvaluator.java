
import org.opt4j.core.problem.Evaluator;

import java.util.ArrayList;

import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;

public class MOEvaluator implements Evaluator<String> {
	Reader r = new Reader();

	@Override
	public Objectives evaluate(String phenotype) {

	
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
		double score = 0.0;
		char[] pheno = phenotype.toCharArray();
		for (int i = 0; i < pheno.length; i++) {
			if (pheno[i] == '1') {
					score += r.getScore(i);
				}
			
		}return score;
}

}
