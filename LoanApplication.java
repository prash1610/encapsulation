package encapsulation;

public class LoanApplication {
	private String customerName;
	private double loanAmount;
	private double interestRate;
	private int loanTerm;
	private double outstandingBalance;

	public LoanApplication(String customerName, double loanAmount, double interestRate, int loanTerm) {
		this.customerName = customerName;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.outstandingBalance = loanAmount; 
		System.out.println("Loan Application Submitted");
	}

	public String getCustomerName() { 
		return customerName; 
		}
	public double getLoanAmount() { 
		return loanAmount; 
		}
	public double getInterestRate() { 
		return interestRate; 
		}
	public int getLoanTerm() { 
		return loanTerm; 
		}
	public double getOutstandingBalance() { 
		return outstandingBalance; 
		}

	public void setCustomerName(String customerName) { 
		this.customerName = customerName; 
		}
	public void setLoanAmount(double loanAmount) { 
		this.loanAmount = loanAmount;
		}
	public void setInterestRate(double interestRate) { 
		this.interestRate = interestRate; 
		}
	public void setLoanTerm(int loanTerm) { 
		this.loanTerm = loanTerm; 
		}
	public void setOutstandingBalance(double outstandingBalance) { 
		this.outstandingBalance = outstandingBalance; 
		}

	public void makePayment(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid payment amount");
		} else if (amount > outstandingBalance) {
			System.out.println("Payment exceeds loan balance");
		} else {
			outstandingBalance -= amount;
			System.out.println("Payment of " + amount + " accepted.");
		}
	}

	public double calculateEMI() {
		double monthlyRate = interestRate / (12 * 100);
		int months = loanTerm * 12;
		if (monthlyRate == 0) {
			return loanAmount / months;
		}
		double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
		             (Math.pow(1 + monthlyRate, months) - 1);
		return Math.round(emi * 100.0) / 100.0;
	}

	public void displayDetails() {
		System.out.println("Customer Name: " + customerName);
		System.out.println("Loan Amount: " + loanAmount);
		System.out.println("Interest Rate: " + interestRate);
		System.out.println("Loan Term (years): " + loanTerm);
		System.out.println("EMI: " + calculateEMI());
		System.out.println("Outstanding Balance: " + outstandingBalance);
	}

	public static void main(String[] args) {
		LoanApplication loan = new LoanApplication("Prashanth", 180000, 4, 3);
		loan.displayDetails();
		loan.makePayment(100000);
		loan.displayDetails(); 
	}
}


