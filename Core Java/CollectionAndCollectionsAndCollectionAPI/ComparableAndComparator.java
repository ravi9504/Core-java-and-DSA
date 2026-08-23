import java.util.List;
import java.util.ArrayList;
/*
    Comparable vs Comparator
        Suppose you have List<Employee>emp  want to sort on basis of age, salary , name
        Comparable-> define an object's natural ordering
        class Employee implements Comparable<Employee>{
            @Override
            public int compareTo(Employee other){
                return Integer.compare(this.id,other.id);
                // return this.id-other.id;   it works often but it can produce incorrect when the
                //  integer substraction overflows
                // Integer.compare(this,other)
                this<other---> negative then "this" comes before "other"
                this>other---> positive then "other" comes before "this"
                this=other--> 0 then both are equal
                and this will give you the ascending order
            }
        }
            then Collections.sort()
              Comparator-> defines an external/custom ordering
    see how?
    emp.sort(Comparator.comparing(Employee::getSalary));
    // Sort employees by salary descending 
        emp.sort(Comparator.comparing (Employee:: getSalary).reversed());
 */

import java.util.Collections;

class Employee implements Comparable<Employee>{
    private int age;
    private double salary;
    private String name;

    Employee(int age,double salary, String name){
        this.age=age;
        this.salary=salary;
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Employee other){
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString(){
        return "Name:"+ name+", Age:"+ age +", Salary:"+salary; 
    }
}

// class define implements Comparable<Employee>{
//     @Override
//     public int compareTo(Employee other){
//         return this.
//     }
// }
class ComparableAndComparator{
    public static void main(String args[]){
        List<Employee>emps= new ArrayList<>();
        Employee emp1= new Employee(25,1000000,"Ravi");
        emps.add(emp1);
        Employee emp2= new Employee(28,2498729,"Amit");
        emps.add(emp2);
        Employee emp3= new Employee(30,21498724,"Ankit");
        emps.add(emp3);
        Collections.sort(emps);
        System.out.println(emps);
        
    }
}