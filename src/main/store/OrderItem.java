package store;

public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float calculateTotalFor() {
		float totalItem = 0;
		float itemAmount = calculateTotalAmount();
		float discount = 0;
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			float booksDiscount = 0;
			if (itemAmount >= 100) {
				booksDiscount = itemAmount * 10 / 100;
			}
			discount = booksDiscount;
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			// 20% discount for Bikes
			discount = itemAmount * 20 / 100;
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			float cloathingDiscount = 0;
			if (getQuantity() > 2) {
				cloathingDiscount = getProduct().getUnitPrice();
			}
			discount = cloathingDiscount;
		}
		totalItem = itemAmount - discount;
		return totalItem;
	}

	private float calculateTotalAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
