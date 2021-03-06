package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.VideoDetailContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.VideoSmallCard

/**
 * Author: lisuperhong
 * Time: Create on 2018/8/15 23:25
 * Github: https://github.com/lisuperhong
 * Desc: 视频详情页
 */
class VideoDetailPresenter(rootView: VideoDetailContract.View) :
    BasePresenter<VideoDetailContract.View>(rootView),
    VideoDetailContract.Presenter {

    override fun loadVideoInfo(videoSmallCard: VideoSmallCard) {
        checkViewAttached()
        val playInfos: List<VideoSmallCard.PlayInfo> = videoSmallCard.playInfo
        if (playInfos.size > 1) {
            for (playInfo in playInfos) {
                if (playInfo.type == "high") {
                    rootView?.setVideoUrl(playInfo.url)
                    break
                }
            }
        } else {
            rootView?.setVideoUrl(videoSmallCard.playUrl)
        }

        rootView?.setVideoData(videoSmallCard)
    }

    override fun requestRelatedVideo(id: Long) {
        checkViewAttached()
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.showRelatedVideo(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.videoRelated(id, observer)
    }
}