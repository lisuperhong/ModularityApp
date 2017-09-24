package com.lisuperhong.kaiyanmodule.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李昭鸿
 * @desc: 首页视频
 * @date Created on 2017/9/23 19:33
 * @github: https://github.com/lisuperhong
 */

public class HomeVedioBean implements Serializable {


    /**
     * type : video
     * data : {"dataType":"VideoBeanForClient","id":18749,"title":"秋天没雪，然而可以滑落叶啊！","slogan":"有地心引力，我可以滑一切","description":"真正热爱滑雪的人可等不到冬天！虽说这么玩，无论单板双板都废了，但比起中规中矩的骑着山地车下来，你还是会想这么尝试一次 \u2014\u2014 有地心引力，就可以滑一切！From Candide Thovex","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"运动","author":null,"cover":{"feed":"http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/0a3606a988d31e72facca5c460f55245.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=default&source=qcloud","thumbPlayUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl/1505919779292_7cb13e6f.mp4?vid=18749&source=qcloud","duration":115,"webUrl":null,"releaseTime":1506128400000,"library":"DAILY","playInfo":[{"height":480,"width":854,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud","size":18069509},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=ucloud","size":18069509}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud"},{"height":720,"width":1280,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=high&source=qcloud","size":28881629},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=high&source=ucloud","size":28881629}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=high&source=qcloud"}],"consumption":{"collectionCount":503,"shareCount":586,"replyCount":32},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":4,"name":"运动","actionUrl":"eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8","adTrack":null},{"id":280,"name":"滑雪","actionUrl":"eyepetizer://tag/280/?title=%E6%BB%91%E9%9B%AA","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":514,"name":"城会玩","actionUrl":"eyepetizer://tag/514/?title=%E5%9F%8E%E4%BC%9A%E7%8E%A9","adTrack":null},{"id":146,"name":"666","actionUrl":"eyepetizer://tag/146/?title=666","adTrack":null},{"id":562,"name":"汽车","actionUrl":"eyepetizer://tag/562/?title=%E6%B1%BD%E8%BD%A6","adTrack":null}],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1506128400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"真正热爱滑雪的人可等不到冬天！虽说这么玩，无论单板双板都废了，但比起中规中矩的骑着山地车下来，你还是会想这么尝试一次 \u2014\u2014 有地心引力，就可以滑一切！From Candide Thovex","collected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null}
     * tag : 0
     */

    private String type;
    private DataBean data;
    private String tag;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static class DataBean {
        /**
         * dataType : VideoBeanForClient
         * id : 18749
         * title : 秋天没雪，然而可以滑落叶啊！
         * slogan : 有地心引力，我可以滑一切
         * description : 真正热爱滑雪的人可等不到冬天！虽说这么玩，无论单板双板都废了，但比起中规中矩的骑着山地车下来，你还是会想这么尝试一次 —— 有地心引力，就可以滑一切！From Candide Thovex
         * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
         * category : 运动
         * author : null
         * cover : {"feed":"http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/0a3606a988d31e72facca5c460f55245.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=default&source=qcloud
         * thumbPlayUrl : http://baobab.kaiyanapp.com/api/v1/playUrl/1505919779292_7cb13e6f.mp4?vid=18749&source=qcloud
         * duration : 115
         * webUrl : null
         * releaseTime : 1506128400000
         * library : DAILY
         * playInfo : [{"height":480,"width":854,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud","size":18069509},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=ucloud","size":18069509}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud"},{"height":720,"width":1280,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=high&source=qcloud","size":28881629},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=high&source=ucloud","size":28881629}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=high&source=qcloud"}]
         * consumption : {"collectionCount":503,"shareCount":586,"replyCount":32}
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * tags : [{"id":4,"name":"运动","actionUrl":"eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8","adTrack":null},{"id":280,"name":"滑雪","actionUrl":"eyepetizer://tag/280/?title=%E6%BB%91%E9%9B%AA","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":514,"name":"城会玩","actionUrl":"eyepetizer://tag/514/?title=%E5%9F%8E%E4%BC%9A%E7%8E%A9","adTrack":null},{"id":146,"name":"666","actionUrl":"eyepetizer://tag/146/?title=666","adTrack":null},{"id":562,"name":"汽车","actionUrl":"eyepetizer://tag/562/?title=%E6%B1%BD%E8%BD%A6","adTrack":null}]
         * type : NORMAL
         * titlePgc : null
         * descriptionPgc : null
         * remark : null
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1506128400000
         * promotion : null
         * label : null
         * labelList : []
         * descriptionEditor : 真正热爱滑雪的人可等不到冬天！虽说这么玩，无论单板双板都废了，但比起中规中矩的骑着山地车下来，你还是会想这么尝试一次 —— 有地心引力，就可以滑一切！From Candide Thovex
         * collected : false
         * played : false
         * subtitles : []
         * lastViewTime : null
         * playlists : null
         */

        private String dataType;
        private int id;
        private String title;
        private String slogan;
        private String description;
        private ProviderBean provider;
        private String category;
        private Object author;
        private CoverBean cover;
        private String playUrl;
        private String thumbPlayUrl;
        private int duration;
        private Object webUrl;
        private long releaseTime;
        private String library;
        private ConsumptionBean consumption;
        private Object campaign;
        private Object waterMarks;
        private Object adTrack;
        private String type;
        private Object titlePgc;
        private Object descriptionPgc;
        private Object remark;
        private int idx;
        private Object shareAdTrack;
        private Object favoriteAdTrack;
        private Object webAdTrack;
        private long date;
        private Object promotion;
        private Object label;
        private String descriptionEditor;
        private boolean collected;
        private boolean played;
        private Object lastViewTime;
        private Object playlists;
        private List<PlayInfoBean> playInfo;
        private List<TagsBean> tags;
        private List<?> labelList;
        private List<?> subtitles;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ProviderBean getProvider() {
            return provider;
        }

        public void setProvider(ProviderBean provider) {
            this.provider = provider;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getAuthor() {
            return author;
        }

        public void setAuthor(Object author) {
            this.author = author;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public String getThumbPlayUrl() {
            return thumbPlayUrl;
        }

        public void setThumbPlayUrl(String thumbPlayUrl) {
            this.thumbPlayUrl = thumbPlayUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public Object getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(Object webUrl) {
            this.webUrl = webUrl;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getLibrary() {
            return library;
        }

        public void setLibrary(String library) {
            this.library = library;
        }

        public ConsumptionBean getConsumption() {
            return consumption;
        }

        public void setConsumption(ConsumptionBean consumption) {
            this.consumption = consumption;
        }

        public Object getCampaign() {
            return campaign;
        }

        public void setCampaign(Object campaign) {
            this.campaign = campaign;
        }

        public Object getWaterMarks() {
            return waterMarks;
        }

        public void setWaterMarks(Object waterMarks) {
            this.waterMarks = waterMarks;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getTitlePgc() {
            return titlePgc;
        }

        public void setTitlePgc(Object titlePgc) {
            this.titlePgc = titlePgc;
        }

        public Object getDescriptionPgc() {
            return descriptionPgc;
        }

        public void setDescriptionPgc(Object descriptionPgc) {
            this.descriptionPgc = descriptionPgc;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public Object getShareAdTrack() {
            return shareAdTrack;
        }

        public void setShareAdTrack(Object shareAdTrack) {
            this.shareAdTrack = shareAdTrack;
        }

        public Object getFavoriteAdTrack() {
            return favoriteAdTrack;
        }

        public void setFavoriteAdTrack(Object favoriteAdTrack) {
            this.favoriteAdTrack = favoriteAdTrack;
        }

        public Object getWebAdTrack() {
            return webAdTrack;
        }

        public void setWebAdTrack(Object webAdTrack) {
            this.webAdTrack = webAdTrack;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public Object getPromotion() {
            return promotion;
        }

        public void setPromotion(Object promotion) {
            this.promotion = promotion;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public String getDescriptionEditor() {
            return descriptionEditor;
        }

        public void setDescriptionEditor(String descriptionEditor) {
            this.descriptionEditor = descriptionEditor;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isPlayed() {
            return played;
        }

        public void setPlayed(boolean played) {
            this.played = played;
        }

        public Object getLastViewTime() {
            return lastViewTime;
        }

        public void setLastViewTime(Object lastViewTime) {
            this.lastViewTime = lastViewTime;
        }

        public Object getPlaylists() {
            return playlists;
        }

        public void setPlaylists(Object playlists) {
            this.playlists = playlists;
        }

        public List<PlayInfoBean> getPlayInfo() {
            return playInfo;
        }

        public void setPlayInfo(List<PlayInfoBean> playInfo) {
            this.playInfo = playInfo;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<?> getLabelList() {
            return labelList;
        }

        public void setLabelList(List<?> labelList) {
            this.labelList = labelList;
        }

        public List<?> getSubtitles() {
            return subtitles;
        }

        public void setSubtitles(List<?> subtitles) {
            this.subtitles = subtitles;
        }

        public static class ProviderBean {
            /**
             * name : YouTube
             * alias : youtube
             * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
             */

            private String name;
            private String alias;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class CoverBean {
            /**
             * feed : http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageMogr2/quality/60/format/jpg
             * blurred : http://img.kaiyanapp.com/0a3606a988d31e72facca5c460f55245.jpeg?imageMogr2/quality/60/format/jpg
             * sharing : null
             * homepage : http://img.kaiyanapp.com/e7fcc5ae26eb82864678959bdd391850.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
             */

            private String feed;
            private String detail;
            private String blurred;
            private Object sharing;
            private String homepage;

            public String getFeed() {
                return feed;
            }

            public void setFeed(String feed) {
                this.feed = feed;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getBlurred() {
                return blurred;
            }

            public void setBlurred(String blurred) {
                this.blurred = blurred;
            }

            public Object getSharing() {
                return sharing;
            }

            public void setSharing(Object sharing) {
                this.sharing = sharing;
            }

            public String getHomepage() {
                return homepage;
            }

            public void setHomepage(String homepage) {
                this.homepage = homepage;
            }
        }

        public static class ConsumptionBean {
            /**
             * collectionCount : 503
             * shareCount : 586
             * replyCount : 32
             */

            private int collectionCount;
            private int shareCount;
            private int replyCount;

            public int getCollectionCount() {
                return collectionCount;
            }

            public void setCollectionCount(int collectionCount) {
                this.collectionCount = collectionCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }
        }

        public static class PlayInfoBean {
            /**
             * height : 480
             * width : 854
             * urlList : [{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud","size":18069509},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=ucloud","size":18069509}]
             * name : 标清
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud
             */

            private int height;
            private int width;
            private String name;
            private String type;
            private String url;
            private List<UrlListBean> urlList;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<UrlListBean> getUrlList() {
                return urlList;
            }

            public void setUrlList(List<UrlListBean> urlList) {
                this.urlList = urlList;
            }

            public static class UrlListBean {
                /**
                 * name : qcloud
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=18749&editionType=normal&source=qcloud
                 * size : 18069509
                 */

                private String name;
                private String url;
                private int size;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }
            }
        }

        public static class TagsBean {
            /**
             * id : 4
             * name : 运动
             * actionUrl : eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8
             * adTrack : null
             */

            private int id;
            private String name;
            private String actionUrl;
            private Object adTrack;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }
        }
    }
}
