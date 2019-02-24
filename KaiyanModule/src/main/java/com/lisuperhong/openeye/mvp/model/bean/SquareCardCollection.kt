package com.lisuperhong.openeye.mvp.model.bean


data class SquareCardCollection(
    var dataType: String,
    var header: Header,
    var itemList: List<Item>,
    var count: Int,
    var adTrack: Any?
) {
    data class Item(
        var type: String,
        var data: FollowCard,
        var tag: Any?,
        var id: Int,
        var adIndex: Int
    )

    data class Header(
        var id: Int,
        var title: String,
        var font: String,
        var subTitle: String,
        var subTitleFont: String,
        var textAlign: String,
        var cover: Any?,
        var label: Any?,
        var actionUrl: String,
        var labelList: Any?
    )
}