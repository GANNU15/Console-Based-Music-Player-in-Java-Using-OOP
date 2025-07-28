package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Playable;
import com.model.Song;

public class Playlist implements Playable{
	
//	playlistId, playlistName, List<Song>
	
	private int playlistId ;
	
	private String playlistName;
	
	private List<Song>songs = new ArrayList<>();
	
	public Playlist() {
		
	}

	public Playlist(int playlistId, String playlistName, List<Song> songs) {
		super();
		this.playlistId = playlistId;
		this.playlistName = playlistName;
		this.songs = songs;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		
		this.playlistName = playlistName;
	}
	

	public Playlist(String playlistName, List<Song> songs) {
		super();
		this.playlistName = playlistName;
		this.songs = songs;
	}

	public Playlist(int playlistId, String playlistName) {
		super();
		this.playlistId = playlistId;
		this.playlistName = playlistName;
	}

	public Playlist(String playlistName) {
		super();
		this.playlistName = playlistName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	@Override
	public void play(String title) {
		
		System.out.println(title + " is playing...");
	}

	@Override
	public void play(int songId) {
		
		System.out.println( "Song is playing...");
	}

	@Override
	public void pause(String title) {
		System.out.println(title + " is paused...");
		
	}

	@Override
	public void pause(int songId) {
		
		System.out.println( "Song is paused...");
	}

	@Override
	public void stop(String title) {
		System.out.println(title + " is stopped...");
		
	}

	@Override
	public void stop(int songId) {
		System.out.println( "Song is stopped...");
	}	
	

	public void addSong(Song song) {
		
		songs.add(song);
		
	}
	public void removeSong(String title) {
		Iterator<Song> iterator = songs.iterator();
		while(iterator.hasNext()) {
			Song next = iterator.next();
			if(next.getTitle().equalsIgnoreCase(title)) {
				iterator.remove();
			}
		}
		
	}
	public void removeById(int id) {
		Iterator<Song> iterator = songs.iterator();
		while(iterator.hasNext()) {
			Song song = iterator.next();
			if(song.getSongId()==id) {
				iterator.remove();
			}
		}
	}
	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", playlistName=" + playlistName + ", songs=" + songs + "]";
	}

	
	
}
