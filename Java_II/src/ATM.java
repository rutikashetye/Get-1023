
public interface ATM {
	String withdraw(int accountNumber,double amount);
	String changePassword(int accountNumber,String oldPassword,String newPassword);
	Account checkBalance(int accountNumber);

}
