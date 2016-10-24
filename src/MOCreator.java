import org.opt4j.core.problem.Creator;
import org.opt4j.core.genotype.BooleanGenotype;
import java.util.Random;

public class MOCreator implements Creator<BooleanGenotype> {
	Random random = new Random();

	public BooleanGenotype create() {
		BooleanGenotype genotype = new BooleanGenotype();
		
		genotype.init(random, 1000); // Better to use injection
		return genotype;
	}
	
	

}
