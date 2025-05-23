package encapsulation;

public class FixedDepositAmount {
	private String customerName;
	private double principalAmount;
	private double interestRate;
	private int duration;
	private double maturityAmount;
	
	public FixedDepositAmount(String customerName,double principalAmount ,double interestRate,int duration,double maturityAmount){
		
		this.customerName=customerName;
		this.principalAmount=principalAmount;
		this.interestRate=interestRate;
		this.duration=duration;
		this.maturityAmount=maturityAmount;
       System.out.println( "Fixed Deposit Created Successfully" );
	}
   
	public String getCustomerName() {
		return this.customerName;
	}
	public  void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	public double getPrincipalAmount() {
		return this.principalAmount;
	}
	public  void setPrincipalAmount(double principalAmount) {
		this.principalAmount=principalAmount;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	public  void setInterestRate(double interestRate) {
		this.interestRate=interestRate;
	}
	public int getDuration() {
		return this.duration;
	}
	public  void setDuration(int duration) {
		this.duration=duration;
	}
	public double getMaturityAmount() {
		return this.maturityAmount;
	}
	public  void setMaturityAmount(double maturityAmount) {
		this.maturityAmount=maturityAmount;
	}
	
	public double calculateMaturityAmount() {
		 
		double rate=this.interestRate/100.0;
		double ci=this.principalAmount*Math.pow(1+(rate/12),12*this.duration);
		this.maturityAmount=ci;
		
		return Math.round(this.maturityAmount*100.0)/100.0;
		
	}
	
	
	public void withdrawBeforeMaturity(int withdrawInMonths) {
		 if (withdrawInMonths < 12) {
		        System.out.println("Cannot withdraw before one year");
		    } 
		 
		  else if(withdrawInMonths<this.duration*12){
		        double penalty = this.principalAmount * 0.02; 
		        double withdrawAmount = this.principalAmount - penalty;
		        System.out.println("Withdrawal before maturity with 2% penalty applied.");
		        System.out.println("Amount after penalty: " + Math.round(withdrawAmount * 100.0) / 100.0);
		    }
		  else {
			  System.out.println("You are withdrawing after maturity go and collect it");
		  }
		
	}

	public static void main(String[] args) {
		
		FixedDepositAmount f = new FixedDepositAmount("Prashu",100000,7,2,0);
		System.out.println(f.calculateMaturityAmount());
		f.withdrawBeforeMaturity(14);

	}

}