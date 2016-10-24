
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;

public class MOEvaluator implements Evaluator<String> {

	@Override
	public Objectives evaluate(String phenotype) {
		Reader r = new Reader();
		r.fileScanner();
		Objectives objectives = new Objectives();
		objectives.add("Requirement Cost", Sign.MIN, evaluateReqCostFitness(phenotype));
		objectives.add("Requirement Score", Sign.MAX, evaluateReqScoreFitness(phenotype));
		return objectives;
	}

	private int evaluateReqCostFitness(String phenotype) {
		char[] pheno = phenotype.toCharArray();
		for (int i =0)
		return 0;

	}
	
	private int evaluateReqScoreFitness(String phenotype){
		return 0;
	}

}
