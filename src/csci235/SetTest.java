import csci235.BSTSet;
import csci235.HashTableSet;
import csci235.Set;

import java.util.ArrayList;

/**
 *
 * @author Ben Tyler
 */
public class SetTest {

    public static void main(String[] args) {
        test(new BSTSet<>());
        test(new HashTableSet<>(4));
    }

    public static void test(Set<Integer> set)  {

        for (int i = 1; i < 50; i = i + 6) {
            if (!set.add(i)) {
                System.out.println(i + " was not added");
            }
        }
        System.out.println("size:" + set.getSize());
        System.out.println(set);
        System.out.println(set.toList());

        for (int i = 49; i > 0; i = i - 10) {
            if (!set.add(i)) {
                System.out.println(i + " was not added");
            }
        }
        System.out.println("size:" + set.getSize());
        System.out.println(set);
        System.out.println(set.toList());

        for (int i = 1; i < 50; i++) {
            System.out.print(i + ":" + set.contains(i) + " ");
        }
        System.out.println();

        set.clear();
        System.out.println("size:" + set.getSize());
        System.out.println(set);
        System.out.println(set.toList());

        System.out.println("------------------");

    }
}
