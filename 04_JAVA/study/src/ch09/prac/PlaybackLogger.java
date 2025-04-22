package ch09.prac;

public class PlaybackLogger {
    void log(String title, String artist){
        class RecentLog{
            String title;
            String artist;
            RecentLog(String title, String artist){
                this.title = title;
                this.artist = artist;
            }

            void printLog(){
                System.out.print("🎼 최근 재생: "+title+" - "+artist);
                if(title.length()>=10||artist.length()>=10){
                    System.out.println(" (인기곡)");
                }
                else System.out.println();
            }
        }
        RecentLog recentLog = new RecentLog(title,artist);
        recentLog.printLog();
    }
}
