package just4test.jvm;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestApp {

	public static void main(String[] args) {
        List<String> stringDateList = collectLocalDates("2019-01-01", "2019-01-01");
        for (String dateString : stringDateList) {
            System.out.println(dateString);
        }
    }

    public static void test() {
        //创建一个Person对象good
        Person good = new Person("good guy");
        //创建一个AtomicStampedReference对象atomicStampedReference
        AtomicStampedReference<Person> atomicStampedReference = new AtomicStampedReference<Person>(good,1);
        //保存atomicStampedReference对象的时间戳
        int stamp = atomicStampedReference.getStamp();
        //创建一个Person对象bad
        Person bad = new Person("bad guy");
        //执行cas,期望被替换的对象引用（expectedReference）good,新的对象引用（newReference）bad,期望时间戳（expectedStamp）1,新时间戳（expectedStamp）2
        boolean flag = atomicStampedReference.compareAndSet(good,bad,stamp,stamp+1);
        System.out.println("执行cas,结果"+flag);
    }


    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     * @param timeStart
     * @param timeEnd
     * @return
     */
    public static List<String> collectLocalDates(String timeStart, String timeEnd){
        return collectLocalDates(LocalDate.parse(timeStart), LocalDate.parse(timeEnd));
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     * @param start
     * @param end
     * @return
     */
    public static List<String> collectLocalDates(LocalDate start, LocalDate end){
        // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
        return Stream.iterate(start, localDate -> localDate.plusDays(1))
                // 截断无限流，长度为起始时间和结束时间的差+1个
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                // 由于最后要的是字符串，所以map转换一下
                .map(LocalDate::toString)
                // 把流收集为List
                .collect(Collectors.toList());
    }
}
