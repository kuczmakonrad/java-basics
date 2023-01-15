package pl.kuczdev.__work_questions.covariant_return_types;

class A {
}

class B extends A {
}

class BaseClass {
    public A m1() {
        System.out.println("In BaseClass method");
        return new A();
    }
}

class ChildClass extends BaseClass {
    public B m1() {
        System.out.println("In ChildClass method");
        return new B();

    }
}

public class OtherExample {
    public static void main(String args[])
    {
        BaseClass b=new ChildClass();
        b.m1();
    }
}
