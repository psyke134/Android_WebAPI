package Model;

public class Book {
	
	private String book_id;
	private String name;
	private String author;
	private String category;
	private float price;
	private int save;
	private String overview;
	private String image;
	private boolean flat_sale;
	private String publisher;
	private String publish_date;
	private String page_count;
	private String demensions;
	private String shipping_weight;
	private String stock;
	private String book_format;
	private String rating;
	private boolean trend;
	
	public Book(String book_id, String name, String author, String category, float price, int save, String overview,
			String image, boolean flat_sale, String publisher, String publish_date, String page_count,
			String demensions, String shipping_weight, String stock, String book_format, String rating, boolean trend) 
	{
		this.book_id = book_id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.save = save;
		this.overview = overview;
		this.image = image;
		this.flat_sale = flat_sale;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.page_count = page_count;
		this.demensions = demensions;
		this.shipping_weight = shipping_weight;
		this.stock = stock;
		this.book_format = book_format;
		this.rating = rating;
		this.trend = trend;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isFlat_sale() {
		return flat_sale;
	}

	public void setFlat_sale(boolean flat_sale) {
		this.flat_sale = flat_sale;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getPage_count() {
		return page_count;
	}

	public void setPage_count(String page_count) {
		this.page_count = page_count;
	}

	public String getDemensions() {
		return demensions;
	}

	public void setDemensions(String demensions) {
		this.demensions = demensions;
	}

	public String getShipping_weight() {
		return shipping_weight;
	}

	public void setShipping_weight(String shipping_weight) {
		this.shipping_weight = shipping_weight;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getBook_format() {
		return book_format;
	}

	public void setBook_format(String book_format) {
		this.book_format = book_format;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean getTrend() {
		return trend;
	}

	public void setTrend(boolean trend) {
		this.trend = trend;
	}
	
}
