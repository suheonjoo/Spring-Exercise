package me.whiteship.designpatterns._02_structural_patterns._11_flyweight._02_after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    //Map으로 캐시를 구현할 것임
    private Map<String, Font> cache = new HashMap<>();

    public Font getFont(String font) {
        // 있으면 꺼내서 주고 , 없으면 새로 만들어서 줌
        if (cache.containsKey(font)) {
            return cache.get(font);
        } else {
            String[] split = font.split(":");
            Font newFont = new Font(split[0], Integer.parseInt(split[1]));
            cache.put(font, newFont);
            return newFont;
        }
    }
}
