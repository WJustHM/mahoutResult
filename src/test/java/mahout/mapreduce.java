package mahout;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * Created by linux on 17-3-17.
 */
public class mapreduce {


    //单循环链表
    static ArrayList<Integer> li = new ArrayList<Integer>();
    static ArrayList<String> l1 = new ArrayList<String>();
    static ArrayList<String> l2 = new ArrayList<String>();
    static Map<Integer, String> maps = new HashMap<Integer, String>();
    static int num = 0;
    int index = 0;

    public static void main(String[] args) throws Exception {
//        for (int i = 1; i <= 10; i++) {
//            li.add(i);
//        }
//        seach(0);
//        bajinzhi(11231, 16);
//        l1.add("6");l1.add("1");l1.add("7");
//        l2.add("2");l2.add("9");l2.add("5");
        int a[]={4,0,2,3,1},i,j,t;
        for(i=1;i<5;i++)
        {
            t=a[i];
            j=i-1;
            while(j>=0&&t>a[j])
            {
                a[j+1]=a[j];
                --j;
            }
            a[j+1]=t;
        }
       for(Integer s:a){
           System.out.println(s);
       }
    }

    public static void bajinzhi(int num, int jinzhi) {
        if (jinzhi == 16) {
            maps.put(10, "A");
            maps.put(11, "B");
            maps.put(12, "C");
            maps.put(13, "D");
            maps.put(14, "E");
            maps.put(15, "F");
        }
        if (num / jinzhi == 0) {
            System.out.println(maps.getOrDefault((num % jinzhi), (num % jinzhi) + ""));
        } else {
            System.out.println(maps.getOrDefault((num % jinzhi), (num % jinzhi) + ""));
            bajinzhi(num / jinzhi, jinzhi);
        }
    }

    public static void seach(int index) {
        while (li.size() >= 1) {
            for (int i = index; i <= li.size(); i++) {
                num++;
                if (i >= li.size()) {
                    i = 0;
                }
                if (num == 5) {
                    index = i;
                    System.out.println(li.remove(i) + "-->");
                    num = 0;
                    if (i == li.size()) {
                        i = 0;
                    }
                    seach(index);
                }
            }
        }
    }

    public static void test() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + ": FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + ": Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + ": Buzz");
            }
        }
    }

    public static  List<String> addLists2(List<String> l1, List<String> l2) {
        String num1 = "";
        String num2 = "";
        for (int i = 0; i < l1.size(); i++) {
            num1 += l1.get(i);
            num2 += l2.get(i);
        }
        int num = Integer.parseInt(num1) + Integer.parseInt(num2);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < String.valueOf(num).split("").length; i++) {
            list.add(String.valueOf(num).split("")[i]);
        }
        return list;
    }
}
