import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.ArrayDeque;

class AATree<K extends Comparable> {
    Node root;
    int size;

    private class Node {
        K key;
        int level;
        Node left;
        Node right;
        int count;
    
        public Node(K key, int i, Node l, Node r) {
            this.key = key;
            this.level = i;
            this.left = l;
            this.right = r;
            this.count = 1;
        }

        @Override
        public String toString() {
            return String.format("%s x%d", this.key.toString(), this.count);
        }
    }

    public AATree() {
        this.root = null;
        this.size = 0;
    }

    public void insert(K x) {
        this.root = insertR(x, this.root);
        this.size++;
    }

    private Node insertR(K x, Node r) {
        if(r == null) {
            return new Node(x, 1, null, null);
        } else if(x.compareTo(r.key) < 0) {
            r.left = insertR(x, r.left);
        } else if(x.compareTo(r.key) > 0) {
            r.right = insertR(x, r.right);
        } else {
            r.count++;
        }

        r = skew(r);
        r = split(r);
        return r;
    }

    private Node skew(Node r) {
        if(r == null) {
            return null;
        } else if(r.left == null) {
            return r;
        } else if(r.left.level == r.level) {
            Node temp = r.left;
            r.left = temp.right;
            temp.right = r;
            return temp;
        } else {
            return r;
        }
    }

    private Node split(Node r) {
        if(r == null) {
            return null;
        } else if(r.right == null || r.right.right == null) {
            return r;
        } else if(r.level == r.right.right.level) {
            Node temp = r.right;
            r.right = temp.left;
            temp.left = r;
            temp.level++;
            return temp;
        } else {
            return r;
        }
    }

    public void delete(K x) {
        this.root = deleteR(x, this.root);
        this.size--;
    }

    private Node deleteR(K x, Node r) {
        if(r == null) {
            return r;
        } else if(x.compareTo(r.key) > 0) {
            r.right = deleteR(x, r.right);
        } else if(x.compareTo(r.key) < 0) {
            r.left = deleteR(x, r.left);
        } else if(--r.count > 0) {
            return r;
        } else {
            if(r.left == null && r.right == null) {
                return r.right;
            } else if(r.left == null) {
                Node temp = r.right;
                Node last = r;
                while(temp != null) {
                    last = temp;
                    temp = temp.left;
                }
                temp = last;
                r.right = deleteRF(temp.key, r.right);
                r.key = temp.key;
                r.count = temp.count;
            } else {
                Node temp = r.left;
                Node last = r;
                while(temp != null) {
                    last = temp;
                    temp = temp.right;
                }
                r.left = deleteRF(last.key, r.left);
                r.key = last.key;
                r.count = last.count;
            }
        }
        r = dl(r);
        r = skew(r);
        r.right = skew(r.right);
        if(r.right != null) {
            r.right.right = skew(r.right.right);
        }
        r = split(r);
        r.right = split(r.right);
        return r;
    }

    private Node deleteRF(K x, Node r) {
        if(r == null) {
            return r;
        } else if(x.compareTo(r.key) > 0) {
            r.right = deleteRF(x, r.right);
        } else if(x.compareTo(r.key) < 0) {
            r.left = deleteRF(x, r.left);
        } else {
            if(r.left == null && r.right == null) {
                return r.right;
            } else if(r.left == null) {
                Node temp = r.right;
                Node last = r;
                while(temp != null) {
                    last = temp;
                    temp = temp.left;
                }
                temp = last;
                r.right = deleteRF(temp.key, r.right);
                r.key = temp.key;
                r.count = temp.count;
            } else {
                Node temp = r.left;
                Node last = r;
                while(temp != null) {
                    last = temp;
                    temp = temp.right;
                }
                r.left = deleteRF(last.key, r.left);
                r.key = last.key;
                r.count = last.count;
            }
        }
        r = dl(r);
        r = skew(r);
        r.right = skew(r.right);
        if(r.right != null) {
            r.right.right = skew(r.right.right);
        }
        r = split(r);
        r.right = split(r.right);
        return r;
    }

    private Node dl(Node r) {
        int i = Math.min(level(r.left), level(r.right)) +1;
        if(i < r.level) {
            r.level = i;
            if(i < level(r.right)) {
                r.right.level = i;
            }
        }
        return r;
    }

    private int level(Node r) {
        if(r == null) {
            return 0;
        } else {
            return r.level;
        }
    }

    public K lte(K key) {
        Node temp = this.root;
        K last = null;
        while(temp != null) {
            int cmp = temp.key.compareTo(key);
            if(cmp > 0) {
                temp = temp.left;
            } else if(cmp < 0) {
                last = temp.key;
                temp = temp.right;
            } else {
                return temp.key;
            }
        }
        return last;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.size << 4);
        preOrder(out, "", "", this.root, this.root != null && this.root.right != null);
        out.append("\n");
        return out.toString();
    }

    private void preOrder(StringBuilder out, String pad, String point, Node r, boolean rightSib) {
        if(r != null) {
            out.append("\n");
            out.append(pad);
            out.append(point);
            out.append(r);
            
            StringBuilder padding = new StringBuilder(pad);
            if(rightSib) {
                padding.append("|  ");
            } else {
                padding.append("   ");
            }
            String bPad = padding.toString();
            String rP = "R──";
            String lP = "L──";

            preOrder(out, bPad, lP, r.left, r.right != null);
            preOrder(out, bPad, rP, r.right, false);
        }
    }
}

class KattisQuest implements Comparable {
    int e;
    int g;

    public KattisQuest(String[] in) {
        this.e = Integer.parseInt(in[1]);
        this.g = Integer.parseInt(in[2]);
    }

    public KattisQuest(int e) {
        this.e = e;
        this.g = Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(Object o) {
        KattisQuest k = (KattisQuest) o;
        return this.e == k.e ? this.g - k.g : this.e - k.e;
    }

    @Override
    public String toString() {
        return String.valueOf(this.e + " " + this.g);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(r.readLine());
        StringBuilder out = new StringBuilder(c << 1);
        AATree<KattisQuest> quests = new AATree<KattisQuest>();
        for(int i = 0; i < c; i++) {
            String[] in = r.readLine().split(" ", 3);
            if(in[0].charAt(0) == 'a') {
                KattisQuest v = new KattisQuest(in);
                quests.insert(v);
            } else {
                int e = Integer.parseInt(in[1]);
                long g = 0;
                while(e > 0) {
                    KattisQuest temp = quests.lte(new KattisQuest(e));
                    if(temp == null) {
                        break;
                    }
                    e -= temp.e;
                    g += temp.g;
                    quests.delete(temp);
                }
                out.append(g);
                out.append("\n");
            }
            // System.out.print(quests);
        }
        System.out.print(out);
        r.close();
    }
}