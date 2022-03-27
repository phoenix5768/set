
package csci235;

import java.util.ArrayList;
import java.util.List;


public class BSTSet<T extends Comparable<T> > implements Set<T> 
{
    private Node root;
    private int size;
    
    public BSTSet() {
        root = null;
        size = 0;
    }


    private class Node {
        public T value;
        public Node left;
        public Node right;

        public Node(T val) {
            value = val;
            left = null;
            right = null;
        }

        private Node addElement(Node cur, T val) {
            if(cur == null) {
                return new Node(val);
            }

            if(cur.value.compareTo(val) > 0) {
                cur.left = addElement(cur.left, val);
            } else if (cur.value.compareTo(val) < 0) {
                cur.right = addElement(cur.right, val);
            } else {
                return cur;
            }

            return cur;
        }

        private boolean isContains(Node cur, T val) {
            if(cur == null) {
                return false;
            }

            if(cur.value.compareTo(val) == 0) {
                return true;
            }

            if(cur.value.compareTo(val) > 0) {
                return isContains(cur.left, val);
            } else if (cur.value.compareTo(val) < 0) {
                return isContains(cur.right, val);
            }
            return false;
        }

        public boolean add(T t) {
            if(this.contains(t)) {
                return false;
            }
            root = addElement(root, t);
            return true;
        }

        public boolean contains(T t) {
            return isContains(root, t);
        }


        void addtoList(List<T> lst) {
            Node cur, pre;

            if(root ==  null) return;
            cur = root;

            while(cur != null) {
                if(cur.left == null) {
                    lst.add(cur.value);
                    cur = cur.right;
                } else {
                    pre = cur.left;
                    while(pre.right != null && pre.right != cur) {
                        pre=pre.right;
                    }

                    if(pre.right == null) {
                        pre.right = cur;
                        cur = cur.left;
                    } else {
                        pre.right = null;
                        lst.add(cur.value);
                        cur = cur.right;
                    }
                }
            }
        }

        void appendtoString(StringBuilder str) {
            List<T> lst = new ArrayList<T>();
            addtoList(lst);
            for(T item: lst) {
                str.append(item + " ");
            }
        }


    }

    public boolean add(T t) {
        Node element = new Node(t);
        boolean check = element.add(t);
        //System.out.println(element.add(t));
        if(!check) {
            return false;
        }
        size++;
        return check;
    }

    @Override
    public boolean contains(T t) {
        Node element = new Node(t);
        return element.contains(t);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public List<T> toList() {
        List<T> lst = new ArrayList<T>();
        if(root != null)
            root.addtoList(lst);
        return lst;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if(root != null)
            root.appendtoString(str);
        return str.toString();
    }

}


