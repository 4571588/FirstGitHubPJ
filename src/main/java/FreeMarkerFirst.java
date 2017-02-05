import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * Created by Administrator on 2017/2/4 0004.
 */
public class FreeMarkerFirst {

    public static void main(String[] args) throws IOException, TemplateException {
        Map<String, Object> dataMap = new HashMap<String,Object>();
        String tplName = "";

       /* dataMap.put("name", "zwq");
        tplName = "index.ftl";

        // 1
        LoadDataToTpl(dataMap,tplName);*/
        // 2
        dataMap.clear();
        dataMap.put("score", new Random().nextInt(100));

        UserInfo u1 = new UserInfo();
        u1.setName("cq1");
        u1.setPassword("cqcq1");
        UserInfo u2 = new UserInfo();
        u2.setName("cq2");
        u2.setPassword("cqcq2");
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(u1);
        list.add(u2);
        dataMap.put("userList", list);
        dataMap.put("time", new Date());
        dataMap.put("str", "北京,上海,杭州");

        tplName = "useif.ftl";
        LoadDataToTpl(dataMap,tplName);
    }

    public static void LoadDataToTpl(Map<String,Object> dataMap, String tplFileName) throws IOException, TemplateException {

        //System.out.println(new File(".").getAbsolutePath());
        //System.out.println(new FreeMarkerFirst().getClass().getResource("").getPath());
        //获取当前工程路径

        /*  String basePath = System.getProperty("user.dir");
        String tplPath = basePath + File.separator + "build" + File.separator + "resources" +
                File.separator + "main" + File.separator + "template";*/

        String tplPath = "./src/main/resources/template";

        //1 创建freemarker配置实例
        Configuration config = new Configuration();
        config.setDirectoryForTemplateLoading(new File(tplPath));
        //2 创建数据模型

        //3 加载模板文件
        Template template = config.getTemplate(tplFileName);
        //4 显示生成后的数据
        Writer writer = new OutputStreamWriter(System.out);
        template.process(dataMap, writer);
        writer.close();
    }

}


