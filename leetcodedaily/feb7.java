class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0, left = 0, right = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while (right < fruits.length) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }
}

// https://leetcode.com/problems/fruit-into-baskets/