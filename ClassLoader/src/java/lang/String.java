package java.lang;

/**
 * * 沙箱安全机制，自己写的java.lang.String.class类不会被加载，这样便可以防止核心API库被随意篡改<br/>
 * * 避免类的重复加载，当父的ClassLoader已经加载了该类时，子的ClassLoader就没有必要再加载一次，保证被加载类的唯一性 <br/>
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/10 16:06
 */
public class String {
    public static void main(String[] args) {
        System.out.println("*********************My String Class*********************");
    }
}
