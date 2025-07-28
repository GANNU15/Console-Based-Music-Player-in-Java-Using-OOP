package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Song;

public class MusicPlayer {
	

	
	private List<Song> allSongs = new ArrayList<>();
	
	private List<Playlist> playlists = new ArrayList<>();
	
	public MusicPlayer() {
		
	}
	
	public MusicPlayer(List<Song> allSongs, List<Playlist> playlists) {
		super();
		this.allSongs = allSongs;
		this.playlists = playlists;
	}

	public List<Song> getAllSongs() {
		return allSongs;
	}

	public void setAllSongs(List<Song> allSongs) {
		this.allSongs = allSongs;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	public void addSong(Song song) {
		allSongs.add(song);
	}
	public void updateSong(String title, Song song) {
		for(Song s : allSongs) {
			if(s.getTitle().equalsIgnoreCase(title)) {
				int i = allSongs.indexOf(s);
				allSongs.set(i, song);
			}
		}
	}
	public void deleteSong(String title) {
		Iterator<Song> iterator = allSongs.iterator();
		while(iterator.hasNext()) {
			Song s = iterator.next();
			if(s.getTitle().equalsIgnoreCase(title)) {
				iterator.remove();
			}
		}
	}
	public List<Song> displayAllSongs() {
		
		for(Song s : allSongs) {
			return allSongs;
		}
		return allSongs;
	}
	public void createPlaylist(int id,String title) {
		playlists.add(new Playlist(id ,title));
	}
	public void addSongToPlaylist(String title, Song song) {
		for(Playlist p : playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(title)) {
				p.addSong(song);
			}
		}
	}
	public List<Playlist> deletePlaylist(String title) {
		Iterator<Playlist> iterator = playlists.iterator();
		while(iterator.hasNext()) {
			Playlist p = iterator.next();
			if(p.getPlaylistName().equalsIgnoreCase(title)) {
				iterator.remove();
			}
		}
		return playlists;
	}
	public String playPlaylist(String title) {
		 String title2 = null;
		for(Playlist p : playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(title)) {
				List<Song> songs = p.getSongs();
				Song song = songs.get(0);
				title2 = song.getTitle();
				
			}
		}
		return  title2 +" is playing...";
		
	}
	public String pausePlaylist(String title) {
		 String title3 = null;
		for(Playlist p : playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(title)) {
				List<Song> songs = p.getSongs();
				Song song = songs.get(0);
				title3 = song.getTitle();
				
			}
		}
		return  title3 +" is paused...";
		
	}
	public List<Song> getPlaylist(String title) {
		List<Song> songs = new ArrayList<>();
		for(Playlist p : playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(title)) {
				songs = p.getSongs();
			}
		}
		return songs;
	}
	public List<String> displayAllPlaylists() {
		List<String> playlistNames = new ArrayList<>();
			for(Playlist p : playlists) {
				String playlistName = p.getPlaylistName();
				playlistNames.add(playlistName);
			}
		return playlistNames;
	}


	@Override
	public String toString() {
		return "MusicPlayer [allSongs=" + allSongs + ", playlists=" + playlists + "]";
	}
	
	
	
	
}
