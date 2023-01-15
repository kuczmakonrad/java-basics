package pl.kuczdev.__work_questions.covariant_return_types;
/*
Covariant return type refers to return type of an overriding method.
It allows to narrow down return type of an overridden method without any need to cast the type or check the return type.
Covariant return type works only for non-primitive return types.

From Java 5 onwards, we can override a method by changing its return type only by abiding the condition that return type is a subclass of that of overridden method
return type.


 */
class SuperClass{
    public void demo() {
        System.out.println("This is the method of the superclass");
    }
}
class SubClass extends SuperClass{
    public void demo() {
        System.out.println("This is the method of the subclass");
    }

    public static void main(String args[]){
        SuperClass sub = new SubClass();
        sub.demo();
    }
}