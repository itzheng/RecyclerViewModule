package org.itzheng.and.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Title:带加载提示的适配器<br>
 * Description: <br>
 *
 * @email ItZheng@ZoHo.com
 * Created by itzheng on 2018-7-19.
 */
public abstract class BaseRecyclerLoadHintAdapter<VH extends RecyclerView.ViewHolder>
        extends BaseRecyclerLoadMoreAdapter<RecyclerView.ViewHolder> {
    public static final int ITEM_VIEW_TYPE_END_LOADING = 0x000013;
    public static final int ITEM_VIEW_TYPE_CONTENT_LOADING = 0x000014;
    public static final int ITEM_VIEW_TYPE_END_ERROR = 0x000015;
    public static final int ITEM_VIEW_TYPE_END_FINISH = 0x000016;
    /**
     * 内容错误，可能是服务器断开连接，可能是没有网络
     */
    public static final int ITEM_VIEW_TYPE_CONTENT_ERROR = 0x000017;
    private boolean isHintEnable = true;

    /**
     * 设置是否启用提示功能，默认开始
     *
     * @param b
     */
    public void setHintEnable(boolean b) {
        this.isHintEnable = b;
    }

    private RecyclerView recyclerView;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    /**
     * 重新设置适配器
     */
    private void reSetAdapter() {
        if (recyclerView != null) {
            recyclerView.setAdapter(this);
        }
    }

    private View emptyView;

    /**
     * 设置结果为空的界面显示
     *
     * @param view
     */
    public void setEmptyView(View view) {
        emptyView = view;
        reSetAdapter();

    }


    private View contentErrorView;

    /**
     * 设置内容错误的界面，如果没有设置错误，直接将空界面替换理论上也是可以的
     *
     * @param view
     */
    public void setContentErrorView(View view) {
        contentErrorView = view;
        reSetAdapter();

    }

    private View contentLoadingView;

    /**
     * 设置内容加载的界面
     *
     * @param view
     */
    public void setContentLoadingView(View view) {
        contentLoadingView = view;
        reSetAdapter();

    }

    private View endErrorView;

    /**
     * 设置内容错误的界面，如果没有设置错误，直接将空界面替换理论上也是可以的
     *
     * @param view
     */
    public void setEndErrorView(View view) {
        endErrorView = view;
        reSetAdapter();

    }

    private View endLoading;

    /**
     * 设置底部加载界面
     *
     * @param view
     */
    public void setEndLoadingView(View view) {
        endLoading = view;
        reSetAdapter();
    }

    private View endFinish;

    /**
     * 设置底部加载界面
     *
     * @param view
     */
    public void setEndFinishView(View view) {
        endFinish = view;
        reSetAdapter();
    }

    @Override
    public View onCreateView(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            default:
                view = onCreateRealView(parent, viewType);
                break;
            case ITEM_VIEW_TYPE_EMPTY:
                if (emptyView == null) {
                    view = onCreateContentEmptyView(parent);
                } else {
                    view = emptyView;
                }
                break;
            case ITEM_VIEW_TYPE_END_LOADING:
                if (endLoading == null) {
                    view = onCreateEndLoadingView(parent);
                } else {
                    view = endLoading;
                }

                break;
            case ITEM_VIEW_TYPE_END_ERROR:
                if (endErrorView == null) {
                    view = onCreateEndErrorView(parent);
                } else {
                    view = endErrorView;
                }
                break;
            case ITEM_VIEW_TYPE_END_FINISH:
                if (endFinish == null) {
                    view = onCreateEndFinishView(parent);
                } else {
                    view = endFinish;
                }

                break;
            case ITEM_VIEW_TYPE_CONTENT_ERROR:
                if (contentErrorView == null) {
                    view = onCreateContentErrorView(parent);
                } else {
                    view = contentErrorView;
                }

                break;
            case ITEM_VIEW_TYPE_CONTENT_LOADING:
                view = onCreateContentLoadingView(parent);
                break;
        }
        return view;
    }

    private View defView(Context context) {
        TextView textView = new TextView(context);
        textView.setText("Def View");
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(Color.WHITE);
        return textView;
    }

    protected View onCreateContentLoadingView(ViewGroup parent) {
        return defView(parent.getContext());
    }


    protected View onCreateContentErrorView(ViewGroup parent) {
        return defView(parent.getContext());
    }

    protected View onCreateEndFinishView(ViewGroup parent) {
        return defView(parent.getContext());
    }

    protected View onCreateEndErrorView(ViewGroup parent) {
        return defView(parent.getContext());
    }

    protected View onCreateEndLoadingView(ViewGroup parent) {
        return defView(parent.getContext());
    }

    protected View onCreateContentEmptyView(ViewGroup parent) {
        return defView(parent.getContext());
    }

    public abstract View onCreateRealView(ViewGroup parent, int viewType);

    public abstract VH onCreateRealViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindRealViewHolder(VH holder, int position);

    /**
     * 获取显示的数量
     *
     * @param mItems
     * @param isHintEnable 是否显示提示(如果显示提示的数量，会进行+1)
     * @return
     */
    protected static int getItemCount(List mItems, boolean isHintEnable) {
        int size = mItems == null ? 0 : mItems.size();
        return isHintEnable ? size + 1 : size;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            default:
                holder = onCreateRealViewHolder(parent, viewType);
                break;
            case ITEM_VIEW_TYPE_EMPTY:

                break;
            case ITEM_VIEW_TYPE_END_LOADING:

                break;
            case ITEM_VIEW_TYPE_END_ERROR:

                break;
            case ITEM_VIEW_TYPE_END_FINISH:

                break;
            case ITEM_VIEW_TYPE_CONTENT_ERROR:

                break;
            case ITEM_VIEW_TYPE_CONTENT_LOADING:

                break;
        }
        if (holder == null) {
            //如果没有设置ViewHolder则使用默认
            holder = new MyViewHolder(onCreateView(parent, viewType));
        }
        return holder;
    }

    /**
     * 判断是否加载中
     */
    private boolean isLoading = true;
    /**
     * 判断是否加载中
     */
    private boolean isError = false;

    public void setLoading(boolean loading) {
        this.isLoading = loading;
        if (isLoading) {
            //如果是正在加载，就没有错误
            setError(false);
        }

    }

    public boolean isLoading() {
        return isLoading;
    }

    /**
     * 加载错误是设置，如果没有设置则表示正确加载
     *
     * @param error
     */
    public void setError(boolean error) {
        this.isError = error;
        if (isError) {
            setLoading(false);
        }
    }

    /**
     * 设置加载完成
     *
     * @param b
     */
    public void setLoadFinish(boolean b) {
        if (b) {
            setError(false);
            setLoading(false);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (!isHintEnable) {
            //如果没有启动提示，则按原有走，只有设置countItems才生效
            return super.getItemViewType(position);
        }
        if (getItemCount() == 1) {
            //如果显示提示，只有一个的时候，就是为空
            if (isLoading) {
                return ITEM_VIEW_TYPE_CONTENT_LOADING;
            } else if (isError) {
                return ITEM_VIEW_TYPE_CONTENT_ERROR;
            } else {
                return ITEM_VIEW_TYPE_EMPTY;
            }

        } else if (position == getItemCount() - 1) {
            if (isLoading) {
                return ITEM_VIEW_TYPE_END_LOADING;
            } else if (isError) {
                return ITEM_VIEW_TYPE_END_ERROR;
            } else {
                return ITEM_VIEW_TYPE_END_FINISH;
            }
        }

        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHintEnable && position == getItemCount() - 1) {
            //这个就是用来
        } else {
            onBindRealViewHolder((VH) holder, position);
        }
    }

//    public abstract void setItems(List items);

    /**
     * 默认
     */
    private class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
