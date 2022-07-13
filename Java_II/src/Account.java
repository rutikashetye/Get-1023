abstract class Account {
	private int accountNo;
	private double accountBalance;
	private String accountPassword;
	private static String bankName="LTI Bank";
	
	abstract double  withdraw(double amount);
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(int accountNo, double accountBalance, String accountPassword) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accountPassword = accountPassword;
	}
	public void displayAccount() {
		System.out.println("ACC NO:"+accountNo+" | "+"Account Bal:"+accountBalance+" | "+"Account Password:"+accountPassword+" | Bank Name:"+bankName);
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String newPassword) {
		this.accountPassword = newPassword;
	}
	

}
