package OOPS;

public class challenge {

    public static void main(String[] args) {

        // product itemno price quantity name
        product p = new product("23Ab4C", "Cosmetics");
        p.setQuantity(20);
        p.setPrice(200000);
        System.out.println("Product details: " + "Item no. " + p.getItemno() + " Product Name: " + p.getName() + " Product Quantity: " + p.getQuantity() + "Product Price: " + p.getPrice());

        // customer--> custid name address phoneno
        customer c = new customer("Ab3Q12", "Sinha", "West Bengal");
        c.setPhoneNo("9504397400");

        System.out.println("Customer details:  Customer ID: " + c.getCustId());
        System.out.println("          Name:" + c.getName());
        System.out.println("        Address: " + c.getAddress());
        System.out.println("      Phone No.: " + c.getPhoneNo());

        // subject->subjectid name maxmarks marksobtain   using array of object
        subject s[] = new subject[4];   //   this is new way to create object the class using array....           !NOTED
        s[0] = new subject("BTCS-108-18", "BEE", 60);
        s[1] = new subject("BTCS-118-18", "PPS", 60);
        s[2] = new subject("BTCS-128-18", "EGD", 60);
        s[3] = new subject("BTCS-138-18", "IT WORKSHOP", 100);
        for (subject subs : s) {     //     Subject is the the class name of which we have to create object for each subject array index
            System.out.println("Subject details: Subject Id: " + subs.getSubjectId()
                    + " Subject Name: " + subs.getName() + " Maximum Marks: " + subs.getMaxMarks() + " Marks Obtain: " + subs.getMarksObtain());
        }
        //student-> rollno, dept name subjects
        student st[]= new student[5];
        st[0]=new student("2221041", "Ravi Raushan");       st[0].setCourse("B.Tech");  st[0].setDepartment("CSE");
        st[1]=new student("2221031", "Raghav");             st[1].setCourse("B.Tech");  st[1].setDepartment("Serious");
        st[2]=new student("2221021", "Sinha");              st[2].setCourse("B.Tech");  st[2].setDepartment("Popular");
        st[3]=new student("2221022", "Prakhar");            st[3].setCourse("B.Tech");  st[3].setDepartment("Busy");
        st[4]=new student("2221028", "Priyanshu");          st[4].setCourse("B.Tech");  st[4].setDepartment("CSE");

        for (student stud : st) {
            System.out.println("Student details: Student Name: "+stud.getName()+"\n Student Roll no.: "+stud.getRolloNo()+"\n Student Department: "+stud.getDepartment()+"\n Student Course: "+stud.getCourse()+"\n\n");            
        }
    }
}

class subject {

    private String subjectID;
    private String name;
    private int maxMarks;
    private int marksObtain;

    subject(String subjectId, String name, int maxMarks) {
        this.subjectID = subjectId;
        this.name = name;
        this.maxMarks = maxMarks;
    }

    String getSubjectId() {
        return subjectID;
    }

    String getName() {
        return name;
    }

    int getMaxMarks() {
        return maxMarks;
    }

    void setMarksObtain(int marksObtain) {
        this.marksObtain = marksObtain;
    }

    int getMarksObtain() {
        return marksObtain;
    }

    boolean isQualified() {
        return marksObtain > (maxMarks / 3);
    }
}

class student {

    private String rolloNo;
    private String name;
    private String department;
    private String course;

    student(String rollNo, String name) {
        this.rolloNo = rollNo;
        this.name = name;
    }

    String getCourse() {
        return course;
    }

    String getDepartment() {
        return department;
    }

    String getName() {
        return name;
    }

    String getRolloNo() {
        return rolloNo;
    }
    void setDepartment(String department){
        this.department=department;
    }
    void setCourse(String course){
        this.course=course;
    }

}

class product {

    private String itemNo;
    private String name;
    private int quantity;
    private int price;

    public product(String i, String n) {
        itemNo = i;
        name = n;
        quantity = 0;
        price = 0;
    }

    String getItemno() {
        return itemNo;
    }

    String getName() {
        return name;
    }

    void setQuantity(int q) {
        quantity = q;
    }

    void setPrice(int p) {
        if (p < 0) {
            System.out.println("There is no price detected... Please check is there any discount is used");
        } else {
            price = p;
        }
    }

    int getQuantity() {
        return quantity;
    }

    int getPrice() {
        return price;
    }
}

class customer {

    private String custId;
    private String name;
    private String address;
    private String PhoneNo;

    customer(String custId, String name, String address) {
        this.custId = custId;
        this.name = name;
        this.address = address;
    }

    void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getAddress() {
        return address;
    }

    String getCustId() {
        return custId;
    }

    String getName() {
        return name;
    }

    String getPhoneNo() {
        return PhoneNo;
    }

}
