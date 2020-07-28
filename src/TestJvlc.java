
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.io.File;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaDetails;
import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.condition.Condition;
import uk.co.caprica.vlcj.player.condition.conditions.ParsedCondition;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class TestJvlc {

    // Some standard options for headless operation
    private static final String[] VLC_ARGS = {
        "--intf", "dummy", /* no interface */
        "--vout", "dummy", /* we don't want video (output) */
        "--no-audio", /* we don't want audio (decoding) */
        "--no-stats", /* no stats */
        "--no-sub-autodetect-file", /* we don't want subtitles */
  //      "--no-inhibit", /* we don't want interfaces */
        "--no-disable-screensaver", /* we don't want interfaces */
        "--no-snapshot-preview", /* no blending in dummy vout */};

    public static void main(String[] args) throws Exception {
//        if(args.length != 1) {
//            System.err.println("Usage: <mrl>");
//            System.exit(1);
//        }

        // final String mrl = "F:\\Drive D\\PRIVATE\\AVCHD\\BDMV\\STREAM\\00198.MTS";// args[0];$
        final String  mrl = "F:\\LesPhotos\\LesFilms\\Photo 277.avi";
        NativeLibrary.addSearchPath(
                RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC"
        );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        MediaPlayerFactory factory = new MediaPlayerFactory(VLC_ARGS);
        MediaPlayer mediaPlayer = factory.newHeadlessMediaPlayer();

        mediaPlayer.setSnapshotDirectory(new File(".").getAbsolutePath());

        // The sequence for getting the meta is...
        //
        // Start the media and wait for it to play
        // Wait for parsed condition
        //
        // There is a small overhead of actually having to start the media - but
        // to mitigate this the media player factory configuration has disabled
        // audio and video outputs so there will be no visible/audible sign of
        // the media playing
        Condition<Integer> parsedCondition = new ParsedCondition(mediaPlayer) {
            @Override
            protected void onBefore() {
                // Some media, such as mpg, must be played before all meta data (e.g. duration) is available
                mediaPlayer.startMedia(mrl); // "start" waits until the media is playing before returning
                mediaPlayer.requestParseMedia(); // asynchronous invocation
            }

            @Override
            protected void onAfter(Integer result) {
                mediaPlayer.stop();
            }
        };
        parsedCondition.await();

        // This is functionally equivalent to the simpler synchronous version:
        /*
         mediaPlayer.startMedia(mrl);  // "start" waits until the media is playing before returning
         mediaPlayer.parseMedia(); // synchronous invocation
         mediaPlayer.stop();
         */
        MediaMeta meta = mediaPlayer.getMediaMeta();
        MediaDetails details = mediaPlayer.getMediaDetails();
        System.out.println(meta.getDate()+"/"+mediaPlayer.getVideoDescriptions());

        mediaPlayer.release();
        factory.release();
    }
}
