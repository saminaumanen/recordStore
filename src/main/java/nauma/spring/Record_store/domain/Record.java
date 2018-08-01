package nauma.spring.Record_store.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String artist;
	private String year;
	private String price;

	public Record(String title, String artist, String year, String price) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Record() {
		super();
	}

	@Override
	public String toString() {
		return "Record [title=" + title + ", artist=" + artist + ", year=" + year
				+  ", price=" + price + "]";
	}

}