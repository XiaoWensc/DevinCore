package stroe.devin.com.devinandroiddemo.ui.model.flash;

import java.util.List;

/**
 * Created by zengxiaowen on 2018/2/5.
 */

public class FlashBean {
    private String sessionConfirmationNumber;
    private List<appStartAd> appStartAd;

    public class appStartAd{
        private String imgUrl;
        private String url;

        @Override
        public String toString() {
            return "appStartAd{" +
                    "imgUrl='" + imgUrl + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public String getSessionConfirmationNumber() {
        return sessionConfirmationNumber;
    }

    public void setSessionConfirmationNumber(String sessionConfirmationNumber) {
        this.sessionConfirmationNumber = sessionConfirmationNumber;
    }

    public List<FlashBean.appStartAd> getAppStartAd() {
        return appStartAd;
    }

    public void setAppStartAd(List<FlashBean.appStartAd> appStartAd) {
        this.appStartAd = appStartAd;
    }

    @Override
    public String toString() {
        return "FlashBean{" +
                "sessionConfirmationNumber='" + sessionConfirmationNumber + '\'' +
                ", appStartAd=" + appStartAd +
                '}';
    }
}
