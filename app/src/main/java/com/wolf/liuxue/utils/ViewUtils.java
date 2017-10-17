package com.wolf.liuxue.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.wolf.liuxue.App;
import com.wolf.liuxue.base.BindActivity;
import com.wolf.liuxue.common.Emoji;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class ViewUtils {
    public static void showMsg(Object o) {
        String title = "";
        if (o instanceof String) {
            title = (String) o;
        } else if (o instanceof Integer) {
            title = App.getIns().getResources().getString((Integer) o);
        }

        Toast.makeText(App.getIns(), title, Toast.LENGTH_SHORT).show();
    }

    public static void hideInput(BindActivity bindActivity) {
        InputMethodManager imm = (InputMethodManager) bindActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(bindActivity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void deleteText(EditText editText) {
        if (!TextUtils.isEmpty(editText.getText())) {
            int selectionStart = editText.getSelectionStart();
            if (selectionStart > 0) {
                String body = editText.getText().toString();
                String tempStr = body.substring(0, selectionStart);
                int i = tempStr.lastIndexOf("[");
                if (i != -1) {
                    CharSequence cs = tempStr.substring(i, selectionStart);
                    if (Emoji.containsEmoji(cs.toString())) {
                        editText.getEditableText().delete(i, selectionStart);
                    } else {
                        editText.getEditableText().delete(selectionStart - 1, selectionStart);
                    }
                } else {
                    editText.getEditableText().delete(selectionStart - 1, selectionStart);
                }
            }
        }
    }
}
