package inheritance;

public class basics {

    public static void main(String[] args) {
        savingAcc sa= new savingAcc("6546464646465", "Ravi", 500000000, 10000000);
        loanAcc la= new loanAcc("654654644654", "Sudhir", 10000);
        sa.setAddress("Dighwara");  la.setAddress("chupur");
        sa.setDob("20/04/2004");    la.setDob("01/01/1990");
        sa.setPhoneNo("9504397400");  la.setPhoneNo("65654646546");
        sa.setDeposit(60000);  sa.setWithdraw(10000);
        la.setTopUpLoan(20000); la.setRepayment(100000);

        System.out.println("Saving Account Detail: Account No. : "+sa.getAccNo()+"\n Name: "+sa.getName()+"\n Fixed Deposit Amount: "+sa.getFixedDeposit()+" \n Liquidate Amount: "+sa.getLiquidate()+"\n Address: "+sa.getAddress()+"\n Date Of Birth: "+sa.getDob()+"\n Last Withdraw: "+sa.getLastWithdraw()+"\n Last Deposit: "+sa.getLastDeposit()+"\n Phone number: "+sa.getPhoneNo() );

        System.out.println("Loan Account Detail: Account No: "+la.getAccNo()+"\n Name: "+la.getName()+"\n Phone number: "+la.getPhoneNo()+"\n Address: "+la.getAddress()+"\n Date Of Birth: "+la.getDob()+"\n EMI: "+la.getEmi()+"\n Top Up Loan: "+la.getTopUpLoan()+"\n Repayment: "+la.getRepayment());
    }
}

class Account {

    private String accNo;
    private String name;
    private String address;
    private String phoneNo;
    private String dob;

    public Account(String accNo, String name) {
        this.accNo = accNo;
        this.name = name;
    }

    String getAccNo() {
        return accNo;
    }

    String getName() {
        return name;
    }

    void setAddress(String address) {
        this.address = address;
    }

    void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    String getAddress() {
        return address;
    }

    String getPhoneNo() {
        return phoneNo;
    }

    void setDob(String dob) {
        this.dob = dob;
    }
    String getDob(){
        return dob;
    }
}

class savingAcc extends Account {

    private int lastDeposit;
    private int lastWithdraw;
    private int fixedDeposit;
    private int liquidate;

    savingAcc(String accNO, String name, int fixedDeposit, int liquidate) {
        super(accNO, name);      // this is a way to use the constructor of the parent class from child class if this is not then the available non parametrized constructor is called if both parametrized and non parametrized constructor is present and we don't use super keyword in child constructor
        this.fixedDeposit = fixedDeposit;
        this.liquidate = liquidate;
    }

    int getFixedDeposit() {
        return fixedDeposit;
    }

    int getLiquidate() {
        return liquidate;
    }

    void setDeposit(int deposit) {
        lastDeposit = deposit;
        fixedDeposit += lastDeposit;
    }

    void setWithdraw(int withdraw) {
        lastWithdraw = withdraw;
        fixedDeposit -= withdraw;
    }
    int getLastDeposit(){
        return lastDeposit;
    }
    int getLastWithdraw(){
        return lastWithdraw;
    }
}

class loanAcc extends Account{
    private int emi;
    private int topUpLoan;
    private int repayment;
    public loanAcc(String accNo, String name,int emi) {
        super(accNo, name);
        this.emi=emi;
    }
    void setTopUpLoan(int tul){
        topUpLoan=tul;
    }
    int getTopUpLoan(){
        return topUpLoan;
    }
    int getEmi(){
        return emi;
    }
    void setRepayment(int repayment){
        this.repayment=repayment;
    }
    int getRepayment(){
        return repayment;
    }   
}




//   All About this and Super keyword i.e we used frequently in above program 

/*      this keyword is always pointing( or giving reference) to the current context (current class members)
        example: if  there is a method in which we gave parameter name same as already decalred members(variables) then compiler get confused that what to assign and where to assign So that we use this keyword with that member which is already present in the class having duplicate name as parameters to specify that it here to assign the value


        super keyword
        what this keyword is for its class so that super keyword for its parent class ( or super class)
        By using super keyword is a way to access the parameterized constructor of parent class from child class 
 
 */
