package own.test.boj;

import com.google.gson.annotations.SerializedName;

public class ChildClass extends ParentClass {
//    @SerializedName("a2")
    private transient String a;
//    @SerializedName("d2")
    private transient String d;
    private String y;
    private String z;

    public ChildClass(String a, String b, String c, String a1, String d, String e, String a2, String d1, String y, String z) {
        super(a, b, c, a1, d, e);
        this.a = a2;
        this.d = d1;
        this.y = y;
        this.z = z;
    }

    @Override
    public String getA() {
        return a;
    }

    @Override
    public String getD() {
        return d;
    }

    public String getY() {
        return y;
    }

    public String getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "a='" + a + '\'' +
                ", d='" + d + '\'' +
                ", y='" + y + '\'' +
                ", z='" + z + '\'' +
                '}' + "\n" + super.toString();
    }
}
