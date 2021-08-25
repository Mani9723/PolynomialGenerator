import java.util.Random;

public class PolynomialGenerator
{

	private String poly;
	private int degree;

	//Randomly generated
	private int numberOfTerms;

	private final static int UNIVARIATE = 1;
	private final static int BIVARIATE = 2;
	private final static int TRIVARIATE = 3;

	private final static int MAX_TERMS = 7;

	public PolynomialGenerator()
	{

	}


	private int getNumberOfTerms()
	{
		return new Random().nextInt(MAX_TERMS);
	}



	public String getPolynomial()
	{
		return this.poly;
	}
}
