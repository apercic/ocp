import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.stream.Stream;

public class Nio {

    public static void main(String[] args) throws URISyntaxException {

        Path path1 = Path.of("pandas/cuddly.png"); //no / = relative, else absolute path(exam rules)
        Path path2 = Path.of("c:", "zooinfo", "November", "employees.txt");
        Path path3 = Paths.get("pandas/cuddly.png"); //interchangable
        Path path4 = FileSystems.getDefault().getPath("/home/zoodirectory");

        //path from uri
        URI a = new URI("file://icecream.txt");
        Path b = Path.of(a);
        Path c = Paths.get(a);
        URI d = b.toUri();

        //connecting to a remote system
        FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
        Path path = fileSystem.getPath("duck.txt");

        //integration between io-nio2
        File file = new File("husky.png");
        Path pathh = file.toPath();
        File backToFile = pathh.toFile();

        //resolve - concatenates two paths (if both absolute - returns just the second one!)
        System.out.println(path1.resolve(path2));

        //relativize - pot od ene do druge (cant mix relative with absolute!! - error)
        path1.relativize(path2);

        try {
            //throws exception if path doesn't exist
            System.out.println(Paths.get(".././food.txt").toRealPath());

            //difference
            Files.createDirectory(Path.of("/bison/field"));
            Files.createDirectories(Path.of("/bison/field/pasture/green"));

            //without this option - throws exception if target already exists (important!!)
            Files.copy(Paths.get("book.txt"), Paths.get("movie.txt"), StandardCopyOption.REPLACE_EXISTING);

            //public static long copy​ (InputStream in, Path target, CopyOption…options) throws IOException
            //public static long copy​ (Path source, OutputStream out)   throws IOException

            //move/rename - ALSO NEEDS REPLACE EXISTING OPTION OR ELSE EXCEPTION IF TARGET EXISTS
            Files.move(Path.of("c:\\zoo"), Path.of("c:\\zoo-new"), StandardCopyOption.REPLACE_EXISTING);

            //views - more efficient way to get multiple data
            BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Is a directory? " + data.isDirectory());
            System.out.println("Is a regular file? " + data.isRegularFile());

            //modify data
            BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            FileTime lastModifiedTime = FileTime.fromMillis(view.readAttributes().lastModifiedTime().toMillis() + 10_000);
            view.setTimes(lastModifiedTime, null, null); //null values stay the same as before

            //walk() method doesnt folow links by default
            Files.walk(path, FileVisitOption.FOLLOW_LINKS);

            //memory problems
            List<String> aa = Files.readAllLines(path); //be careful-not a stream(ex. stream function like filter not available)
            Stream<String> bb = Files.lines(path); //BETTER = lazy load

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
