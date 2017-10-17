package com.wolf.liuxue.presenter;

import java.io.Serializable;

/**
 * Created by nanchaodong on 2017/5/10.
 */

public interface PresentImpl extends Serializable {
    int itemType(TypeFactoryImpl typeFactory);
}
