package cn.zhouxp.base.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuZY
 * @create 2020-04-28 12:37
 */
class CriteriaTest {

    @Test
    public void sort(){
        //输出一段字符串的最后一个单词的长度
        String str = "adad  daf  fsg   sdfshdhd    grdhj sfdh fsehd   ";
        System.out.println(str.length());
        String[] str1 = str.split(" ");
        List<String> list =new ArrayList<>();
        System.out.println(str1.length);
        for (String ssss:str1
             ){
            if (!ssss.contains(" ")){
                list.add(ssss);
            }
        }
        System.out.println(list.size());
        for (String s:list){
            if (s.contains(" ")){
                list.remove(s);
            }
        }
    }
}