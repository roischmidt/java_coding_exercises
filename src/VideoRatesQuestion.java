import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list L of video names and their watch rates,
 * write a function that will return the videos with the top 10 watch rates.
 * Video names may appear more than once.
 */
public class VideoRatesQuestion {

    VideoMap videoMap = new VideoMap();

    public void addVideo(Video video) {
        videoMap.put(video.id,video);
    }

    public List<Video> getTop(){
        return videoMap.top();
    }

    public static class Video implements Comparable<Video> {

        int id;
        int rate;
        String name;

        public Video(int id, String name, int rate){
            this.id = id;
            this.name = name;
            this.rate = rate;
        }

        @Override
        public int compareTo(Video o) {
            int diff = rate - o.rate;
            if(rate == 0){
                return name.compareTo(o.name) + diff;
            }
            return diff;
        }
    }

    class VideoMap extends HashMap<Integer,Video> {

        Set<Video> top = new TreeSet<>(Video::compareTo).descendingSet();

        List<Video> top10 = new ArrayList<>(10);

        @Override
        public Video put(Integer key,Video value) {
            super.put(key,value);
            top.add(value);
            return value;
        }

        @Override
        public Video remove(Object key) {
            Video video = super.remove(key);
            top.remove(video);
            return video;
        }

        public List<Video> top() {
            return top.stream().limit(10).collect(Collectors.toList());
        }
    }

    public static void main(String args[]) {
        VideoRatesQuestion v = new VideoRatesQuestion();
        v.addVideo(new Video(1,"test",234));
        v.addVideo(new Video(12,"test1",234));
        v.addVideo(new Video(13,"test3",555));
        v.addVideo(new Video(14,"test2",26634));
        v.addVideo(new Video(15,"test7",2324));
        v.addVideo(new Video(16,"test3",2));
        v.addVideo(new Video(17,"test4",564));
        v.addVideo(new Video(18,"test15",678));
        v.addVideo(new Video(19,"test11",889));
        v.addVideo(new Video(111,"test12",445));
        v.addVideo(new Video(1111,"test10",333));
        List<String> s = v.getTop().stream().map(x -> x.name).collect(Collectors.toList());
        System.out.println(s);
    }
}
