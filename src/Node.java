public class Node
{

	private int coeff;
	private String var;
	private int expo;
	private boolean noVar;

	public Node(int coeff, String var, int expo)
	{
		this.coeff = coeff;
		setCoeff(coeff);
		setVar(var);
		setExpo(expo);
	}


	public void setVariable(String var)
	{
		setVar(var);
	}

	private void setCoeff(int coeff)
	{
		if(coeff > 1){
			this.coeff = coeff;
		}else{
			this.coeff = -1;
		}
	}

	private void setExpo(int expo)
	{
		if(!noVar) {
			this.expo = expo;
		}else{
			this.expo = 1;
		}
	}

	private void setVar(String var)
	{
		if(var.length() != 0){
			this.var = var;
			this.noVar = false;
		}else{
			this.noVar = true;
		}
	}

	public int getCoeff()
	{
		return coeff;
	}

	public String getVar()
	{
		return var;
	}

	public int getExpo()
	{
		return expo;
	}

	@Override
	public String toString()
	{
		String poly = "";
		if(coeff > 1){
			poly += getCoeff();
		}
		if(!noVar){
			poly += getVar();
		}
		if(getExpo()>1) {
			poly += "^" + getExpo();
		}
		return poly;
	}
}
