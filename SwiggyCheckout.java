import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Class representing the user's transaction details
class Transaction {
    double cartValue;
    String paymentMethod;
    boolean isEligibleForFreeDelivery;
    boolean isSwiggyOneMember;

    public Transaction(double cartValue, String paymentMethod, boolean isSwiggyOneMember) {
        this.cartValue = cartValue;
        this.paymentMethod = paymentMethod;
        this.isSwiggyOneMember = isSwiggyOneMember;
        // Free delivery if cart value > 500 or the user is a Swiggy One member
        this.isEligibleForFreeDelivery = cartValue >= 500 || isSwiggyOneMember;
    }

    public double getCartValue() {
        return cartValue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isEligibleForFreeDelivery() {
        return isEligibleForFreeDelivery;
    }

    public boolean isSwiggyOneMember() {
        return isSwiggyOneMember;
    }
}

// Abstract class for Offer
abstract class Offer {
    String offerName;
    double rewardValue;
    double minimumCartValue;

    public Offer(String offerName, double minimumCartValue) {
        this.offerName = offerName;
        this.minimumCartValue = minimumCartValue;
    }

    public abstract double calculateReward(Transaction transaction);

    public String getOfferName() {
        return offerName;
    }

    public double getRewardValue() {
        return rewardValue;
    }

    public boolean isEligible(Transaction transaction) {
        return transaction.getCartValue() >= minimumCartValue;
    }
}

// Class for percentage discount offers
class DiscountOffer extends Offer {
    double discountPercentage;

    public DiscountOffer(String offerName, double discountPercentage, double minimumCartValue) {
        super(offerName, minimumCartValue);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateReward(Transaction transaction) {
        if (isEligible(transaction)) {
            rewardValue = transaction.getCartValue() * (discountPercentage / 100);
        } else {
            rewardValue = 0;
        }
        return rewardValue;
    }
}

// Class for cashback offers
class CashbackOffer extends Offer {
    double cashbackAmount;

    public CashbackOffer(String offerName, double cashbackAmount, double minimumCartValue) {
        super(offerName, minimumCartValue);
        this.cashbackAmount = cashbackAmount;
    }

    @Override
    public double calculateReward(Transaction transaction) {
        if (isEligible(transaction)) {
            rewardValue = cashbackAmount;
        } else {
            rewardValue = 0;
        }
        return rewardValue;
    }
}

// Class for coupon offers
class CouponOffer extends Offer {
    double couponDiscount;

    public CouponOffer(String offerName, double couponDiscount, double minimumCartValue) {
        super(offerName, minimumCartValue);
        this.couponDiscount = couponDiscount;
    }

    @Override
    public double calculateReward(Transaction transaction) {
        if (isEligible(transaction)) {
            rewardValue = couponDiscount;
        } else {
            rewardValue = 0;
        }
        return rewardValue;
    }
}

// New class for Buy One Get One offers
class BOGOOffer extends Offer {
    public BOGOOffer(String offerName, double minimumCartValue) {
        super(offerName, minimumCartValue);
    }

    @Override
    public double calculateReward(Transaction transaction) {
        if (isEligible(transaction)) {
            rewardValue = transaction.getCartValue() / 2;
        } else {
            rewardValue = 0;
        }
        return rewardValue;
    }
}

// New class for Free Delivery offers
class FreeDeliveryOffer extends Offer {
    public FreeDeliveryOffer(String offerName) {
        super(offerName, 0);  // No minimum cart value for free delivery
    }

    @Override
    public double calculateReward(Transaction transaction) {
        if (transaction.isEligibleForFreeDelivery()) {
            rewardValue = 30;  // Assume a fixed delivery fee
        } else {
            rewardValue = 0;
        }
        return rewardValue;
    }
}

// New class for Swiggy Card Discount
class SwiggyCardDiscount extends Offer {
    double cardDiscount;

    public SwiggyCardDiscount(String offerName, double cardDiscount, double minimumCartValue) {
        super(offerName, minimumCartValue);
        this.cardDiscount = cardDiscount;
    }

    @Override
    public double calculateReward(Transaction transaction) {
        if (isEligible(transaction) && transaction.getPaymentMethod().equals("SwiggyCard")) {
            rewardValue = transaction.getCartValue() * (cardDiscount / 100);
        } else {
            rewardValue = 0;
        }
        return rewardValue;
    }
}

// Main class for sorting and displaying offers
public class SwiggyCheckout {

    public static void main(String[] args) {
        // Example transaction (non-Swiggy One member with cart value of Rs. 450)
        Transaction transaction = new Transaction(800, "SwiggyCard", true);

        // List of offers available
        List<Offer> offers = new ArrayList<>();
        offers.add(new DiscountOffer("10% Discount", 10, 300));  // Minimum Rs. 300 cart value
        offers.add(new CashbackOffer("Rs. 50 Cashback", 50, 200));  // Minimum Rs. 200 cart value
        offers.add(new CouponOffer("Rs. 100 Coupon", 100, 500));  // Minimum Rs. 500 cart value
        offers.add(new BOGOOffer("Buy One Get One", 400));  // Minimum Rs. 400 cart value
        offers.add(new FreeDeliveryOffer("Free Delivery"));
        offers.add(new SwiggyCardDiscount("5% Swiggy Card Discount", 5, 300));  // Minimum Rs. 300 cart value

        // Calculate rewards for each offer
        for (Offer offer : offers) {
            offer.calculateReward(transaction);
        }

        // Sort offers by reward value in descending order
        Collections.sort(offers, new Comparator<Offer>() {
            @Override
            public int compare(Offer o1, Offer o2) {
                return Double.compare(o2.getRewardValue(), o1.getRewardValue());
            }
        });

        // Handle offers based on Swiggy One membership and cart value
        if (transaction.isSwiggyOneMember()) {
            System.out.println("Offers for Swiggy One Member (with free delivery):");
        } else {
            if (transaction.getCartValue() < 500) {
                System.out.println("Offers for Non-Swiggy One Member (with only one offer):");
                Offer bestOffer = offers.stream().max(Comparator.comparingDouble(Offer::getRewardValue)).get();
                offers.clear();
                offers.add(bestOffer);  // Only the best offer is available
            } else {
                System.out.println("Offers for Non-Swiggy One Member (with free delivery):");
            }
        }

        // Display sorted offers
        for (Offer offer : offers) {
            System.out.println(offer.getOfferName() + " - Reward: Rs. " + offer.getRewardValue());
        }
    }
}
