package om.disney.wdpro.otherservice.rabbitmq;

import com.google.common.collect.Lists;
import lombok.*;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws ConcurrentException {
//        String[] arr = new String[]{"hello", "world"};
//        Arrays.setAll(arr, x -> x);
//        System.out.println(Arrays.toString(arr));

//        Integer[] arr = new Integer[]{1,2,3,4,3,6,8};
//        int loc = Arrays.binarySearch(arr, 6);
//        System.out.println(loc);

//        String encodedStr = Base64.getEncoder().encodeToString("test1200909".getBytes());
//        System.out.println(encodedStr);
//
//        String decodedStr = new String(Base64.getDecoder().decode(encodedStr.getBytes()));
//        System.out.println(decodedStr);

//        List<String> list = Lists.newArrayList("test", "test2");
//        System.out.println(list);
//        Object[] objs = list.toArray();
//        Arrays.stream(objs).forEach(x -> {
//            System.out.println(x instanceof Integer);
//        });
//        String[] objs2 =  list.toArray(new String[0]);
//        System.out.println(Arrays.toString(objs2));

//        list.removeIf(x -> x.indexOf("test")!= -1);
//        System.out.println(list);

//
//        ArrayList<Integer> list = Lists.newArrayList(1,2,3,4,3,6,8);
////        Collections.shuffle(list);
//        Collections.rotate(list, 8);
////        System.out.println(list);
//
//        Collection<Integer> list2 = Collections.unmodifiableCollection(list);
//
//        String a = " he3d dll;o";
//        String b = " d  ";
//        String c = "hello";
//        boolean bb = StringUtils.isAnyBlank(a, b);
//        System.out.println(bb);
//
//        String at = StringUtils.truncate(a, 3);
//        System.out.println(StringUtils.strip(a, " "));
//
//        System.out.println(StringUtils.compare("hello", "hello2"));
//        System.out.println(StringUtils.equalsAny(StringUtils.strip(a), b, c));
//        System.out.println(StringUtils.indexOfAnyBut(a,  "t"));
//        System.out.println(Arrays.toString(StringUtils.splitByCharacterType(a)));
//        System.out.println(StringUtils.join(new String[]{"hello", "world"}, ","));
//        System.out.println(StringUtils.join(Lists.newArrayList("hello", "world"), ","));
//
//        System.out.println(StringUtils.deleteWhitespace(" he3d dll;o"));
//        System.out.println(StringUtils.containsWhitespace(""));
//        System.out.println(StringUtils.repeat("ho", 10));
//        System.out.println(StringUtils.center("hello", 20, 't'));

//        System.out.println(StringUtils.capitalize("hello \nworld"));
//        System.out.println(StringUtils.countMatches("hello", "l"));
//        System.out.println(StringUtils.isAlphanumericSpace("hj2;"));
//        System.out.println(StringUtils.getDigits("hellow2 d8"));
//
//        System.out.println(StringUtils.firstNonBlank("", " ", "hel", "  ", "ll"));
//
//        System.out.println(StringUtils.reverse("hello"));
//        System.out.println(StringUtils.abbreviate("hello", 4));
//
//        System.out.println(StringUtils.getCommonPrefix("hello", "hel"));
//
//        System.out.println(StringUtils.appendIfMissing("hello", "h"));
//
//        System.out.println(StringUtils.toEncodedString("hello".getBytes(), Charset.defaultCharset()));
//
//        System.out.println(ToStringBuilder.reflectionToString(new Test()));

        A a = new A("michael", 30);
        A clone = SerializationUtils.clone(a);
        System.out.println(clone);
        System.out.println(a == clone);

        System.out.println(StringUtils.join(Lists.newArrayList(SystemUtils.getHostName(), SystemUtils.getJavaHome(), SystemUtils.getUserHome()), ","));


        LazyInitializer<A> lazyInitializer = new LazyInitializer<A>() {
            @Override
            protected A initialize() throws ConcurrentException {
                return new A("michael", 30);
            }
        };

        System.out.println(lazyInitializer.get() == lazyInitializer.get());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class A implements Serializable {
    private String name;
    private int age;
}
