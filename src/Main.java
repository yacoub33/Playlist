import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Bon Jovi Greatest Hits Disc 1", "Bon Jovi");
        album.addSong("Livin' On A Prayer", 4.10);
        album.addSong("You Give Love A Bad Name", 3.43);
        album.addSong("It's My Life", 3.44);
        album.addSong("Have A Nice Day", 3.48);
        album.addSong("Wanted Dead Or Alive", 5.08);
        album.addSong("Bad Medicine", 5.16);
        album.addSong("We Weren't Born To Follow", 4.04);
        album.addSong("I'll Be There For You", 5.46);
        album.addSong("Born To Be My Baby", 4.40);
        album.addSong("Bed Of Roses", 6.35);
        album.addSong("Who Says You Can't Go Home", 4.40);
        album.addSong("Lay Your Hand On Me", 3.49);
        album.addSong("Always", 5.53);
        album.addSong("In These Arms", 5.19);
        album.addSong("What Do You Got", 3.47);
        album.addSong("No Apologies", 3.44);
        albums.add(album);

        album = new Album("ABBA Gold", "ABBA");
        album.addSong("Dancing Queen", 3.51);
        album.addSong("Knowing Me, Knowing You", 4.01);
        album.addSong("Take A Chance On Me", 4.06);
        album.addSong("Mamma Mia", 3.30);
        album.addSong("Lay All Your Love On Me", 4.32);
        album.addSong("Super Trouper", 4.11);
        album.addSong("I Have A Dream", 4.43);
        album.addSong("The Winner Takes It All", 4.55);
        album.addSong("Money, Money, Money", 3.06);
        album.addSong("SOS", 3.21);
        album.addSong("Chiquitita", 5.25);
        album.addSong("Fernando", 4.12);
        album.addSong("Voulez-Vous", 5.06);
        album.addSong("Gimme! Gimme! Gimme! (A Man After Midnight)", 4.49);
        album.addSong("Does Your Mother Know", 3.13);
        album.addSong("One Of Us", 3.54);
        album.addSong("The Name Of The Game", 4.52);
        album.addSong("Thank You For The Music", 3.48);
        album.addSong("Waterloo", 2.45);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Livin' On A Prayer", playlist);
        albums.get(0).addToPlaylist("It's My Life", playlist);
        albums.get(0).addToPlaylist("We Weren't Born To Follow", playlist);
        albums.get(0).addToPlaylist("Hello", playlist); // Does not exist.
        albums.get(0).addToPlaylist(9, playlist);
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(6, playlist);
        albums.get(1).addToPlaylist(22, playlist); // Does not exist.

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("No Songs in Playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist Complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("End of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available Actions: \npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.");
    }

    private static void printList (LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("=============================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=============================");
    }
}