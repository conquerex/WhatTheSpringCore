package what.the.springcore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        System.out.println("helloLombok.getName() = " + helloLombok.getName());
        System.out.println("HelloLombok.main" + helloLombok);
    }
}
