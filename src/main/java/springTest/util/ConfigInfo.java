package springTest.util;

/**
 * Created by guofengrui on 2017/6/7.
 */
import java.io.InputStream;
import java.util.Properties;

public class ConfigInfo {
    public static final String PROPERTIES_DEFAULT = "config.properties";//类路径下的属性文件名
    //mail
    public static String mail_host;
    public static int mail_port;
    public static String mail_from;
    public static String mail_username;
    public static String mail_password;
    public static int mail_smtp_timeout;
    static{
        initOrRefresh();
    }
    //初始化或更新缓存
    public static void initOrRefresh(){
        Properties p=new Properties();
        try {
            InputStream in = ConfigInfo.class.getClassLoader().getResourceAsStream(PROPERTIES_DEFAULT);
            p.load(in);
            in.close();
            mail_host = p.getProperty("mail_host","smtp.163.com");
            mail_port = Integer.parseInt(p.getProperty("mail_port","25"));
            mail_from = p.getProperty("mail_from");
            mail_username = p.getProperty("mail_username");
            mail_password = p.getProperty("mail_password");
            mail_smtp_timeout = Integer.parseInt(p.getProperty("mail_smtp_timeout","25000"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
