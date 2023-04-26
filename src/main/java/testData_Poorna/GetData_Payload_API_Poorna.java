package testData_Poorna;

public class GetData_Payload_API_Poorna {
	private String accountno;
	private String departmentno;
private String salary;
private String pincode;
private String userid;
private String id;

public GetData_Payload_API_Poorna(String sAccNo, String sDeptNo, String sSalary, String sPinCode, String sUserid, String sId) {
	this.accountno=sAccNo;
	this.departmentno=sDeptNo;
	this.salary=sSalary;
	this.pincode=sPinCode;
	this.userid=sUserid;
	this.id=sId;
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
public String getUserId() {
	return userid;
}
public String getId() {
	return id;
}
}
