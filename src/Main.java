public class Main
{

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
