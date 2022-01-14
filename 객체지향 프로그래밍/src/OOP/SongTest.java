package OOP;


public class SongTest {
	public static void main(String[] args) {
		Song s0 = new Song("별 헤는 밤", "유재하");
		Song s1 = new Song("비상", "임재범");
		Song s2 = new Song("비밀", "박완규");
		
		Song[] songs = new Song[3];
		songs[0] = s0;
		songs[1] = s1;
		songs[2] = s2;
		
		for(int i = 0; i < songs.length; i++) {
			System.out.println(songs[i].toStr());
		}
	}
}

class Song{
	String name;
	String singer;
	
	public Song(String name, String singer) {
		this.name = name;
		this.singer = singer;
	}
	
	String toStr() {
		return String.format("Song {name : %s, singer : %s}", this.name, this.singer);
				
				
	}
}
