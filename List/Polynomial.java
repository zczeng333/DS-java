public class Polynomial {
    public Polynomial(float[] coef, int[] degree) {
        /**define a polynomial based on list structure
         * @description
         * @param coef coefficient array for the polynomial
         * @param degree degree array for the polynomial
         * @return
         * @author zczeng
         * @date 2020/2/29 20:15
         */
        if (coef.length != degree.length) {
            System.out.println("coefficient & degree does not match!");
            this.start = null;
        } else {
            this.length = coef.length;
            this.start = new factor(null, null, 0, 0);/*head is a fake node*/
            factor temp = this.start;
            for (int i = 0; i < coef.length; i++) {
                factor node = new factor(temp, null, coef[i], degree[i]);
                temp.tail = node;
                temp = node;
            }
            this.end = temp;
        }
        sort(this.start, this.end);
        merge();
    }

    public void sort(factor start, factor end) {
        /**
         * @description insertion sort (descending degree order)
         * @param start head node of polynomial list (fake node)
         * @param end end node of polynomial list
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:15
         */
        if (start.tail != null && start.tail.tail != null) {/*when polynomial is not empty or has only one factor*/
            factor record = end;
            factor temp;
            while (record != start.tail) {
                temp = start.tail;
                while (temp != record) {/*when temp's is not record*/
                    if (temp.degree < temp.tail.degree) {
                        swap(temp, temp.tail);
                    }
                    temp = temp.tail;
                }
                record = record.head;
            }
        }
    }

    private void swap(factor A, factor B) {
        /**
         * @description swap two factors
         * @param A factor A
         * @param B factor B
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:16
         */
        float temp1 = A.coef;
        int temp2 = A.degree;
        A.coef = B.coef;
        A.degree = B.degree;
        B.coef = temp1;
        B.degree = temp2;
    }

    public void add(float coef, int degree) {
        /**
         * @description add a new factor to current polynomial
         * @param coef coefficient of the factor
         * @param degree degree of the factor
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:17
         */
        factor node = new factor(this.end, null, coef, degree);
        this.end.tail = node;
        this.end = node;
    }

    public void merge() {
        /**
         * @description merge factors with the same degree in the polynomial
         * @param
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:17
         */
        factor temp = this.start.tail;
        if (temp != null) {/*polynomial is not empty*/
            while (temp.tail != null) {
                if (temp.degree == temp.tail.degree) {
                    temp.coef = temp.coef + temp.tail.coef;
                    if (temp.tail.tail != null) {
                        temp.tail.tail.head = temp;
                    }
                    if (temp.tail.tail == null) {/*when end node has been merged, adjust this.end*/
                        this.end = temp;
                    }
                    temp.tail = temp.tail.tail;
                    continue;
                }
                temp = temp.tail;
            }
        }
    }

    public static Polynomial multiple(Polynomial A, Polynomial B) {
        /**
         * @description multiply two polynomial
         * @param A polynomial A
         * @param B polynomial B
         * @return Polynomial multiplication result
         * @author zczeng
         * @date 2020/2/29 20:18
         */
        factor head_a = A.start.tail;/*first element in polynomial A*/
        factor head_b = B.start.tail;/*first element in polynomial A*/
        Polynomial result = new Polynomial(new float[0], new int[0]);
        while (head_a != null) {
            while (head_b != null) {
                result.add(head_a.coef * head_b.coef, head_a.degree + head_b.degree);
                head_b = head_b.tail;
            }
            head_a = head_a.tail;
            head_b = B.start.tail;
        }
        result.merge();
        return result;
    }

    public void print_polynomial() {
        /**
         * @description print polynomial
         * @param
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:18
         */
        sort(this.start, this.end);/*sort polynomial based on descending degree order*/
        factor temp = this.start.tail;
        System.out.printf("%.2f" + " x^" + "%d ", temp.coef, temp.degree);
        temp = temp.tail;
        while (temp != null) {
            if (temp.coef == 0) {
                temp = temp.tail;
                continue;
            }
            if (temp.coef > 0) {
                System.out.print("+");
            }
            System.out.printf(" %.2f" + " x^" + "%d ", temp.coef, temp.degree);
            temp = temp.tail;
        }
        System.out.println();
    }

    public factor start;
    public factor end;
    public int length;
}