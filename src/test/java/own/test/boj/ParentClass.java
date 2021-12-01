package own.test.boj;

import com.google.gson.annotations.SerializedName;

public class ParentClass extends GrandClass {
//    @SerializedName("a1")
    private transient String a;
    private String d;
    private String e;

    public ParentClass(String a, String b, String c, String a1, String d, String e) {
        super(a, b, c);
        this.a = a1;
        this.d = d;
        this.e = e;
    }

    @Override
    public String getA() {
        return a;
    }

    public String getD() {
        return d;
    }

    public String getE() {
        return e;
    }

    @Override
    public String toString() {
        return "ParentClass{" +
                "a='" + a + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                '}' +"\n"+ super.toString();
    }
}
