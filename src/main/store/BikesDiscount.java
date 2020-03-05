package store;

public class BikesDiscount implements DiscountCalculator {

	@Override
	public float calculateDiscount(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItem.calculateTotalAmount() * 20 / 100;
	}

}
