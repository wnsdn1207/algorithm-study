package own.test.boj;

import com.google.gson.annotations.SerializedName;

public class GrandClass {
    private String a;
    private String b;
    private String c;

    public GrandClass(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    @Override
    public String toString() {
        return "GrandClass{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
