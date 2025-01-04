import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {
    public int shoppingOffers(
        List<Integer> prices, List<List<Integer>> specials, List<Integer> needs) {
      
        // Calculate the cost without any special offers
        int minCost = calculateTotal(prices, needs);
        List<Integer> newNeeds = new ArrayList<>();
      
        // Attempt to use each special offer to reduce the total cost
        for (List<Integer> offer : specials) {
            newNeeds.clear();

            // Determine if the offer can be applied by checking if the needs
            // are greater than or equal to what the offer provides
            boolean validOffer = true;
            for (int i = 0; i < needs.size(); ++i) {
                if (offer.get(i) > needs.get(i)) {
                    // If offer exceeds needs for any item, reject this offer
                    validOffer = false;
                    break;
                }
                // Calculate remaining needs after applying the offer
                newNeeds.add(needs.get(i) - offer.get(i));
            }

            // If the offer is valid, recurse to find the minimum cost using 
            // the reduced needs. The offer's price is added to this minimum cost
            if (validOffer) {
                minCost = Math.min(
                    minCost,
                    offer.get(offer.size() - 1) + shoppingOffers(prices, specials, newNeeds)
                );
            }
        }
        return minCost;
    }

    // Helper method to calculate the total cost without any special offers
    private int calculateTotal(List<Integer> prices, List<Integer> needs) {
        int totalCost = 0;
        for (int i = 0; i < prices.size(); ++i) {
            // Multiply the price of each item by the quantity needed
            totalCost += prices.get(i) * needs.get(i);
        }
        return totalCost;
    }
}
