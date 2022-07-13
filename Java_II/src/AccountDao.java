import java.util.List;

public interface AccountDao {
	String addAnAccount(Account account);

	void withdraw(int accountNumber, double amount);

	Double checkBalance(int accountNumber);

	void changePassword(int accountNumber, String oldPassword, String newPassword);

	List<Account> viewAllAccounts();

	Account getAccountDetails(int accountNumber);
}
