package adapter.adapter2;


import adapter.adapter1.Banner;

public class PrintBanner extends Print{
    private Banner banner;

    public PrintBanner(String title) {
       banner = new Banner(title);
    }

    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }
    @Override
    public void printStrong() {
        banner.showWithAster();
    }

}
