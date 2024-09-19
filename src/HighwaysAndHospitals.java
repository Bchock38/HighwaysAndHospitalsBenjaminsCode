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
        int cluster = 0;
        n = n1;
        hospitalCost = hospitalCost1;
        highwayCost = highwayCost1;
        cities = cities1;
        clusters = new int[n+1];
        int cityRight;
        int cityLeft2;
        int cityLeft;
        int cityRight2;
        int temp;
        int counter;
        if (highwayCost > hospitalCost){
            return (long) n * hospitalCost;
        }
        for (int i = 0; i < cities.length; i++){
            cityRight = cities[i][1];
            cityLeft = cities[i][0];
            cityLeft2 = cityLeft;
            cityRight2 = cityRight;
            while (clusters[cityLeft] > 0){
                cityLeft = clusters[cityLeft];
            }
            while (clusters[cityRight] > 0){
                cityRight = clusters[cityRight];
            }

            while (clusters[cityLeft2] > 0){
                temp = clusters[cityLeft2];
                clusters[cityLeft2] = cityLeft;
                cityLeft2 = temp;
            }
            while (clusters[cityRight2] > 0){
                temp = clusters[cityRight2];
                clusters[cityRight2] = cityRight;
                cityRight2 = temp;
            }

            if (cityRight != cityLeft){
                if (clusters[cityRight] < clusters[cityLeft]){
                    clusters[cityRight] += clusters[cityLeft]-1;
                    clusters[cityLeft] = cityRight;
                }
                else{
                    clusters[cityLeft] += clusters[cityRight]-1;
                    clusters[cityRight] = cityLeft;
                }
            }




        }

//        for (int i = 0; i < clusters.length;i++){
//            System.out.print(clusters[i]);
//        }
        cluster = checkClusterAmount();
        return (long) cluster *hospitalCost + ((long) (n - cluster) *highwayCost);


    }

    public static int checkClusterAmount(){
        int counter = 0;
        for (int i = 0; i < clusters.length;i++){
            if (clusters[i] <= 0){
                counter++;
            }
        }
        return counter-1;
    }


}
