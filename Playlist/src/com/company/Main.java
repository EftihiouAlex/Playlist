package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Illusions", "Guns n Roses");
        album.addSong("Sweet Child o' mine", 5.45);
        album.addSong("Paradise City", 6.25);
        album.addSong("Estranged", 7.56);
        album.addSong("Night train", 4.22);
        album.addSong("Don't cry", 4.34);
        album.addSong("Patience", 5.01);
        album.addSong("Welcome to the jungle", 3.45);
        album.addSong("Knocking on heaven's door", 4.12);
        albums.add(album);

        album = new Album("Fear of the dark", "Iron Maiden");
        album.addSong("Fear of the dark", 5.35);
        album.addSong("The trooper", 5.25);
        album.addSong("Run to the hills", 5.56);
        album.addSong("Aces high", 5.22);
        album.addSong("Wasted years", 5.34);
        album.addSong("The phantom of the opera", 6.56);
        album.addSong("Alexander", 5.45);
        album.addSong("Dance of death", 6.45);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Night train", playlist);
        albums.get(0).addToPlaylist("Patience", playlist);
        albums.get(0).addToPlaylist("Live and let die", playlist);
        albums.get(0).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(8, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(7, playlist);
        albums.get(1).addToPlaylist(24, playlist);

        play(playlist);
    }




    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator =  playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs to play");
            return;
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action =scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist completed");
                    quit = false;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("We reached the end of the list");
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
                    }else {
                        System.out.println("We are at the start of the list");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " +listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We reached  the end of the list");
                        }
                    }
                    break;
                case 4 :
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() >0)  {
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());

                        }
                    }

            }
        }

    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0- to quit\n" +
                    "1 - to play next song\n" +
                    "2 - to play previous song\n" +
                    "3 - to replay current song\n" +
                    "4 - list songs in the playlist\n" +
                    "5 - print available actions\n" +
                    "6 - to delete a song from the playlist" );
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator= playlist.iterator();
        System.out.println("=============================");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("=============================");
    }


}
