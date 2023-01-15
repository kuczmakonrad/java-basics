package pl.kuczdev.data_structures.HashMap;

import java.util.HashMap;

public class p02_HashMapMethodsComputeFromJava8 {
    public static void main(String[] args) {
        // compute()
            // Let’s say you have a HashMap of team and no. of goal as below.
            HashMap<String,Integer> teamGoalMap = new HashMap<>();
            teamGoalMap.put("team1", 1);
            teamGoalMap.put("team2", 1);

            // Now you want to add 1 goal to team1 and generally, you do it as follow.
            teamGoalMap.put("team1", teamGoalMap.get("team1") + 1);

            // Instead, you can easily do it with compute as below.
            teamGoalMap.compute("team1", (team, goal) -> goal + 1);

            // So whenever you want to apply mappings based on key, value pair then compute should be used.
            System.out.println(teamGoalMap);


        // computeIfPresent()
        // computeIfPresent recomputes the value if specified key is present and value is not null.

            // You might have written code like below before:
            if (teamGoalMap.containsKey("team1")) {
                teamGoalMap.put("team1", teamGoalMap.get("team1") + 1);
            }

            // You can rewrite this with computeIfPresent as below
            // If function returns null, then key will be removed from HashMap.
            teamGoalMap.computeIfPresent("team1",(team,goal) -> goal+1);


        // computeIfAbsent()
        // computeIfAbsent recomputes the value if specified key is not present and function does not return null.

            // You might have written code like below before:
            if(!teamGoalMap.containsKey("team3")) {
                teamGoalMap.put("team3",1);
            }

            // You can rewrite this with computeIfAbsent as below
            // If key is already present in map, then nothing will change.
            teamGoalMap.computeIfAbsent("team3",value -> 1);

    }
}
