package com.spring.interview.demo.LamdaExpressions.classes;

import com.spring.interview.demo.LamdaExpressions.classes.Models.Employee;
import com.spring.interview.demo.LamdaExpressions.classes.Models.EmployeeDTO;
import com.spring.interview.demo.LamdaExpressions.classes.Models.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Important methods of Stream
/*
Stream.of() - to create a stream
stream.forEach() - to loop the stream
.stream() - to convert the collection into stream
.filter() - to filter based on a certain condition
.toList() - converts to list
.sorted() - default sorts in ascending order
.sorted(Comparator.naturalOrder()) - sorts in ascending order
.sorted(Comparator.reverseOrder()) - sorts in descending order
.sorted(Comparator.comparing(Employee::getName) - compares strings
.sorted(Comparator.comparingLong(Employee::getSalary) - compares long
.sorted(Comparator.comparingInt(Employee::getAge) - compares int
.map() - to map to a different obj . eg: .map(emp->emp.getName().toUpperCase) - to do some conversion
.map((emp)-> new EmployeeDTO(emp.getId(),emp.getName(),emp.getAge()))
.peek() - to modify the same stream -> peek(emp->emp.setName(emp.getName()))
.findFirst() - finds the first element
.findAny() - finds any element. but mostly finds the first element only
.count() - gives count inside the stream
.min() - gives min : .min(Comparator.comparing(Integer::valueOf))
.max() - gives max : .max(Comparator.comparing(Integer::valueOf))

*/
public class StreamAPILearning {

    public void createStream()
    {
        //creating
        Stream<String> stream = Stream.of("shilpa", "krishna", "pandu");

        //looping
        stream.forEach(System.out::println);

        //create a stream from sources collection
        Collection<String> collection = Arrays.asList("shilpa", "krishna", "pandu");
        Stream<String> stream1 = collection.stream();
        stream1.forEach(System.out::println);

        //create a stream from list
//        List<String> list = Arrays.asList("shilpa", "krishna", "pandu");
        List<String> list = new ArrayList<>();
        list.add("shilpa");
        list.add("pandu");
        list.add("krishna");
        Stream<String> streamList = list.stream();
        streamList.forEach(System.out::println);

        //just a plain array
        String[] arr = {"a", "b", "c"};
        Arrays.stream(arr).forEach(System.out::println); //vvvvvv imp


    }

    public void filteringUsingStream()
    {

        List<Product> products = getProductList();

        //filter products whose products price greater than 25000
        List<Product> filteredProds = products.stream().filter(p->p.getPrice() > 25000f).toList();
        List<Product> filteredProds1 = products.stream().filter(p->p.getPrice() > 25000f).collect(Collectors.toList());//even if you do this... it shows to use toList()
        filteredProds.forEach(System.out::println);

        //can directly use as below
        getProductList().stream().filter(p->p.getPrice() > 25000f).toList().forEach(System.out::println);
    }

    private List<Product> getProductList() {

        Product p = new Product();
        p.setId(1);
        p.setName("laptop");
        p.setPrice(40000f);

        List<Product> pList = new ArrayList<>();
        pList.add(p);
        return pList;
    }

    //sort string into list
    public void sortList()
    {
        List<String> fruits = new ArrayList<>() ;
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("watermelon");
        fruits.add("apricot");
        fruits.add("lemon");

        //default sorting
        List<String> ascending = fruits.stream().sorted().toList(); //default sorts in ascending order

        //ascending order
        List<String> ascFruits = fruits.stream().sorted(Comparator.naturalOrder()).toList(); //sorts in ascending order
        //we can also do this using lambda expression
        List<String> ascFruits1 = fruits.stream().sorted((s1,s2)->s1.compareTo(s2)).toList();
        //method reference
        List<String> ascFruits2 = fruits.stream().sorted(String::compareTo).toList();

        //descending order
        List<String> descFruits = fruits.stream().sorted(Comparator.reverseOrder()).toList(); //descending order

        //using lambda
        List<String> descFruits1 = fruits.stream().sorted((s1,s2)->s2.compareTo(s1)).toList();

    }


    //sort employee object
    public void sortEmployee(){

        //ascending order
        List<Employee> sortedEmp = getEmployees().stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        }).toList();

        //ascending lambda
        List<Employee> sortedEmpt = getEmployees().stream().sorted(((o1,o2) -> (int) (o1.getSalary() - o2.getSalary()))).toList();

        //using comparing default ascending order
        List<Employee> sortedDescCom = getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary)).toList();

        //specifically for long
        List<Employee> sortedDescComl = getEmployees().stream().sorted(Comparator.comparingLong(Employee::getSalary)).toList();

        /////////////////////////////////////////////////////////////////////////////////////////////////

        //descending
        List<Employee> sortedDesc = getEmployees().stream().sorted(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());
            }
        }).toList();

        //descending lambda
        List<Employee> sortedDesclambda = getEmployees().stream().sorted((s1,s2)-> (int) (s2.getSalary()-s1.getSalary())).toList();


        //specifically for long
        List<Employee> sortedDesclong = getEmployees().stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).toList();


        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //sorting employees by age

        //ascending order
        List<Employee> sorted = getEmployees().stream().sorted(Comparator.comparingInt(Employee::getAge)).toList();

        //descending order
        List<Employee> sorteddesc = getEmployees().stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).toList();

        ///////////////////////////////////////////////////////////////////////////////////////////////////

        //ascending order compare by name
        List<Employee> sortedStringAsc = getEmployees().stream().sorted(Comparator.comparing(Employee::getName)).toList();

        //descending order compare by name
        List<Employee> sortedStringDesc = getEmployees().stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();



    }

    public List<Employee> getEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("shilpa");
        employee1.setSalary(10000);
        employee1.setAge(32);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("shilpa");
        employee2.setSalary(10000);
        employee2.setAge(32);
        employees.add(employee2);
        return employees;
    }


    public void usingMapAndCollect()
    {
        //we use stream.map method to map one object into other object.
        //example : map names into upper case

        List<String> employeesUpper = getEmployees().stream().map(emp->emp.getName().toUpperCase()).toList();

        //or if you want to convert the names into upper case in another list
//        peek() is used to perform a side-effect (like modifying the object) without altering the stream pipeline.
        List<Employee> modifiedEmpList = getEmployees().stream().peek(emp->emp.setName(emp.getName().toUpperCase())).toList();
        //or this can be done using forEach . In place mutation
        getEmployees().forEach(emp -> emp.setName(emp.getName().toUpperCase()));



        //map each Employee into EmployeeDto Object - take data from employee object and put into employeeDto
        //using Function class where we pass Employee as input and get EmployeeDto as output

        List<EmployeeDTO> employeeDTOS = getEmployees().stream().map(new Function<Employee,EmployeeDTO>(){

            @Override
            public EmployeeDTO apply(Employee emp) {
                return new EmployeeDTO(emp.getId(), emp.getName(), emp.getAge());
            }
        }).toList();

        //replacing with lambda
        List<EmployeeDTO> employeeDTOS1 = getEmployees().stream().map((emp)-> new EmployeeDTO(emp.getId(),emp.getName(),emp.getAge())).toList();
        employeeDTOS1.forEach(System.out::println);

    }

    //Finding elements using stream api
    public void findElements()
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5,2);

        //find the first element from the stream
        Optional<Integer> element = list.stream().findFirst();
        //if present print it
        if(element.isPresent())
        {
            System.out.println(element.get());
        }

        //write more appropriate one
        element.ifPresent(System.out::println);


        //findAny() - to find if any element is present
        Optional<Integer> el = list.stream().findAny();
        element.ifPresent(System.out::println);

    }

    //count min and max methods
    public void countMinMax()
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5,2);

        //count
        int count = (int) list.stream().count(); //but mostly used with list.size()

        //find min
        Integer min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();

        //find max
        Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
    }

}
