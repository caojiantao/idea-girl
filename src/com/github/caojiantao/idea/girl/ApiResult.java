package com.github.caojiantao.idea.girl;

import java.util.List;

public class ApiResult {

    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public static class Photo {
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Src getSrc() {
            return src;
        }

        public void setSrc(Src src) {
            this.src = src;
        }

        private String url;
        private Src src;
    }

    public static class Src {
        private String original;
        private String small;
        private String landscape;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public String getLandscape() {
            return landscape;
        }

        public void setLandscape(String landscape) {
            this.landscape = landscape;
        }
    }
}
