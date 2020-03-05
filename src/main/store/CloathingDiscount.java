package store;

public class CloathingDiscount implements DiscountCalculator {

	@Override
	public float calculateDiscount(OrderItem orderItem) {
		// TODO Auto-generated method stub
		float cloathingDiscount = 0;
		if (orderItem.getQuantity() > 2) {
			cloathingDiscount = orderItem.getProduct().getUnitPrice();
		}
		return cloathingDiscount;
	}

}
