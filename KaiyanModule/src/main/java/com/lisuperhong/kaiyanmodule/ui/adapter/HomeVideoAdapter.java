package com.lisuperhong.kaiyanmodule.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lisuperhong.kaiyanmodule.R;
import com.lisuperhong.kaiyanmodule.model.bean.HomeBean;

import java.util.List;

/**
 * @author 李昭鸿
 * @desc:
 * @date Created on 2017/10/18 16:56
 */

public class HomeVideoAdapter extends BaseQuickAdapter<HomeBean, BaseViewHolder> {

    public HomeVideoAdapter(List<HomeBean> homeBeanList) {
        super(R.layout.kaiyan_home_video_item, homeBeanList);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean item) {

    }
}
