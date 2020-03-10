import java.util.Arrays;

public class DisSet {
    public static void main(String[] args) {
        /**
         * test for disjoint set operations
         */
        int MaxElement = 30;
        int NumR = 30;
        int temp;
        DisSetOperation S = new DisSetOperation(MaxElement);
        int[][] relation = new int[NumR][2];
        for (int i = 0; i < NumR; i++) {
            relation[i][0] = (int) (Math.random() * (MaxElement - 1)) + 1;
            temp = relation[i][0];
            while (temp == relation[i][0]) {
                temp = (int) (Math.random() * (MaxElement - 1)) + 1;
            }
            relation[i][1] = temp;
            int[] reverse = new int[]{relation[i][1], relation[i][0]};
            for (int j = 0; j < i; j++) {
                if (relation[i] == relation[j] || reverse == relation[j]) {
                    i = i - 1;
                }
            }
        }
        //int[][] relation=new int[][]{{8,3},{3,4},{5,4},{1,8},{1,4},{8,2}};
        System.out.println("Relation: ");
        for (int i = 0; i < relation.length; i++) {
            System.out.println(Arrays.toString(relation[i]));
        }
        S.BuildSet(relation);
        System.out.println("Disjoint Set: ");
        S.PrintSet();
    }
}
