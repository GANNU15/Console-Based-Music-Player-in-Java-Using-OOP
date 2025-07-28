package com.application;

import java.util.List;
import java.util.Scanner;

import com.model.Song;
import com.service.MusicPlayer;
import com.service.Playlist;

public class Application {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
 		MusicPlayer musicPlayer = new MusicPlayer();
		char continueChar = 'y';
		char escapeChar = 'n';
		
		while(continueChar == 'y') {
			
			System.out.println("========= MUSIC PLAYER MENU =========\n" +
	                   "1. Add New Song\n" +
	                   "2. Update Existing Song\n" +
	                   "3. Delete Song\n" +
	                   "4. Display All Songs\n" +
	                   "5. Create New Playlist\n" +
	                   "6. Add Song to Playlist\n" +
	                   "7. Display All Playlists\n" +
	                   "8. Display Songs in Playlist\n" +
	                   "9. Play Song in Playlist\n" +
	                   "10. Pause Song in Playlist\n" +
	                   "11. Stop Song in Playlist\n" +
	                   
	                   "Enter your choice: ");
			
			int choice = sc.nextInt();
			switch(choice) {
				
			case 1 :
		
				System.out.print("Enter song id : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter song title : ");
				String title = sc.nextLine();
				System.out.print("Enter artist name : ");
				String artist = sc.nextLine();
				System.out.print("Enter your Song duration : ");
				double duration = sc.nextDouble();
				
				Song newSong = new Song(id,title,artist,duration);
				musicPlayer.addSong(newSong);
				
				System.out.println(title +" added to the library...");
				
				break;
			
			case 2:
				sc.nextLine();
				System.out.print("Enter song title to update : ");
				String oldTitle = sc.nextLine();
				System.out.print("Enter the updated song id : ");
				int updatedId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter song title : ");
				String updatedTitle = sc.nextLine();
				System.out.print("Enter song artist : ");
				String updatedArtist = sc.nextLine();
				System.out.print("Enter song duration : ");
				double updatedDuration = sc.nextDouble();
				
				Song updatedSong = new Song(updatedId,updatedTitle,updatedArtist,updatedDuration);
				
				musicPlayer.updateSong(oldTitle, updatedSong);
				
				System.out.println("Song updated...");
				break;
				
			case 3:
				sc.nextLine();
				System.out.print("Enter song title to delete : ");
				String titleToDelete = sc.nextLine();
				
				musicPlayer.deleteSong(titleToDelete);
				System.out.println(titleToDelete +" is deleted from library...");
				break;
				
			case 4:
				
				List<Song> allSongs = musicPlayer.displayAllSongs();
				if(allSongs.isEmpty()) {
					System.out.println("Library is empty...");
					break;
				}
				else {
					
					System.out.println("These are the songs in your library... ");
					for(Song s : allSongs) {
						System.out.println(s);
					}
					break;
				}
				
			case 5:
				
				System.out.print("Enter playlist id : ");
				int playlistId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter playlist title : ");
				String newPlaylistTitle = sc.nextLine();
				
//				Playlist newPlaylist = new Playlist(playlistId,newPlaylistTitle);
				musicPlayer.createPlaylist(playlistId, newPlaylistTitle);
				System.out.println(newPlaylistTitle + " is created...");
				break;
				
			case 6:
				sc.nextLine();
				System.out.print("Enter playlist title : ");
				String playlistT = sc.nextLine();
				
				System.out.print("Enter song id : ");
				int idS = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter song title : ");
				String titleS = sc.nextLine();
				System.out.print("Enter artist name : ");
				String artistS = sc.nextLine();
				System.out.print("Enter your Song duration : ");
				double durationS = sc.nextDouble();
				
				Song songToPlaylist = new Song(idS,titleS,artistS,durationS);
				
				musicPlayer.addSongToPlaylist(playlistT, songToPlaylist);
				System.out.println(titleS + " added to "+ playlistT);
				break;
				
			case 7:
				
				List<String> allPlaylists = musicPlayer.displayAllPlaylists();
				if(allPlaylists.isEmpty()) {
					System.out.println("your library is empty...");
					break;
				}
				else {
					System.out.println("These are the playlists in your library...");
					for(String p : allPlaylists) {
						System.out.println("--"+p+"--");
					}
					break;
				}
				
			case 8:
				
				System.out.print("Enter playlist title : ");
				sc.nextLine();
				String playlistToFind = sc.nextLine();
				
				List<Playlist> playlists = musicPlayer.getPlaylists();
				for(Playlist p : playlists) {
					if(p.getPlaylistName().equalsIgnoreCase(playlistToFind)) {
						List<Song> songs = p.getSongs();
						if(songs.isEmpty()) {
							System.out.println("playlist is empty.");
						}
						else {
							System.out.println("these are the songs in your playlist "+playlistToFind);
							for(Song s  : songs) {
								System.out.println(s);
							}
							
						}
					}
				}
				
				break;
				
			case 9:
				sc.nextLine();
				System.out.print("Enter your playlist title to play : ");
				String playlistToPlay = sc.nextLine();
				
				String playPlaylist = musicPlayer.playPlaylist(playlistToPlay);
				System.out.println(playPlaylist);
				break;
				
			case 10:
				sc.nextLine();
				System.out.print("Enter your playlist title to play : ");
				String playlistToPause = sc.nextLine();
				
				String pausePlaylist = musicPlayer.pausePlaylist(playlistToPause);
				System.out.println(pausePlaylist);
				break;
			}
			
			System.out.print("do you wish to continue y / n : ");
			char escape = sc.next().charAt(0);
			if(escape == 'n') {
				System.out.println("=======...Adios amigo...=======");
				break;
				
			
					
			}
			
			
			
		}	
	}
}
