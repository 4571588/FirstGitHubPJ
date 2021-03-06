import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用freemark生成word
 */
public class Freemark {

    public static void main(String[] args) throws IOException {
        Freemark freemark = new Freemark("./src/main/resources/template");
        freemark.setTemplateName("wordtpl.ftl");
        freemark.setFileName("doc_" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) + ".doc");
        freemark.setFilePath("./src/main/resources/doc");
        //生成word  
        freemark.createWord();
    }

    private void createWord() {

        Template t = null;
        try {
            //获取模板信息  
            t = configuration.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File outFile = new File(filePath + File.separator+fileName);
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map map = new HashMap<String, Object>();
        map.put("name", "蒙奇·D·路飞");
        map.put("country", "日本");
        map.put("city", "东京");
        map.put("time", new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        try {
            //输出数据到模板中，生成文件。  
            t.process(map, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生成doc成功！");
    }

    /**
     * freemark初始化
     *
     * @param templatePath 模板文件位置
     */
    public Freemark(String templatePath) throws IOException {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(new File(templatePath));
        //configuration.setClassForTemplateLoading(this.getClass(), templatePath);
    }

    /**
     * freemark模板配置
     */
    private Configuration configuration;
    /**
     * freemark模板的名字
     */
    private String templateName;
    /**
     * 生成文件名
     */
    private String fileName;
    /**
     * 生成文件路径
     */
    private String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

}  