/**
 * @author zczeng
 * @description Priority Queue: Min Heap
 * @date 2020/3/5 22:55
 */
public class HeapOperation {
    private int[] record;  /*record nodes of heap sequentially*/
    private int size;   /*current size of heap*/
    private int max_size;   /*max size of heap*/

    public HeapOperation(int MaxElement) {
        /**
         * @description Initialization for min heap
         * @param MaxElement maximum number of elements
         * @return
         * @author zczeng
         * @date 2020/3/5 22:56
         */
        this.record = new int[MaxElement + 1]; /*record[0] is reserved for sentinel*/
        this.record[0] = -1;    /*sentinel*/
        this.size = 0;
        this.max_size = MaxElement;
    }

    public void BuildHeap(int[] array) {
        /**
         * @description build up min heap based on input array
         * @param array int array
         * @return void
         * @author zczeng
         * @date 2020/3/5 22:57
         */
        if (array.length == 0) {
            System.out.println("Empty array");
        } else if (array.length > this.max_size) {
            System.out.println("Out of Heap size");
        } else {
            record[1] = array[0];
            this.size = 1;
            for (int i = 1; i < array.length; i++) {
                this.record[i + 1] = array[i];
                MinifyUp(i + 1);  /*adjust element i+1 to form a max heap*/
                size = size + 1;
            }
        }
    }

    private void MinifyUp(int ind) {
        /**
         * @description adjust node to form a binary heap (Bottom-Up) (when new node value is smaller than previous value)
         * @param ind index of node to be minified
         * @return void
         * @author zczeng
         * @date 2020/3/5 22:59
         */
        int parent = (int) Math.floor(ind / 2);
        if (parent < 1) {
            return;
        } else {
            if (this.record[ind] < this.record[parent]) {
                int temp = this.record[ind];
                this.record[ind] = this.record[parent];
                this.record[parent] = temp;
                MinifyUp(parent);
            } else {
                return;
            }
        }
    }

    private void MinifyDown(int ind) {
        /**
         * @description adjust node to form a binary heap (Up-Down) (when new node value is bigger than previous value)
         * @param ind index of node to be minified
         * @return void
         * @author zczeng
         * @date 2020/3/5 22:58
         */
        if (ind > (int) Math.floor(this.size / 2)) {/*leave*/
            return;
        } else {
            int temp;
            if (2 * ind + 1 > this.size) {/*node[ind] does not have right child*/
                if (this.record[2 * ind] < this.record[ind]) {
                    temp = this.record[2 * ind];
                    this.record[2 * ind] = this.record[ind];
                    this.record[ind] = temp;
                }
                return;
            } else {
                int left = this.record[2 * ind];
                int right = this.record[2 * ind + 1];
                if (left > right) {/*swap node with right*/
                    if (right < this.record[ind]) {
                        this.record[2 * ind + 1] = this.record[ind];
                        this.record[ind] = right;
                        MinifyDown(2 * ind + 1);
                    }
                } else {
                    if (left < this.record[ind]) {
                        this.record[2 * ind] = this.record[ind];
                        this.record[ind] = left;
                        MinifyDown(2 * ind);
                    }
                }
            }
        }
    }

    public void Insert(int value) {
        /**
         * @description insert node with value to form a max heap
         * @param value value to be inserted in the binary heap
         * @return void
         * @author zczeng
         * @date 2020/3/5 23:01
         */
        if (this.size == this.max_size) {
            System.out.println("Binary Heap is full ,unable to insert");
        } else {
            this.size = this.size + 1;
            this.record[this.size] = value;
            MinifyUp(this.size);
        }
    }

    public void Delete_min() {
        /**
         * @description delete node with the minimum key value
         * @param
         * @return void
         * @author zczeng
         * @date 2020/3/5 23:02
         */
        this.record[1] = this.record[this.size];
        this.record[this.size] = 0;
        this.size = this.size - 1;
        MinifyDown(1);
    }

    public void DecreaseKey(int ind, int delta) {
        /**
         * @description decrease node[ind]'s key value by delta
         * @param ind index of node to be processed
         * @param delta decreasing value
         * @return void
         * @author zczeng
         * @date 2020/3/5 23:02
         */
        if (delta >= 0) {
            System.out.println("Decrease value must be negative");
        }
        this.record[ind] = this.record[ind] + delta;
        MinifyUp(ind);/*New key values is smaller than the original key value. Execute MinifyUp to build a heap*/
    }

    public void IncreaseKey(int ind, int delta) {
        if (delta <= 0) {
            System.out.println("Increase value must be positive");
        }
        this.record[ind] = this.record[ind] + delta;
        MinifyDown(ind);/*New key values is bigger than the original key value. Execute MinifyUp to build a heap*/
    }

    public void Delete(int ind) {
        /**
         * @description Delete node[ind]
         * @param ind index of node to be deleted
         * @return void
         * @author zczeng
         * @date 2020/3/5 23:04
         */
        if (ind > this.size) {
            System.out.println("Index out of range, unable to delete");
        } else if (ind == this.size) {/*when node to be deleted is the last node*/
            this.record[ind] = 0;
            this.size = this.size - 1;
        } else {
            int temp = this.record[ind];
            this.record[ind] = this.record[this.size];/*swap the value of node[ind] with the last node*/
            this.record[this.size] = 0;
            this.size = this.size - 1;
            if (temp > this.record[ind]) {/*apply MinifyUp*/
                MinifyUp(ind);
            } else {/*apply MinifyDown*/
                MinifyDown(ind);
            }
        }
    }

    public int[] GetHeap() {/*get the heap*/
        return this.record;
    }

    public int FindMin() {/*find minimum value in heap*/
        return this.record[1];
    }
}