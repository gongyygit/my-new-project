import java.lang.reflect.Method;
public class Inspect {
  public static void main(String[] args) throws Exception {
    Class<?> cls = Class.forName("org.mybatis.spring.annotation.MapperScannerRegistrar");
    System.out.println(cls.getName());
    for (Method m : cls.getDeclaredMethods()) {
      System.out.println(m);
    }
  }
}
