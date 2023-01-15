package pl.kuczdev.__work_questions.string_lastindexof_method;

public class StringLastIndexOfMethodExample {
    public static void main(String[] args) {

        String str="Hello world from java2blog";
        // Using lastIndexOf method with character
        System.out.println("---------------------------------------------------");
        System.out.println("Using lastIndexOf method with character");
        System.out.println("---------------------------------------------------");
        System.out.println("Last index of character l in \"Hello world from java2blog\" is : "+str.lastIndexOf('l'));
        System.out.println();
        // OUTPUT: Last index of character l in "Hello world from java2blog" is : 23

        System.out.println("---------------------------------------------------");
        System.out.println("Using lastIndexOf method with fromIndex with character");
        System.out.println("---------------------------------------------------");
        System.out.println("Last index of character o from index 6 in \"Hello world from java2blog\" is : "+str.lastIndexOf('o',6));
        System.out.println();
        // OUTPUT: Last index of character o from index 6 in "Hello world from java2blog" is : 4

        // Using lastIndexOf method with String
        System.out.println("---------------------------------------------------");
        System.out.println("Using lastIndexOf method with String");
        System.out.println("---------------------------------------------------");

        String str1="from";
        System.out.println("Last index of String \"from\" in \"Hello world from java2blog\" is : "+str.lastIndexOf(str1));
        System.out.println();
        // OUTPUT: Last index of String "from" in "Hello world from java2blog" is : 12

        String howDo="How do you do";
        System.out.println("---------------------------------------------------");
        System.out.println("Using lastIndexOf method with fromIndex with String");
        System.out.println("---------------------------------------------------");
        System.out.println("Last index of String \"do\" from index 9 in \"How do you do\" is : "+howDo.lastIndexOf("do",9));
        System.out.println();
        // OUTPUT: Last index of String "do" from index 9 in "How do you do" is : 4
        System.out.println("---------------------------------------------------");
        System.out.println("If String or char is not available");
        System.out.println("---------------------------------------------------");
        System.out.println("Last index of \"from\" in \"How do you do\" is : "+howDo.lastIndexOf("from"));
        // OUTPUT: Last index of "from" in "How do you do" is : -1
    }
}