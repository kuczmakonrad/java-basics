package pl.kuczdev.__fast_testing;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CopiedFiles {
    public static void main(String[] args) {
        File f = new File("/");
        //showFiles(f);
        showDuplicateFiles(f);
    }

    private static void showFiles(File f) {
        for (File file : f.listFiles()) {
            System.out.println("File: " + file.getName() + " | PATH: " + file.getAbsolutePath());
        }
    }


    private static void showDuplicateFiles(File f) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (File file : f.listFiles()) {
            if (hm.containsKey(file)) {
                hm.put(file.getPath() , hm.get(file) + 1);
            }

            hm.putIfAbsent(file.getPath(), 1);
        }

        for (Map.Entry<String, Integer> e : hm.entrySet()) {
        //    if (e.getValue() > 1) {
                System.out.println("File path: " + e.getKey() + "\nis duplicated: " + e.getValue() + " times.");
          //  }
        }
    }
}
