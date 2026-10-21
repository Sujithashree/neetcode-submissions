

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // 1. Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // 2. Count the frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // 3. Sort the hand so we always process the smallest available card first
        Arrays.sort(hand);

        // 4. Form groups of size groupSize
        for (int card : hand) {
            // If this card has already been used up in previous groups, skip it
            if (countMap.get(card) == 0) {
                continue;
            }

            // Try to build a consecutive sequence starting from 'card'
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                int count = countMap.getOrDefault(currentCard, 0);

                // If the required consecutive card is missing, we can't form a valid group
                if (count == 0) {
                    return false;
                }

                // Consume one instance of currentCard
                countMap.put(currentCard, count - 1);
            }
        }

        return true;
    }
}
