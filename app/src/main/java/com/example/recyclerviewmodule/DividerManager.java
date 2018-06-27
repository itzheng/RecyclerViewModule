package com.example.recyclerviewmodule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import org.itzheng.and.recyclerview.decoration.DecorationManager;

/**
 * Title:<br>
 * Description: <br>
 *
 * @email ItZheng@ZoHo.com
 * Created by itzheng on 2017-11-7.
 */
public class DividerManager {
    public static RecyclerView.ItemDecoration getDecoration(Context context) {
        RecyclerView.ItemDecoration decoration = DecorationManager.LinearLayoutManager.
                newItemDecoration(0
                                | DecorationManager.ShowDivider.SHOW_DIVIDER_BEGINNING
                                | DecorationManager.ShowDivider.SHOW_DIVIDER_MIDDLE
                                | DecorationManager.ShowDivider.SHOW_DIVIDER_END
                        , dip2px(context, 40), context.getResources().getColor(android.R.color.holo_blue_dark));
        return decoration;
    }

    public static int dip2px(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((float) dip * scale + 0.5F);
    }
}
