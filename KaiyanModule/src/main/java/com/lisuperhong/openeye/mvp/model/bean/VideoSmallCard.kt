package com.lisuperhong.openeye.mvp.model.bean

import java.io.Serializable


data class VideoSmallCard(
    var dataType: String,
    var id: Long,
    var title: String,
    var description: String,
    var library: String,
    var tags: List<Tag>,
    var consumption: Consumption,
    var resourceType: String,
    var slogan: Any?,
    var provider: Provider,
    var category: String,
    var author: Author,
    var cover: Cover,
    var playUrl: String,
    var thumbPlayUrl: Any?,
    var duration: Int,
    var webUrl: WebUrl,
    var releaseTime: Long,
    var playInfo: List<PlayInfo>,
    var campaign: Any?,
    var waterMarks: Any?,
    var adTrack: Any?,
    var type: String,
    var titlePgc: Any?,
    var descriptionPgc: Any?,
    var remark: Any?,
    var ifLimitVideo: Boolean,
    var searchWeight: Int,
    var idx: Int,
    var shareAdTrack: Any?,
    var favoriteAdTrack: Any?,
    var webAdTrack: Any?,
    var date: Long,
    var promotion: Any?,
    var label: Any?,
    var labelList: List<Any>,
    var descriptionEditor: String,
    var collected: Boolean,
    var played: Boolean,
    var subtitles: List<Any>,
    var lastViewTime: Any?,
    var playlists: Any?,
    var src: Any?
) : Serializable {
    data class WebUrl(
        var raw: String,
        var forWeibo: String
    ) : Serializable

    data class Tag(
        var id: Int,
        var name: String,
        var actionUrl: String,
        var adTrack: Any?,
        var desc: Any?,
        var bgPicture: String,
        var headerImage: String,
        var tagRecType: String
    ) : Serializable

    data class Provider(
        var name: String,
        var alias: String,
        var icon: String
    ) : Serializable

    data class PlayInfo(
        var height: Int,
        var width: Int,
        var urlList: List<Url>,
        var name: String,
        var type: String,
        var url: String
    ) : Serializable {

        data class Url(
            var name: String,
            var url: String,
            var size: Int
        ) : Serializable
    }

    data class Consumption(
        var collectionCount: Int,
        var shareCount: Int,
        var replyCount: Int
    ) : Serializable

    data class Cover(
        var feed: String,
        var detail: String,
        var blurred: String,
        var sharing: Any?,
        var homepage: String
    ) : Serializable

    data class Author(
        var id: Int,
        var icon: String,
        var name: String,
        var description: String,
        var link: String,
        var latestReleaseTime: Long,
        var videoNum: Int,
        var adTrack: Any?,
        var follow: Follow,
        var shield: Shield,
        var approvedNotReadyVideoCount: Int,
        var ifPgc: Boolean
    ) : Serializable {
        data class Shield(
            var itemType: String,
            var itemId: Int,
            var shielded: Boolean
        ) : Serializable

        data class Follow(
            var itemType: String,
            var itemId: Int,
            var followed: Boolean
        ) : Serializable
    }
}