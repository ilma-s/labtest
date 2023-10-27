import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<YTVideo> ytVideos = getYTVideos("src/input_files/youtube (2).csv");
        getEngRate(ytVideos, "src/output_files/taskOne.csv");
        getTitleHashtags(ytVideos, "src/output_files/taskTwo.csv");
    }

    private static void getEngRate(ArrayList<YTVideo> ytVideos, String outputFilename) throws IOException {
        FileWriter fw = new FileWriter(outputFilename);
        fw.write("video_id,title,views,likes,dislikes,comment_count,engagement_rate\n");

        for (YTVideo v : ytVideos) {
            fw.write(v.getVideoId() + "," + v.getTitle() + "," + v.getViews() + "," + v.getLikes() + "," + v.getDislikes() + "," + v.getCommentCount() + "," + v.getEngagementRate() + "\n");
        }

        fw.close();
    }

    private static void getTitleHashtags(ArrayList<YTVideo> ytVideos, String outputFilename) {
        try (FileWriter fw = new FileWriter(outputFilename)) {
            int missingHashtags = 0;

            for (YTVideo y : ytVideos) {
                String title = y.getTitle();
                String[] words = title.split("\\s");

                /*for (String word : words) {
                    String trimmedWord = word.trim();
                    if (trimmedWord.startsWith("#")) {
                        fw.write(y.getTitle() + " " + trimmedWord + " " + "\n");
                    }
                }*/
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private static ArrayList<YTVideo> getYTVideos(String inputFilename) {
        ArrayList<YTVideo> allYTVideos = new ArrayList<>();
        try {
            File file = new File(inputFilename);
            Scanner scanner = new Scanner(file);

            if(scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                String video_id = elements[0];
                String title = elements[1];
                Integer views = Integer.parseInt(elements[2]);
                Integer likes = Integer.parseInt(elements[3]);
                Integer dislikes = Integer.parseInt(elements[4]);
                Integer comment_count = Integer.parseInt(elements[5]);
                Double engagement_rate = (double) (likes + dislikes + comment_count) / (double) views;

                YTVideo v = new YTVideo(video_id, title, views, likes, dislikes, comment_count, engagement_rate);
                allYTVideos.add(v);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allYTVideos;

    }
}