package com.algorithm.array;

/**
 * @Author fujc
 * @Date: 2021/9/16 22:08
 * @Version 1.0
 */
public class ArrayTest {

    /**
     * 数组的长度
     */
    private int size;
    /**
     *
     */
    private int data[];
    /**
     * 当前已经存在的数据大小
     */
    private int index;

    /**
     * 数组初始化过程
     *
     * @param size 数组长度
     */
    public ArrayTest(int size) {
        this.size = size;
        this.data = new int[size];  //分配内存空间，只要运行到这里，就已经占内存了
        index = 0;
    }

    public void print() {
        System.out.println("index：" + index);
        for (int i = 0; i < index; i++) {
            System.out.println(data[i] + " ");
        }
    }

    /**
     * 插入数据，时间复杂度O(n)
     *
     * @param loc
     * @param n
     */
    public void insert(int loc, int n) {
        //移位，把数据后移一位
        for (int i = this.size - 1; i > loc; i--) {
            this.data[i] = this.data[i - 1];
        }
        //赋值
        data[loc] = n;
    }

    /**
     * 删除，时间复杂度O(n)
     *
     * @param loc
     */
    public void delete(int loc) {
        //移位，
        for (int i = loc; i < this.size; i++) {
            //
            if (i != size - 1) {
                data[i] = data[i + 1];
            } else {
                data[i] = 0;
            }
        }
        index--;

    }

    /**
     * 修改 O(1)
     *
     * @param loc
     * @param n
     */
    public void update(int loc, int n) {
        this.data[loc] = n;
    }

    /**
     * 删除 O(1)
     *
     * @param loc
     * @return
     */
    public int get(int loc) {
        return this.data[loc];
    }


    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);

    }
}
