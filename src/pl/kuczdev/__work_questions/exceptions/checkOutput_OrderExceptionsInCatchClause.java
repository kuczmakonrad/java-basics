package pl.kuczdev.__work_questions.exceptions;
/*
    QUESTION: Is there any order in which catch block should be written?
        Yes, most specific exception should be written first and then generic one.

    For example:
        below code will give you compilation error.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class checkOutput_OrderExceptionsInCatchClause {
    public static void main(String[] args) {
        /*
        try {
            BufferedReader f = new BufferedReader(new FileReader("/test"));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
