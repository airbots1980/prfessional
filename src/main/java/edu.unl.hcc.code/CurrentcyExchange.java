package edu.unl.hcc.coding.tiktok;

import edu.unl.hcc.service.common.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class with input like [["USD","JPY", 1],
 * ["USD", "EUR", "2"]]  两个货币名称加上对应的exchange rate，
 * 然后实现一个function(String s1, String s2)来return汇率.
 * implement了最简单的map的方法，但是如果有两种汇率不能相互转换的话
 * 就要躲处理，比如再多个["A","B",5]求A和USD的汇率。面试官提示下最后
 * 得出了用graph来实现然后s1和s2就是start和src的位置变成了路径问题。
 */
public class CurrentcyExchange {

    static Map dictionary =  new HashMap<String, HashMap<String, String>>();

    private static Map initDict(List<List<String>> dict){
        if(dict ==null || dict.size()==0) return dictionary;
        for(List a : dict) {
            if(a.size()!=3) continue;
            if(dictionary.containsKey(a.get(0))) {
                Map subDict = (Map)dictionary.get(a.get(0));
                if(subDict.containsKey(a.get(1))) {
                    int currentValue = Integer.parseInt(subDict.get(a.get(1)).toString());
                    if(Integer.parseInt(a.get(2).toString()) < currentValue) {
                        subDict.put(a.get(1), a.get(2));
                    }
                } else {
                    subDict.put(a.get(1), a.get(2));
                }
            }
        }

        //create all to all shortest path using



        return dictionary;
    }

    public static int findExchange(List<List<String>> dict, String c1, String c2) {
        int result=0;
        //boundary conditions
        if(dict==null||dict.size()==0|| StringUtils.isEmpty(c1)
            ||StringUtils.isEmpty(c2)) return result;
        Map dictionary = initDict(dict);
        if(dictionary.containsKey(c1)) {
            Map subDict = (Map)dictionary.get(c1);
            if(subDict.containsKey(c2))
                return Integer.parseInt(subDict.get(c2).toString());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
