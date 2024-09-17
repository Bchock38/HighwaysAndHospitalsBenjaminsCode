import java.util.ArrayList;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Benjamin Chock
 *
 */



public class HighwaysAndHospitals {
private static int n;
private static int hospitalCost;
private static int highwayCost;
private static int[][] cities;
private static int[] clusters;
private static ArrayList <ArrayList> citiesTouching;
    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n1, int hospitalCost1, int highwayCost1, int cities1[][]) {

        n = n1;
        hospitalCost = hospitalCost1;
        highwayCost = highwayCost1;
        cities = cities1;
        citiesTouching = new ArrayList<ArrayList>();
        citiesTouching.add(findTouching(1));
        clusters = new int[cities.length];

        if (highwayCost > hospitalCost){
            return n * hospitalCost;
        }
        for (int i = 0; i < cities.length;i++){
            if (clusters[cities[i][0]] == 0){
                clusters[cities[i][0]] = cities1[i][1];
            }
            else{
                clusters[clusters[cities[i][0]]] =  
            }
        }



//        else{
//            int current = 0;
//            while (getSizeofArrays() < n){
//                citiesTouching.add(findTouching(findmissingCities(citiesTouching.get(current))));
//                current++;
//            }
//            System.out.println(citiesTouching.size()*hospitalCost);
//            System.out.println(n);
//            return (citiesTouching.size()*hospitalCost1 + getSizeofArrays()/2);
//
//        }

        //clusters*hospticalcount +(n-clusters*highwaycost)


//        for (int i = 0; i < citiesTouching.get(0).size(); i++){
//            System.out.print(citiesTouching.get(0).get(i));
//        }
//        System.out.println();
//        for (int i = 0; i < citiesTouching.get(1).size(); i++){
//            System.out.print(citiesTouching.get(1).get(i));
//        }
        return 0;
    }


    public static ArrayList<Integer> findTouching(int toFind){
        ArrayList<Integer> holding = new ArrayList<Integer>();
        holding.add(toFind);
        int newToFind;
        int counter = 0;
        while (counter < holding.size()){
            newToFind = holding.get(counter);
            for (int i = 0; i < cities.length; i++){
                if (cities[i][0] == newToFind && !holding.contains(cities[i][1])){
                    holding.add(cities[i][1]);
                }
            }
            counter++;
        }
        return holding;
    }

    public static int getSizeofArrays(){
        int counter = 0;
        for (int i = 0; i < citiesTouching.size(); i++){
            counter += citiesTouching.get(i).size();
        }
        return counter;
    }

    public static int findmissingCities(ArrayList<Integer> cities){
        for (int i = 0; i < cities.size(); i++){
            if (cities.get(i) != i+1){
                return i+1;
            }
        }
        return 0;
    }

}
