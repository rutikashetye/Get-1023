
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String usr = "hr";
	private static String pass = "hr";
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;

	public AccountDaoImpl() {
		try {
			con = DriverManager.getConnection(url, usr, pass);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (con != null) {
			System.out.println("Connected.");
		} else {
			System.out.println("Not Connected.");
		}
	}

	@Override
	public String addAnAccount(Account account) {
		String sql = "insert into tbl_acc values(?,?,?)";
		String msg = "";
		int count = 0;
		try {

			ps = con.prepareStatement(sql);
			ps.setInt(1, account.getAccountNo());
			ps.setDouble(2, account.getAccountBalance());
			ps.setString(3, account.getAccountPassword());
			count = ps.executeUpdate();
			if (count != 0) {
				msg = "insertion succesful";
			} else {
				msg = "Error occured while insertion. ";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public void withdraw(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		double bal = checkBalance(accountNumber);
		double new_bal = bal - amount;
		String sql = "update table tbl_acc set acc_bal = ? where acc_no= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(2, new_bal);
			ps.setInt(1, accountNumber);
			int count = ps.executeUpdate();
			if (count != 0) {
				System.out.println("Withdrawed Money Successfully Current Balance:" + new_bal);
			} else {
				System.out.println("Error Occured");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Double checkBalance(int accountNumber) {
		String sql = "select acc_bal from tbl_acc where acc_no=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = null;
			double val = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				val = rs.getDouble(2);
			}
			return val;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void changePassword(int accountNumber, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update table tbl_acc set acc_pass = ? where acc_no= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(2, accountNumber);
			ps.setString(1, newPassword);
			int count = ps.executeUpdate();
			if (count != 0) {
				System.out.println("Password Changed Successfully");
			} else {
				System.out.println("Error Occured");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Account> viewAllAccounts() {
		String sql = "select * from tbl_acc";
		List<Account> col = new ArrayList<>();
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			Account st = null;
			while (rs.next()) {
//				st = new Account();
				st.setAccountNo(rs.getInt(1));
				st.setAccountBalance(rs.getDouble(2));
				st.setAccountPassword(rs.getString(3));
				col.add(st);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return col;
	}

	@Override
	public Account getAccountDetails(int accountNumber) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_acc where acc_no=?";
		try {

			ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = null;
			rs = ps.executeQuery();

			Account st = null;
			while (rs.next()) {
//				st = new Account();
				st.setAccountNo(rs.getInt(1));
				st.setAccountBalance(rs.getDouble(2));
				st.setAccountPassword(rs.getString(3));
			}
			return st;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
