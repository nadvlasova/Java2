package lesson5;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surName;
    private String age;

    public Student(String name, String surName, String age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + surName + " " + age;
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", surName='" + surName + '\'' +
//                ", age=" + age +
//                '}';
        // такой вывод будет у стандартого метода toString который закоментили
//        Student{name='Гарри', surName='Поттер', age=14}
//        Student{name='Рон', surName='Уизли', age=15}
//        Student{name='Гермиона', surName='Гренджер', age=13}
    }
}
