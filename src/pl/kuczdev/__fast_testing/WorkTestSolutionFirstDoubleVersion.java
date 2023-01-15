package pl.kuczdev.__fast_testing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class WorkTestSolutionFirstDoubleVersion {
    private static HashMap <String, BigDecimal> pfpMap;     // Helper HashMap (prices for products).
    private static HashMap <String, BigDecimal> tflMap;     // Helper HashMap (tax for location).
    private static CheckoutResult cr;                       // Helper object of class CheckoutResult.

    public static void main(String[] args) {
        // define example array CartItem for show results (original)
        CartItem[] cartFirst = new CartItem[] {
                new CartItem("apple", 6),       // 6 * 0.5 = 3$
                new CartItem("orange", 3),      // 3 * 0.4 = 1.2$
                new CartItem("banana", 4)       // 4 * 0.2 = 0.8$
        };                                                 // Subtotal = 5$

        // define two additional carts for another tests (mine)
        CartItem[] cartSecond = new CartItem[] {
                new CartItem("apple", 6),       // 6 * 0.5 = 3$
                new CartItem("orange", 3),      // 3 * 0.4 = 1.2$
                new CartItem(null, 0)           // 0 * 0.2 = 0$
        };                                                 // Subtotal = 4.2$

        CartItem[] cartThird = new CartItem[] {
                new CartItem("apple", 1),       // 1 * 0.5 = 0.5$
                new CartItem("orange", 1),      // 1 * 0.4 = 0.4$
                new CartItem("banana", 1),      // 1 * 0.2 = 0.2$
                new CartItem("strawberry", 3)   // 3 * 2 = 6$
        };                                                 // Subtotal = 7.1$

        // Part 1
        System.out.println("Part 1 (cartFirst) original test: \n" + checkout(cartFirst, null, null));

        // Part 2
        System.out.println("Part 2 (cartFirst) original test: \n" + checkout(cartFirst, "MO", null));

        // Part 3
        System.out.println("Part 3 (cartFirst) original test: \n" + checkout(cartFirst, "IL", "tenpercentoff"));

        // Part 4
        System.out.println("Part 4 (cartFirst) original test: \n" + checkout(cartFirst, "GA", "2dollarsoff"));

        // Part 5
        System.out.println("Part 5 (cartFirst) original test: \n" + checkout(cartFirst, "MO", "buyonegetonefree"));

        // Mine additional tests:
        System.out.println("\n\n");
        System.out.println("Part 1 (cartSecond) mine additional test: \n" + checkout(cartSecond, null, null));
        System.out.println("Part 1 (cartThird) mine additional test: \n" + checkout(cartThird, null, null));
        System.out.println("\n\n");
        System.out.println("Part 2 (cartSecond) mine additional test: \n" + checkout(cartSecond, "GA", null));
        System.out.println("Part 2 (cartThird) mine additional test: \n" + checkout(cartThird, "RANDOM", null));
        System.out.println("\n\n");
        System.out.println("Part 3 (cartSecond) mine additional test: \n" + checkout(cartSecond, "IL", "WRONG DISCOUNT CODE"));
    }

    // Method with logic - setting all values for CheckoutResult object and return it (calling the method sets the data depending on the arguments provided).
    private static CheckoutResult checkout(CartItem[] cart, String taxCode, String discountCode) {
        if (checkIsEmptyCart(cart)) return cr;                                                              // Cart restriction
        checkBasicRestrictions(taxCode,discountCode);                                                       // Basic restrictions

        countAndSetTotal(cart);                                                                             // 1 point

        if (discountCode != null) {
            if (checkIsValidDiscountCode(discountCode)) setAndUpdateDiscount(cart, discountCode);           // 3, 4, 5 points
        }

        if (taxCode != null) countAndSetTaxWithUpdateTotal(taxCode);                                        // 2 point

        return cr;
    }

    // Restrictions/Validations methods:
    // Main restriction method - checking restrictions.
    private static void checkBasicRestrictions(String taxCode, String discountCode) {
        checkIsCheckoutResultInitialised();
        checkIsTflMapInitialised();
        checkIsPfpMapInitialised();
        checkIsDiscountCodeNull(discountCode);
        checkIsTaxNull(taxCode);
    }

    // Method validates the discount code - if code is not empty and wrong returns true.
    private static boolean checkIsValidDiscountCode(String discountCode) {
        if (!discountCode.isEmpty() && !discountCode.equals("tenpercentoff") && !discountCode.equals("2dollarsoff") && !discountCode.equals("buyonegetonefree")) {
            System.out.println("Wrong discount code - discount won't be counted!");
            return false;
        }
        return true;
    }

    // Method validates cart - if empty or null return true.
    private static boolean checkIsEmptyCart(CartItem[] cart) {
        if (cart == null || cart.length == 0) {
            System.out.println("Empty cart!");
            return true;
        }
        return false;
    }

    // Method check if checkoutResult is initialised (if not it will initialise it).
    private static void checkIsCheckoutResultInitialised() {
        if (cr == null) initialiseCheckoutResult();
    }

    // Method check if helperHashMap (tax for location) is initialized (if not it will initialise it)..
    private static void checkIsTflMapInitialised() {
        if (tflMap == null || tflMap.isEmpty()) initialiseTaxForLocationMap();
    }

    // Method check if helperHashMap (price for product) is initialized (if not it will initialise it)..
    private static void checkIsPfpMapInitialised() {
        if (pfpMap == null || pfpMap.isEmpty()) initialisePriceForProductMap();
    }

    // Method checking discountCode is null (if yes - set discount on 0.00).
    private static void checkIsDiscountCodeNull(String discountCode) {
        if (discountCode == null) cr.setDiscount(0.0);
    }

    // Method checking tax is null (if yes - set tax on 0.00).
    private static void checkIsTaxNull(String taxCode) {
        if (taxCode == null) cr.setTax(0.0);
    }


    // Initialise methods:
    // Method initialise CheckoutResult object.
    private static void initialiseCheckoutResult() {
        cr = new CheckoutResult();
    }

    // Method initialise helper HashMap with prices for products.
    private static void initialisePriceForProductMap() {
        pfpMap = new HashMap<>();
        pfpMap.put("apple", BigDecimal.valueOf(0.5d));
        pfpMap.put("orange", BigDecimal.valueOf(0.4d));
        pfpMap.put("banana", BigDecimal.valueOf(0.2d));
        pfpMap.put("strawberry", BigDecimal.valueOf(2.0d));
    }

    // Method initialise helper HashMap with tax for locations.
    private static void initialiseTaxForLocationMap() {
        tflMap = new HashMap<>();
        tflMap.put("MO", BigDecimal.valueOf(1.225));
        tflMap.put("OR", BigDecimal.valueOf(0.0));
        tflMap.put("GA", BigDecimal.valueOf(4.0));
        tflMap.put("All Others", BigDecimal.valueOf(2.0));
    }


    // Helper methods:
    // Helper method for 1 point - It will count and set 'subtotal', 'total' fields.
    private static void countAndSetTotal(CartItem[] cart) {
        BigDecimal total = new BigDecimal(0.0);

        for (CartItem item:cart) {
            if (item.getCount() > 0 && pfpMap.containsKey(item.getItem())) {
                BigDecimal itemCount = BigDecimal.valueOf(item.getCount());
                BigDecimal priceForItem = pfpMap.get(item.getItem());
                total = total.add(itemCount.multiply(priceForItem));
            }
        }

        cr.setSubtotal(total.doubleValue());
        cr.setTotal(total.doubleValue());
    }

    // Helper method for 3,4,5 points - If discount code is not empty it will count discount field and set value.
    private static void setAndUpdateDiscount(CartItem[] cart, String discountCode) {
        BigDecimal discount = BigDecimal.ZERO;

        if (discountCode.equals("tenpercentoff")) {
            if (cr.getSubtotal() > 0.0) discount = BigDecimal.valueOf(cr.getSubtotal()).multiply(new BigDecimal(0.1));
        }

        if (discountCode.equals("2dollarsoff")) {
            if (cr.getSubtotal() >= 5.00) discount = BigDecimal.valueOf(2.0);
        }

        if (discountCode.equals("buyonegetonefree")) {
            if (cr.getSubtotal() > 0.0) {
                for (CartItem i: cart) {
                    if (i.getCount() > 1 && pfpMap.get(i.getItem()) != null && pfpMap.get(i.getItem()).doubleValue() > 0) {
                        discount = discount.add(
                                         BigDecimal.valueOf(i.getCount())
                                        .divide(BigDecimal.valueOf(2))
                                        .setScale(0, RoundingMode.DOWN)
                                        .multiply(pfpMap.get(i.getItem())));
                    }
                }
            }
        }

        cr.setDiscount(discount.doubleValue());
    }

    // Method counting tax and update total value (if discount is not 0 method will include discount).
    private static void countAndSetTaxWithUpdateTotal(String taxCode) {
        BigDecimal taxToSet;
        BigDecimal totalToSet;
        BigDecimal taxValueByCode;

        if (tflMap.containsKey(taxCode)) {
            taxValueByCode = tflMap.get(taxCode);
        } else {
            taxValueByCode = tflMap.get("All Others");
        }

        if (cr.getSubtotal() > 0) {
            BigDecimal subtotal = BigDecimal.valueOf(cr.getSubtotal());
            BigDecimal hundred = BigDecimal.valueOf(100.00);

            if (cr.getDiscount() > 0) {
                BigDecimal discount = BigDecimal.valueOf(cr.getDiscount());

                taxToSet = subtotal.subtract(discount).multiply(taxValueByCode).divide(hundred);
                totalToSet = subtotal.add(taxToSet).subtract(discount);
            } else {
                taxToSet = subtotal.multiply(taxValueByCode).divide(hundred);
                totalToSet = subtotal.add(taxToSet);
            }

            taxToSet = round(taxToSet, 2);
            totalToSet = round(totalToSet, 2);
            cr.setTax(taxToSet.doubleValue());
            cr.setTotal(totalToSet.doubleValue());
        }
    }

    // Method rounding double value for x places.
    private static BigDecimal round(BigDecimal value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        value = value.setScale(places, RoundingMode.HALF_UP);
        return value;
    }

    // CartItem class.
    private static class CartItem {
        private String item;
        private int count;

        public CartItem(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public String getItem() { return item; }
        public int getCount() { return count; }
    }

    // CheckoutResult class.
    private static class CheckoutResult {
        private double subtotal;
        private double total;
        private double tax;
        private double discount;

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
            this.subtotal = subtotal;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        @Override
        public String toString() {
            return "CheckoutResult{" +
                    "subtotal=" + subtotal +
                    ", discount=" + discount +
                    ", tax=" + tax +
                    ", total=" + total +
                    '}';
        }
    }
}