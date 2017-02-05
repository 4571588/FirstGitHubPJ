import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateHtml {
    public static void main(String[] args) {
        try {
          /*  String basePath = System.getProperty("user.dir");
            String tplPath = basePath + File.separator + "build" + File.separator + "resources" +
                    File.separator + "main" + File.separator + "template";*/
            String tplPath = "./src/main/resources/template";

            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(tplPath));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");  //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate("test.html");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");

            List<String> nameList = new ArrayList<String>();
            nameList.add("陈靖仇");
            nameList.add("玉儿");
            nameList.add("宇文拓");
            paramMap.put("nameList", nameList);

            Map<String, Object> weaponMap = new HashMap<String, Object>();
            weaponMap.put("first", "轩辕剑");
            weaponMap.put("second", "崆峒印");
            weaponMap.put("third", "女娲石");
            weaponMap.put("fourth", "神农鼎");
            weaponMap.put("fifth", "伏羲琴");
            weaponMap.put("sixth", "昆仑镜");
            weaponMap.put("seventh", null);
            paramMap.put("weaponMap", weaponMap);

            Writer writer = new OutputStreamWriter(new FileOutputStream(tplPath+File.separator+"success.html"), "UTF-8");
            template.process(paramMap, writer);

            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}