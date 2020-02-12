package just4test.yml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @program: collectionIdea
 * @description: no
 * @author: SKH
 * @create: 2019-09-07 11:18
 **/
public class App {
    public static void main(String[] args) throws Exception {
//        String nullString = "";
//        String target = "32";
//        int length = 12;
//        String regex = "%0" + length + "d";
//        String result = String.format(regex,Long.valueOf(target));
//        System.out.println("*"+ result +"*");


        String temp = null;
        System.out.println(temp.length());

    }


    public static String testA() {
        return null;
    }

    /*
     * @Author:Xiang Chen
     * @Description:
     * @Param: 
     * @param columnName
     * @param name
     * @param length
     * @Date:2019/9/17 17:52
     **/
    public static void testYml(String columnName,String name, Integer length){
//        /* 读取 */
//        Yaml y = new Yaml();
//        System.out.println();
//        //创建file对象
//        File file = new File("D:/ideaProject/collection/src/main/java/just4test/yml/dictionaryTest.yml");
//        //将yaml内容解析成map表
//        Map m1 = null;
//        try {
//            m1 = (Map) y.load(new FileInputStream(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        //获取第一级键中的“details”键作为对象，进一步获取下级的键和值
//        List a = (List) m1.get(columnName);
//        System.out.println(a.contains("zhangsan"));
    }



    public static boolean testFor(){
        for(int i=0;i<5;i++){
            if(i==2){
                continue;
            }
            System.out.println("当前i的值为"+i);
        }
        return true;
    }

    public static void testPatten() {
        String regex = "^[1-9]\\d*\\.\\d{2}|0\\.\\d{2}$";
        String target1 = "11098．11";
        String target2 = "11i98.00";
        String target3 = "11098.03";
        String target7 = "11098.031";
        String target4 = "0.00";
        String target5 = "0.30";
        String target6 = "0.001";

        System.out.println("target1: " + Pattern.matches(regex,target1));
        System.out.println("target2: " + Pattern.matches(regex,target2));
        System.out.println("target3: " + Pattern.matches(regex,target3));
        System.out.println("target7: " + Pattern.matches(regex,target7));
        System.out.println("target4: " + Pattern.matches(regex,target4));
        System.out.println("target5: " + Pattern.matches(regex,target5));
        System.out.println("target6: " + Pattern.matches(regex,target6));

//        String regex2 = "^[1-9]\\d*\\.\\d{2}$";vvv"^[1-9]\\d*\\.\\d{2}|0\\.\\d{2}$";
//        String temp1 = "10.01";
//        System.out.println("temp1: " + Pattern.matches(regex2,temp1));

//        String regex3 = "^[0-9]$";
//        String test1 = "0";
//        System.out.println("test1: " + Pattern.matches(regex3,test1));
    }

    public static void checkDate() {
        String date_str = "201102a9";
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        format.setLenient(false);
        try {
            Date date = format.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期不合法");
        }
        System.out.println("wo shi zhongguoren");
    }

    public static void leftFillZero() {

    }
}
