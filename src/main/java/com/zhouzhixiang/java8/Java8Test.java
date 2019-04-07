package com.zhouzhixiang.java8;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: Java8剖析与实战
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-01-30 17:24
 */
public class Java8Test {

    /***********************************迭代***********************************/
    /**
     * 外部迭代
     */
    public void test1_1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int number : numbers){
            System.out.println(number);
        }
    }

    /**
     * 内部迭代
     */
    public void test1_2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
    }

    /**
     * java8 lambda进一步
     */
    public void test1_3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach((Integer value) -> System.out.println(value));
    }

    /**
     * java8 lambda再进一步
     */
    public void test1_4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(value -> System.out.println(value));
    }

    /**
     * java8 lambda再再进一步
     */
    public void test1_5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(System.out::println);
    }

    /***********************************迭代***********************************/

    /***********************************排序***********************************/
    /**
     * 普通排序
     */
    public void test2_1() {
        List<String> names = Arrays.asList("zhangsan", "wangwu", "lisi", "zhaoliu");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Student> students = null;
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
    }

    class Student {
        private String name;
        private String score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }
    }

    /**
     * java8 lambda排序
     */
    public void test2_2() {
        List<String> names = Arrays.asList("zhangsan", "wangwu", "lisi", "zhaoliu");
        List<Student> students = new ArrayList<>();
        Collections.sort(names, (a, b) -> {
            return b.compareTo(a);
        });
        Collections.sort(names, (a, b) -> b.compareTo(a));
        Collections.sort(students, (a, b) -> b.getScore().compareTo(a.getScore()));
        System.out.println(names);
        System.out.println(students);
    }
    /***********************************排序***********************************/

    /***********************************函数式接口***********************************/
    public void test3_1() {
        TheInterface theInterface = () -> {};
        System.out.println(theInterface.getClass().getInterfaces()[0]);
        TheInterface2 theInterface2 = () -> {};
        System.out.println(theInterface2.getClass().getInterfaces()[0]);

    }
    /***********************************函数式接口***********************************/

    /***********************************Thread启动线程***********************************/
    public void test4_1() {
        // 使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
            }
        }).start();

        // 使用lambda
        new Thread(() -> System.out.println("start")).start();
    }
    /***********************************Thread启动线程***********************************/

    /***********************************两个List集合之间数据处理***********************************/
    public void test5_1() {
        List<String> list = Arrays.asList("chapter1","two","three");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        List<String> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item.toUpperCase()));
        list2.forEach(item -> System.out.println(item));
    }
    /***********************************两个List集合之间数据处理***********************************/

    /***********************************Stream串行流***********************************/
    public void test6_1() {
        List<String> list = Arrays.asList("chapter1","two","three");
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));
    }
    /***********************************Stream串行流***********************************/

    /***********************************Function高阶函数***********************************/
    /**
     * Function测试类
     */
    class FunctionTest {

        public int compute(int a, Function<Integer, Integer> function) {
            int result = function.apply(a);
            return result;
        }

        public String convert(int a, Function<Integer, String> function) {
            return function.apply(a);
        }
    }
    public void test7_1() {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1, value -> {return 2 * value;}));
        System.out.println(test.compute(2, value -> 5 + value));
        System.out.println(test.compute(3, value -> value * value));
        System.out.println(test.convert(5, value -> String.valueOf(value + "helloworld")));
    }

    static class FunctionTest2 {

        public static void main(String[] args) {
            FunctionTest2 test = new FunctionTest2();
//            System.out.println(test.compute(2, value -> value * 3, value -> value * value)); // 12
//            System.out.println(test.compute2(2, value -> value * 3, value -> value * value)); // 36
//            System.out.println(test.compute3(1, 2, (value1, value2) -> value1 * value2));  // 2
//            System.out.println(test.compute3(1, 2, (value1, value2) -> value1 / value2));  // 0.5

            System.out.println(test.compute4(2, 3, (value1, value2) -> value1 + value2, value -> value * value)); // 25
        }


        public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
            return function1.compose(function2).apply(a);
        }

        public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
            return function1.andThen(function2).apply(a);
        }

        public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
            return biFunction.apply(a, b);
        }

        public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
            return biFunction.andThen(function).apply(a, b);
        }
    }
    /***********************************Function高阶函数***********************************/

    /***********************************BiFunction高阶函数实例***********************************/
    static class Person {
        private String username;
        private Integer age;

        public Person(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    static class PersonTest {
        public static void main(String[] args) {
            PersonTest test = new PersonTest();

            Person p1 = new Person("zhangsan", 20);
            Person p2 = new Person("lisi", 22);
            Person p3 = new Person("wangwu", 25);

            List<Person> peoples = Arrays.asList(p1, p2, p3);

            List<Person> personResult1 = test.getPersonsByUsername("zhangsan", peoples);
            personResult1.forEach(person -> System.out.println(person.getUsername()));

            List<Person> personResult2 = test.getPersonsByAge(20, peoples);
            personResult2.forEach(person -> System.out.println(person.getAge()));

            List<Person> personResult3 = test.getPersonsByAge1(20, peoples);
            personResult3.forEach(person -> System.out.println(person.getAge()));

            List<Person> personResult4 = test.getPersonsByAge2(20, peoples, (age, personList) -> {
                return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
            });
            personResult4.forEach(person -> System.out.println(person.getAge()));

        }

        public List<Person> getPersonsByUsername(String username, List<Person> persons) {
            return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
        }

        public List<Person> getPersonsByAge(int age, List<Person> persons) {
            return persons.stream().filter(person -> person.getAge() == age).collect(Collectors.toList());
        }

        public List<Person> getPersonsByAge1(int age, List<Person> persons) {
            BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> {
                return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
            };
            return biFunction.apply(age, persons);
        }

        public List<Person> getPersonsByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
            return biFunction.apply(age, persons);
        }
    }
    /***********************************BiFunction高阶函数实例***********************************/

    /***********************************Predicate深入剖析***********************************/
    static class PredicateTest {
        public static void main(String[] args) {
            Predicate<String> predicate = p -> p.length() > 5;
            System.out.println(predicate.test("hello1"));
        }
    }

    static class PredicateTest2 {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            PredicateTest2 predicateTest2 = new PredicateTest2();

            predicateTest2.conditionFilter(list, item -> item % 2 == 0);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> item % 2 != 0);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> item > 5);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> item < 3);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> true);
            System.out.println("----------");
            predicateTest2.conditionFilter(list, item -> false);
            System.out.println("----------");

            predicateTest2.conditionAndFilter(list, item -> item > 5, item -> item % 2 == 0);
            System.out.println("----------");

            System.out.println(predicateTest2.isEqual("test").test("test"));
            System.out.println("----------");
        }

        public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
            list.forEach(c -> {
                if (predicate.test(c)) {
                    System.out.println(c);
                }
            });
        }

        public void conditionAndFilter(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
            list.forEach(c -> {
                if (predicate.and(predicate2).test(c)) {
                    System.out.println(c);
                }
            });
        }

        public Predicate<String> isEqual(Object object) {
            return Predicate.isEqual(object);
        }
    }
    /***********************************Predicate深入剖析***********************************/
    /***********************************Supplier深入剖析***********************************/
    static class Student2 {
        private String name = "zhangsan";
        private Integer age;

        public Student2() {
        }

        public Student2(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    static class StudentTest {
        public static void main(String[] args) {
            Supplier<Student2> supplier = () -> new Student2();
            System.out.println(supplier.get().getName());
            System.out.println("--------------");

            Supplier<Student2> supplier1 = Student2::new;
            System.out.println(supplier1.get().getName());
        }
    }
    /***********************************Supplier深入剖析***********************************/
    /***********************************BinaryOperator深入剖析***********************************/
    /**BinaryOperator其父类是BiFunction；
     * 主要提供大小比较的两个函数
     */
    static class BinaryOperatorTest {
        public static void main(String[] args) {
            BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
            System.out.println(binaryOperatorTest.compute(1, 2, (a, b) -> a + b));
            System.out.println("------------------");

            System.out.println(binaryOperatorTest.getShort("hello11111", "world", (a, b) -> a.length() - b.length()));
            System.out.println(binaryOperatorTest.getShort("hello11111", "world", (a, b) -> a.charAt(0) - b.charAt(0)));
        }

        public int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
            return binaryOperator.apply(a, b);
        }

        public String getShort(String a, String b, Comparator<String> compartor) {
            return BinaryOperator.maxBy(compartor).apply(a, b);
        }
    }

    /***********************************BinaryOperator深入剖析***********************************/
    /***********************************Optional深入详解***********************************/
    static class OptionalTest {
        public static void main(String[] args) {
//            Optional<String> optional = Optional.of(null);
            Optional<String> optional = Optional.empty();

//            if (optional.isPresent()) {
//                System.out.println(optional.get());
//            }
            optional.ifPresent(item -> System.out.println(item)); // 推荐使用
            System.out.println("--------------");

            System.out.println(optional.orElse("world"));
            System.out.println("--------------");

            System.out.println(optional.orElseGet(() -> "nihao"));

        }
    }

    static class OptionalTest2 {
        public static void main(String[] args) {
            Employee e = new Employee("zhangsan");
            Employee e2 = new Employee("lisi");

            Company c = new Company("company1", null);

            List<Employee> employees = Arrays.asList(e, e2);
            c.setEmployees(employees);

            List<Employee> list = c.getEmployees();

            // 赋值
            Optional<Company> optional = Optional.ofNullable(c);
            System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));
        }

        static class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        static class Company {
            private String name;
            private List<Employee> employees;

            public Company(String name, List<Employee> employees) {
                this.name = name;
                this.employees = employees;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Employee> getEmployees() {
                return employees;
            }

            public void setEmployees(List<Employee> employees) {
                this.employees = employees;
            }
        }
    }

    /***********************************Optional深入详解***********************************/

    /***********************************方法引用—method reference***********************************/
    /**
     * 方法引用实际上是个Lambda表达式的一种语法糖
     * 我们可以将方法看作是一个【函数指针】，function pointer
     * 方法引用共分为4类：
     * 1、类名::静态方法名
     * 2、引用名（对象名）::实例方法名
     * 3、类名::实例方法名
     * 4、构造方法引用：类名::new
     */
    static class MethodReferenceTest {

        public String getString(Supplier<String> supplier) {
            return supplier.get() + "test";
        }

        public String getString2(String str, Function<String, String> function) {
            return function.apply(str);
        }

        public static void main(String[] args) {
            Student student = new Student("zhangsan", 10);
            Student student1 = new Student("lisi", 90);
            Student student2 = new Student("wangwu", 50);
            Student student3 = new Student("zhaoliu", 40);

            List<Student> students = Arrays.asList(student, student1, student2, student3);

            students.sort((studentParam1, studentParam2) -> Student.compareStudentByScore(studentParam1, studentParam2));
            students.forEach(stu -> System.out.println(stu.getScore()));
            System.out.println("------------------------");

            // 1、类名::静态方法名
            students.sort(Student::compareStudentByName);
            students.forEach(stu -> System.out.println(stu.getName()));

            System.out.println("------------------------");

            // 2、引用名（对象名）::实例方法名
            StudentComparator sc = new StudentComparator();
            students.sort(sc::compareStudentByName);
            students.forEach(stu -> System.out.println(stu.getName()));
            System.out.println("------------------------");
            students.forEach(stu -> System.out.println(stu.getScore()));
            System.out.println("------------------------");

            // 3、类名::实例方法名
            List<String> cities = Arrays.asList("anhui", "chongqing", "qingdao", "beijing");
            Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
            cities.forEach(c -> System.out.println(c));
            System.out.println("------------------------");

            students.sort(Student::compareByName);
            students.forEach(stu -> System.out.println(stu.getName()));
            System.out.println("------------------------");

            students.sort(Student::compareByScore);
            students.forEach(stu -> System.out.println(stu.getScore()));
            System.out.println("------------------------");

            Collections.sort(cities, String::compareToIgnoreCase);
            cities.forEach(System.out::println);
            System.out.println("------------------------");

            MethodReferenceTest mrt = new MethodReferenceTest();
            System.out.println(mrt.getString(String::new));
            System.out.println(mrt.getString2("hello", String::new));
            System.out.println("------------------------");

            // 4、构造方法引用：类名::new
        }

        static class Student {
            private String name;
            private Integer score;

            public Student(String name, Integer score) {
                this.name = name;
                this.score = score;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getScore() {
                return score;
            }

            public void setScore(Integer score) {
                this.score = score;
            }

            public static int compareStudentByScore(Student s1, Student s2) {
                return s1.getScore() - s2.getScore();
            }

            public static int compareStudentByName(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }

            public int compareByScore(Student s) {
                return this.getScore() - s.getScore();
            }

            public int compareByName(Student s) {
                return this.getName().compareToIgnoreCase(s.getName());
            }

        }

        static class StudentComparator {
            public static int compareStudentByScore(Student s1, Student s2) {
                return s1.getScore() - s2.getScore();
            }

            public int compareStudentByName(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        }

    }
    /***********************************方法引用—method reference***********************************/

    /***********************************流—Stream***********************************/
    /**
     * Stream流
     *
     * * Collection提供了新的stream()方法
     * * 流不存储值，通过管道的方式获取值
     * * 本质是函数式的，对流的操作会生成一个结果，不过并不会修改底层的数据源，集合可以作为流的底层数据源
     * * 延迟查找，很多流操作（过滤、映射、排序等）都可以延迟实现
     *
     * 流由三个部分构成：
     * 1、源
     * 2、零个或多个中间操作
     * 3、终止操作
     *
     * 流操作的分类：
     * 1、惰性求值
     * 2、及早求值
     * stream.xxx().yyy().zzz().count();
     *        ----惰性求值-------及早求值--
     */
    static class StreamTest1 {
        public static void main(String[] args) {
            // 流的创建方式
            Stream stream1 = Stream.of("hello", "world", "hello world");
            String[] myArray = new String[]{"hello", "world", "hello world"};
            Stream stream2 = Stream.of(myArray);
            Stream stream3 = Arrays.stream(myArray);
            // 通过结合创建，最常见的方式
            List<String> list = Arrays.asList(myArray);
            Stream stream4 = list.stream();
        }
    }

    static class StreamTest2 {
        public static void main(String[] args) {
            IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);
            System.out.println("-------");

            //range()方法，范围 [3,6)
            IntStream.range(3, 8).forEach(System.out::println);
            System.out.println("-------");

            //rangeClosed()方法，范围[3,8]
            IntStream.rangeClosed(3, 8).forEach(System.out::println);
        }
    }

    static class StreamTest3 {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
            //map()方法，映射
            System.out.println(list.stream().map(i -> i * 2).reduce(0, Integer::sum));
        }
    }

    static class StreamTest4 {
        public static void main(String[] args) {
            //构造流
            Stream<String> stream = Stream.of("hello", "world", "helloworld");
            //遍历流
//            String[] stringArray = stream.toArray(length -> new String[length]);
//            String[] stringArray2 = stream.toArray(String[]::new);
//            Arrays.asList(stringArray2).forEach(System.out::println);

//            List<String> list = stream.collect(Collectors.toList());
//            List<String> list = stream.collect(() -> new ArrayList<>(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
            //方法引用
            List<String> list = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

            list.forEach(System.out::print);
//            list2.forEach(System.out::print);
//            list3.forEach(System.out::print);



        }
    }

    static class StreamTest5 {
        public static void main(String[] args) {
            Stream<String> stream = Stream.of("hello","world");
            //将流转换为一个List
            List<String> list1 = stream.collect(Collectors.toList());
            list1.forEach(System.out :: println);
            System.out.println("--------------------------");

            //将流转换为Set
            Stream<String> stream0 = Stream.of("hello","world");
            Set<String> set = stream0.collect(Collectors.toCollection(TreeSet ::new));
            set.forEach(System.out :: println);
            System.out.println("--------------------------");

            //拼接字符串
            Stream<String> stream1 = Stream.of("hello","world");
            String str = stream1.collect(Collectors.joining()).toString();
            stream1.collect(Collectors.joining()).toString();
            System.out.print(str);
            System.out.println("--------------------------");

            //将集合中的每个元素转换为大写
            List<String> list = Arrays.asList("hello", "world", "helloworld", "test");
            list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
            System.out.println("--------------------------");

            List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
            list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
            System.out.println("--------------------------");

            //flatMap 将每个List都平平方，再将其作为一个整体输出，也就是一个List。
            Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
            listStream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
        }
    }

    static class StreamTest6 {
        public static void main(String[] args) {
            // generate()方法
            Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
            stream.findFirst().ifPresent(System.out::println);
            // iterate方法
            Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);
            System.out.println("------------------------------");

            // 找出流中大于2的元素，然后将每个元素乘以2，然后忽略掉流中的前两个元素，
            // 再取流中的前两个元素，最后求出流中元素的总和
            int sum = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();
            System.out.println(sum);
            System.out.println("------------------------------");

            // 找出流中大于2的元素，然后将每个元素乘以2，然后忽略掉流中的前两个元素，
            // 再取流中的前两个元素，最后求出流中最小的元素
            // 注意 min()返回的是int的包装类型 OptionalInt
            // 这样的区别在于返回的值是否能够为空，下面这种会抛出异常
            System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().getAsInt());

            System.out.println("------------------------------");
            List<String> list = Arrays.asList("hello", "world", "hello world");
            //将集合的每个单词首字母变大写后输出
            list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out :: println);

            System.out.println("------------------------------");
            //下面没有任何输出 因为map操作是惰性求值的，也就是在没有遇到终止操作之前，是不会求值的。   惰性求值
            list.stream().map(item -> {
                String result = item.substring(0, 1).toUpperCase() + item.substring(1);
                System.out.println("test");
                return result;
            });

            System.out.println("------------------------------");
            //下面将会有输出 。因为有终止信号 forEach()   立即求值
            list.stream().map(item -> {
                String result = item.substring(0, 1).toUpperCase() + item.substring(1);
                System.out.println("test");
                return result;
            }).forEach(System.out::println);

            // 找出所有单词，并且去重.
            List<String> list4 = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
            // 输出的是四个数组对象
            list4.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out :: println);

            // 应该使用flatMap . flatMap()的作用在于打平
            List<String> reList = list4.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct()
                    .collect(Collectors.toList());
            reList.forEach(System.out::println);
        }
    }

    /***********************************流—Stream***********************************/

    /***********************************流的短路与并发流***********************************/
    static class StreamTest7 {
        public static void main(String[] args) {
            //对比串行流与并行流
            List<String> list = new ArrayList<>(5000000);

            for (int i = 0; i < 5000000; ++i) {
                list.add(UUID.randomUUID().toString());
            }
            System.out.println("开始排序");
            long startTime = System.nanoTime(); // 时间更精确

            // 串行流
            // list.stream().sorted().count(); //花费9s ，只有一个线程

            // 并行流
            list.parallelStream().sorted().count(); // 花费5s , 多个线程

            long endTime = System.nanoTime();

            long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

            System.out.println("排序耗时： " + millis);
        }
    }
    /***********************************流的短路与并发流***********************************/

    /***********************************流的短路***********************************/
    static class StreamTest8 {
        public static void main(String[] args) {
            // 将列表中长度为5的单词的长度打印出来。
            List<String> list = Arrays.asList("hello", "world", "hello world");
            // 打印结果  5
            list.stream().mapToInt(item -> item.length()).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

            System.out.println("-------------------------");

            // 对比下面的方式
            // 打印结果 5 5  （因为内部也有一个打印）
            list.stream().mapToInt(item -> {
                int length = item.length();
                System.out.println(length);
                return length;
            }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

            // 打印的结果 hello 5 这其实就是流的短路。找到了符合条件的，其他的就不再执行。
        }
    }
    /***********************************流的短路***********************************/

    /***********************************流的分组与分区***********************************/
    static class StreamTest9 {
        static class Student2 {
            private String name;
            private Double chinese;
            private Double math;
            private Double score;

            public Student2(String name, Double chinese, Double math) {
                this.name = name;
                this.chinese = chinese;
                this.math = math;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public Double getChinese() {
                return chinese;
            }
            public void setChinese(Double chinese) {
                this.chinese = chinese;
            }
            public Double getMath() {
                return math;
            }
            public void setMath(Double math) {
                this.math = math;
            }
            public Double getScore() {
                return (chinese + math) / 2;
            }
            public void setScore(Double score) {
                this.score = score;
            }
        }
        public static void main(String[] args) {

            Student2 student1 = new Student2("zhangsan", 100.00, 20.00);
            Student2 student2 = new Student2("lisi", 90.00, 20.00);
            Student2 student3 = new Student2("wangwu", 50.00, 30.00);
            Student2 student4 = new Student2("lisi", 90.00, 25.00);

            // 根据名字进行分组
            /*
             * F 传统的方式 Map<String, List<Student>> 1.循环列表 2.取出学生的名字
             * 3.检查map中是否存在该名字，不存在直接加到map中.存在则将map中的list对象取出来，然后将 student对象加到List中
             *
             */

            System.out.println("根据姓名分组----------------------------------");
            // jdk8中提供的分组方式， 和SQL中的分组是一样的概念
            // 把对象加在流中
            List<Student2> students = Arrays.asList(student1, student2, student3, student4);
            // 根据姓名实现分组
            Map<String, List<Student2>> map = students.stream().collect(Collectors.groupingBy(Student2::getName));
            System.out.println(map);

            System.out.println("根据分数分组----------------------------------");

            // 根据分数分组
            Map<Double, List<Student2>> map2 = students.stream().collect(Collectors.groupingBy(Student2::getScore));
            System.out.println(map2);

            System.out.println("求每个分组后的平均值----------------------------------");

            // 求每个分组后的平均值
            Map<String, Double> map3 = students.stream().collect(Collectors.groupingBy(Student2::getName, Collectors.averagingDouble(Student2::getScore)));
            System.out.println(map3);

            System.out.println("分区----------------------------------");

            // 分区: partition by .分区是分组的特殊情况。结果只会有两组
            Map<Boolean, List<Student2>> map4 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90));
            System.out.println(map4);
        }
    }
    /***********************************流的分组与分区***********************************/

    /***********************************collector源码分析与收集器核心***********************************/
    static class StreamTest10 {
        static class Student {
            private String name;
            private Integer age;

            public Student(String name, Integer age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }
        }

        public static void main(String[] args) {
            Student student1 = new Student("zhangsan", 22);
            Student student2 = new Student("lisi", 23);
            Student student3 = new Student("wangwu", 25);
            Student student4 = new Student("zhaoliu", 24);

            List<Student> students = Arrays.asList(student1, student2, student3, student4);
            List<Student> students1 = students.stream().collect(Collectors.toList());
            students1.forEach(System.out::println);
            System.out.println("---------------------");

            System.out.println("count::"+students1.stream().collect(Collectors.counting()));
            System.out.println("count::"+students1.stream().count());
        }
    }
    /***********************************collector源码分析与收集器核心***********************************/




}


@FunctionalInterface
interface TheInterface {
    void myMethod();
}

@FunctionalInterface
interface TheInterface2 {
    void myMethod2();
}