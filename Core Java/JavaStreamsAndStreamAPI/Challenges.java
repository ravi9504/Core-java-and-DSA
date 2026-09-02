import java.util.*;
import java.util.stream.*;

class Employee{
    private int id;
    private String name;
    private double salary;
    private String department;
   

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }

   
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
}
class Challenges {
    public static void main(String args[]){
        List<Integer>n= List.of(1,2,3,4,5,6,7,8,8,9,10,4,6,565,434,23,2343,23,4,5,6,7,8,9,0);
        // level 1 
            //q1- Find all even numbers
            List<Integer>even= n.stream().filter(i->i%2==0).collect(Collectors.toList());
            // even.forEach(j->System.out.println(j));
                // q2- Multliply all the number by 2 and return a new list
            List<Integer>multiply=n.stream().map(i->i*2).collect(Collectors.toList());
            // multiply.forEach(j->System.out.println(j));
                // q3- Find all the numbers greater than 15
            List<Integer>num= n.stream().filter(j->j>15).collect(Collectors.toList());
            // num.forEach(j->System.out.println(j));
                //q4- Remove all the duplicates
            Set<Integer>num1=n.stream().collect(Collectors.toSet());
            // num1.forEach(j->System.out.println(j));
            // q5- Sort the numbers in ascending order
            List<Integer>num2=n.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
            // num2.forEach(System.out::println);

        // level 2
            // q6- Find all even number and sort them in ascending order
            List<Integer>num3=n.stream().distinct().filter(i->i%2==0).sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
            // num3.forEach(System.out::println);
            // q7- Find all the numbers greater than 10 and return their square
            List<Integer>num4=n.stream().filter(i->i>10).map(j->j*j).collect(Collectors.toList());
            // num4.forEach(System.out::println);
            // q8- Skip the first 2 numbers and return the next 3 numbers
            List<Integer>num5=n.stream().skip(2).limit(3).collect(Collectors.toList());
            // num5.forEach(System.out::println);
                // q9- Convert all the names to upperclass and remove the duplicates
            List<String>name=List.of("John","Jane","Jack","Jill","James","Jasmine","Jacob","Julia","John","James");
            Set<String>nam=name.stream().map(e->e.toUpperCase()).collect(Collectors.toSet());
            // nam.forEach(System.out::println);
            // System.out.println("wtf");
                // removing duplicates using distinct
            List<String>na= name.stream().distinct().map(e->e.toUpperCase()).collect(Collectors.toList());
            // na.forEach(System.out::println);
               // q 10- Find the count of numbers greater than 15
        long count= n.stream().filter(i->i>15).count();
        // System.out.println(count);

                        // Level 3

                // q 11- Find the maximum number
        Optional<Integer>maxm=n.stream().max(Comparator.naturalOrder());
        // maxm.ifPresent(System.out::println);
            // q 12- Find the minimum number
        Optional<Integer>minm=n.stream().min(Comparator.naturalOrder());
        // minm.ifPresent(System.out::println);
            // q 13 - Find the sum of all numbers using reduce
        int sum= n.stream().reduce(0,(a,b)->a+b);
        // System.out.println(sum);
        // q 14- check whether any number is greater than 35
        Boolean check= n.stream().anyMatch(i->i>35);
        // System.out.println(check);
        // q 15- Check whether all number is positive
        Boolean check2= n.stream().allMatch(i->i>=0);
        // System.out.println(check2);

                        // Real Java Developer Questions
        List<Employee>gEmp= List.of(
            new Employee(1,"Ravi",60000,"IT"),
            new Employee(2,"Priya",50000,"IT"),
            new Employee(3,"Rahul",70000,"Finance"),
            new Employee(4,"Anita",40000,"Finance"),
            new Employee(5,"Aman",0,"HR"),
            new Employee(6,"Aman",50000,"Supporting"),
            new Employee(6,"Ramesh",55000,"IT")
        );
        
        // q16- Get names of all employees    and i have answered in two ways to print this
        List<Employee>emps= gEmp.stream().collect(Collectors.toList());
        // emps.forEach(e->System.out.println(e.getName()));
        List<String>emps1=gEmp.stream().map(e->e.getName()).collect(Collectors.toList());
        // emps1.forEach(System.out::println);

        // q17- Find employees with salary greater than 50000
        List<Employee>emps2=gEmp.stream().filter(e->e.getSalary()>50000).collect(Collectors.toList());
        // emps2.forEach(e->System.out.println(e.getId()+ " "+e.getName()+" "+e.getDepartment()+" "+e.getSalary()));

        // q18- Sort employees by salary descending
        List<Employee>emps3=gEmp.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary)
                                                .reversed())
                                .collect(Collectors.toList());
        // emps3.forEach(e->System.out.println(e.getId()+ " "+e.getName()+" "+e.getDepartment()+" "+e.getSalary()));

        //q19 Find the highest-paid employee
        Optional<Employee>emps4= gEmp.stream().max(Comparator.comparingDouble(Employee::getSalary));
            // emps4.ifPresent(e-> System.out.println(e.getName()));
        
        // q20 Group employees by department
       Map<String , List<Employee>> emps5= gEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        emps5.forEach((dept,emp)-> {System.out.println(dept);
        emp.forEach(e-> System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary())
        );
    });

        // q21 Count employees in each department
        Map<String,Long> emps6= gEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        emps6.forEach((dept,count1)->{
            System.out.println(dept +": "+count1);
        });

        // q22 Find the averageSalary of each department
        Map<String,Double>emps7= gEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        emps7.forEach((dept,avgSalary)->{
            System.out.println(dept+" : "+avgSalary);
        });
        
        // q23 Return only unique department names
        Set<String>emps8= gEmp.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        emps8.forEach(e->System.out.println(e));
}
}