package store;

public class AccessoriesDiscount implements DiscountCalculator{

	@Override
	public float calculateDiscount(OrderItem orderItem) {
		// TODO Auto-generated method stub
		float booksDiscount = 0;
		if (orderItem.calculateTotalAmount() >= 100) {
			booksDiscount = orderItem.calculateTotalAmount() * 10 / 100;
		}
		return booksDiscount;
	}

}
