package gb.work.rcpcalculator.calculator.domain;

import java.math.BigDecimal;

public class Item {

	/**
	 * Currently, the logic key useful to uniquely identify such Item is based on name, category and imported status.
	 */
	private String name;
	private GoodCategory category;
	private boolean imported = false;

	private BigDecimal grossPrice;


	public Item(String name, BigDecimal grossPrice, GoodCategory category) {
		this(name, grossPrice, category, false);
	}

	public Item(String name, BigDecimal grossPrice, GoodCategory category, boolean imported) {
		this.name = name;
		this.grossPrice = grossPrice;
		this.category = category;
		this.imported = imported;
	}


	public BigDecimal getGrossPrice() {
		return grossPrice;
	}



	public String getName() {
		return name;
	}

	
	
	public void setGrossPrice(BigDecimal grossPrice) {
		this.grossPrice = grossPrice;
	}



	public GoodCategory getCategory() {
		return category;
	}



	public void setCategory(GoodCategory category) {
		this.category = category;
	}

	public boolean isImported() {
		return imported;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (imported ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (category != other.category)
			return false;
		if (imported != other.imported)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



}
