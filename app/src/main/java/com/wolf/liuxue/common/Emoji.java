package com.wolf.liuxue.common;

import android.content.Context;
import android.text.Spannable;
import android.text.style.ImageSpan;

import com.wolf.liuxue.bean.ExpressionBean;
import com.wolf.liuxue.view.VerticalImageSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by nanchaodong on 2017/5/16.
 */

public class Emoji {
    public static final String ee_1 = "[):]";
    public static final String ee_2 = "[:D]";
    public static final String ee_3 = "[;)]";
    public static final String ee_4 = "[:-o]";
    public static final String ee_5 = "[:p]";
    public static final String ee_6 = "[(H)]";
    public static final String ee_7 = "[:@]";
    public static final String ee_8 = "[:s]";
    public static final String ee_9 = "[:$]";
    public static final String ee_10 = "[:(]";
    public static final String ee_11 = "[:'(]";
    public static final String ee_12 = "[:|]";
    public static final String ee_13 = "[(a)]";
    public static final String ee_14 = "[8o|]";
    public static final String ee_15 = "[8-|]";
    public static final String ee_16 = "[+o(]";
    public static final String ee_17 = "[<o)]";
    public static final String ee_18 = "[|-)]";
    public static final String ee_19 = "[*-)]";
    public static final String ee_20 = "[:-#]";
    public static final String ee_21 = "[:-*]";
    public static final String ee_22 = "[^o)]";
    public static final String ee_23 = "[8-)]";
    public static final String ee_24 = "[(|)]";
    public static final String ee_25 = "[(u)]";
    public static final String ee_26 = "[(S)]";
    public static final String ee_27 = "[(*)]";
    public static final String ee_28 = "[(#)]";
    public static final String ee_29 = "[(R)]";
    public static final String ee_30 = "[({)]";
    public static final String ee_31 = "[(})]";
    public static final String ee_32 = "[(k)]";
    public static final String ee_33 = "[(F)]";
    public static final String ee_34 = "[(W)]";
    public static final String ee_35 = "[(D)]";
    private static List<String> emojiName = new ArrayList<>();
    private static List<ExpressionBean> list = new ArrayList<>();
    private static List<ExpressionBean> slist = new ArrayList<>();
    private static Spannable.Factory spannableFactory = Spannable.Factory.getInstance();
    private static List<ExpressionBean> allList = new ArrayList<>();
    public static void init(){
        emojiName.add(ee_1);
        emojiName.add(ee_2);
        emojiName.add(ee_3);
        emojiName.add(ee_4);
        emojiName.add(ee_5);
        emojiName.add(ee_6);
        emojiName.add(ee_7);
        emojiName.add(ee_8);
        emojiName.add(ee_9);
        emojiName.add(ee_10);
        emojiName.add(ee_11);
        emojiName.add(ee_12);
        emojiName.add(ee_13);
        emojiName.add(ee_14);
        emojiName.add(ee_15);
        emojiName.add(ee_16);
        emojiName.add(ee_17);
        emojiName.add(ee_18);
        emojiName.add(ee_19);
        emojiName.add(ee_20);
        emojiName.add(ee_21);
        emojiName.add(ee_22);
        emojiName.add(ee_23);
        emojiName.add(ee_24);
        emojiName.add(ee_25);
        emojiName.add(ee_26);
        emojiName.add(ee_27);
        emojiName.add(ee_28);
        emojiName.add(ee_29);
        emojiName.add(ee_30);
        emojiName.add(ee_31);
        emojiName.add(ee_32);
        emojiName.add(ee_33);
        emojiName.add(ee_34);
        emojiName.add(ee_35);


        for (int i = 0; i < 20; i++) {
            ExpressionBean bean = new ExpressionBean("android.resource://com.wolf.liuxue/mipmap/ee_" + (i + 1), emojiName.get(i));
            list.add(bean);
        }
        list.add(new ExpressionBean("android.resource://com.wolf.liuxue/mipmap/delete_expression"));
        for (int i = 20; i < 35; i++) {
            ExpressionBean bean = new ExpressionBean("android.resource://com.wolf.liuxue/mipmap/ee_" + (i + 1), emojiName.get(i));
            slist.add(bean);
        }
        slist.add(new ExpressionBean("android.resource://com.wolf.liuxue/mipmap/delete_expression"));
        allList.addAll(list);
        allList.addAll(slist);
    }



    public static List<ExpressionBean> getFirstPageExpressions() {
        return list;
    }

    public static List<ExpressionBean> getSecondPageExpressions() {

        return slist;
    }

    public static Spannable getSimledText(Context context, CharSequence text) {
        Spannable spannable = spannableFactory.newSpannable(text);
        addSmiles(context, spannable);
        return spannable;
    }

    private static boolean addSmiles(Context context, Spannable spannable) {
        boolean hasChanges = false;
        for (ExpressionBean bean : allList) {
            if (bean.getPattern() != null) {
                Matcher matcher = bean.getPattern().matcher(spannable);
                while (matcher.find()) {
                    boolean set = true;
                    for (ImageSpan span : spannable.getSpans(matcher.start(), matcher.end(), ImageSpan.class)) {
                        if (spannable.getSpanStart(span) >= matcher.start() && spannable.getSpanEnd(span) <= matcher.end()) {
                            spannable.removeSpan(span);
                        } else {
                            set = false;
                            break;
                        }
                    }
                    if (set) {
                        hasChanges = true;
                        int id = context.getResources().getIdentifier(bean.getFileName(), "mipmap", context.getPackageName());
                        ImageSpan im = new VerticalImageSpan(context, id);
                        spannable.setSpan(im, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    }
                }
            }
        }
        return hasChanges;

    }

    public static boolean containsEmoji(String key) {
        boolean b = false;
        for (ExpressionBean bean : allList) {
            if (bean.getPattern() != null) {
                Matcher matcher = bean.getPattern().matcher(key);
                if (matcher.find()) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }

}
