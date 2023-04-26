package testData_Poorna;

public class AddData_Payload_API_Poorna {

	private String accountno;
	private String departmentno;
private String salary;
private String pincode;



public AddData_Payload_API_Poorna(String sAccNo, String sDeptNo, String sSalary, String sPinCode) {
	this.accountno=sAccNo;
	this.departmentno=sDeptNo;
	this.salary=sSalary;
	this.pincode=sPinCode;
}

public String getAccountNo() {
	return accountno;
}

public String getDeptNo() {
	return departmentno;
	}
 public String getsSalary() {
	 return salary;
 }
public String getPincode() {
	return pincode;
}


}