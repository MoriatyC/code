package com.example.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.model.Project;

public class Judge {

    //年级小于35岁的属于young
    public static boolean youngJudge(Project project) {
        if (project.getPerson().getAge() <= 35) {
            return true;
        }
        return false;
    }
    //职称大于等于目标职称的返回true
    public static boolean titleJudge(Project project, String target) {
        Map<String, Integer> map = new HashMap<>();
        map.put("讲师", 0);
        map.put("副教授", 1);
        map.put("教授", 3);
        String title = project.getPerson().getTitle();
        if (map.get(title) >= map.get(target)) {
            return true;
        }
        return false;
    }
    //时间小于目标时间的返回true
    public static boolean timeJudge(Project project, String time) {
        String[] target = time.split("-");
        String[] myTime = project.getDate().split("-");
        for (int i = 0; i <= 2; i++) {
            if (Integer.valueOf(myTime[i]) < Integer.valueOf(target[i])) {
                return true;
            }
        }
        return false;
    }
}
