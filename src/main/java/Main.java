import java.io.File;

/**
 * Created by Administrator on 2017/2/4 0004.
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("./src/main/resources/template");
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
        }else{
            System.out.println("路径不存在");
        }
    }
}
