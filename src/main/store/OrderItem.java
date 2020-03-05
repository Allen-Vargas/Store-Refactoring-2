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
		DiscountCalculator discountCalculator = null;
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			discountCalculator = new AccessoriesDiscount();
			discount = discountCalculator.calculateDiscount(this);
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			discountCalculator = new BikesDiscount();
			discount = discountCalculator.calculateDiscount(this);
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

	public float calculateTotalAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
