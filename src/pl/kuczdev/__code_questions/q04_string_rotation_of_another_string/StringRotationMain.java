package pl.kuczdev.__code_questions.q04_string_rotation_of_another_string;

/*
Lets say you need to check whether str1 and str2 is rotation of one another or not.

Create a new String with str3= str1 + str1
Check if str3 contains str2 or not.
if str3 contains str2 then str2 is rotation of str1 else it is not
 */
public class StringRotationMain {
    public static void main(String[] args) {
        System.out.println("java2blog and blogjava2 are rotation of each other : " + isRotation("java2blog", "blogjava2"));
        System.out.println("java2blog and avablog2j are rotation of each other : " + isRotation("java2blog", "avablog2j"));
    }

    private static boolean isRotation(String orginal, String rotation) {
        String result = orginal + orginal;
        if (result.contains(rotation)) return true;

        return false;
    }
}
