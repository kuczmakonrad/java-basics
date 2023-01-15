package pl.kuczdev.__code_questions.q39_arrays_longest_common_prefix_in_array_strings;
/*
In this post, we are going to see longest common prefix in array of Strings.
So lets say you have string array as below:
    String[] strArr = {"java2blog", "javaworld", "javabean", "javatemp"};

So Longest common prefix in above String array will be “java” as all above string starts with “java”.
Lets take one more example:
    String[] strArr={"sqlblog","sql2world","sqlquery","sqlproc"};
So Longest common prefix in above String array will be “sql” as all above string starts with “sql”.

Algorithm:
    1. Find minimum length String.
    2. Iterate over array of String and if we find any mismatch with minimum length String, we break the loop and that index will give us longest common prefix of this array of String,
 */
public class LongestCommonPrefixInArrayStrings {
    public static void main(String[] args) {
        String[] strArr={"java2blog","javaworld","javabean","javatemp"};
        String longestPrefix=getLongestCommonPrefix(strArr);
        System.out.println("Longest Prefix : "+longestPrefix);
    }
    public static String getLongestCommonPrefix(String[] strArr) {
        if(strArr.length==0) return "";
        String minStr = getMinString(strArr);        // Find minimum length String

        int minPrefixStrLength = minStr.length();
        for(int i= 0; i < strArr.length; i++){
            int j;
            for(j = 0; j < minPrefixStrLength; j++){
                if(minStr.charAt(j) != strArr[i].charAt(j))
                    break;
            }
            if(j < minPrefixStrLength) minPrefixStrLength = j;
        }
        return minStr.substring(0, minPrefixStrLength);
    }

    public static String getMinString(String[] strArr) {
        String minStr = strArr[0];
        for(int i = 1; i < strArr.length; i++){
            if(strArr[i].length() < minStr.length()) minStr = strArr[i];
        }
        return minStr;
    }
}