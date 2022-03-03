package com.designpattern.report._11_flyweight.step2_after.flyweightFactory;

import com.designpattern.report._11_flyweight.step2_after.flyweight.Font;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    private Map<String, Font> cache = new HashMap<>();

    /**
     * 캐시 처리
     * @param font
     * @return
     */
    public Font getFont(String font) {
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
