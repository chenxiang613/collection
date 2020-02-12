package just4test.yml;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @program: collectionIdea
 * @description: 数据校验工具类
 * @author: chenxiang
 * @create: 2019-09-09 09:21
 **/
public class ValidateUtils {

    public static void main(String[] args) throws Exception {
        Record record = ValidateUtils.testExcel();
        System.out.println(record.toStringLine());
        ArrayList<String> errorList = new ArrayList<String>();
        boolean result = ValidateUtils.validate(record, errorList);
        if (result == true) {
            ValidateUtils.preProcessBeforeAnalyse(record);
            System.out.println(record.toStringLine());
        } else {
            for (String reason : errorList) {
                System.out.println(reason);
            }
        }
    }

    private static Field[] fields;
    private static Map<ValidateGZCB.DataType, String> patternMap = new HashMap<ValidateGZCB.DataType, String>();

    //初始化一些参数
    static {
        Class clazz = null;
        try {
            clazz = Class.forName("just4test.yml.Record");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ValidateUtils.fields = clazz.getDeclaredFields();
        patternMap.put(ValidateGZCB.DataType.NUMBER, "^\\d+$");
        patternMap.put(ValidateGZCB.DataType.NUMBER_AND_CHARACTER, "^\\w+$");
        patternMap.put(ValidateGZCB.DataType.AMOUNT, "^[1-9]\\d*\\.\\d{2}|0\\.\\d{2}$");

    }

    public static boolean validate(Record record,List errorList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuilder errorMsg = new StringBuilder(record.getUserName());
        for (Field field : fields) {
            //获取所有get方法
            String methodName = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            Method m = record.getClass().getMethod(methodName);
            String target = (String) m.invoke(record);
            ValidateGZCB annotationT = field.getAnnotation(ValidateGZCB.class);
            if (annotationT == null) {
//                 System.out.println(field.getName() + "此字段没有@ValidateGZCB注解，跳出循环不用处理");
                continue;
            }
            ValidateGZCB.NecessaryEnum necessary = field.getAnnotation(ValidateGZCB.class).necessary();
            //判断字段值是否为空
            if (target == null) {
                if (necessary == ValidateGZCB.NecessaryEnum.N) {
                    System.out.println("to be continue");
                    continue;
                } else {
                    errorMsg.append(" " + field.getName() + "字段值为空，不符合要求");
                    errorList.add(errorMsg.toString());
                    return false;
                }
            }
            ValidateGZCB.DataType dataType = field.getAnnotation(ValidateGZCB.class).dataType();
            boolean typeMatch = true;
            //
            if (dataType == ValidateGZCB.DataType.DICTIONARY) {
                typeMatch = testYml(field.getName(), target);
            } else if (dataType == ValidateGZCB.DataType.NUMBER_AND_CHARACTER) {

            } else if (dataType == ValidateGZCB.DataType.DATE) {
                try {
                    SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
                    format.setLenient(false);
                    Date date = format.parse(target);
                } catch (Exception ex){
                    typeMatch = false;
                    ex.printStackTrace();
                }
            } else {
                typeMatch = Pattern.matches(patternMap.get(dataType), target);
            }
            if(typeMatch == false){
                errorMsg.append(" " + field.getName() + "字段取值不符合规范");
                errorList.add(errorMsg.toString());
                return false;
            }
            int limit = field.getAnnotation(ValidateGZCB.class).limit();
            boolean limitMatchResult = true;
            //如果limit等于0则不做长度校验
            if (limit != 0) {
                limitMatchResult = target.length() <= limit ? true:false;
            }
            if (limitMatchResult == false) {
                errorMsg.append(" " + field.getName() + "字段取值长度不符合规范");
                errorList.add(errorMsg.toString());
                return false;
            }
        }
        return true;
    }

    public static boolean testYml(String columnName,String columnValue){
        /* 读取 */
        Yaml y = new Yaml();
        //创建file对象
        File file = new File("D:/ideaProject/collection/src/main/java/just4test/yml/dictionaryTest.yml");
        //将yaml内容解析成map表
        Map dictionaryMap = null;
        try {
            dictionaryMap = (Map) y.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //获取第一级键中的“details”键作为对象，进一步获取下级的键和值
        List list = (List) dictionaryMap.get(columnName);
        return list.contains(columnValue);
    }


    public static Record testExcel() throws Exception {
        File file = new File("C:/Users/Administrator/Desktop/调账/end.xls");
        Record record = new Record();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            List<Map<String, Object>> maps = PoiUtils.readExcel(fileInputStream);
            for (Map<String, Object> map : maps) {
                record.setAmount(String.valueOf(map.get("调整金额")));
                record.setDirection(String.valueOf(map.get("调整方向")));
                record.setUserName(String.valueOf(map.get("客户姓名")));
                record.setCardNbr(String.valueOf(map.get("卡号")));
                record.setAdjustmentDate(String.valueOf(map.get("调整日期")));
                record.setNoAnnotationMember(String.valueOf(map.get("交易类型")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return record;
    }

    public static void preProcessBeforeAnalyse(Record record) {
        String[] temp = record.getAmount().split("\\.");
        if (temp.length > 1) {
            record.setAmount(temp[0] + temp[1]);
        }
    }
}
