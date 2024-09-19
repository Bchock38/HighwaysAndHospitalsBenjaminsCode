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
        //intialize instance variables
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
        //if the cost of making hospitals is cheaper than road then return the cost of building a hospital in every city
        if (highwayCost > hospitalCost){
            return (long) n * hospitalCost;
        }
        //for all the touching/nieghboring cities
        for (int i = 0; i < cities.length; i++){
            //cityRight = the city on the right
            cityRight = cities[i][1];
            //cityLeft = the city on the left
            cityLeft = cities[i][0];
            //save the orginal left city for path compression
            cityLeft2 = cityLeft;
            //save the orginal right city for path compression
            cityRight2 = cityRight;
            //while left city isn't the root iterate up till you get to the root
            while (clusters[cityLeft] > 0){
                cityLeft = clusters[cityLeft];
            }
            //while right city isn't the root iterate up till you get to the root
            while (clusters[cityRight] > 0){
                cityRight = clusters[cityRight];
            }
            //use path compression on city left
            while (clusters[cityLeft2] > 0){
                temp = clusters[cityLeft2];
                clusters[cityLeft2] = cityLeft;
                cityLeft2 = temp;
            }
            //use path compression on city right
            while (clusters[cityRight2] > 0){
                temp = clusters[cityRight2];
                clusters[cityRight2] = cityRight;
                cityRight2 = temp;
            }
            //if city right isn't the same as city left
            if (cityRight != cityLeft){
                //if city right is larger/has more nodes add city left to it and have city left point to city right as it's root
                if (clusters[cityRight] < clusters[cityLeft]){
                    clusters[cityRight] += clusters[cityLeft]-1;
                    clusters[cityLeft] = cityRight;
                }
                //otherwise add city right to city left and have city right point to city left as it's root
                else{
                    clusters[cityLeft] += clusters[cityRight]-1;
                    clusters[cityRight] = cityLeft;
                }
            }




        }
        //run check cluster amount to get # of clusters
        cluster = checkClusterAmount();
        //return the calcuated cost using equation we made in class
        return (long) cluster *hospitalCost + ((long) (n - cluster) *highwayCost);


    }

    //check for amount of clusters
    public static int checkClusterAmount(){
        int counter = 0;
        //count the amount of roots
        for (int i = 0; i < clusters.length;i++){
            if (clusters[i] <= 0){
                counter++;
            }
        }
        //return the number -1 because of the 0,0 that gets added to the count;
        return counter-1;
    }


}
