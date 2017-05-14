
import java.util.*;

public class CutTheSticks {

    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        if (in == null) throw new NullPointerException();
        
        int number = in.nextInt();
        if (number < 1 || number > 1000) 
            throw new IllegalArgumentException("Invalid n=" + number + " indicated");
        
        ArrayList<Integer> sticks = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int stick = in.nextInt();
            if (stick < 1 || stick > 1000) 
                throw new IllegalArgumentException("Invalid length of stick=" + stick + " indicated");
            sticks.add(stick);
        }
        
        int shortest = sticks.get(0);
        for (int i = 0; i < number; i++) {
            if (sticks.get(i) < shortest)
                shortest = sticks.get(i);
        }
        
        while (!sticks.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer i : sticks) {
                int cut = i - shortest;
                if (cut >= 1) list.add(cut);
            }
            
            System.out.println(sticks.size());
            sticks = list;
            
            if (!sticks.isEmpty()) {
                shortest = sticks.get(0);
                for (Integer i : sticks) {
                    if (i < shortest) shortest = i;
                }
            }
        }
        in.close();
    }

}
