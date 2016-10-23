import org.opt4j.core.problem.ProblemModule;

public class MOProblemModule extends ProblemModule {
	protected void config() {
		bindProblem(MOCreator.class, MODecoder.class, MOEvaluator.class);
	}

}
