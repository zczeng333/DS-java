public class factor {
    public factor(factor head, factor tail, float coef, int degree) {
        /**
         * @description factor data structure for polynomial
         * @param head parent of factor
         * @param tail child of factor
         * @param coef coefficient of the factor
         * @param degree degree of the factor
         * @return
         * @author zczeng
         * @date 2020/2/29 20:14
         */
        this.head = head;
        this.tail = null;
        this.coef = coef;
        this.degree = degree;
    }

    public factor head;
    public factor tail;
    public float coef;
    public int degree;
}