package first_maven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Demo {

    public static String splitByField(String s, String field) {
        String regex = field + "=(\\S+),";
        String regex2 = field + "=(\\S+)\\)";
        Pattern p = Pattern.compile(regex);
        Pattern p2 = Pattern.compile(regex2);
        Matcher m = p.matcher(s);
        Matcher m2 = p2.matcher(s);
        if (m.find())
        {
            return m.group(1);
        }
        if (m2.find()) {
            return m2.group(1);
        }
        return "fail";
    }
    public static void main(String[] args) {
        System.out.println(splitByField("Person(id=113121231, name=李四, age=44, college=外语学院, title=教授, sex=女)", "sex"));
        
    }
}
