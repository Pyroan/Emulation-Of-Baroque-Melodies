package abc;

/**
 * Represents a Song.
 * @author Violet Moore
 *
 */
public class Song {
	
	// Metadata/information fields
	private String title; // Title of the piece
	private String composer; // original composer
	private Tempo tempo; // Speed the piece should be played at.
	private String key;
	
	// The following two will be used when creating pieces
	// to evaluate how many beats/notes should be in each measure.
	private int[] meter = new int[2];
	private int noteLength;
	
	// Tune Body
//	public Note[] notes;
	
	/*********************
	 *    Constructors   *
	 *********************/

	/**
	 * Constructs a new Song with default attributes
	 */
	public Song() {
		title = "Untitled";
		composer = "Unnamed";
		tempo = Tempo.ANDANTE;
		key = "C";
		meter[0]=4; 
		meter[1]=4;
		noteLength = 8;
	}
	
	/**
	 * Constructs a new song with specified attributes
	 */
	public Song(String title, String composer, Tempo tempo, String timeSignature) {
		this.title = title;
		this.composer = composer;
		this.tempo = tempo;
		// TODO BROKE THIS
		//this.meter = timeSignature;
	}
	
	/**
	 * Constructs an existing song from the given
	 * pathname.
	 * @param path
	 */
	public Song(String path) {
		SongBuilder abcReader = new SongBuilder();
		abcReader.openReader(path);
	}
	
	/****************************
	 *    Getters and Setters   *
	 ****************************/
	
	/**
	 * Returns just the title and composer in the form
	 * "<Title>, by <Composer>"
	 */
	public String getTitleAndComposer() {
		String s = title + ",\nBy " + composer;
		return s;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getComposer() {
		return composer;
	}
	
	public void setComposer(String comp) {
		composer = comp;
	}
	
	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Sets the note length based on a string instead
	 * of an int, converting it.
	 * This assumes note length is always in the form
	 * "1" or "1/X"
	 * @param noteLength
	 */
	public void setNoteLength(String noteLength) {
		if (noteLength.length() == 1) {
			setNoteLength(Integer.parseInt(noteLength));
		} else {
			noteLength = noteLength.substring(2);
		}
	}
	
	public void setNoteLength(int noteLength) {
		this.noteLength = noteLength;
	}
	
	public void setTimeSignature(String ts) {
		// reminder meter isn't a string anymore;
		//meter = ts;
	}
}
