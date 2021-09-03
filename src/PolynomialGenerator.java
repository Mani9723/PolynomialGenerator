import java.util.LinkedList;
import java.util.Random;

/**
 * Randomly generates an unsimplified polynomial.
 *
 * @author Mani Shah
 */
public class PolynomialGenerator
{
	/**
	 * Holds the polynomial
	 */
	private  StringBuilder poly;
	/**
	 * Degree of the polynomial
	 */
	private  int degree;
	/**
	 * Holds the indeterminates of the polynomial
	 */
	private String[] var;
	/**
	 * Contains the nodes(terms) of the polynomial
	 */
	private LinkedList<Node> termsList;
	/**
	 *
	 */
	private  int numberOfTerms;
	private int currentMode;
	private boolean containsVariable;
	/**
	 * One Indeterminate
	 */
	public final static int UNIVARIATE = 1;
	/**
	 * Two Indeterminate
	 */
	public final static int BIVARIATE = 2;
	/**
	 * Three Indeterminate
	 */
	public final static int TRIVARIATE = 3;

	private final static String[] OPERATIONS = {"+","-"};
	private final static String[] VARIABLES = {"x","y","z"};
	private final static int DEFAULT_DEGREE = 3;


	/**
	 * Class that generates a random unsimplified polynomial.
	 * In default mode it will create a univariate polynomial
	 * with a default degree <= 3 while the number of terms
	 * will always be (degree + 1). User can set number of indeterminates
	 * if they want. See: {@link #univariateMode()}
	 * {@link #bivariateMode()} {@link #trivariateMode()}
	 */
	public PolynomialGenerator()
	{
		termsList = new LinkedList<>();
		poly = new StringBuilder();
		this.degree = DEFAULT_DEGREE;
		univariateMode();
		this.numberOfTerms = new Random().nextInt(this.degree+2);
		this.containsVariable = false;
	}

	/**
	 * Resets all of the fields.
	 */
	private void clear()
	{
		termsList = new LinkedList<>();
		poly = new StringBuilder();
		this.degree = DEFAULT_DEGREE;
		this.numberOfTerms = new Random().nextInt(this.degree+2);
		this.containsVariable = false;
	}
	/**
	 * Fills the available variables array with indeterminates
	 */
	private void setValidVariablesArray()
	{

		var = new String[currentMode+1];
		var[0] = "";
		if (currentMode >= 0) {
			System.arraycopy(VARIABLES, 0, var, 1, currentMode);
		}
	}

	/**
	 * Set polynomial mode to Univariate.
	 * One indeterminate.
	 */
	public void univariateMode()
	{
		clear();
		currentMode = UNIVARIATE;
		setValidVariablesArray();
	}

	/**
	 * Set polynomial mode to Bivariate.
	 * Two indeterminates.
	 */
	public void bivariateMode()
	{
		clear();
		currentMode = BIVARIATE;
		setValidVariablesArray();

	}

	/**
	 * Set polynomial mode to Trivariate
	 * Three indeterminates.
	 */
	public void trivariateMode()
	{
		clear();
		currentMode = TRIVARIATE;
		setValidVariablesArray();
	}

	/**
	 * Public method that generates polynomial
	 * @return Generated polynomial
	 */
	public String generatePolynomial()
	{
		createPolynomial();
		return getPolynomial();
	}

	/**
	 * Generates a univariate polynomial
	 */
	private void createPolynomial()
	{
		for(int i = 0; i < this.numberOfTerms+1; i++)
		{
			Node node = new Node(genCoeff(), genVar(), genExponent());
			termsList.add(node);
		}
		if(!containsVariable){
			System.out.println("Hit no variable");
			termsList.get(0).setVariable(var[1]);
		}
		joinTerms();
	}

	private void joinTerms()
	{
		for(Node node : termsList){
			this.poly.append(node);
			this.poly.append(OPERATIONS[new Random().nextInt(OPERATIONS.length)]);
		}
		this.poly.deleteCharAt(this.poly.length()-1);
	}

	/**
	 * Generates a coefficient between 1 < coeff < 100
	 * @return coefficient
	 */
	private int genCoeff()
	{
		return new Random().nextInt(99)+1;
	}

	/**
	 * Chooses a variable based on the predetermined variable list.
	 * @return variable
	 */
	private String genVar()
	{
		String var = this.var[new Random().nextInt(this.var.length)];
		if(!var.equalsIgnoreCase(this.var[0])){
			this.containsVariable = true;
		}
		return var;
	}

	/**
	 * Generates an exponent 1 <= expo <= this.degree
	 * @return Exponent
	 */
	private int genExponent()
	{
		return new Random().nextInt(this.degree+1);
	}

	public String getPolynomial()
	{
		return this.poly.toString();
	}

	public static void main(String[] args)
	{
		PolynomialGenerator polynomialGenerator = new PolynomialGenerator();

		System.out.println("Univariate");
		polynomialGenerator.univariateMode();
		String poly1 = polynomialGenerator.generatePolynomial();
		System.out.println(poly1);

		System.out.println("Bivariate");
		polynomialGenerator.bivariateMode();
		String poly2 = polynomialGenerator.generatePolynomial();
		System.out.println(poly2);

		System.out.println("Trivariate");
		polynomialGenerator.trivariateMode();
		String poly3 = polynomialGenerator.generatePolynomial();
		System.out.println(poly3);

	}

}
