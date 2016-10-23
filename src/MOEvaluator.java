
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;

public class MOEvaluator implements Evaluator<String> {

	@Override
	public Objectives evaluate(String phenotype) {
		Objectives objectives = new Objectives();
		objectives.add("Requirement Cost", Sign.MIN, evaluateReqCostFitness(phenotype));
		objectives.add("Requirement Score", Sign.MAX, evaluateReqScoreFitness(phenotype));
		return objectives;
	}

	private int evaluateReqCostFitness(String phenotype) {
		return 0;

	}
	
	private int evaluateReqScoreFitness(String phenotype){
		return 0;
	}

}
