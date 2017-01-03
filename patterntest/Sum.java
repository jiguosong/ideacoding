package patterntest;

public abstract class Sum {
	public Sum(Sumtype problemtype) {
		this.problemtype = problemtype;
	}
	
	public Sumtype getProblemType() {
		return problemtype;
	}
	
	protected abstract void run();
	
	private Sumtype problemtype = null;
}


