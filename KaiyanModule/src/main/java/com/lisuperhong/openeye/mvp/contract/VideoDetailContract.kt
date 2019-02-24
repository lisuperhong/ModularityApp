package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.VideoSmallCard

/**
 * Author: lisuperhong
 * Time: Create on 2018/8/15 23:25
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface VideoDetailContract {

    interface View : IMvpView {

        /**
         * 设置视频播放源
         */
        fun setVideoUrl(url: String)

        /**
         * 设置视频信息
         */
        fun setVideoData(videoSmallCard: VideoSmallCard)

        /**
         * 设置相关视频信息
         */
        fun showRelatedVideo(baseBean: BaseBean)
    }

    interface Presenter : IMvpPresenter {

        fun loadVideoInfo(videoSmallCard: VideoSmallCard)

        fun requestRelatedVideo(id: Long)
    }
}