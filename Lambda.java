//lambda,stream
public class Lambda{
    public static void main(String[] args) {
        walkable obj = (steps) -> steps * 2;
        System.out.println(obj.walk(10));

    }
}

interface walkable{
    int walk(int steps);
    int run(int abc);
}